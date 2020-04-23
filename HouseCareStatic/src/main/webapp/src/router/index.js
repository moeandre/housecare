import Vue from 'vue'
import VueRouter from 'vue-router'
import nprogress from 'nprogress'

// Layouts
import Layout from '@/components/Layout/Layout'
import LayoutPage from '@/components/Layout/LayoutPage'
// Dashboard
const Home = () => import('@/views/Home/index.vue')
// Pages
const Error404 = () => import('@/views/Pages/404.vue')
const Error500 = () => import('@/views/Pages/500.vue')
const Lock = () => import('@/views/Pages/Lock.vue')
const Login = () => import('@/views/Pages/Login.vue')
const Maintenance = () => import('@/views/Pages/Maintenance.vue')
const Recover = () => import('@/views/Pages/Recover.vue')
const Register = () => import('@/views/Pages/Register.vue')
const Template = () => import('@/views/Pages/Template.vue')

//Cliente
const ClienteHome = () => import('@/views/Cliente/lista.vue')
const ClienteEditar = () => import('@/views/Cliente/formulario.vue')
const FaturaClienteEditar = () => import('@/views/Cliente/fatura.vue')
const AnotacaoClienteEditar = () => import('@/views/Cliente/anotacao.vue')
const HospedagemClienteEditar = () => import('@/views/Cliente/hospedagem.vue')

//Familiar
const FamiliarHome = () => import('@/views/Familiar/lista.vue')

//Funcionario
const FuncionarioHome = () => import('@/views/Usuario/lista.vue')
const FuncionarioEditar = () => import('@/views/Usuario/formulario.vue')

//Funcionario
const FaturaHome = () => import('@/views/Fatura/lista.vue')
const FaturaEditar = () => import('@/views/Fatura/detalhe.vue')

Vue.use(VueRouter)
 
const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            redirect: '/home',
        },
        {
            path: '/',
            component: Layout,
            children: [
                {
                    path: '/cliente',
                    component: ClienteHome
                },
                {
                    path: '/cliente/criar',
                    component: ClienteEditar
                },
                {
                    name: 'editar-cliente',
                    path: '/cliente/editar/:id',
                    component: ClienteEditar
                },
                {
                    name: 'fatura-cliente',
                    path: '/cliente/:id/fatura',
                    component: FaturaClienteEditar
                }, 
                {
                    name: 'anotacao-cliente',
                    path: '/cliente/:id/anotacao',
                    component: AnotacaoClienteEditar
                },            
                {
                    name: 'hospedagem-cliente',
                    path: '/cliente/:id/hospedagem',
                    component: HospedagemClienteEditar
                },            
                {
                    name: 'familiar-cliente',
                    path: '/cliente/:id/familiar',
                    component: FamiliarHome
                },            
                {
                    path: '/familiar',
                    component: FamiliarHome
                },
                {
                    path: '/usuario',
                    component: FuncionarioHome
                },
                {
                    path: '/usuario/criar',
                    component: FuncionarioEditar,
                },
                {
                    name: 'editar-funcionario',
                    path: '/usuario/editar/:id',
                    component: FuncionarioEditar,
                },
                {
                    name: 'listar-fatura',
                    path: '/fatura',
                    component: FaturaHome
                },
                {
                    name: 'detalhar-fatura',
                    path: '/fatura/detalhar/:id',
                    component: FaturaEditar,
                },
                

            ]
        },
        // Admin Pages
        {
            path: '/',
            component: Layout,
            children: [
                // Dashboard
                {
                    path: '/home',
                    component: Home
                },
                // Extras
            ]
        },
        // User Pages
        {
            path: '/',
            component: LayoutPage,
            children: [
                {
                    component: Login,
                    path: '/login',
                }, {
                    component: Register,
                    path: '/register',
                }, {
                    component: Recover,
                    path: '/recover',
                }, {
                    component: Lock,
                    path: '/lock',
                }, {
                    component: Error404,
                    path: '/notfound',
                }, {
                    component: Error500,
                    path: '/error500'
                }, {
                    component: Maintenance,
                    path: '/maintenance'
                },
            ]
        },
        // Not found route
        {
            path: '*',
            redirect: '/'
        }
    ]
});

router.beforeEach((to, from, next) => {
    // redirect to login page if not logged in and trying to access a restricted page
    //const publicPages = ['/login', '/register'];
    //const authRequired = !publicPages.includes(to.path);
    const loggedIn = localStorage.getItem('user');

    if(to.name){
        nprogress.start();
    }
    if (!loggedIn && to.path != '/login') {
      return next('/login');
    }
  
    next();
  });

  router.afterEach((to, from) => {
    // Complete the animation of the route progress bar.
    nprogress.done();
  })

  export default router;