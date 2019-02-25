# something practice

package explain:

- package **pattern** is something about design pattern,i implements some examples for better comprehension.

```
├── pattern
│   ├── factory
│   │   ├── shanghaiTofuTypes.properties
│   │   ├── store
│   │   │   ├── AbstractTofuStore.java
│   │   │   ├── ShanghaiTofuStore.java
│   │   │   ├── Store.java
│   │   │   └── TofuStore.java
│   │   ├── tofu
│   │   │   ├── HardTofu.java
│   │   │   ├── SoftTofu.java
│   │   │   ├── SweetTofu.java
│   │   │   └── Tofu.java
│   │   ├── TofuFactory.java
│   │   ├── TofuTest.java
│   │   ├── TofuTypes.properties
│   │   └── util
│   │       └── Util.java
│   ├── observer
│   │   ├── Center.java
│   │   ├── Observerable.java
│   │   ├── Observer.java
│   │   ├── ObserverTest.java
│   │   ├── pubsub
│   │   │   ├── Publisher.java
│   │   │   ├── PubSubTest.java
│   │   │   └── SubScriber.java
│   │   └── Subject.java
│   ├── singleton
│   │   ├── SingletonEnum.java
│   │   ├── SingletonTest.java
│   │   └── Sun.java
│   └── strategy                           (also include command pattern)
│       ├── attack
│       │   ├── IAttack1.java
│       │   ├── IAttack2.java
│       │   ├── IAttack3.java
│       │   └── INormalAttack.java
│       ├── command
│       │   ├── Attack1.java
│       │   ├── Attack2.java
│       │   ├── Attack3.java
│       │   ├── Command.java
│       │   └── NormalAttack.java
│       ├── CommandPanel.java              (It is a command line game)
│       ├── Role.java
│       ├── roles
│       │   ├── heros.properties
│       │   ├── HerosUtil.java
│       │   ├── libai
│       │   │   ├── Base.java
│       │   │   ├── LiBaiAttack1.java
│       │   │   ├── LiBaiAttack2.java
│       │   │   ├── LiBaiAttack3.java
│       │   │   ├── LiBaiNormalAttack.java
│       │   │   ├── NewLiBaiAttack3.java
│       │   │   └── RoleLiBai.java
│       │   └── luban                      (where to add another hero)
│       └── RoleTest.java
```

- package **Thread** is something about concurrent,also some examples here.

```
Thread/
├── Array.java
├── atomic
│   └── Normal.java
├── communcation
│   ├── Main.java
│   ├── Pool.java
│   ├── Thread1.java
│   └── Thread2.java
├── Consumer.java
├── container
│   └── Test.java
├── countdownlatch
│   ├── CountDownLatchTest2.java
│   └── CountDownLatchTest.java
├── cyclicbarrier
│   ├── CyclicBarrierTest.java
│   └── Seckill.java
├── lock                   					  
│   ├── Account.java
│   ├── Deposit.java
│   ├── DepositWithdraw.java
│   ├── Lock.java
│   ├── Main.java
│   ├── SimpleLock.java
│   ├── Thread2.java
│   ├── TwoThread.java
│   └── Withdraw.java
├── Productor.java
├── semaphore
│   ├── Bus.class
│   ├── Bus.java
│   ├── java.txt
│   ├── JxSemaphore.java
│   └── SemaphoreTest.java
├── ThreadTest2.java
└── ThreadTest.java
```
package **io/nio** is something about nio,implements a simple HTTP Server,can access the request from browser. 

```
nio/my/
├── bean			(server base bean)
│   ├── HttpMethod.java
│   ├── RequestBean.java
│   ├── ResponseBean.java
│   └── StatuCode.java
├── HttpClient.java		(http client)
├── HttpServer.java		(http server,can access the request from browser)
├── resource.txt
└── Test.java
```