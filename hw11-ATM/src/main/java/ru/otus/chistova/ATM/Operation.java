package ru.otus.chistova.ATM;

//Операция, выполняемая банкоматом, возвращает true при удачном выполнении, false - при ошибке
public interface Operation {
    long doOperation();
}
