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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//HistorialFormaPagoPuntoVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class HistorialFormaPagoPuntoVentaDataAccess extends  HistorialFormaPagoPuntoVentaDataAccessAdditional{ //HistorialFormaPagoPuntoVentaDataAccessAdditional,DataAccessHelper<HistorialFormaPagoPuntoVenta>
	//static Logger logger = Logger.getLogger(HistorialFormaPagoPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="historial_forma_pago_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_factura_punto_venta,id_empresa,id_sucursal)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_factura_punto_venta=?,id_empresa=?,id_sucursal=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select historialformapagopuntoventa from "+HistorialFormaPagoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" historialformapagopuntoventa";
	public static String QUERYSELECTNATIVE="select "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id,"+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_factura_punto_venta,"+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal from "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id,"+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".version_row from "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_factura_punto_venta=?,id_empresa=?,id_sucursal=?";
	
	public static String STOREPROCEDUREINSERT="call SP_HISTORIALFORMAPAGOPUNTOVENTA_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_HISTORIALFORMAPAGOPUNTOVENTA_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_HISTORIALFORMAPAGOPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_HISTORIALFORMAPAGOPUNTOVENTA_SELECT(?,?)";
	
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
	
	
	protected HistorialFormaPagoPuntoVentaDataAccessAdditional historialformapagopuntoventaDataAccessAdditional=null;
	
	public HistorialFormaPagoPuntoVentaDataAccessAdditional getHistorialFormaPagoPuntoVentaDataAccessAdditional() {
		return this.historialformapagopuntoventaDataAccessAdditional;
	}
	
	public void setHistorialFormaPagoPuntoVentaDataAccessAdditional(HistorialFormaPagoPuntoVentaDataAccessAdditional historialformapagopuntoventaDataAccessAdditional) {
		try {
			this.historialformapagopuntoventaDataAccessAdditional=historialformapagopuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public HistorialFormaPagoPuntoVentaDataAccess() {
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
		HistorialFormaPagoPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		HistorialFormaPagoPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		HistorialFormaPagoPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setHistorialFormaPagoPuntoVentaOriginal(HistorialFormaPagoPuntoVenta historialformapagopuntoventa)throws Exception  {
		historialformapagopuntoventa.setHistorialFormaPagoPuntoVentaOriginal((HistorialFormaPagoPuntoVenta)historialformapagopuntoventa.clone());		
	}
	
	public void setHistorialFormaPagoPuntoVentasOriginal(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas)throws Exception  {
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa:historialformapagopuntoventas){
			historialformapagopuntoventa.setHistorialFormaPagoPuntoVentaOriginal((HistorialFormaPagoPuntoVenta)historialformapagopuntoventa.clone());
		}
	}
	
	public static void setHistorialFormaPagoPuntoVentaOriginalStatic(HistorialFormaPagoPuntoVenta historialformapagopuntoventa)throws Exception  {
		historialformapagopuntoventa.setHistorialFormaPagoPuntoVentaOriginal((HistorialFormaPagoPuntoVenta)historialformapagopuntoventa.clone());		
	}
	
	public static void setHistorialFormaPagoPuntoVentasOriginalStatic(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas)throws Exception  {
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa:historialformapagopuntoventas){
			historialformapagopuntoventa.setHistorialFormaPagoPuntoVentaOriginal((HistorialFormaPagoPuntoVenta)historialformapagopuntoventa.clone());
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
	
	public  HistorialFormaPagoPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		
		
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
	
	public  HistorialFormaPagoPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.HistorialFormaPagoPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setHistorialFormaPagoPuntoVentaOriginal(new HistorialFormaPagoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialFormaPagoPuntoVenta("",entity,resultSet); 
				
				//entity.setHistorialFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoPuntoVentaOriginal(this.getEntityHistorialFormaPagoPuntoVenta("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialFormaPagoPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  HistorialFormaPagoPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();
				
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
	
	public  HistorialFormaPagoPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.HistorialFormaPagoPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setHistorialFormaPagoPuntoVentaOriginal(new HistorialFormaPagoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialFormaPagoPuntoVenta("",entity,resultSet);    
				
				//entity.setHistorialFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoPuntoVentaOriginal(this.getEntityHistorialFormaPagoPuntoVenta("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialFormaPagoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //HistorialFormaPagoPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.HistorialFormaPagoPuntoVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseHistorialFormaPagoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<HistorialFormaPagoPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
		
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
	
	public  List<HistorialFormaPagoPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPagoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialFormaPagoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setHistorialFormaPagoPuntoVentaOriginal( new HistorialFormaPagoPuntoVenta());
      	    	//entity.setHistorialFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoPuntoVentaOriginal(this.getEntityHistorialFormaPagoPuntoVenta("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialFormaPagoPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialFormaPagoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
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
	
	public  List<HistorialFormaPagoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPagoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialFormaPagoPuntoVenta();
					//entity.setMapHistorialFormaPagoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapHistorialFormaPagoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialFormaPagoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=HistorialFormaPagoPuntoVentaDataAccess.getEntityHistorialFormaPagoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setHistorialFormaPagoPuntoVentaOriginal( new HistorialFormaPagoPuntoVenta());
					////entity.setHistorialFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setHistorialFormaPagoPuntoVentaOriginal(this.getEntityHistorialFormaPagoPuntoVenta("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialFormaPagoPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public HistorialFormaPagoPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
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
	
	public  HistorialFormaPagoPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPagoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialFormaPagoPuntoVenta();
					//entity.setMapHistorialFormaPagoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapHistorialFormaPagoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialFormaPagoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=HistorialFormaPagoPuntoVentaDataAccess.getEntityHistorialFormaPagoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setHistorialFormaPagoPuntoVentaOriginal( new HistorialFormaPagoPuntoVenta());
					////entity.setHistorialFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setHistorialFormaPagoPuntoVentaOriginal(this.getEntityHistorialFormaPagoPuntoVenta("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseHistorialFormaPagoPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static HistorialFormaPagoPuntoVenta getEntityHistorialFormaPagoPuntoVenta(String strPrefijo,HistorialFormaPagoPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = HistorialFormaPagoPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = HistorialFormaPagoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					HistorialFormaPagoPuntoVentaDataAccess.setFieldReflectionHistorialFormaPagoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasHistorialFormaPagoPuntoVenta=HistorialFormaPagoPuntoVentaConstantesFunciones.getTodosTiposColumnasHistorialFormaPagoPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasHistorialFormaPagoPuntoVenta) {
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
							field = HistorialFormaPagoPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = HistorialFormaPagoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						HistorialFormaPagoPuntoVentaDataAccess.setFieldReflectionHistorialFormaPagoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionHistorialFormaPagoPuntoVenta(Field field,String strPrefijo,String sColumn,HistorialFormaPagoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case HistorialFormaPagoPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialFormaPagoPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new HistorialFormaPagoPuntoVenta();
					entity=super.getEntity("",entity,resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityHistorialFormaPagoPuntoVenta("",entity,resultSet);
					
					//entity.setHistorialFormaPagoPuntoVentaOriginal( new HistorialFormaPagoPuntoVenta());
					//entity.setHistorialFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setHistorialFormaPagoPuntoVentaOriginal(this.getEntityHistorialFormaPagoPuntoVenta("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseHistorialFormaPagoPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialFormaPagoPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialFormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<HistorialFormaPagoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
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
	
	public  List<HistorialFormaPagoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPagoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialFormaPagoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setHistorialFormaPagoPuntoVentaOriginal( new HistorialFormaPagoPuntoVenta());
      	    	//entity.setHistorialFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoPuntoVentaOriginal(this.getEntityHistorialFormaPagoPuntoVenta("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseHistorialFormaPagoPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialFormaPagoPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
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
	
	public  List<HistorialFormaPagoPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialFormaPagoPuntoVenta> entities = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		HistorialFormaPagoPuntoVenta entity = new HistorialFormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPagoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialFormaPagoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setHistorialFormaPagoPuntoVentaOriginal( new HistorialFormaPagoPuntoVenta());
      	    	//entity.setHistorialFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoPuntoVentaOriginal(this.getEntityHistorialFormaPagoPuntoVenta("",entity.getHistorialFormaPagoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialFormaPagoPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public HistorialFormaPagoPuntoVenta getEntityHistorialFormaPagoPuntoVenta(String strPrefijo,HistorialFormaPagoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_factura_punto_venta(resultSet.getLong(strPrefijo+HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA));
				entity.setid_empresa(resultSet.getLong(strPrefijo+HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowHistorialFormaPagoPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(HistorialFormaPagoPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=HistorialFormaPagoPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=HistorialFormaPagoPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=HistorialFormaPagoPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=HistorialFormaPagoPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(HistorialFormaPagoPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME,HistorialFormaPagoPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			HistorialFormaPagoPuntoVentaDataAccess.setHistorialFormaPagoPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public FacturaPuntoVenta getFacturaPuntoVenta(Connexion connexion,HistorialFormaPagoPuntoVenta relhistorialformapagopuntoventa)throws SQLException,Exception {

		FacturaPuntoVenta facturapuntoventa= new FacturaPuntoVenta();

		try {
			FacturaPuntoVentaDataAccess facturapuntoventaDataAccess=new FacturaPuntoVentaDataAccess();

			facturapuntoventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);

			facturapuntoventa=facturapuntoventaDataAccess.getEntity(connexion,relhistorialformapagopuntoventa.getid_factura_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturapuntoventa;

	}

	public Empresa getEmpresa(Connexion connexion,HistorialFormaPagoPuntoVenta relhistorialformapagopuntoventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relhistorialformapagopuntoventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,HistorialFormaPagoPuntoVenta relhistorialformapagopuntoventa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relhistorialformapagopuntoventa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,HistorialFormaPagoPuntoVenta historialformapagopuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!historialformapagopuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura_punto_venta.setValue(historialformapagopuntoventa.getid_factura_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(historialformapagopuntoventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(historialformapagopuntoventa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
						if(!historialformapagopuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(historialformapagopuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(historialformapagopuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(historialformapagopuntoventa.getId());
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
	
	public void setIsNewIsChangedFalseHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta historialformapagopuntoventa)throws Exception  {		
		historialformapagopuntoventa.setIsNew(false);
		historialformapagopuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseHistorialFormaPagoPuntoVentas(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas)throws Exception  {				
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa:historialformapagopuntoventas) {
			historialformapagopuntoventa.setIsNew(false);
			historialformapagopuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarHistorialFormaPagoPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
