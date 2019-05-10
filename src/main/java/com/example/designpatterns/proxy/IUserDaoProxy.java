package com.example.designpatterns.proxy;

/**
 * 静态代理:
 *静态代理，代理对象和目标对象（被代理对象）都要实现相同的接口
 * 代理对象 持有目标对象的引用，实际干活的还是被代理对象，
 * 代理对象可以对目标对象的方法进行增强，在不改变目标对象的方法逻辑上。
 * 缺点：静态代理只能针对某个接口的增强如 IUserDao ，
 * 如果有其他的接口也需要代理，则需要重新写对应的代理，不够灵活。
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护
 */
public class IUserDaoProxy implements IUserDao{
    private IUserDao iUserDao;

    public IUserDaoProxy(IUserDao iUserDao){
        this.iUserDao = iUserDao;
    }

    /**
     * 调用目标对象的方法
     * 对目标对象的方法进行增强
     */
    @Override
    public void save() {
        System.out.println("保存前开启事务");
        iUserDao.save();
        System.out.println("保存后提交事务");
    }

    public static void main(String[] args) {
        IUserDaoImpl iUserDao = new IUserDaoImpl();
        IUserDaoProxy iUserDaoProxy = new IUserDaoProxy(iUserDao);

        iUserDaoProxy.save();
    }
}
