<template>
    <ContentWrapper>
        <div class="content-heading">Familiares
            <div class="ml-auto">
               <a class="btn btn-secondary right" :href="'/familiar/'">Voltar</a>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="card card-default">
                    <div class="card-header d-flex align-items-center">
                        <div class="d-flex col">
                            <div class="h4 m-0">Dados Cadastrais</div>
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
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact2">Parentesco</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact2" type="email" value="mail@example.com" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact4">Telefone</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact4" type="text" value="(12) 123 987 465" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact6">E-mail</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="inputContact5" type="text" value="http://some.wesbite.com" />
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
                                    <a class="text-muted" href="#">Remover o Familiar?</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </ContentWrapper>
</template>
