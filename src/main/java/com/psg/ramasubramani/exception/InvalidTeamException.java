package com.psg.ramasubramani.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

/**
 * @author rn5
 * 
 * Request :
 * 
	mutation {
	  newPlayer(teamName: "Indian", playerName: "Rahul Dravid", playerAge: 40) {
	    id
	    name
	    age
	  }
	}
 * 
 * Response :
 * 
	 {
	  "data": null,
	  "errors": [
	    {
	      "message": "Exception while fetching data (/newPlayer) : Invalid Team Name",
	      "path": [
	        "newPlayer"
	      ],
	      "exception": {
	        "cause": null,
	        "locations": null,
	        "errorType": "ValidationError",
	        "message": "Invalid Team Name",
	        "path": null,
	        "extensions": null,
	        "localizedMessage": "Invalid Team Name",
	        "suppressed": []
	      },
	      "locations": [
	        {
	          "line": 2,
	          "column": 3
	        }
	      ],
	      "extensions": null,
	      "errorType": "DataFetchingException"
	    }
	  ]
	}
 *
 */
public class InvalidTeamException extends RuntimeException implements GraphQLError {

	private static final long serialVersionUID = 1L;

	public InvalidTeamException(String message) {
		super(message);
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.ValidationError;
	}

	@Override
	@JsonIgnore //Error handler to print not to stack trace.
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}

}
