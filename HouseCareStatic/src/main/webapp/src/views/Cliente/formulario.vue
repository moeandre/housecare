<template>
    <ContentWrapper>
        <div class="content-heading">Clientes
            <div class="ml-auto">
                <router-link class="btn btn-secondary right" tag="a" to="/cliente/">Voltar</router-link>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="card card-default">
                    <div class="card-body text-center">
                        <div class="py-4">
                            <img class="img-fluid rounded-circle img-thumbnail thumb96" src="img/user/13.jpg" alt="Contact" />
                        </div>
                        <h3 class="m-0 text-bold">Teresinha</h3>
                        <div class="my-3">
                            <p>Hello, I'm a just a dummy contact in your contact list and this is my presentation text. Have fun!</p>
                        </div>
                    </div>
                </div>
                <div class="card card-default d-none d-lg-block">
                    <div class="card-header">
                        <div class="card-title text-center">Familiares</div>
                    </div>
                    <div class="card-body">
                        <div class="media">
                            <img class="align-self-center mr-2 rounded-circle img-thumbnail thumb48" src="img/user/05.jpg" alt="Contact" />
                            <div class="media-body py-2">
                                <div class="text-bold">Filha
                                    <div class="text-sm text-muted">6677-0000</div>
                                </div>
                            </div>
                        </div>
                        <div class="media">
                            <img class="align-self-center mr-2 rounded-circle img-thumbnail thumb48" src="img/user/05.jpg" alt="Contact" />
                            <div class="media-body py-2">
                                <div class="text-bold">Luis Vasquez
                                    <div class="text-sm text-muted">2h ago</div>
                                </div>
                            </div>
                        </div>
                        <div class="media">
                            <img class="align-self-center mr-2 rounded-circle img-thumbnail thumb48" src="img/user/06.jpg" alt="Contact" />
                            <div class="media-body py-2">
                                <div class="text-bold">Duane Mckinney
                                    <div class="text-sm text-muted">yesterday</div>
                                </div>
                            </div>
                        </div>
                        <div class="media">
                            <img class="align-self-center mr-2 rounded-circle img-thumbnail thumb48" src="img/user/07.jpg" alt="Contact" />
                            <div class="media-body py-2">
                                <div class="text-bold">Connie Lambert
                                    <div class="text-sm text-muted">2 weeks ago</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card card-default">
                    <div class="card-header d-flex align-items-center">
                        <div class="d-flex col">
                            <div class="h4 m-0">Dados Cadastrais</div>
                        </div>
                        <div class="d-flex justify-content-end">
                                <b-dropdown id="ddown1" variant="link" no-caret right>
                                    <template slot="button-content">
                                        <em class="fa fa-ellipsis-v fa-lg text-muted"></em>
                                    </template>
                                    <!--dropdown-item>Conta Corrente</b-dropdown-item>
                                    <b-dropdown-item>Serviços</b-dropdown-item>
                                    <b-dropdown-item>Inventário</b-dropdown-item -->
                                    <b-dropdown-item>
                                        <router-link tag="a" to="/cliente/1/fatura">Lançamentos de Fatura</router-link>
                                    </b-dropdown-item>
                                    <b-dropdown-divider></b-dropdown-divider>
                                    <b-dropdown-item>
                                        <router-link tag="a" to="/cliente/1/anotacao">Anotações</router-link>
                                    </b-dropdown-item>
                                    <b-dropdown-item>
                                        <router-link tag="a" to="/cliente/1/hospedagem">Hospedagem</router-link>
                                    </b-dropdown-item>
                                </b-dropdown>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row py-4 justify-content-center">
                            <div class="col-12 col-sm-10">
                                <form class="form-horizontal">
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact1">Nome</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact1" type="text" placeholder="" value="Audrey Hunt" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact2">Sobrenome</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact2" type="email" value="mail@example.com" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact3">Apelido</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact3" type="text" value="(123) 465 789" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact4">CPF</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact4" type="text" value="(12) 123 987 465" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact5">Nascimento</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact5" type="text" value="http://some.wesbite.com" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact6">Nacionalidade</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact5" type="text" value="http://some.wesbite.com" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact7">Naturalidade</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact7" type="text" value="@Social" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact8">Company</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact8" type="text" placeholder="No Company" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact8">Cadastro</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            Data
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact8">Alteração</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            Data
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-md-12 text-right">
                                            <button class="btn btn-primary mr-1" type="button">Armazenar</button>
                                            <button class="btn btn-secondary mr-1" type="button">Cancelar</button>
                                        </div>
                                    </div>
                                </form>
                                <div class="text-right">
                                    <a class="text-muted" href="#">Remover o Hospede?</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </ContentWrapper>
</template>
