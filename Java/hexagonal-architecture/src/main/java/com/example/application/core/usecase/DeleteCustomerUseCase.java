package com.example.application.core.usecase;

import com.example.application.ports.in.DeleteCustomerInputPort;
import com.example.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;

    public DeleteCustomerUseCase(DeleteCustomerOutputPort deleteCustomerOutputPort) {
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
    }

    @Override
    public void delete(int customerId) {
        this.deleteCustomerOutputPort.delete(customerId);
    }
}
