package com.aventon.platform.u202215823.crm.interfaces.rest;

import com.aventon.platform.u202215823.crm.domain.services.RatingCommandService;
import com.aventon.platform.u202215823.crm.interfaces.rest.resources.CreateRatingResource;
import com.aventon.platform.u202215823.crm.interfaces.rest.resources.RatingResource;
import com.aventon.platform.u202215823.crm.interfaces.rest.transform.CreateRatingCommandFromResourceAssembler;
import com.aventon.platform.u202215823.crm.interfaces.rest.transform.RatingResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/products/{productid}/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Ratings", description = "Operations related to ratings")
public class RatingController {

    private final RatingCommandService ratingCommandService;

    public RatingController(RatingCommandService ratingCommandService) {
        this.ratingCommandService = ratingCommandService;
    }

    @Operation(
            summary = "Create a rating",
            description = "Creates a rating with the data provided in the request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rating created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<RatingResource> createRating(@RequestBody CreateRatingResource resource){
        var createRatingCommand = CreateRatingCommandFromResourceAssembler.toCommandFromResource(resource);
        var rating = ratingCommandService.handle(createRatingCommand);
        if (rating.isEmpty()){return ResponseEntity.badRequest().build();}
        var sensorResource = RatingResourceFromEntityAssembler.toResourceFromEntity(rating.get());
        return new ResponseEntity<>(sensorResource, HttpStatus.CREATED);
    }
}
