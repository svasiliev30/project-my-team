package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.GlobalUser;

/**
 * Класс enum содержит описание значений поля в таблие global_user.user_role
 * @autor Sergey Proshchaev
 * @version 1.0
 * @see GlobalUser#Object()
 */
public enum UserRoleType {
    User,
    Operator,
    Admin;

    UserRoleType() {
    }

}
