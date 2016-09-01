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
package com.bydan.erp.facturacion.business.dataaccess;

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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//EstadoNotaCreditoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class EstadoNotaCreditoDataAccess extends  DataAccessHelperSinIdGenerated<EstadoNotaCredito>{ //EstadoNotaCreditoDataAccessAdditional,DataAccessHelper<EstadoNotaCredito>
	//static Logger logger = Logger.getLogger(EstadoNotaCreditoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_nota_credito";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadonotacredito from "+EstadoNotaCreditoConstantesFunciones.SPERSISTENCENAME+" estadonotacredito";
	public static String QUERYSELECTNATIVE="select "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".id,"+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".version_row,"+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".codigo,"+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".nombre from "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME;//+" as "+EstadoNotaCreditoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".id,"+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".version_row,"+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".nombre from "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME;//+" as "+EstadoNotaCreditoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADONOTACREDITO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADONOTACREDITO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADONOTACREDITO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADONOTACREDITO_SELECT(?,?)";
	
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
	
	
	public EstadoNotaCreditoDataAccess() {
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
		EstadoNotaCreditoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoNotaCreditoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoNotaCreditoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoNotaCreditoOriginal(EstadoNotaCredito estadonotacredito)throws Exception  {
		estadonotacredito.setEstadoNotaCreditoOriginal((EstadoNotaCredito)estadonotacredito.clone());		
	}
	
	public void setEstadoNotaCreditosOriginal(List<EstadoNotaCredito> estadonotacreditos)throws Exception  {
		
		for(EstadoNotaCredito estadonotacredito:estadonotacreditos){
			estadonotacredito.setEstadoNotaCreditoOriginal((EstadoNotaCredito)estadonotacredito.clone());
		}
	}
	
	public static void setEstadoNotaCreditoOriginalStatic(EstadoNotaCredito estadonotacredito)throws Exception  {
		estadonotacredito.setEstadoNotaCreditoOriginal((EstadoNotaCredito)estadonotacredito.clone());		
	}
	
	public static void setEstadoNotaCreditosOriginalStatic(List<EstadoNotaCredito> estadonotacreditos)throws Exception  {
		
		for(EstadoNotaCredito estadonotacredito:estadonotacreditos){
			estadonotacredito.setEstadoNotaCreditoOriginal((EstadoNotaCredito)estadonotacredito.clone());
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
	
	public  EstadoNotaCredito getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoNotaCredito entity = new EstadoNotaCredito();		
		
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
	
	public  EstadoNotaCredito getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoNotaCredito entity = new EstadoNotaCredito();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.EstadoNotaCredito.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoNotaCreditoOriginal(new EstadoNotaCredito());
      	    	entity=super.getEntity("",entity,resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoNotaCredito("",entity,resultSet); 
				
				//entity.setEstadoNotaCreditoOriginal(super.getEntity("",entity.getEstadoNotaCreditoOriginal(),resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNotaCreditoOriginal(this.getEntityEstadoNotaCredito("",entity.getEstadoNotaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoNotaCredito(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoNotaCredito getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoNotaCredito entity = new EstadoNotaCredito();
				
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
	
	public  EstadoNotaCredito getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoNotaCredito entity = new EstadoNotaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoNotaCredito.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoNotaCreditoOriginal(new EstadoNotaCredito());
      	    	entity=super.getEntity("",entity,resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoNotaCredito("",entity,resultSet);    
				
				//entity.setEstadoNotaCreditoOriginal(super.getEntity("",entity.getEstadoNotaCreditoOriginal(),resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNotaCreditoOriginal(this.getEntityEstadoNotaCredito("",entity.getEstadoNotaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoNotaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoNotaCredito
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoNotaCredito entity = new EstadoNotaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoNotaCredito.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoNotaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoNotaCredito> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoNotaCredito> entities = new  ArrayList<EstadoNotaCredito>();
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
		
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
	
	public  List<EstadoNotaCredito> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoNotaCredito> entities = new  ArrayList<EstadoNotaCredito>();
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoNotaCredito("",entity,resultSet);
      	    	
				//entity.setEstadoNotaCreditoOriginal( new EstadoNotaCredito());
      	    	//entity.setEstadoNotaCreditoOriginal(super.getEntity("",entity.getEstadoNotaCreditoOriginal(),resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNotaCreditoOriginal(this.getEntityEstadoNotaCredito("",entity.getEstadoNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoNotaCreditos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoNotaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoNotaCredito> entities = new  ArrayList<EstadoNotaCredito>();
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
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
	
	public  List<EstadoNotaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoNotaCredito> entities = new  ArrayList<EstadoNotaCredito>();
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNotaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoNotaCredito();
					//entity.setMapEstadoNotaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoNotaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoNotaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoNotaCreditoDataAccess.getEntityEstadoNotaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoNotaCreditoOriginal( new EstadoNotaCredito());
					////entity.setEstadoNotaCreditoOriginal(super.getEntity("",entity.getEstadoNotaCreditoOriginal(),resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoNotaCreditoOriginal(this.getEntityEstadoNotaCredito("",entity.getEstadoNotaCreditoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoNotaCreditos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoNotaCredito getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
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
	
	public  EstadoNotaCredito getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNotaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoNotaCredito();
					//entity.setMapEstadoNotaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoNotaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoNotaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoNotaCreditoDataAccess.getEntityEstadoNotaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoNotaCreditoOriginal( new EstadoNotaCredito());
					////entity.setEstadoNotaCreditoOriginal(super.getEntity("",entity.getEstadoNotaCreditoOriginal(),resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoNotaCreditoOriginal(this.getEntityEstadoNotaCredito("",entity.getEstadoNotaCreditoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoNotaCredito(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoNotaCredito getEntityEstadoNotaCredito(String strPrefijo,EstadoNotaCredito entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoNotaCredito.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoNotaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoNotaCreditoDataAccess.setFieldReflectionEstadoNotaCredito(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoNotaCredito=EstadoNotaCreditoConstantesFunciones.getTodosTiposColumnasEstadoNotaCredito();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoNotaCredito) {
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
							field = EstadoNotaCredito.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoNotaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoNotaCreditoDataAccess.setFieldReflectionEstadoNotaCredito(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoNotaCredito(Field field,String strPrefijo,String sColumn,EstadoNotaCredito entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoNotaCreditoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoNotaCreditoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoNotaCreditoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoNotaCreditoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoNotaCredito>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoNotaCredito> entities = new  ArrayList<EstadoNotaCredito>();
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoNotaCredito();
					entity=super.getEntity("",entity,resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoNotaCredito("",entity,resultSet);
					
					//entity.setEstadoNotaCreditoOriginal( new EstadoNotaCredito());
					//entity.setEstadoNotaCreditoOriginal(super.getEntity("",entity.getEstadoNotaCreditoOriginal(),resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoNotaCreditoOriginal(this.getEntityEstadoNotaCredito("",entity.getEstadoNotaCreditoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoNotaCreditos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoNotaCredito>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoNotaCredito> entities = new  ArrayList<EstadoNotaCredito>();
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoNotaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoNotaCredito> entities = new  ArrayList<EstadoNotaCredito>();
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
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
	
	public  List<EstadoNotaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoNotaCredito> entities = new  ArrayList<EstadoNotaCredito>();
		EstadoNotaCredito entity = new EstadoNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoNotaCredito("",entity,resultSet);
      	    	
				//entity.setEstadoNotaCreditoOriginal( new EstadoNotaCredito());
      	    	//entity.setEstadoNotaCreditoOriginal(super.getEntity("",entity.getEstadoNotaCreditoOriginal(),resultSet,EstadoNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNotaCreditoOriginal(this.getEntityEstadoNotaCredito("",entity.getEstadoNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoNotaCreditos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoNotaCredito getEntityEstadoNotaCredito(String strPrefijo,EstadoNotaCredito entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoNotaCreditoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoNotaCreditoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+EstadoNotaCreditoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoNotaCredito(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoNotaCredito entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoNotaCreditoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoNotaCreditoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoNotaCreditoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoNotaCreditoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoNotaCreditoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoNotaCreditoDataAccess.TABLENAME,EstadoNotaCreditoDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoNotaCreditoDataAccess.setEstadoNotaCreditoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<NotaCreditoSoli> getNotaCreditoSoliSolis(Connexion connexion,EstadoNotaCredito estadonotacredito)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolisolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoNotaCreditoConstantesFunciones.SCHEMA+".estado_nota_credito ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_estado_nota_credito="+EstadoNotaCreditoConstantesFunciones.SCHEMA+".estado_nota_credito.id WHERE "+EstadoNotaCreditoConstantesFunciones.SCHEMA+".estado_nota_credito.id="+String.valueOf(estadonotacredito.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.EstadoNotaCreditoSoli WHERE notacreditosoli.EstadoNotaCreditoSoli.id="+String.valueOf(estadonotacredito.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolisolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolisolis;

	}

	public List<NotaCredito> getNotaCreditos(Connexion connexion,EstadoNotaCredito estadonotacredito)throws SQLException,Exception {

		List<NotaCredito> notacreditos= new ArrayList<NotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoNotaCreditoConstantesFunciones.SCHEMA+".estado_nota_credito ON "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id_estado_nota_credito="+EstadoNotaCreditoConstantesFunciones.SCHEMA+".estado_nota_credito.id WHERE "+EstadoNotaCreditoConstantesFunciones.SCHEMA+".estado_nota_credito.id="+String.valueOf(estadonotacredito.getId());
			} else {
				sQuery=" INNER JOIN notacredito.EstadoNotaCredito WHERE notacredito.EstadoNotaCredito.id="+String.valueOf(estadonotacredito.getId());

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

	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentaPuntoVentas(Connexion connexion,EstadoNotaCredito estadonotacredito)throws SQLException,Exception {

		List<NotaCreditoPuntoVenta> notacreditopuntoventapuntoventas= new ArrayList<NotaCreditoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoNotaCreditoConstantesFunciones.SCHEMA+".estado_nota_credito ON "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".nota_credito_punto_venta.id_estado_nota_credito="+EstadoNotaCreditoConstantesFunciones.SCHEMA+".estado_nota_credito.id WHERE "+EstadoNotaCreditoConstantesFunciones.SCHEMA+".estado_nota_credito.id="+String.valueOf(estadonotacredito.getId());
			} else {
				sQuery=" INNER JOIN notacreditopuntoventa.EstadoNotaCreditoPuntoVenta WHERE notacreditopuntoventa.EstadoNotaCreditoPuntoVenta.id="+String.valueOf(estadonotacredito.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoPuntoVentaDataAccess notacreditopuntoventaDataAccess=new NotaCreditoPuntoVentaDataAccess();

			notacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			notacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			notacreditopuntoventapuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditopuntoventapuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoNotaCredito estadonotacredito) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadonotacredito.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadonotacredito.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadonotacredito.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadonotacredito.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadonotacredito.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadonotacredito.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadonotacredito.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadonotacredito.getId());
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
	
	public void setIsNewIsChangedFalseEstadoNotaCredito(EstadoNotaCredito estadonotacredito)throws Exception  {		
		estadonotacredito.setIsNew(false);
		estadonotacredito.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoNotaCreditos(List<EstadoNotaCredito> estadonotacreditos)throws Exception  {				
		for(EstadoNotaCredito estadonotacredito:estadonotacreditos) {
			estadonotacredito.setIsNew(false);
			estadonotacredito.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoNotaCredito(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
