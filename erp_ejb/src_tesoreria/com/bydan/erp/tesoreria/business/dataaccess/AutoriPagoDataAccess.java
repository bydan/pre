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
package com.bydan.erp.tesoreria.business.dataaccess;

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

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//AutoriPagoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class AutoriPagoDataAccess extends  AutoriPagoDataAccessAdditional{ //AutoriPagoDataAccessAdditional,DataAccessHelper<AutoriPago>
	//static Logger logger = Logger.getLogger(AutoriPagoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="autori_pago";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_cliente,id_factura,id_asiento_contable,id_centro_costo,id_centro_actividad,id_banco,id_cuenta_banco,id_detalle_prove,id_transaccion,fecha_emision,fecha_vencimiento,valor_pago,valor_cancelado,numero_factura,detalle_factura,fecha_corte,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_cliente=?,id_factura=?,id_asiento_contable=?,id_centro_costo=?,id_centro_actividad=?,id_banco=?,id_cuenta_banco=?,id_detalle_prove=?,id_transaccion=?,fecha_emision=?,fecha_vencimiento=?,valor_pago=?,valor_cancelado=?,numero_factura=?,detalle_factura=?,fecha_corte=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select autoripago from "+AutoriPagoConstantesFunciones.SPERSISTENCENAME+" autoripago";
	public static String QUERYSELECTNATIVE="select "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".version_row,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_empresa,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_sucursal,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_ejercicio,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_cliente,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_factura,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_asiento_contable,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_centro_costo,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_centro_actividad,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_banco,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_cuenta_banco,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_detalle_prove,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_transaccion,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".fecha_emision,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".valor_pago,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".valor_cancelado,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".numero_factura,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".detalle_factura,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".fecha_corte,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".descripcion from "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME;//+" as "+AutoriPagoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".version_row from "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME;//+" as "+AutoriPagoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_cliente=?,id_factura=?,id_asiento_contable=?,id_centro_costo=?,id_centro_actividad=?,id_banco=?,id_cuenta_banco=?,id_detalle_prove=?,id_transaccion=?,fecha_emision=?,fecha_vencimiento=?,valor_pago=?,valor_cancelado=?,numero_factura=?,detalle_factura=?,fecha_corte=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_AUTORIPAGO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_AUTORIPAGO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_AUTORIPAGO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_AUTORIPAGO_SELECT(?,?)";
	
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
	
	
	protected AutoriPagoDataAccessAdditional autoripagoDataAccessAdditional=null;
	
	public AutoriPagoDataAccessAdditional getAutoriPagoDataAccessAdditional() {
		return this.autoripagoDataAccessAdditional;
	}
	
	public void setAutoriPagoDataAccessAdditional(AutoriPagoDataAccessAdditional autoripagoDataAccessAdditional) {
		try {
			this.autoripagoDataAccessAdditional=autoripagoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AutoriPagoDataAccess() {
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
		AutoriPagoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AutoriPagoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AutoriPagoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAutoriPagoOriginal(AutoriPago autoripago)throws Exception  {
		autoripago.setAutoriPagoOriginal((AutoriPago)autoripago.clone());		
	}
	
	public void setAutoriPagosOriginal(List<AutoriPago> autoripagos)throws Exception  {
		
		for(AutoriPago autoripago:autoripagos){
			autoripago.setAutoriPagoOriginal((AutoriPago)autoripago.clone());
		}
	}
	
	public static void setAutoriPagoOriginalStatic(AutoriPago autoripago)throws Exception  {
		autoripago.setAutoriPagoOriginal((AutoriPago)autoripago.clone());		
	}
	
	public static void setAutoriPagosOriginalStatic(List<AutoriPago> autoripagos)throws Exception  {
		
		for(AutoriPago autoripago:autoripagos){
			autoripago.setAutoriPagoOriginal((AutoriPago)autoripago.clone());
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
	
	public  AutoriPago getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AutoriPago entity = new AutoriPago();		
		
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
	
	public  AutoriPago getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AutoriPago entity = new AutoriPago();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.AutoriPago.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAutoriPagoOriginal(new AutoriPago());
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAutoriPago("",entity,resultSet); 
				
				//entity.setAutoriPagoOriginal(super.getEntity("",entity.getAutoriPagoOriginal(),resultSet,AutoriPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOriginal(this.getEntityAutoriPago("",entity.getAutoriPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAutoriPago(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AutoriPago getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AutoriPago entity = new AutoriPago();
				
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
	
	public  AutoriPago getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AutoriPago entity = new AutoriPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.AutoriPago.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAutoriPagoOriginal(new AutoriPago());
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAutoriPago("",entity,resultSet);    
				
				//entity.setAutoriPagoOriginal(super.getEntity("",entity.getAutoriPagoOriginal(),resultSet,AutoriPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOriginal(this.getEntityAutoriPago("",entity.getAutoriPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAutoriPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AutoriPago
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AutoriPago entity = new AutoriPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.AutoriPago.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAutoriPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AutoriPago> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
		
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
	
	public  List<AutoriPago> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPago();
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriPago("",entity,resultSet);
      	    	
				//entity.setAutoriPagoOriginal( new AutoriPago());
      	    	//entity.setAutoriPagoOriginal(super.getEntity("",entity.getAutoriPagoOriginal(),resultSet,AutoriPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOriginal(this.getEntityAutoriPago("",entity.getAutoriPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriPagos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AutoriPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
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
	
	public  List<AutoriPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPago();
				
				if(conMapGenerico) {
					entity.inicializarMapAutoriPago();
					//entity.setMapAutoriPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAutoriPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAutoriPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AutoriPagoDataAccess.ISWITHSCHEMA);         		
					entity=AutoriPagoDataAccess.getEntityAutoriPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAutoriPagoOriginal( new AutoriPago());
					////entity.setAutoriPagoOriginal(super.getEntity("",entity.getAutoriPagoOriginal(),resultSet,AutoriPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setAutoriPagoOriginal(this.getEntityAutoriPago("",entity.getAutoriPagoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriPagos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AutoriPago getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AutoriPago entity = new AutoriPago();		  
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
	
	public  AutoriPago getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AutoriPago entity = new AutoriPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPago();
				
				if(conMapGenerico) {
					entity.inicializarMapAutoriPago();
					//entity.setMapAutoriPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAutoriPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAutoriPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AutoriPagoDataAccess.ISWITHSCHEMA);         		
					entity=AutoriPagoDataAccess.getEntityAutoriPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAutoriPagoOriginal( new AutoriPago());
					////entity.setAutoriPagoOriginal(super.getEntity("",entity.getAutoriPagoOriginal(),resultSet,AutoriPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setAutoriPagoOriginal(this.getEntityAutoriPago("",entity.getAutoriPagoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAutoriPago(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AutoriPago getEntityAutoriPago(String strPrefijo,AutoriPago entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AutoriPago.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AutoriPago.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AutoriPagoDataAccess.setFieldReflectionAutoriPago(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAutoriPago=AutoriPagoConstantesFunciones.getTodosTiposColumnasAutoriPago();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAutoriPago) {
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
							field = AutoriPago.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AutoriPago.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AutoriPagoDataAccess.setFieldReflectionAutoriPago(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAutoriPago(Field field,String strPrefijo,String sColumn,AutoriPago entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AutoriPagoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDCUENTABANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDDETALLEPROVE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriPagoConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriPagoConstantesFunciones.VALORPAGO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.VALORCANCELADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.DETALLEFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriPagoConstantesFunciones.FECHACORTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriPagoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AutoriPago>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AutoriPago();
					entity=super.getEntity("",entity,resultSet,AutoriPagoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAutoriPago("",entity,resultSet);
					
					//entity.setAutoriPagoOriginal( new AutoriPago());
					//entity.setAutoriPagoOriginal(super.getEntity("",entity.getAutoriPagoOriginal(),resultSet,AutoriPagoDataAccess.ISWITHSCHEMA));         		
					//entity.setAutoriPagoOriginal(this.getEntityAutoriPago("",entity.getAutoriPagoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAutoriPagos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AutoriPago>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AutoriPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
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
	
	public  List<AutoriPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPago();
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriPago("",entity,resultSet);
      	    	
				//entity.setAutoriPagoOriginal( new AutoriPago());
      	    	//entity.setAutoriPagoOriginal(super.getEntity("",entity.getAutoriPagoOriginal(),resultSet,AutoriPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOriginal(this.getEntityAutoriPago("",entity.getAutoriPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAutoriPagos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AutoriPago> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
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
	
	public  List<AutoriPago> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriPago> entities = new  ArrayList<AutoriPago>();
		AutoriPago entity = new AutoriPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPago();
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriPago("",entity,resultSet);
      	    	
				//entity.setAutoriPagoOriginal( new AutoriPago());
      	    	//entity.setAutoriPagoOriginal(super.getEntity("",entity.getAutoriPagoOriginal(),resultSet,AutoriPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOriginal(this.getEntityAutoriPago("",entity.getAutoriPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriPagos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AutoriPago getEntityAutoriPago(String strPrefijo,AutoriPago entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDEJERCICIO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDCLIENTE));
				entity.setid_factura(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDFACTURA));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDASIENTOCONTABLE));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_centro_actividad(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD));if(resultSet.wasNull()) {entity.setid_centro_actividad(null); }
				entity.setid_banco(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDBANCO));
				entity.setid_cuenta_banco(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDCUENTABANCO));
				entity.setid_detalle_prove(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDDETALLEPROVE));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+AutoriPagoConstantesFunciones.IDTRANSACCION));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+AutoriPagoConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+AutoriPagoConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setvalor_pago(resultSet.getDouble(strPrefijo+AutoriPagoConstantesFunciones.VALORPAGO));
				entity.setvalor_cancelado(resultSet.getDouble(strPrefijo+AutoriPagoConstantesFunciones.VALORCANCELADO));
				entity.setnumero_factura(resultSet.getString(strPrefijo+AutoriPagoConstantesFunciones.NUMEROFACTURA));
				entity.setdetalle_factura(resultSet.getString(strPrefijo+AutoriPagoConstantesFunciones.DETALLEFACTURA));
				entity.setfecha_corte(new Date(resultSet.getDate(strPrefijo+AutoriPagoConstantesFunciones.FECHACORTE).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+AutoriPagoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAutoriPago(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AutoriPago entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AutoriPagoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AutoriPagoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AutoriPagoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AutoriPagoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AutoriPagoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AutoriPagoDataAccess.TABLENAME,AutoriPagoDataAccess.ISWITHSTOREPROCEDURES);
			
			AutoriPagoDataAccess.setAutoriPagoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relautoripago.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relautoripago.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relautoripago.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Cliente getCliente(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relautoripago.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relautoripago.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public AsientoContable getAsientoContable(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relautoripago.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public CentroCosto getCentroCosto(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relautoripago.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public CentroActividad getCentroActividad(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		CentroActividad centroactividad= new CentroActividad();

		try {
			CentroActividadDataAccess centroactividadDataAccess=new CentroActividadDataAccess();

			centroactividadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centroactividadDataAccess.setConnexionType(this.connexionType);
			centroactividadDataAccess.setParameterDbType(this.parameterDbType);

			centroactividad=centroactividadDataAccess.getEntity(connexion,relautoripago.getid_centro_actividad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centroactividad;

	}

	public Banco getBanco(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relautoripago.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public CuentaBanco getCuentaBanco(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		CuentaBanco cuentabanco= new CuentaBanco();

		try {
			CuentaBancoDataAccess cuentabancoDataAccess=new CuentaBancoDataAccess();

			cuentabancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentabancoDataAccess.setConnexionType(this.connexionType);
			cuentabancoDataAccess.setParameterDbType(this.parameterDbType);

			cuentabanco=cuentabancoDataAccess.getEntity(connexion,relautoripago.getid_cuenta_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabanco;

	}

	public DetalleProve getDetalleProve(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		DetalleProve detalleprove= new DetalleProve();

		try {
			DetalleProveDataAccess detalleproveDataAccess=new DetalleProveDataAccess();

			detalleproveDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleproveDataAccess.setConnexionType(this.connexionType);
			detalleproveDataAccess.setParameterDbType(this.parameterDbType);

			detalleprove=detalleproveDataAccess.getEntity(connexion,relautoripago.getid_detalle_prove());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleprove;

	}

	public Transaccion getTransaccion(Connexion connexion,AutoriPago relautoripago)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relautoripago.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AutoriPago autoripago) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!autoripago.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(autoripago.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(autoripago.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(autoripago.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(autoripago.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(autoripago.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(autoripago.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(autoripago.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_actividad=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_actividad.setValue(autoripago.getid_centro_actividad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_actividad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(autoripago.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_banco.setValue(autoripago.getid_cuenta_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_prove=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_prove.setValue(autoripago.getid_detalle_prove());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_prove);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(autoripago.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(autoripago.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(autoripago.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_pago=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_pago.setValue(autoripago.getvalor_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_cancelado=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_cancelado.setValue(autoripago.getvalor_cancelado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_cancelado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(autoripago.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedetalle_factura=new ParameterValue<String>();
					parameterMaintenanceValuedetalle_factura.setValue(autoripago.getdetalle_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedetalle_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_corte=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_corte.setValue(autoripago.getfecha_corte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_corte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(autoripago.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!autoripago.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(autoripago.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(autoripago.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(autoripago.getId());
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
	
	public void setIsNewIsChangedFalseAutoriPago(AutoriPago autoripago)throws Exception  {		
		autoripago.setIsNew(false);
		autoripago.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAutoriPagos(List<AutoriPago> autoripagos)throws Exception  {				
		for(AutoriPago autoripago:autoripagos) {
			autoripago.setIsNew(false);
			autoripago.setIsChanged(false);
		}
	}
	
	public void generarExportarAutoriPago(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
