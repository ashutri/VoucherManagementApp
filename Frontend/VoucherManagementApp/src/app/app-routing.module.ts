import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AdminComponent } from '../admin/admin/admin.component';
import { LoginComponent } from '../login/login/login.component';
import { ConsumerComponent } from '../consumer/consumer/consumer.component';
import { MerchantComponent } from '../merchant/merchant/merchant.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'logout', component: LoginComponent},
  {path: 'merchant', component: MerchantComponent},
  {path: 'consumer/consumerList/:mobile', component: ConsumerComponent},
  {path: 'merchant/:voucherId', component: MerchantComponent},
  {path: 'merchant', component: MerchantComponent},
  {path: 'consumer', component: ConsumerComponent},
  {path: 'admin/voucherList', component: AdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
