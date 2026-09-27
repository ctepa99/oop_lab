package oop.lab;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class lab_two_Main {

    // Главное окно программы
    private JFrame frame;

    // Поля для ввода данных
    private JTextField clientField;
    private JTextField accountNumberField;
    private JTextField balanceField;

    /**
     * Создаёт главное окно банковской системы
     * и выполняет первоначальную настройку интерфейса.
     */
    public lab_two_Main() {

        frame = new JFrame();

        frame.setTitle("Банковская система");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        createInterface();
    }

    /**
     * Создаёт и размещает графические компоненты
     * интерфейса банковской системы.
     */
    private void createInterface() {

        frame.setLayout(new BorderLayout());

        // ==========================================
        // Панель кнопок
        // ==========================================

        JToolBar toolBar = new JToolBar();

        toolBar.add(new JButton("Добавить"));
        toolBar.add(new JButton("Изменить"));
        toolBar.add(new JButton("Удалить"));
        toolBar.add(new JButton("Обновить"));

        // ==========================================
        // Панель информации
        // ==========================================

        JPanel informationPanel =
                new JPanel(new GridLayout(6, 2, 10, 10));

        informationPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 10, 10
                )
        );

        // Банк
        informationPanel.add(
                new JLabel("Банк:")
        );

        JComboBox<String> bankComboBox =
                new JComboBox<>();

        bankComboBox.addItem("Сбербанк");
        bankComboBox.addItem("ВТБ");
        bankComboBox.addItem("Альфа-Банк");

        informationPanel.add(bankComboBox);

        // ФИО клиента
        informationPanel.add(
                new JLabel("ФИО клиента:")
        );

        clientField = new JTextField();

        informationPanel.add(clientField);

        // Номер счёта
        informationPanel.add(
                new JLabel("Номер счёта:")
        );

        accountNumberField =
                new JTextField("40817810001");

        informationPanel.add(accountNumberField);

        // Тип счёта
        informationPanel.add(
                new JLabel("Тип счёта:")
        );

        JComboBox<String> accountTypeComboBox =
                new JComboBox<>();

        accountTypeComboBox.addItem("Сберегательный");
        accountTypeComboBox.addItem("Расчётный");

        informationPanel.add(accountTypeComboBox);

        // Баланс
        informationPanel.add(
                new JLabel("Баланс:")
        );

        balanceField =
                new JTextField("150000");

        informationPanel.add(balanceField);

        // Валюта
        informationPanel.add(
                new JLabel("Валюта:")
        );

        JComboBox<String> currencyComboBox =
                new JComboBox<>();

        currencyComboBox.addItem("RUB");
        currencyComboBox.addItem("USD");
        currencyComboBox.addItem("EUR");

        informationPanel.add(currencyComboBox);

        // ==========================================
        // Верхняя часть окна
        // ==========================================

        JPanel topPanel =
                new JPanel(new BorderLayout());

        topPanel.add(
                toolBar,
                BorderLayout.NORTH
        );

        topPanel.add(
                informationPanel,
                BorderLayout.CENTER
        );

        frame.add(
                topPanel,
                BorderLayout.NORTH
        );

        // ==========================================
        // Таблица счетов
        // ==========================================

        String[] columns = {
                "ФИО клиента",
                "Номер счёта",
                "Тип",
                "Баланс",
                "Валюта"
        };

        Object[][] data = {
                {
                        "Иванов Иван Иванович",
                        "40817810001",
                        "Сберегательный",
                        "150000",
                        "RUB"
                },
                {
                        "Петров Пётр Петрович",
                        "40817810002",
                        "Расчётный",
                        "50000",
                        "RUB"
                },
                {
                        "Сидоров Алексей Сергеевич",
                        "40817810003",
                        "Сберегательный",
                        "2500",
                        "EUR"
                }
        };

        DefaultTableModel tableModel =
                new DefaultTableModel(
                        data,
                        columns
                );

        JTable accountTable =
                new JTable(tableModel);

        JScrollPane scrollPane =
                new JScrollPane(accountTable);

        frame.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // ==========================================
        // Нижняя часть окна
        // ==========================================

        JPanel bottomPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        JButton closeButton =
                new JButton("Закрыть");

        bottomPanel.add(closeButton);

        frame.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // Кнопка закрытия окна
        closeButton.addActionListener(
                e -> System.exit(0)
        );
    }

    /**
     * Запускает приложение и отображает
     * главное окно банковской системы.
     *
     * @param args параметры командной строки
     */
    public static void main(String[] args) {

        lab_two_Main application =
                new lab_two_Main();

        application.frame.setVisible(true);
    }
}

