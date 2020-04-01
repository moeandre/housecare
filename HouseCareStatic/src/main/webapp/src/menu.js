const Menu = [
    {
        heading: 'Menu Principal',
        translate: 'Menu Principal'
    },
    {
        name: 'Cliente/Hospedagem',
        icon: 'icon-diamond',
        translate: 'Cliente/Hospedagem',
        submenu: [{
                name: 'Dados Cadastrais',
                path: '/cliente'
            },
            {
                name: 'Hospedagem',
                path: '/cliente'
            },
            {
                name: 'Inventário',
                path: '/cliente'
            },
            {
                name: 'Farmácia',
                path: '/cliente'
            },
            {
                name: 'Serviços',
                path: '/cliente'
            },
            {
                name: 'Conta Corrente',
                path: '/cliente'
            },
            {
                name: 'Fatura',
                path: '/cliente'
            }
        ]
    },
    {
        name: 'Usuários',
        icon: 'fa fa-cog',
        translate: 'Usuários',
        submenu: [{
                name: 'Cadastro',
                path: '/cliente'
            }
        ]
    },
    {
        name: 'Médico',
        icon: 'fa fa-hospital',
        translate: 'Médico',
        submenu: [{
                name: 'Anotações',
                path: '/cliente'
            },
            {
                name: 'Prescrição',
                path: '/cliente'
            },
            {
                name: 'Evolução do Cliente',
                path: '/cliente'
            }
        ]
    },
    {
        name: 'Enfermeira',
        icon: 'fa fa-heart',
        translate: 'Médico',
        submenu: [{
                name: 'Anotações',
                path: '/cliente'
            },
            {
                name: 'Prescrição',
                path: '/cliente'
            },
            {
                name: 'Evolução do Cliente',
                path: '/cliente'
            }
        ]
    },
    {
        name: 'Nutricionista',
        icon: 'fa fa-lemon',
        translate: 'Médico',
        submenu: [{
                name: 'Anotações',
                path: '/cliente'
            },
            {
                name: 'Prescrição',
                path: '/cliente'
            },
            {
                name: 'Evolução do Cliente',
                path: '/cliente'
            }
        ]
    },
    {
        name: 'Auxiliar de Enfermagem',
        icon: 'fa fa-pills',
        translate: 'Médico',
        submenu: [{
                name: 'Anotações',
                path: '/cliente'
            }
        ]
    },
    {
        name: 'Configurações',
        icon: 'fa fa-cogs',
        translate: 'Configurações',
        submenu: [{
                name: 'Companhia',
                path: '/cliente'
            },
            {
                name: 'Quartos',
                path: '/cliente'
            }
        ]
    },
    {
        name: 'Sair',
        icon: 'fa fa-sign-out-alt',
        path: '/login'
    }
];

export default Menu;