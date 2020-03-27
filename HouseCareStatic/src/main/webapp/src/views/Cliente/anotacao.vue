<template>
    <ContentWrapper>
        <div class="content-heading">Anotações
            <div class="ml-auto">
               <router-link class="btn btn-secondary right" tag="a" to="/cliente/1/anotacao/criar">Adicionar Novo</router-link>
               <router-link class="btn btn-secondary right" tag="a" to="/cliente/editar/1">Voltar</router-link>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-12 col-lg-12">
                <div class="card card-default">
                    <div class="card-body">
                        <!-- p.lead.text-centerNo mails here-->
                        <table class="table table-hover mb-mails">
                            <tbody>
                                <tr>
                                    <td>
                                        <div class="d-flex">
                                            <img class="mb-mail-avatar mr-2" alt="Mail Avatar" src="img/user/01.jpg" />
                                            <div class="mb-mail-meta">
                                                <div class="mb-mail-subject">Admin web application</div>
                                                <div class="mb-mail-from">Evelyn Holmes</div>
                                                <div class="mb-mail-preview">Fusce gravida, diam ac adipiscing pretium, sem nibh bibendum diam, non consequat quam metus non nunc</div>
                                            </div>
                                            <div class="mb-mail-date ml-auto">10 minutes ago</div>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </ContentWrapper>
</template>