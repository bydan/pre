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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//EstadoDetalleClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class EstadoDetalleClienteDataAccess extends  EstadoDetalleClienteDataAccessAdditional{ //EstadoDetalleClienteDataAccessAdditional,DataAccessHelper<EstadoDetalleCliente>
	//static Logger logger = Logger.getLogger(EstadoDetalleClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_detalle_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+"(version_row,codigo,nombre)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadodetallecliente from "+EstadoDetalleClienteConstantesFunciones.SPERSISTENCENAME+" estadodetallecliente";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".id,"+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".id,"+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".codigo from "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADODETALLECLIENTE_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADODETALLECLIENTE_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADODETALLECLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADODETALLECLIENTE_SELECT(?,?)";
	
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
	
	
	protected EstadoDetalleClienteDataAccessAdditional estadodetalleclienteDataAccessAdditional=null;
	
	public EstadoDetalleClienteDataAccessAdditional getEstadoDetalleClienteDataAccessAdditional() {
		return this.estadodetalleclienteDataAccessAdditional;
	}
	
	public void setEstadoDetalleClienteDataAccessAdditional(EstadoDetalleClienteDataAccessAdditional estadodetalleclienteDataAccessAdditional) {
		try {
			this.estadodetalleclienteDataAccessAdditional=estadodetalleclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoDetalleClienteDataAccess() {
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
		EstadoDetalleClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoDetalleClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoDetalleClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoDetalleClienteOriginal(EstadoDetalleCliente estadodetallecliente)throws Exception  {
		estadodetallecliente.setEstadoDetalleClienteOriginal((EstadoDetalleCliente)estadodetallecliente.clone());		
	}
	
	public void setEstadoDetalleClientesOriginal(List<EstadoDetalleCliente> estadodetalleclientes)throws Exception  {
		
		for(EstadoDetalleCliente estadodetallecliente:estadodetalleclientes){
			estadodetallecliente.setEstadoDetalleClienteOriginal((EstadoDetalleCliente)estadodetallecliente.clone());
		}
	}
	
	public static void setEstadoDetalleClienteOriginalStatic(EstadoDetalleCliente estadodetallecliente)throws Exception  {
		estadodetallecliente.setEstadoDetalleClienteOriginal((EstadoDetalleCliente)estadodetallecliente.clone());		
	}
	
	public static void setEstadoDetalleClientesOriginalStatic(List<EstadoDetalleCliente> estadodetalleclientes)throws Exception  {
		
		for(EstadoDetalleCliente estadodetallecliente:estadodetalleclientes){
			estadodetallecliente.setEstadoDetalleClienteOriginal((EstadoDetalleCliente)estadodetallecliente.clone());
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
	
	public  EstadoDetalleCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		
		
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
	
	public  EstadoDetalleCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.EstadoDetalleCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoDetalleClienteOriginal(new EstadoDetalleCliente());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleCliente("",entity,resultSet); 
				
				//entity.setEstadoDetalleClienteOriginal(super.getEntity("",entity.getEstadoDetalleClienteOriginal(),resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleClienteOriginal(this.getEntityEstadoDetalleCliente("",entity.getEstadoDetalleClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoDetalleCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleCliente entity = new EstadoDetalleCliente();
				
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
	
	public  EstadoDetalleCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleCliente entity = new EstadoDetalleCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.EstadoDetalleCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoDetalleClienteOriginal(new EstadoDetalleCliente());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleCliente("",entity,resultSet);    
				
				//entity.setEstadoDetalleClienteOriginal(super.getEntity("",entity.getEstadoDetalleClienteOriginal(),resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleClienteOriginal(this.getEntityEstadoDetalleCliente("",entity.getEstadoDetalleClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoDetalleCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoDetalleCliente entity = new EstadoDetalleCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.EstadoDetalleCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoDetalleCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoDetalleCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
		
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
	
	public  List<EstadoDetalleCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleCliente();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleCliente("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleClienteOriginal( new EstadoDetalleCliente());
      	    	//entity.setEstadoDetalleClienteOriginal(super.getEntity("",entity.getEstadoDetalleClienteOriginal(),resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleClienteOriginal(this.getEntityEstadoDetalleCliente("",entity.getEstadoDetalleClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
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
	
	public  List<EstadoDetalleCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleCliente();
					//entity.setMapEstadoDetalleCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoDetalleClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleClienteDataAccess.getEntityEstadoDetalleCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleClienteOriginal( new EstadoDetalleCliente());
					////entity.setEstadoDetalleClienteOriginal(super.getEntity("",entity.getEstadoDetalleClienteOriginal(),resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleClienteOriginal(this.getEntityEstadoDetalleCliente("",entity.getEstadoDetalleClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoDetalleCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
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
	
	public  EstadoDetalleCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleCliente();
					//entity.setMapEstadoDetalleCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoDetalleClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleClienteDataAccess.getEntityEstadoDetalleCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleClienteOriginal( new EstadoDetalleCliente());
					////entity.setEstadoDetalleClienteOriginal(super.getEntity("",entity.getEstadoDetalleClienteOriginal(),resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleClienteOriginal(this.getEntityEstadoDetalleCliente("",entity.getEstadoDetalleClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoDetalleCliente getEntityEstadoDetalleCliente(String strPrefijo,EstadoDetalleCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoDetalleCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoDetalleCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoDetalleClienteDataAccess.setFieldReflectionEstadoDetalleCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoDetalleCliente=EstadoDetalleClienteConstantesFunciones.getTodosTiposColumnasEstadoDetalleCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoDetalleCliente) {
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
							field = EstadoDetalleCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoDetalleCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoDetalleClienteDataAccess.setFieldReflectionEstadoDetalleCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoDetalleCliente(Field field,String strPrefijo,String sColumn,EstadoDetalleCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoDetalleClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoDetalleClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleClienteConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleClienteConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoDetalleCliente();
					entity=super.getEntity("",entity,resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoDetalleCliente("",entity,resultSet);
					
					//entity.setEstadoDetalleClienteOriginal( new EstadoDetalleCliente());
					//entity.setEstadoDetalleClienteOriginal(super.getEntity("",entity.getEstadoDetalleClienteOriginal(),resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoDetalleClienteOriginal(this.getEntityEstadoDetalleCliente("",entity.getEstadoDetalleClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoDetalleClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoDetalleCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
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
	
	public  List<EstadoDetalleCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleCliente();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleCliente("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleClienteOriginal( new EstadoDetalleCliente());
      	    	//entity.setEstadoDetalleClienteOriginal(super.getEntity("",entity.getEstadoDetalleClienteOriginal(),resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleClienteOriginal(this.getEntityEstadoDetalleCliente("",entity.getEstadoDetalleClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoDetalleClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
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
	
	public  List<EstadoDetalleCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleCliente> entities = new  ArrayList<EstadoDetalleCliente>();
		EstadoDetalleCliente entity = new EstadoDetalleCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleCliente();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleCliente("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleClienteOriginal( new EstadoDetalleCliente());
      	    	//entity.setEstadoDetalleClienteOriginal(super.getEntity("",entity.getEstadoDetalleClienteOriginal(),resultSet,EstadoDetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleClienteOriginal(this.getEntityEstadoDetalleCliente("",entity.getEstadoDetalleClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoDetalleCliente getEntityEstadoDetalleCliente(String strPrefijo,EstadoDetalleCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleClienteConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoDetalleClienteConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleClienteConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoDetalleCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoDetalleCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoDetalleClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoDetalleClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoDetalleClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoDetalleClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoDetalleClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoDetalleClienteDataAccess.TABLENAME,EstadoDetalleClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoDetalleClienteDataAccess.setEstadoDetalleClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<DetalleProve> getDetalleProves(Connexion connexion,EstadoDetalleCliente estadodetallecliente)throws SQLException,Exception {

		List<DetalleProve> detalleproves= new ArrayList<DetalleProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetalleClienteConstantesFunciones.SCHEMA+".estado_detalle_cliente ON "+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove.id_estado_detalle_cliente="+EstadoDetalleClienteConstantesFunciones.SCHEMA+".estado_detalle_cliente.id WHERE "+EstadoDetalleClienteConstantesFunciones.SCHEMA+".estado_detalle_cliente.id="+String.valueOf(estadodetallecliente.getId());
			} else {
				sQuery=" INNER JOIN detalleprove.EstadoDetalleCliente WHERE detalleprove.EstadoDetalleCliente.id="+String.valueOf(estadodetallecliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleProveDataAccess detalleproveDataAccess=new DetalleProveDataAccess();

			detalleproveDataAccess.setConnexionType(this.connexionType);
			detalleproveDataAccess.setParameterDbType(this.parameterDbType);
			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleproves;

	}

	public List<DetalleMoviClienProve> getDetalleMoviClienProves(Connexion connexion,EstadoDetalleCliente estadodetallecliente)throws SQLException,Exception {

		List<DetalleMoviClienProve> detallemoviclienproves= new ArrayList<DetalleMoviClienProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetalleClienteConstantesFunciones.SCHEMA+".estado_detalle_cliente ON "+DetalleMoviClienProveConstantesFunciones.SCHEMA+".detalle_movi_clien_prove.id_estado_detalle_cliente="+EstadoDetalleClienteConstantesFunciones.SCHEMA+".estado_detalle_cliente.id WHERE "+EstadoDetalleClienteConstantesFunciones.SCHEMA+".estado_detalle_cliente.id="+String.valueOf(estadodetallecliente.getId());
			} else {
				sQuery=" INNER JOIN detallemoviclienprove.EstadoDetalleCliente WHERE detallemoviclienprove.EstadoDetalleCliente.id="+String.valueOf(estadodetallecliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMoviClienProveDataAccess detallemoviclienproveDataAccess=new DetalleMoviClienProveDataAccess();

			detallemoviclienproveDataAccess.setConnexionType(this.connexionType);
			detallemoviclienproveDataAccess.setParameterDbType(this.parameterDbType);
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemoviclienproves;

	}

	public List<DetalleCliente> getDetalleClientes(Connexion connexion,EstadoDetalleCliente estadodetallecliente)throws SQLException,Exception {

		List<DetalleCliente> detalleclientes= new ArrayList<DetalleCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetalleClienteConstantesFunciones.SCHEMA+".estado_detalle_cliente ON "+DetalleClienteConstantesFunciones.SCHEMA+".detalle_cliente.id_estado_detalle_cliente="+EstadoDetalleClienteConstantesFunciones.SCHEMA+".estado_detalle_cliente.id WHERE "+EstadoDetalleClienteConstantesFunciones.SCHEMA+".estado_detalle_cliente.id="+String.valueOf(estadodetallecliente.getId());
			} else {
				sQuery=" INNER JOIN detallecliente.EstadoDetalleCliente WHERE detallecliente.EstadoDetalleCliente.id="+String.valueOf(estadodetallecliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleClienteDataAccess detalleclienteDataAccess=new DetalleClienteDataAccess();

			detalleclienteDataAccess.setConnexionType(this.connexionType);
			detalleclienteDataAccess.setParameterDbType(this.parameterDbType);
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleclientes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoDetalleCliente estadodetallecliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadodetallecliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadodetallecliente.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadodetallecliente.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadodetallecliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadodetallecliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadodetallecliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadodetallecliente.getId());
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
	
	public void setIsNewIsChangedFalseEstadoDetalleCliente(EstadoDetalleCliente estadodetallecliente)throws Exception  {		
		estadodetallecliente.setIsNew(false);
		estadodetallecliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoDetalleClientes(List<EstadoDetalleCliente> estadodetalleclientes)throws Exception  {				
		for(EstadoDetalleCliente estadodetallecliente:estadodetalleclientes) {
			estadodetallecliente.setIsNew(false);
			estadodetallecliente.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoDetalleCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
