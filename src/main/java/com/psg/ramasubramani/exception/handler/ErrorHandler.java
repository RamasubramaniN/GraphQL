package com.psg.ramasubramani.exception.handler;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

/**
 * @author rn5
 *
 */
public class ErrorHandler implements GraphQLErrorHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphql.servlet.GraphQLErrorHandler#processErrors(java.util.List)
	 */
	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> list) {
		return list.stream().map(this::getActualException).collect(Collectors.toList());
	}

	private GraphQLError getActualException(GraphQLError error) {
		if (error instanceof ExceptionWhileDataFetching) {
			ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) error;
			if (exceptionError.getException() instanceof GraphQLError) {
				return (GraphQLError) exceptionError.getException();
			}
		}
		return error;
	}
	
}
