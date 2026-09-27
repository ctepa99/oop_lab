package oop.lab;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab_three_Main {

    // Главное окно программы
    private JFrame frame;

    // Поля для ввода данных
    private JTextField clientField;
    private JTextField accountNumberField;
    private JTextField balanceField;

    // Список валют
    private JComboBox<String> currencyComboBox;

    // Создание окна
    public lab_three_Main() {

        frame = new JFrame();

        frame.setTitle("Банковская система");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        createInterface();
    }

    // Создание интерфейса
    private void createInterface() {

        frame.setLayout(new BorderLayout());

        // ==========================================
        // Панель кнопок
        // ==========================================

        JToolBar toolBar = new JToolBar();

        JButton addButton = new JButton("Добавить");
        JButton editButton = new JButton("Изменить");
        JButton deleteButton = new JButton("Удалить");
        JButton refreshButton = new JButton("Обновить");

        toolBar.add(addButton);
        toolBar.add(editButton);
        toolBar.add(deleteButton);
        toolBar.add(refreshButton);

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

        currencyComboBox =
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

        // ==========================================
        // СЛУШАТЕЛЬ 1 — кнопка "Добавить"
        // ==========================================

        /**
         * Обрабатывает нажатие кнопки «Добавить».
         * Выводит сообщение об успешном добавлении клиента.
         */
        addButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {

                        JOptionPane.showMessageDialog(
                                frame,
                                "Клиент добавлен"
                        );
                    }
                }
        );

        // ==========================================
        // СЛУШАТЕЛЬ 2 — кнопка "Удалить"
        // ==========================================

        /**
         * Обрабатывает нажатие кнопки «Удалить».
         * Выводит сообщение об удалении клиента.
         */
        deleteButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {

                        JOptionPane.showMessageDialog(
                                frame,
                                "Клиент удалён"
                        );
                    }
                }
        );

        // ==========================================
        // СЛУШАТЕЛЬ 3 — выбор валюты
        // ==========================================

        /**
         * Обрабатывает изменение выбранной валюты.
         * Получает выбранное значение и выводит его пользователю.
         */
        currencyComboBox.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {

                        String currency =
                                (String) currencyComboBox.getSelectedItem();

                        JOptionPane.showMessageDialog(
                                frame,
                                "Выбрана валюта: " + currency
                        );
                    }
                }
        );

        // ==========================================
        // Кнопка "Закрыть"
        // ==========================================

        closeButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                }
        );
    }

    // Запуск программы
    public static void main(String[] args) {

        lab_three_Main application =
                new lab_three_Main();

        application.frame.setVisible(true);
    }
}

