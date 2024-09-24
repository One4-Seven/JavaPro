package com.yst.ATM_system;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    ArrayList<Account> accounts = new ArrayList<>();

    private void loginAccount() {
        if (accounts.isEmpty()) {
            System.out.println("当前系统中没有用户,请开户!");
            return;
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--------------登 录 系 统--------------");

            // 用户输入卡号
            System.out.print("卡号: ");
            String card = sc.next();

            // 用户输入密码
            System.out.print("密码: ");
            String password = sc.next();

            // 检查是否有匹配的信息
            if (checkKey(card, password)) {
                System.out.println("--------------登 录 成 功--------------");
                userSystem(card);
                break;
            } else {
                System.out.println("卡号或密码错误,请重新输入!");
            }
        }
    }

    private void openAccount() {
        Account user = new Account();
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------开 户 系 统--------------");

        // 设置用户名
        System.out.print("用户名: ");
        String name = sc.next();
        user.setName(name);

        // 设置密码
        while (true) {
            System.out.print("密码: ");
            String password1 = sc.next();
            System.out.print("请确认密码: ");
            String password2 = sc.next();
            if (password1.equals(password2)) {
                user.setPassword(password1);
                break;
            } else {
                System.out.println("两次输入的密码不同,请重新输入!");
            }
        }

        // 设置初始余额
        user.setMoney(0);

        // 设置限额
        System.out.print("限额: ");
        double limit = sc.nextDouble();
        user.setLimit(limit);

        // 生成随机卡号
        String card;

        // 确保卡号不重复
        while (true) {
            card = createCard();
            Account newuser = searchUser(card);
            if (newuser == null) {
                break;
            }
        }
        user.setCard(card);

        // 把用户信息添加进系统
        accounts.add(user);

        System.out.println("亲爱的" + name + "恭喜您开户成功! 卡号: " + card);
    }

    public void Start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------------欢迎光临南审银行------------");
            System.out.println("输入[1]登录您的账号");
            System.out.println("输入[2]进行系统开户");
            System.out.println("输入[3]退出当前系统");
            System.out.println("-------------------------------------");
            System.out.print("输入你的操作: ");
            String flag = sc.next();
            switch (flag) {
                case "1":
                    loginAccount();
                    break;
                case "2":
                    openAccount();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("哥们,上面的提示看不懂?");
            }
        }
    }

    private String createCard() {
        StringBuilder card = new StringBuilder();
        Random r = new Random();
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < 8; i++) {
            int num = r.nextInt(10);
            card.append(numbers[num]);
        }
        return card.toString();
    }

    private void userSystem(String card){
        Scanner sc = new Scanner(System.in);

        // 根据卡号查找出当前登录的用户
        Account user = searchUser(card);
        if (user == null) {
            System.out.println("--------------卡 号 异 常--------------");
            return;
        }

        while (true) {
            System.out.println("--------------办 理 业 务--------------");
            System.out.println("[1] 查询个人信息");
            System.out.println("[2] 存款");
            System.out.println("[3] 取款");
            System.out.println("[4] 转账");
            System.out.println("[5] 修改密码");
            System.out.println("[6] 退出系统");
            System.out.println("[7] 注销账号");
            System.out.println("-------------------------------------");
            System.out.print("选择业务: ");
            String flag = sc.next();
            switch (flag) {

                case "1":
                    showMessage(user);
                    break;

                case "2":
                    addMoney(user);
                    break;

                case "3":
                    outMoney(user);
                    break;

                case "4":
                    transferMoney(user);
                    break;

                case "5":
                    boolean rc = changePassword(user);

                    if (rc) {
                        return;
                    } else {
                        break;
                    }

                case "6":
                    return;

                case "7":
                    boolean re = signoutAccount(user);

                    if (re) {
                        return;
                    } else {
                        break;
                    }

                default:
                    System.out.println("哥们,上面的提示看不懂?");
            }
        }

    }

    private void transferMoney(Account user) {
        Scanner sc = new Scanner(System.in);

        // 转账对象
        Account people;

        System.out.println("----------------转 账----------------");
        System.out.print("请输入转账卡号: ");
        String peoplecard = sc.next();

        // 检查卡号是否存在
        if (searchUser(peoplecard) != null) {

            // 创建转账对象
            people = searchUser(peoplecard);

            if (user == people) {
                System.out.println("无法给自己转账!");
                System.out.println("--------------转 账 失 败--------------");
                return;
            }

            System.out.print("请输入转账金额: ");
            double money = sc.nextDouble();

            // 检查限额
            if (money <= user.getLimit()) {

                if (money <= user.getMoney()) {

                    // 优先更新转账对象的余额
                    people.setMoney(people.getMoney() + money);

                    // 更新当前账户的余额
                    money = user.getMoney() - money;
                    user.setMoney(money);

                    System.out.println("您的余额: " + user.getMoney());
                    System.out.println("--------------转 账 成 功--------------");
                } else {
                    System.out.println("存款不足!您的存款: " + user.getMoney());
                    System.out.println("--------------转 账 失 败--------------");
                }

            } else {
                System.out.println("超出限额!您的限额: " + user.getLimit());
                System.out.println("--------------转 账 失 败--------------");
            }
        } else {
            System.out.println("转账账号不存在!");
            System.out.println("--------------转 账 失 败--------------");
        }
    }

    private boolean signoutAccount(Account user) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------注 销 账 号--------------");
        System.out.println("您确定要注销账号吗?此操作不可撤销!( Y / N )");
        System.out.print("您的选择: ");
        String flag = sc.next();

        if (flag.equals("yes")) {
            if (user.getMoney() > 0) {
                System.out.println("账户内仍有余额,您的余额: " + user.getMoney());
                System.out.println("--------------注 销 失 败--------------");
                return false;
            } else {
                System.out.println("感谢您对本行的支持!");
                System.out.println("--------------注 销 成 功--------------");
                accounts.remove(user);
                return true;
            }
        } else {
            System.out.println("感谢您对本行的支持!");
            System.out.println("--------------注 销 失 败--------------");
            return false;
        }
    }


    private boolean changePassword(Account user) {
        Scanner sc = new Scanner(System.in);
        String oldkey = user.getPassword();

        System.out.println("--------------修 改 密 码--------------");
        System.out.print("原密码: ");
        String userin = sc.next();

        // 判断用户原密码是否正确
        if (oldkey.equals(userin)) {
            while (true) {
                System.out.print("新密码: ");
                String newkey1 = sc.next();
                System.out.print("请确认密码: ");
                String newkey2 = sc.next();
                if (newkey2.equals(newkey1)) {
                    user.setPassword(newkey2);
                    System.out.println("--------------修 改 成 功--------------");
                    return true;
                } else {
                    System.out.println("两次输入的密码不同,请重新输入!");
                }
            }

        } else {
            System.out.println("原密码错误!请重试");
            System.out.println("--------------修 改 失 败--------------");
            return false;
        }
    }

    private void outMoney(Account user) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------取 款----------------");
        System.out.print("请输入你的取款金额: ");
        double money = sc.nextDouble();

        if (money <= user.getLimit()) {
            if (money <= user.getMoney()) {
                money = user.getMoney() - money;
                user.setMoney(money);
                System.out.println("您的余额: " + user.getMoney());
                System.out.println("--------------取 款 成 功--------------");
            } else {
                System.out.println("存款不足!您的存款: " + user.getMoney());
                System.out.println("--------------取 款 失 败--------------");
            }
        } else {
            System.out.println("超出限额!您的限额: " + user.getLimit());
            System.out.println("--------------取 款 失 败--------------");
        }
    }

    private void addMoney(Account user) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------存 款----------------");
        System.out.print("请输入你的存款金额: ");
        double money = sc.nextDouble();

        if (money > 0) {
            money += user.getMoney();
            user.setMoney(money);
            System.out.println("您的余额: " + user.getMoney());
            System.out.println("--------------存 款 成 功--------------");
        } else {
            System.out.println("存款金额小于零!");
        }
    }

    private void showMessage(Account user) {
        System.out.println("--------------个 人 信 息--------------");
        System.out.println("户主: " + user.getName());
        System.out.println("卡号: " + user.getCard());
        System.out.println("余额: " + user.getMoney());
        System.out.println("限额: " + user.getLimit());
    }

    private boolean checkKey(String card, String password) {
        for (Account account : accounts) {
            if (card.equals(account.getCard()) && password.equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }

    private Account searchUser(String card) {
        for (Account account : accounts) {
            if (card.equals(account.getCard())) {
                return account;
            }
        }
        return null;
    }


}
