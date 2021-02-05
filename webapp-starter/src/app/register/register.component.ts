import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NzModalService } from 'ng-zorro-antd/modal';
import { UserService } from './user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  title = 'webapp-starter';
  registerForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private modal: NzModalService
  ) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]],
      confirmPassword: [
        null,
        [Validators.required, this.confirmPasswordValidator],
      ],
    });
  }

  confirmPasswordValidator = (
    control: FormControl
  ): { [s: string]: boolean } => {
    if (!control.value) {
      return { required: true };
    } else if (control.value !== this.registerForm.controls.password.value) {
      return { confirm: true, error: true };
    }
    return {};
  };

  onSubmit = (): void => {
    for (const i in this.registerForm.controls) {
      this.registerForm.controls[i].markAsDirty();
      this.registerForm.controls[i].updateValueAndValidity();
    }
    if (this.registerForm.valid) {
      this.userService.createUser(this.registerForm.value).subscribe(
        (_) => this.onSuccess(),
        (error) => this.onError(error)
      );
    }
  };

  onSuccess = (): void => {
    this.modal.success({
      nzTitle: 'Success!',
      nzContent: 'Registration successful',
    });
  };

  onError = (error: any): void => {
    this.modal.error({
      nzTitle: 'Oups! something when wrong!',
      nzContent: error,
    });
  };

}
