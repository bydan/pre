/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.contabilidad.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//TipoCambioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;




@SuppressWarnings("unused")
final public class TipoCambioDataAccess extends  TipoCambioDataAccessAdditional{ //TipoCambioDataAccessAdditional,DataAccessHelper<TipoCambio>
	//static Logger logger = Logger.getLogger(TipoCambioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_cambio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_moneda,valor_compra,valor_venta,fecha)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_moneda=?,valor_compra=?,valor_venta=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocambio from "+TipoCambioConstantesFunciones.SPERSISTENCENAME+" tipocambio";
	public static String QUERYSELECTNATIVE="select "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".id,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".version_row,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".id_empresa,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".id_moneda,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".valor_compra,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".valor_venta,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".fecha from "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME;//+" as "+TipoCambioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".id,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".version_row from "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME;//+" as "+TipoCambioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_moneda=?,valor_compra=?,valor_venta=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCAMBIO_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCAMBIO_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCAMBIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCAMBIO_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected TipoCambioDataAccessAdditional tipocambioDataAccessAdditional=null;
	
	public TipoCambioDataAccessAdditional getTipoCambioDataAccessAdditional() {
		return this.tipocambioDataAccessAdditional;
	}
	
	public void setTipoCambioDataAccessAdditional(TipoCambioDataAccessAdditional tipocambioDataAccessAdditional) {
		try {
			this.tipocambioDataAccessAdditional=tipocambioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoCambioDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		TipoCambioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCambioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCambioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setTipoCambioOriginal(TipoCambio tipocambio)throws Exception  {
		tipocambio.setTipoCambioOriginal((TipoCambio)tipocambio.clone());		
	}
	
	public void setTipoCambiosOriginal(List<TipoCambio> tipocambios)throws Exception  {
		
		for(TipoCambio tipocambio:tipocambios){
			tipocambio.setTipoCambioOriginal((TipoCambio)tipocambio.clone());
		}
	}
	
	public static void setTipoCambioOriginalStatic(TipoCambio tipocambio)throws Exception  {
		tipocambio.setTipoCambioOriginal((TipoCambio)tipocambio.clone());		
	}
	
	public static void setTipoCambiosOriginalStatic(List<TipoCambio> tipocambios)throws Exception  {
		
		for(TipoCambio tipocambio:tipocambios){
			tipocambio.setTipoCambioOriginal((TipoCambio)tipocambio.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  TipoCambio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCambio entity = new TipoCambio();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  TipoCambio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCambio entity = new TipoCambio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoCambio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCambioOriginal(new TipoCambio());
      	    	entity=super.getEntity("",entity,resultSet,TipoCambioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCambio("",entity,resultSet); 
				
				//entity.setTipoCambioOriginal(super.getEntity("",entity.getTipoCambioOriginal(),resultSet,TipoCambioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCambioOriginal(this.getEntityTipoCambio("",entity.getTipoCambioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCambio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCambio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCambio entity = new TipoCambio();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoCambio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCambio entity = new TipoCambio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCambioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoCambio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCambioOriginal(new TipoCambio());
      	    	entity=super.getEntity("",entity,resultSet,TipoCambioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCambio("",entity,resultSet);    
				
				//entity.setTipoCambioOriginal(super.getEntity("",entity.getTipoCambioOriginal(),resultSet,TipoCambioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCambioOriginal(this.getEntityTipoCambio("",entity.getTipoCambioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCambio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCambio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCambio entity = new TipoCambio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCambioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoCambio.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseTipoCambio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCambio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoCambio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCambioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCambio();
      	    	entity=super.getEntity("",entity,resultSet,TipoCambioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCambio("",entity,resultSet);
      	    	
				//entity.setTipoCambioOriginal( new TipoCambio());
      	    	//entity.setTipoCambioOriginal(super.getEntity("",entity.getTipoCambioOriginal(),resultSet,TipoCambioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCambioOriginal(this.getEntityTipoCambio("",entity.getTipoCambioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCambios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCambio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCambio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoCambio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCambio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCambio();
					//entity.setMapTipoCambio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCambioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCambio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCambioDataAccess.ISWITHSCHEMA);         		
					entity=TipoCambioDataAccess.getEntityTipoCambio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCambioOriginal( new TipoCambio());
					////entity.setTipoCambioOriginal(super.getEntity("",entity.getTipoCambioOriginal(),resultSet,TipoCambioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCambioOriginal(this.getEntityTipoCambio("",entity.getTipoCambioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCambios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCambio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCambio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoCambio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCambio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCambio();
					//entity.setMapTipoCambio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCambioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCambio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCambioDataAccess.ISWITHSCHEMA);         		
					entity=TipoCambioDataAccess.getEntityTipoCambio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCambioOriginal( new TipoCambio());
					////entity.setTipoCambioOriginal(super.getEntity("",entity.getTipoCambioOriginal(),resultSet,TipoCambioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCambioOriginal(this.getEntityTipoCambio("",entity.getTipoCambioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCambio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCambio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCambio getEntityTipoCambio(String strPrefijo,TipoCambio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCambio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCambio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCambioDataAccess.setFieldReflectionTipoCambio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCambio=TipoCambioConstantesFunciones.getTodosTiposColumnasTipoCambio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCambio) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = TipoCambio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCambio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCambioDataAccess.setFieldReflectionTipoCambio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCambio(Field field,String strPrefijo,String sColumn,TipoCambio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCambioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCambioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCambioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCambioConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCambioConstantesFunciones.VALORCOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoCambioConstantesFunciones.VALORVENTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoCambioConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCambio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCambioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new TipoCambio();
					entity=super.getEntity("",entity,resultSet,TipoCambioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCambio("",entity,resultSet);
					
					//entity.setTipoCambioOriginal( new TipoCambio());
					//entity.setTipoCambioOriginal(super.getEntity("",entity.getTipoCambioOriginal(),resultSet,TipoCambioDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCambioOriginal(this.getEntityTipoCambio("",entity.getTipoCambioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCambios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCambio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCambio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCambioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCambioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<TipoCambio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoCambio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCambio();
      	    	entity=super.getEntity("",entity,resultSet,TipoCambioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCambio("",entity,resultSet);
      	    	
				//entity.setTipoCambioOriginal( new TipoCambio());
      	    	//entity.setTipoCambioOriginal(super.getEntity("",entity.getTipoCambioOriginal(),resultSet,TipoCambioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCambioOriginal(this.getEntityTipoCambio("",entity.getTipoCambioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCambios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCambio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCambio> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoCambio> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCambio> entities = new  ArrayList<TipoCambio>();
		TipoCambio entity = new TipoCambio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCambio();
      	    	entity=super.getEntity("",entity,resultSet,TipoCambioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCambio("",entity,resultSet);
      	    	
				//entity.setTipoCambioOriginal( new TipoCambio());
      	    	//entity.setTipoCambioOriginal(super.getEntity("",entity.getTipoCambioOriginal(),resultSet,TipoCambioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCambioOriginal(this.getEntityTipoCambio("",entity.getTipoCambioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCambios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoCambio getEntityTipoCambio(String strPrefijo,TipoCambio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoCambioConstantesFunciones.IDEMPRESA));
				entity.setid_moneda(resultSet.getLong(strPrefijo+TipoCambioConstantesFunciones.IDMONEDA));
				entity.setvalor_compra(resultSet.getDouble(strPrefijo+TipoCambioConstantesFunciones.VALORCOMPRA));
				entity.setvalor_venta(resultSet.getDouble(strPrefijo+TipoCambioConstantesFunciones.VALORVENTA));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+TipoCambioConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCambio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCambio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCambioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCambioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCambioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCambioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCambioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCambioDataAccess.TABLENAME,TipoCambioDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCambioDataAccess.setTipoCambioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoCambio reltipocambio)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipocambio.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Moneda getMoneda(Connexion connexion,TipoCambio reltipocambio)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,reltipocambio.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}


		
		public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<AutoriPagoOrdenCompra> autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+".autori_pago_orden_compra.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN autoripagoordencompra.TipoCambio WHERE autoripagoordencompra.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoOrdenCompraDataAccess autoripagoordencompraDataAccess=new AutoriPagoOrdenCompraDataAccess();

			autoripagoordencompraDataAccess.setConnexionType(this.connexionType);
			autoripagoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagoordencompras;

	}

	public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.TipoCambio WHERE notacreditosoli.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolis;

	}

	public List<GuiaRemision> getGuiaRemisions(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<GuiaRemision> guiaremisions= new ArrayList<GuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN guiaremision.TipoCambio WHERE guiaremision.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GuiaRemisionDataAccess guiaremisionDataAccess=new GuiaRemisionDataAccess();

			guiaremisionDataAccess.setConnexionType(this.connexionType);
			guiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return guiaremisions;

	}

	public List<MovimientoInventario> getMovimientoInventarios(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<MovimientoInventario> movimientoinventarios= new ArrayList<MovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN movimientoinventario.TipoCambio WHERE movimientoinventario.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MovimientoInventarioDataAccess movimientoinventarioDataAccess=new MovimientoInventarioDataAccess();

			movimientoinventarioDataAccess.setConnexionType(this.connexionType);
			movimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return movimientoinventarios;

	}

	public List<Compra> getCompras(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<Compra> compras= new ArrayList<Compra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+CompraConstantesFunciones.SCHEMA+".compra.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN compra.TipoCambio WHERE compra.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CompraDataAccess compraDataAccess=new CompraDataAccess();

			compraDataAccess.setConnexionType(this.connexionType);
			compraDataAccess.setParameterDbType(this.parameterDbType);
			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return compras;

	}

	public List<DetalleAsientoContableCajaChica> getDetalleAsientoContableCajaChicas(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas= new ArrayList<DetalleAsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+".detalle_asiento_contable_caja_chica.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontablecajachica.TipoCambio WHERE detalleasientocontablecajachica.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableCajaChicaDataAccess detalleasientocontablecajachicaDataAccess=new DetalleAsientoContableCajaChicaDataAccess();

			detalleasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			detalleasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontablecajachicas;

	}

	public List<PedidoCompraImpor> getPedidoCompraImpors(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<PedidoCompraImpor> pedidocompraimpors= new ArrayList<PedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN pedidocompraimpor.TipoCambio WHERE pedidocompraimpor.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimpors;

	}

	public List<PedidoExpor> getPedidoExpors(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<PedidoExpor> pedidoexpors= new ArrayList<PedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN pedidoexpor.TipoCambio WHERE pedidoexpor.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoExporDataAccess pedidoexporDataAccess=new PedidoExporDataAccess();

			pedidoexporDataAccess.setConnexionType(this.connexionType);
			pedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoexpors;

	}

	public List<OrdenCompra> getOrdenCompras(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<OrdenCompra> ordencompras= new ArrayList<OrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN ordencompra.TipoCambio WHERE ordencompra.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);
			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompras;

	}

	public List<Proforma> getProformas(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<Proforma> proformas= new ArrayList<Proforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+ProformaConstantesFunciones.SCHEMA+".proforma.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN proforma.TipoCambio WHERE proforma.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProformaDataAccess proformaDataAccess=new ProformaDataAccess();

			proformaDataAccess.setConnexionType(this.connexionType);
			proformaDataAccess.setParameterDbType(this.parameterDbType);
			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proformas;

	}

	public List<PedidoCompra> getPedidoCompras(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<PedidoCompra> pedidocompras= new ArrayList<PedidoCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN pedidocompra.TipoCambio WHERE pedidocompra.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraDataAccess pedidocompraDataAccess=new PedidoCompraDataAccess();

			pedidocompraDataAccess.setConnexionType(this.connexionType);
			pedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompras;

	}

	public List<Factura> getFacturas(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<Factura> facturas= new ArrayList<Factura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+FacturaConstantesFunciones.SCHEMA+".factura.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN factura.TipoCambio WHERE factura.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);
			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturas;

	}

	public List<Pedido> getPedidos(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<Pedido> pedidos= new ArrayList<Pedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+PedidoConstantesFunciones.SCHEMA+".pedido.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN pedido.TipoCambio WHERE pedido.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoDataAccess pedidoDataAccess=new PedidoDataAccess();

			pedidoDataAccess.setConnexionType(this.connexionType);
			pedidoDataAccess.setParameterDbType(this.parameterDbType);
			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidos;

	}

	public List<DetalleAsientoContable> getDetalleAsientoContables(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<DetalleAsientoContable> detalleasientocontables= new ArrayList<DetalleAsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+DetalleAsientoContableConstantesFunciones.SCHEMA+".detalle_asiento_contable.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontable.TipoCambio WHERE detalleasientocontable.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableDataAccess detalleasientocontableDataAccess=new DetalleAsientoContableDataAccess();

			detalleasientocontableDataAccess.setConnexionType(this.connexionType);
			detalleasientocontableDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontables;

	}

	public List<NotaCredito> getNotaCreditos(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<NotaCredito> notacreditos= new ArrayList<NotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN notacredito.TipoCambio WHERE notacredito.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoDataAccess notacreditoDataAccess=new NotaCreditoDataAccess();

			notacreditoDataAccess.setConnexionType(this.connexionType);
			notacreditoDataAccess.setParameterDbType(this.parameterDbType);
			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditos;

	}

	public List<Consignacion> getConsignacions(Connexion connexion,TipoCambio tipocambio)throws SQLException,Exception {

		List<Consignacion> consignacions= new ArrayList<Consignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio ON "+ConsignacionConstantesFunciones.SCHEMA+".consignacion.id_tipo_cambio="+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id WHERE "+TipoCambioConstantesFunciones.SCHEMA+".tipo_cambio.id="+String.valueOf(tipocambio.getId());
			} else {
				sQuery=" INNER JOIN consignacion.TipoCambio WHERE consignacion.TipoCambio.id="+String.valueOf(tipocambio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConsignacionDataAccess consignacionDataAccess=new ConsignacionDataAccess();

			consignacionDataAccess.setConnexionType(this.connexionType);
			consignacionDataAccess.setParameterDbType(this.parameterDbType);
			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignacions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCambio tipocambio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocambio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipocambio.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(tipocambio.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_compra=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_compra.setValue(tipocambio.getvalor_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_venta=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_venta.setValue(tipocambio.getvalor_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(tipocambio.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocambio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocambio.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocambio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocambio.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseTipoCambio(TipoCambio tipocambio)throws Exception  {		
		tipocambio.setIsNew(false);
		tipocambio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCambios(List<TipoCambio> tipocambios)throws Exception  {				
		for(TipoCambio tipocambio:tipocambios) {
			tipocambio.setIsNew(false);
			tipocambio.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCambio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
