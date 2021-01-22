<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="form-group row">
	<label class="col-12 col-form-label">Please carefully read and
		select one or more Business Activity categories that best match to
		your business from below. If none of the Business Activities apply to
		your business, you will be redirected to our Regular Business
		Registration page.</label>
</div>
<hr />
<fieldset id="group-1" class="fund-class-group">
	<legend class="legend-fund-class">&nbsp 1 &nbsp</legend>
	<div class="form-group">
		<h5 class="text-underline">Child Care and Social Assistance</h5>
		<p>
			You provide <strong>non-medical</strong> child care in a daycare
			setting.
		</p>
	</div>
	<div class="form-group">
		<h5 class="text-underline">Tugboat Services</h5>
		<p>You provide tugboat services.</p>
	</div>
	<div class="form-group">
		<h5 class="text-underline">Wholesale sales</h5>
		<p>
			You provide <strong>wholesale</strong> sales of goods, wares, or
			merchandise for the purpose of resale.
		</p>
		<div class="form-check-inline checkbox-highlight">
			<form:checkbox class="form-check-input fund-class-input"
				path="fundClass" value="LGR1" />
			<label class="form-check-label">Check here if your business
				belongs in this category.</label>
		</div>
	</div>
</fieldset>
<fieldset id="group-2" class="fund-class-group">
	<legend class="legend-fund-class">&nbsp 2 &nbsp</legend>
	<div class="form-group">
		<h5 class="text-underline">Property Rentals</h5>
		<p>You provide rentals of commercial, hotel, or residential units.</p>
	</div>
	<div class="form-group">
		<h5 class="text-underline">Radio, Television, and Theater</h5>
		<p>You assist with radio or television shows, either as a
			service for the show or actual production of the show.</p>
		<p>Also covered are businesses operating theaters for live
			entertainment or motion picture movie theaters including drive-in
			theaters.</p>
	</div>
	<div class="form-group">
		<h5 class="text-underline">Retail Sales</h5>
		<p>
			You provide <strong>retail</strong> sales of goods, wares, or
			merchandise for any purpose NOT INCLUDING resale.
		</p>
	</div>
	<div class="form-group">
		<h5 class="text-underline">Swap Meet and Antique Sales</h5>
		<p>You operate swap meets and antique sales, including shops and
			shows.</p>
	</div>
	<div class="form-group">
		<h5 class="text-underline">Telecommunications</h5>
		<p>You provide phone and internet services.</p>
		<div class="form-check-inline checkbox-highlight">
			<form:checkbox class="form-check-input fund-class-input"
				path="fundClass" value="LGR2" />
			<label class="form-check-label">Check here if your business
				belongs in this category.</label>
		</div>
	</div>
</fieldset>
<fieldset id="group-3" class="fund-class-group">
	<legend class="legend-fund-class">&nbsp 3 &nbsp</legend>
	<div class="form-group">
		<h5 class="text-underline">Educational and Medical Institutions</h5>
		<p>You run a school or similar educational facility, or medical
			facility such as a hospital or nursing home.</p>
		<h5 class="text-underline">Professions, Occupations</h5>
		<p>You provide professional or occupational services and skilled
			work. Examples include but are not limited to: attorneys, auto
			mechanics, barbers, teachers, and medical professionals.</p>
		<div class="form-check-inline checkbox-highlight">
			<form:checkbox class="form-check-input fund-class-input"
				path="fundClass" value="L049" />
			<label class="form-check-label">Check here if your business
				belongs in this category.</label>
		</div>
	</div>
</fieldset>