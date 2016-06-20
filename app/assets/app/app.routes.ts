import {provideRouter, RouterConfig} from "@angular/router"

import {TodoAppComponent}  from "./app"

export const routes:RouterConfig = [
    {path: "/", component: TodoAppComponent},
]

export const APP_ROUTER_PROVIDERS = [provideRouter(routes)]
