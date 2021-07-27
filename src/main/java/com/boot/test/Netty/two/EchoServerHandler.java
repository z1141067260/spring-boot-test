package com.boot.test.Netty.two;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author WangW
 * @date 2021/05/07 17:28
 * @description 响应传入的消息
 * ChannelInboundHandlerAdapter是ChannelInboundHandler的默认实现
 */
//标示一个Channel-Handler 可以被多个Channel安全地共享
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 对于每个传入的消息都要调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //转换成Netty的基本类型(ByteBuf), 并转换成UTF-8形式记录到控制台
        ByteBuf in = (ByteBuf) msg;
        System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));
        //将接收到的消息写给发送者，而不冲刷出站消息
        ctx.write(in);
    }

    /**
     * 通知ChannelInboundHandler最后一次对channel-Read()的调用是当前批量读取中的最后一条消息；
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将未决消息冲刷到远程节点，并且关闭该Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * 在读取操作期间，有异常抛出时会调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //打印异常栈跟踪
        cause.printStackTrace();
        //关闭该Channel
        ctx.close();
    }


    /**
     * 关键点：
     * 针对不同类型的事件来调用ChannelHandler;
     * 应用程序通过实现或者扩展ChannelHandler来挂钩到事件的生命周期，
     * 并且提供自定义的应用程序逻辑。
     * 在架构上，ChannelHandler有助于保持业务逻辑与网络处理代码的分离。
     * 这简化了开发过程，因为代码必须不断地演化以响应不断变化的需求。
     *
     *
     * PS:每个Channel都拥有一个与之相关联的ChannelPipeline,其ChannelHandler采用链式结构，
     * 如果其中发生异常不进行捕获，会传递到尾端的ChannelPipeline并被记录。
     * 因此你的应用程序中至少有一个实现了exceptionCaught()方法的 ChannelHandler。
     */
}
