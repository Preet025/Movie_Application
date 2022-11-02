import { Directive, HostBinding, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHover]'
})
export class HoverDirective {

  constructor() { }

  @Input('appHover') 
  zoom : string  = "";
 
  @HostBinding('style.transform')
  hover : string = "";

  @HostListener('mouseenter') onEnter()
  {
    this.hover = this.zoom;
  }

  @HostListener('mouseleave') onLeave()
  {
    this.hover = "";
  }

}
