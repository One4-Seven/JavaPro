package com.yst.diary;

import cn.hutool.core.io.FileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NoteJFrame extends JFrame implements ActionListener {
    // 创建三个按钮
    JButton add = new JButton("添加");
    JButton update = new JButton("修改");
    JButton delete = new JButton("删除");

    // 创建表格组件
    JTable table;

    // 创建菜单的导入和导出
    JMenuItem exportItem = new JMenuItem("导出");
    JMenuItem importItem = new JMenuItem("导入");

    // 定义表格的内容
    // 二维数组中的每一个一维数组，是表格里面的一行数据
    Object[][] tableDates;

    List<String> strings;

    public NoteJFrame() {
        // 初始化界面
        initFrame();
        // 初始化菜单
        initJMenuBar();
        // 初始化组件
        initView();
        // 让界面显示出来
        this.setVisible(true);
    }

    // 初始化组件
    private void initView() {
        // 定义最上面的每日一记
        JLabel title = new JLabel("每日一记");
        title.setBounds(220, 20, 584, 50);
        title.setFont(new Font("宋体", Font.BOLD, 32));
        this.getContentPane().add(title);

        // 定义表格的标题
        Object[] tableTitles = {"编号", "标题", "正文"};

        // 读取数据
        initDate();

        // 定义表格组件
        // 并给表格设置标题和内容
        table = new JTable(tableDates, tableTitles);
        table.setBounds(40, 70, 504, 380);

        // 创建可滚动的组件，并把表格组件放在滚动组件中间
        // 好处：如果表格中数据过多，可以进行上下滚动
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(40, 70, 504, 380);
        this.getContentPane().add(jScrollPane);

        // 给三个按钮设置宽高属性，并添加点击事件
        add.setBounds(40, 466, 140, 40);
        update.setBounds(222, 466, 140, 40);
        delete.setBounds(404, 466, 140, 40);

        add.setFont(new Font("宋体", Font.PLAIN, 24));
        update.setFont(new Font("宋体", Font.PLAIN, 24));
        delete.setFont(new Font("宋体", Font.PLAIN, 24));

        add.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);

        this.getContentPane().add(add);
        this.getContentPane().add(update);
        this.getContentPane().add(delete);
    }

    // 读入文件数据
    private void initDate() {
        strings = FileUtil.readUtf8Lines("E:\\Java\\JavaSE_ProMax\\experimental-case-app\\daily_date\\date.txt");
        int rows = strings.size();
        tableDates = new Object[rows][3];
        int num = 0;
        for (String string : strings) {
            String[] split = string.split("&");
            tableDates[num][0] = num + 1;
            tableDates[num][1] = split[0];
            tableDates[num][2] = split[1];
            num++;
        }
    }

    // 初始化菜单
    private void initJMenuBar() {
        // 创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        // 创建菜单上面的选项的对象
        JMenu functionJMenu = new JMenu("功能");

        // 把5个存档，添加到saveJMenu中
        functionJMenu.add(exportItem);
        functionJMenu.add(importItem);

        // 将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);

        // 绑定点击事件
        exportItem.addActionListener(this);
        importItem.addActionListener(this);

        // 给菜单设置颜色
        jMenuBar.setBackground(new Color(230, 230, 230));

        // 给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    // 初始化界面
    private void initFrame() {
        // 设置界面的宽高
        this.setSize(600, 600);
        // 设置界面的标题
        this.setTitle("每日一记");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
        // 设置背景颜色
        this.getContentPane().setBackground(new Color(212, 212, 212));
    }

    JDialog jDialog = new JDialog();

    // 展示弹框
    public void showJDialog(String content) {
        if (!jDialog.isVisible()) {
            // 创建一个弹框对象
            JDialog jDialog = new JDialog();
            // 给弹框设置大小
            jDialog.setSize(200, 150);
            // 让弹框置顶
            jDialog.setAlwaysOnTop(true);
            // 让弹框居中
            jDialog.setLocationRelativeTo(null);
            // 弹框不关闭永远无法操作下面的界面
            jDialog.setModal(true);
            // 创建 JLabel 对象管理文字并添加到弹框当中
            JLabel warning = new JLabel(content);
            warning.setBounds(0, 0, 200, 150);
            jDialog.getContentPane().add(warning);
            // 让弹框展示出来
            jDialog.setVisible(true);
        }
    }

    // 作用：展示一个带有确定和取消按钮的弹框
    // 0 表示用户点击了确定
    // 1 表示用户点击了取消
    // 该弹框用于用户删除时候，询问用户是否确定删除
    public int showChooseJDialog() {
        return JOptionPane.showConfirmDialog(this, "是否删除选中数据？", "删除信息确认", JOptionPane.YES_NO_OPTION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取当前那个组件被点击
        Object obj = e.getSource();

        // 添加数据
        if (obj == add) {
            this.setVisible(false);
            new AddJFrame();
        }

        // 修改数据
        else if (obj == update) {
            int i = table.getSelectedRow();
            if (i < 0) {
                showJDialog("请选择要修改的数据");
            } else {
                this.setVisible(false);
                new UpdateJFrame(strings, i);
            }
        }

        else if (obj == delete) {
            int i = table.getSelectedRow();
            // 没选择
            if (i < 0) {
                showJDialog("请选择要删除的数据");
            } else {
                int j = showChooseJDialog();
                System.out.println(i);
                if (j == 0) {
                    strings.remove(i);
                    FileUtil.writeUtf8Lines(strings, "E:\\Java\\JavaSE_ProMax\\experimental-case-app\\daily_date\\date.txt");
                    showJDialog("删除成功");
                    strings = FileUtil.readUtf8Lines("E:\\Java\\JavaSE_ProMax\\experimental-case-app\\daily_date\\date.txt");
                    System.out.println(strings);
                    int count = 1;
                    int num = 0;
                    for (String string : strings) {
                        String[] split = string.split("&");
                        table.setValueAt(count + "", num, 0);
                        table.setValueAt(split[0], num, 1);
                        table.setValueAt(split[1], num, 2);
                        num++;
                        count++;
                    }
                    table.setValueAt(null, num, 0);
                    table.setValueAt(null, num, 1);
                    table.setValueAt(null, num, 2);
                } else {
                    showJDialog("删除失败");
                }
            }


        } else if (obj == exportItem) {
            System.out.println("菜单的导出功能");

        } else if (obj == importItem) {
            System.out.println("菜单的导入功能");

        }
    }

}

