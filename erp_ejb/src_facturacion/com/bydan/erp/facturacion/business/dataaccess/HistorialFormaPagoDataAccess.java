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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//HistorialFormaPagoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class HistorialFormaPagoDataAccess extends  HistorialFormaPagoDataAccessAdditional{ //HistorialFormaPagoDataAccessAdditional,DataAccessHelper<HistorialFormaPago>
	//static Logger logger = Logger.getLogger(HistorialFormaPagoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="historial_forma_pago";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_factura,id_tipo_forma_pago,id_cuenta_contable,numero_dias,valor,fecha,porcentaje,porcentaje_retencion,base_retencion,numero_retencion,nombre_retencion,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_factura=?,id_tipo_forma_pago=?,id_cuenta_contable=?,numero_dias=?,valor=?,fecha=?,porcentaje=?,porcentaje_retencion=?,base_retencion=?,numero_retencion=?,nombre_retencion=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select historialformapago from "+HistorialFormaPagoConstantesFunciones.SPERSISTENCENAME+" historialformapago";
	public static String QUERYSELECTNATIVE="select "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".version_row,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_ejercicio,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_periodo,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_factura,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".numero_dias,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".valor,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".fecha,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".porcentaje,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".porcentaje_retencion,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".base_retencion,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".numero_retencion,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".nombre_retencion,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_anio,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_mes from "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME;//+" as "+HistorialFormaPagoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".version_row from "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME;//+" as "+HistorialFormaPagoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_factura=?,id_tipo_forma_pago=?,id_cuenta_contable=?,numero_dias=?,valor=?,fecha=?,porcentaje=?,porcentaje_retencion=?,base_retencion=?,numero_retencion=?,nombre_retencion=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_HISTORIALFORMAPAGO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_HISTORIALFORMAPAGO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_HISTORIALFORMAPAGO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_HISTORIALFORMAPAGO_SELECT(?,?)";
	
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
	
	
	protected HistorialFormaPagoDataAccessAdditional historialformapagoDataAccessAdditional=null;
	
	public HistorialFormaPagoDataAccessAdditional getHistorialFormaPagoDataAccessAdditional() {
		return this.historialformapagoDataAccessAdditional;
	}
	
	public void setHistorialFormaPagoDataAccessAdditional(HistorialFormaPagoDataAccessAdditional historialformapagoDataAccessAdditional) {
		try {
			this.historialformapagoDataAccessAdditional=historialformapagoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public HistorialFormaPagoDataAccess() {
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
		HistorialFormaPagoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		HistorialFormaPagoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		HistorialFormaPagoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setHistorialFormaPagoOriginal(HistorialFormaPago historialformapago)throws Exception  {
		historialformapago.setHistorialFormaPagoOriginal((HistorialFormaPago)historialformapago.clone());		
	}
	
	public void setHistorialFormaPagosOriginal(List<HistorialFormaPago> historialformapagos)throws Exception  {
		
		for(HistorialFormaPago historialformapago:historialformapagos){
			historialformapago.setHistorialFormaPagoOriginal((HistorialFormaPago)historialformapago.clone());
		}
	}
	
	public static void setHistorialFormaPagoOriginalStatic(HistorialFormaPago historialformapago)throws Exception  {
		historialformapago.setHistorialFormaPagoOriginal((HistorialFormaPago)historialformapago.clone());		
	}
	
	public static void setHistorialFormaPagosOriginalStatic(List<HistorialFormaPago> historialformapagos)throws Exception  {
		
		for(HistorialFormaPago historialformapago:historialformapagos){
			historialformapago.setHistorialFormaPagoOriginal((HistorialFormaPago)historialformapago.clone());
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
	
	public  HistorialFormaPago getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialFormaPago entity = new HistorialFormaPago();		
		
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
	
	public  HistorialFormaPago getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialFormaPago entity = new HistorialFormaPago();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.HistorialFormaPago.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setHistorialFormaPagoOriginal(new HistorialFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialFormaPago("",entity,resultSet); 
				
				//entity.setHistorialFormaPagoOriginal(super.getEntity("",entity.getHistorialFormaPagoOriginal(),resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoOriginal(this.getEntityHistorialFormaPago("",entity.getHistorialFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialFormaPago(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  HistorialFormaPago getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialFormaPago entity = new HistorialFormaPago();
				
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
	
	public  HistorialFormaPago getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialFormaPago entity = new HistorialFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.HistorialFormaPago.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setHistorialFormaPagoOriginal(new HistorialFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialFormaPago("",entity,resultSet);    
				
				//entity.setHistorialFormaPagoOriginal(super.getEntity("",entity.getHistorialFormaPagoOriginal(),resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoOriginal(this.getEntityHistorialFormaPago("",entity.getHistorialFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //HistorialFormaPago
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		HistorialFormaPago entity = new HistorialFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.HistorialFormaPago.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseHistorialFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<HistorialFormaPago> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
		
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
	
	public  List<HistorialFormaPago> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialFormaPago("",entity,resultSet);
      	    	
				//entity.setHistorialFormaPagoOriginal( new HistorialFormaPago());
      	    	//entity.setHistorialFormaPagoOriginal(super.getEntity("",entity.getHistorialFormaPagoOriginal(),resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoOriginal(this.getEntityHistorialFormaPago("",entity.getHistorialFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialFormaPagos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
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
	
	public  List<HistorialFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialFormaPago();
					//entity.setMapHistorialFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapHistorialFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=HistorialFormaPagoDataAccess.getEntityHistorialFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setHistorialFormaPagoOriginal( new HistorialFormaPago());
					////entity.setHistorialFormaPagoOriginal(super.getEntity("",entity.getHistorialFormaPagoOriginal(),resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setHistorialFormaPagoOriginal(this.getEntityHistorialFormaPago("",entity.getHistorialFormaPagoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialFormaPagos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public HistorialFormaPago getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialFormaPago entity = new HistorialFormaPago();		  
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
	
	public  HistorialFormaPago getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialFormaPago entity = new HistorialFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialFormaPago();
					//entity.setMapHistorialFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapHistorialFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=HistorialFormaPagoDataAccess.getEntityHistorialFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setHistorialFormaPagoOriginal( new HistorialFormaPago());
					////entity.setHistorialFormaPagoOriginal(super.getEntity("",entity.getHistorialFormaPagoOriginal(),resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setHistorialFormaPagoOriginal(this.getEntityHistorialFormaPago("",entity.getHistorialFormaPagoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseHistorialFormaPago(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static HistorialFormaPago getEntityHistorialFormaPago(String strPrefijo,HistorialFormaPago entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = HistorialFormaPago.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = HistorialFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					HistorialFormaPagoDataAccess.setFieldReflectionHistorialFormaPago(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasHistorialFormaPago=HistorialFormaPagoConstantesFunciones.getTodosTiposColumnasHistorialFormaPago();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasHistorialFormaPago) {
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
							field = HistorialFormaPago.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = HistorialFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						HistorialFormaPagoDataAccess.setFieldReflectionHistorialFormaPago(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionHistorialFormaPago(Field field,String strPrefijo,String sColumn,HistorialFormaPago entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case HistorialFormaPagoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.NUMERODIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case HistorialFormaPagoConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.BASERETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.NUMERORETENCION:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.NOMBRERETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialFormaPagoConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialFormaPago>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new HistorialFormaPago();
					entity=super.getEntity("",entity,resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityHistorialFormaPago("",entity,resultSet);
					
					//entity.setHistorialFormaPagoOriginal( new HistorialFormaPago());
					//entity.setHistorialFormaPagoOriginal(super.getEntity("",entity.getHistorialFormaPagoOriginal(),resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA));         		
					//entity.setHistorialFormaPagoOriginal(this.getEntityHistorialFormaPago("",entity.getHistorialFormaPagoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseHistorialFormaPagos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialFormaPago>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<HistorialFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
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
	
	public  List<HistorialFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialFormaPago("",entity,resultSet);
      	    	
				//entity.setHistorialFormaPagoOriginal( new HistorialFormaPago());
      	    	//entity.setHistorialFormaPagoOriginal(super.getEntity("",entity.getHistorialFormaPagoOriginal(),resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoOriginal(this.getEntityHistorialFormaPago("",entity.getHistorialFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseHistorialFormaPagos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialFormaPago> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
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
	
	public  List<HistorialFormaPago> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialFormaPago> entities = new  ArrayList<HistorialFormaPago>();
		HistorialFormaPago entity = new HistorialFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialFormaPago("",entity,resultSet);
      	    	
				//entity.setHistorialFormaPagoOriginal( new HistorialFormaPago());
      	    	//entity.setHistorialFormaPagoOriginal(super.getEntity("",entity.getHistorialFormaPagoOriginal(),resultSet,HistorialFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialFormaPagoOriginal(this.getEntityHistorialFormaPago("",entity.getHistorialFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialFormaPagos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public HistorialFormaPago getEntityHistorialFormaPago(String strPrefijo,HistorialFormaPago entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+HistorialFormaPagoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+HistorialFormaPagoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+HistorialFormaPagoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+HistorialFormaPagoConstantesFunciones.IDPERIODO));
				entity.setid_factura(resultSet.getLong(strPrefijo+HistorialFormaPagoConstantesFunciones.IDFACTURA));
				entity.setid_tipo_forma_pago(resultSet.getLong(strPrefijo+HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE));
				entity.setnumero_dias(resultSet.getInt(strPrefijo+HistorialFormaPagoConstantesFunciones.NUMERODIAS));
				entity.setvalor(resultSet.getDouble(strPrefijo+HistorialFormaPagoConstantesFunciones.VALOR));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+HistorialFormaPagoConstantesFunciones.FECHA).getTime()));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+HistorialFormaPagoConstantesFunciones.PORCENTAJE));
				entity.setporcentaje_retencion(resultSet.getDouble(strPrefijo+HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION));
				entity.setbase_retencion(resultSet.getDouble(strPrefijo+HistorialFormaPagoConstantesFunciones.BASERETENCION));
				entity.setnumero_retencion(resultSet.getInt(strPrefijo+HistorialFormaPagoConstantesFunciones.NUMERORETENCION));
				entity.setnombre_retencion(resultSet.getString(strPrefijo+HistorialFormaPagoConstantesFunciones.NOMBRERETENCION));
				entity.setid_anio(resultSet.getLong(strPrefijo+HistorialFormaPagoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+HistorialFormaPagoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowHistorialFormaPago(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(HistorialFormaPago entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=HistorialFormaPagoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=HistorialFormaPagoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=HistorialFormaPagoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=HistorialFormaPagoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(HistorialFormaPagoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,HistorialFormaPagoDataAccess.TABLENAME,HistorialFormaPagoDataAccess.ISWITHSTOREPROCEDURES);
			
			HistorialFormaPagoDataAccess.setHistorialFormaPagoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,HistorialFormaPago relhistorialformapago)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relhistorialformapago.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,HistorialFormaPago relhistorialformapago)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relhistorialformapago.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,HistorialFormaPago relhistorialformapago)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relhistorialformapago.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,HistorialFormaPago relhistorialformapago)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relhistorialformapago.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Factura getFactura(Connexion connexion,HistorialFormaPago relhistorialformapago)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relhistorialformapago.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public TipoFormaPago getTipoFormaPago(Connexion connexion,HistorialFormaPago relhistorialformapago)throws SQLException,Exception {

		TipoFormaPago tipoformapago= new TipoFormaPago();

		try {
			TipoFormaPagoDataAccess tipoformapagoDataAccess=new TipoFormaPagoDataAccess();

			tipoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoformapagoDataAccess.setConnexionType(this.connexionType);
			tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipoformapago=tipoformapagoDataAccess.getEntity(connexion,relhistorialformapago.getid_tipo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformapago;

	}

	public CuentaContable getCuentaContable(Connexion connexion,HistorialFormaPago relhistorialformapago)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relhistorialformapago.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Anio getAnio(Connexion connexion,HistorialFormaPago relhistorialformapago)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relhistorialformapago.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,HistorialFormaPago relhistorialformapago)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relhistorialformapago.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,HistorialFormaPago historialformapago) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!historialformapago.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(historialformapago.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(historialformapago.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(historialformapago.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(historialformapago.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(historialformapago.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_forma_pago.setValue(historialformapago.getid_tipo_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(historialformapago.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias.setValue(historialformapago.getnumero_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(historialformapago.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(historialformapago.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(historialformapago.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_retencion=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_retencion.setValue(historialformapago.getporcentaje_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuebase_retencion.setValue(historialformapago.getbase_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_retencion=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_retencion.setValue(historialformapago.getnumero_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_retencion=new ParameterValue<String>();
					parameterMaintenanceValuenombre_retencion.setValue(historialformapago.getnombre_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(historialformapago.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(historialformapago.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!historialformapago.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(historialformapago.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(historialformapago.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(historialformapago.getId());
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
	
	public void setIsNewIsChangedFalseHistorialFormaPago(HistorialFormaPago historialformapago)throws Exception  {		
		historialformapago.setIsNew(false);
		historialformapago.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseHistorialFormaPagos(List<HistorialFormaPago> historialformapagos)throws Exception  {				
		for(HistorialFormaPago historialformapago:historialformapagos) {
			historialformapago.setIsNew(false);
			historialformapago.setIsChanged(false);
		}
	}
	
	public void generarExportarHistorialFormaPago(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
