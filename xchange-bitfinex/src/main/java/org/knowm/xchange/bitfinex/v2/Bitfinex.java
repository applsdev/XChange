package org.knowm.xchange.bitfinex.v2;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.knowm.xchange.bitfinex.v1.dto.BitfinexException;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexPublicFundingTrade;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexPublicTrade;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexTicker;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.Status;

@Path("v2")
@Produces(MediaType.APPLICATION_JSON)
public interface Bitfinex {

  @GET
  @Path("tickers")
  BitfinexTicker[] getTickers(@QueryParam("symbols") String symbols)
      throws IOException, BitfinexException;

  @GET
  @Path("status/{type}")
  List<Status> getStatus(@PathParam("type") String type, @QueryParam("keys") String symbols)
      throws IOException, BitfinexException;

  @GET
  @Path("/trades/{symbol}/hist")
  BitfinexPublicFundingTrade[] getPublicFundingTrades(
      @PathParam("symbol") String fundingSymbol,
      @QueryParam("limit") int limit,
      @QueryParam("start") long startTimestamp,
      @QueryParam("end") long endTimestamp,
      @QueryParam("sort") int sort)
      throws IOException, BitfinexException;

  @GET
  @Path("/trades/{symbol}/hist")
  BitfinexPublicTrade[] getPublicTrades(
      @PathParam("symbol") String fundingSymbol,
      @QueryParam("limit") int limit,
      @QueryParam("start") long startTimestamp,
      @QueryParam("end") long endTimestamp,
      @QueryParam("sort") int sort)
      throws IOException, BitfinexException;
}
