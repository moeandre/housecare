<template>
    <header class="topnavbar-wrapper">
        <!-- START Top Navbar-->
        <nav class="navbar topnavbar">
            <!-- START navbar header-->
            <div class="navbar-header">
                <a class="navbar-brand" href="#/">
                    <div class="brand-logo">
                        <img class="img-fluid" src="img/logo.png" alt="App Logo">
                    </div>
                    <div class="brand-logo-collapsed">
                        <img class="img-fluid" src="img/logo-single.png" alt="App Logo">
                    </div>
                </a>
            </div>
            <!-- END navbar header-->
            <!-- START Left navbar-->
            <ul class="navbar-nav mr-auto flex-row">
                <li class="nav-item">
                    <!-- Button used to collapse the left sidebar. Only visible on tablet and desktops-->
                     <a href="" class="nav-link d-none d-md-block d-lg-block d-xl-block" @click.prevent="toggleAsideCollapsed">
                        <em class="fas fa-bars"></em>
                    </a>
                    <!-- Button to show/hide the sidebar on mobile. Visible on mobile only.-->
                    <a href="" class="nav-link sidebar-toggle d-md-none" @click.prevent="toggleOffcanvas">
                        <em class="fas fa-bars"></em>
                    </a>
                </li>
                
                <li class="nav-item d-none d-md-block" v-if="account.user.empresa">
                    <span class="nav-link">Empresa: {{account.user.empresa.nomeFantasia}}</span>
                </li>
                <!-- END User avatar toggle-->
            </ul>
            <!-- END Left navbar-->
            <!-- START Right Navbar-->
            <ul class="navbar-nav flex-row">
                <!-- Fullscreen (only desktops)-->
                <li class="nav-item d-none d-md-block">
                    <ToggleFullscreen tag="A" class="nav-link" href="#" />
                </li>
                <!-- START Alert menu-->
                <b-nav-item-dropdown class="dropdown-list" no-caret menuClass="animated flipInX" right>
                    <template slot="button-content">
                        <em class="icon-bell"></em>
                        <span class="badge badge-danger">11</span>
                    </template>
                    <b-dropdown-item>
                        <!-- START list group-->
                        <div class="list-group">
                            <!-- list item-->
                            <!-- list item-->
                            <div class="list-group-item list-group-item-action">
                                <div class="media">
                                    <div class="align-self-start mr-2">
                                        <em class="fas fa-tasks fa-2x text-success"></em>
                                    </div>
                                    <div class="media-body">
                                        <p class="m-0">Pending Tasks</p>
                                        <p class="m-0 text-muted text-sm">11 pending task</p>
                                    </div>
                                </div>
                            </div>
                            <!-- last list item-->
                            <div class="list-group-item list-group-item-action">
                                <span class="d-flex align-items-center">
                                    <span class="text-sm">More notifications</span>
                                    <span class="badge badge-danger ml-auto">14</span>
                                </span>
                            </div>
                        </div>
                        <!-- END list group-->
                    </b-dropdown-item>
                </b-nav-item-dropdown>
                <!-- END Alert menu-->
            </ul>
        </nav>
        <!-- END Top Navbar-->
    </header>
</template>

<script>
    import { mapState, mapMutations } from 'vuex'
    import HeaderSearch from '@/components/Layout/HeaderSearch'
    import ToggleFullscreen from '@/components/Common/ToggleFullscreen'

    export default {
        name: 'Header',
        computed: {
            ...mapState({
                account: state => state.account
            })
        },
        data: () => {
            return {
                navSearchOpen: false
            }
        },
        components: {
            HeaderSearch,
            ToggleFullscreen
        },
        methods: {
            /**
             * Triggers a window resize event when clicked
             * for plugins that needs to be redrawed
             */
            resize: e => {
                // all IE friendly dispatchEvent
                var evt = document.createEvent('UIEvents');
                evt.initUIEvent('resize', true, false, window, 0);
                window.dispatchEvent(evt);
                // modern dispatchEvent way
                // window.dispatchEvent(new Event('resize'));
            },
            ...mapMutations([
                'toggleSetting'
            ]),
            toggleOffsidebar() {
                this.toggleSetting('offsidebarOpen')
            },
            toggleOffcanvas() {
                this.toggleSetting('asideToggled')
            },
            toggleAsideCollapsed() {
                this.toggleSetting('isCollapsed')
                this.resize();
            },
            toggleUserBlock() {
                this.toggleSetting('showUserBlock')
            },
            toggleNavSearch () {
                this.navSearchOpen = !this.navSearchOpen;
            },
            closeNavSearch() {
                this.navSearchOpen = false;
            }
        }
    }
</script>