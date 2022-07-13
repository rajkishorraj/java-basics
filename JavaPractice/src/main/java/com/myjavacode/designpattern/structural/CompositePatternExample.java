package com.myjavacode.designpattern.structural;

import java.util.List;

public class CompositePatternExample {

}

interface Department {
    void showDepartmentName();
}

class SalesDepartment implements Department {

    @Override
    public void showDepartmentName() {

    }
}

class FinancialDepartment implements Department {

    @Override
    public void showDepartmentName() {

    }
}

class DepartmentDirectory implements Department {

    private List<Department> departments;

    @Override
    public void showDepartmentName() {
        departments.forEach(department -> {});
    }

    public void addDepartment(Department department) {

    }

    public void removeDepartment(Department department) {

    }
}