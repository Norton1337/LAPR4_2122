/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.categorymanagment.repositories.CategoryRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.questionnairemanagement.QuestionnaireRepository;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.base.warehouses.repositories.*;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }


    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public WarehouseRepository warehouse(TransactionalContext autoTx) {
        return new InMemoryWarehouseRepository();
    }
    @Override
    public WarehouseRepository warehouse() {
        return warehouse(null);
    }

    @Override
    public OrderRepository order(TransactionalContext autoTx) {
        return new InMemoryOrderRepository();
    }
    @Override
    public OrderRepository order() {
        return order(null);
    }

    @Override
    public TaskRepository task(TransactionalContext autoTx) {
        return new InMemoryTaskRepository();
    }
    @Override
    public TaskRepository task() {
        return task(null);
    }

    @Override
    public AgvRepository agv(TransactionalContext autoTx) {
        return new InMemoryAgvRepository();
    }
    @Override
    public AgvRepository agv() {
        return agv(null);
    }

    @Override
    public AgvDockRepository agvDock(TransactionalContext autoTx) {
        return new InMemoryAgvDockRepository();
    }

    @Override
    public AgvDockRepository agvDock() {
        return agvDock(null);
    }

    @Override
    public ProductRepository product(TransactionalContext autoTx) {
        return new InMemoryProductRepository();
    }

    @Override
    public ProductRepository product() {
        return product(null);
    }

    @Override
    public CategoryRepository category(TransactionalContext autoTx) {
        return new InMemoryCategoryRepository();
    }

    @Override
    public CategoryRepository category() {
        return category(null);
    }

    @Override
    public QuestionnaireRepository questionnaire(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public QuestionnaireRepository questionnaire() {
        return null;
    }

    @Override
    public BinRepository bin(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public BinRepository bin() {
        return null;
    }

    @Override
    public AisleRepository aisle(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public AisleRepository aisle() {
        return null;
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
