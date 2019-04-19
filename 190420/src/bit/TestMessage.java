package bit;



/**
 *
 */
public class TestMessage {

    public static void main(String[] args) {
       IMessage<String> qqMessage=new QQMessage<>();
       IMessage msnMessage=new MSNMessage();
        System.out.println(qqMessage.print("你好"));
        System.out.println(((MSNMessage) msnMessage).print("你好"));
    }
}
interface IMessage<T> {
    T print(T t);
}
class QQMessage<T> implements IMessage<T> {
    @Override
    public T print(T t) {
        return t;
    }
}
class MSNMessage implements  IMessage<String > {

    @Override
    public String print(String s) {
        return s;
    }
}