package com.company.objects.bank_management.models.account;

import java.math.BigDecimal;

public interface Taxable {
    void tax(BigDecimal income);
}
