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
import com.bydan.erp.tesoreria.util.*;//BancoFormaPagoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class BancoFormaPagoDataAccess extends  BancoFormaPagoDataAccessAdditional{ //BancoFormaPagoDataAccessAdditional,DataAccessHelper<BancoFormaPago>
	//static Logger logger = Logger.getLogger(BancoFormaPagoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="banco_forma_pago";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_factura,id_deta_forma_pago,id_tipo_banco_forma_pago,nombre_banco,nombre_girador,fecha_vence,numero_cuenta_banco,numero_cheque,valor_monto,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_factura=?,id_deta_forma_pago=?,id_tipo_banco_forma_pago=?,nombre_banco=?,nombre_girador=?,fecha_vence=?,numero_cuenta_banco=?,numero_cheque=?,valor_monto=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select bancoformapago from "+BancoFormaPagoConstantesFunciones.SPERSISTENCENAME+" bancoformapago";
	public static String QUERYSELECTNATIVE="select "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".version_row,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_ejercicio,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_periodo,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_factura,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_deta_forma_pago,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_tipo_banco_forma_pago,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".nombre_banco,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".nombre_girador,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".fecha_vence,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".numero_cuenta_banco,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".numero_cheque,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".valor_monto,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_anio,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_mes from "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME;//+" as "+BancoFormaPagoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".version_row from "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME;//+" as "+BancoFormaPagoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_factura=?,id_deta_forma_pago=?,id_tipo_banco_forma_pago=?,nombre_banco=?,nombre_girador=?,fecha_vence=?,numero_cuenta_banco=?,numero_cheque=?,valor_monto=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_BANCOFORMAPAGO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_BANCOFORMAPAGO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_BANCOFORMAPAGO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_BANCOFORMAPAGO_SELECT(?,?)";
	
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
	
	
	protected BancoFormaPagoDataAccessAdditional bancoformapagoDataAccessAdditional=null;
	
	public BancoFormaPagoDataAccessAdditional getBancoFormaPagoDataAccessAdditional() {
		return this.bancoformapagoDataAccessAdditional;
	}
	
	public void setBancoFormaPagoDataAccessAdditional(BancoFormaPagoDataAccessAdditional bancoformapagoDataAccessAdditional) {
		try {
			this.bancoformapagoDataAccessAdditional=bancoformapagoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public BancoFormaPagoDataAccess() {
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
		BancoFormaPagoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		BancoFormaPagoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		BancoFormaPagoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setBancoFormaPagoOriginal(BancoFormaPago bancoformapago)throws Exception  {
		bancoformapago.setBancoFormaPagoOriginal((BancoFormaPago)bancoformapago.clone());		
	}
	
	public void setBancoFormaPagosOriginal(List<BancoFormaPago> bancoformapagos)throws Exception  {
		
		for(BancoFormaPago bancoformapago:bancoformapagos){
			bancoformapago.setBancoFormaPagoOriginal((BancoFormaPago)bancoformapago.clone());
		}
	}
	
	public static void setBancoFormaPagoOriginalStatic(BancoFormaPago bancoformapago)throws Exception  {
		bancoformapago.setBancoFormaPagoOriginal((BancoFormaPago)bancoformapago.clone());		
	}
	
	public static void setBancoFormaPagosOriginalStatic(List<BancoFormaPago> bancoformapagos)throws Exception  {
		
		for(BancoFormaPago bancoformapago:bancoformapagos){
			bancoformapago.setBancoFormaPagoOriginal((BancoFormaPago)bancoformapago.clone());
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
	
	public  BancoFormaPago getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		BancoFormaPago entity = new BancoFormaPago();		
		
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
	
	public  BancoFormaPago getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		BancoFormaPago entity = new BancoFormaPago();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.BancoFormaPago.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setBancoFormaPagoOriginal(new BancoFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBancoFormaPago("",entity,resultSet); 
				
				//entity.setBancoFormaPagoOriginal(super.getEntity("",entity.getBancoFormaPagoOriginal(),resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoFormaPagoOriginal(this.getEntityBancoFormaPago("",entity.getBancoFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseBancoFormaPago(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  BancoFormaPago getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		BancoFormaPago entity = new BancoFormaPago();
				
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
	
	public  BancoFormaPago getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		BancoFormaPago entity = new BancoFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.BancoFormaPago.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setBancoFormaPagoOriginal(new BancoFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBancoFormaPago("",entity,resultSet);    
				
				//entity.setBancoFormaPagoOriginal(super.getEntity("",entity.getBancoFormaPagoOriginal(),resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoFormaPagoOriginal(this.getEntityBancoFormaPago("",entity.getBancoFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseBancoFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //BancoFormaPago
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		BancoFormaPago entity = new BancoFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.BancoFormaPago.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseBancoFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<BancoFormaPago> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
		
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
	
	public  List<BancoFormaPago> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBancoFormaPago("",entity,resultSet);
      	    	
				//entity.setBancoFormaPagoOriginal( new BancoFormaPago());
      	    	//entity.setBancoFormaPagoOriginal(super.getEntity("",entity.getBancoFormaPagoOriginal(),resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoFormaPagoOriginal(this.getEntityBancoFormaPago("",entity.getBancoFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBancoFormaPagos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<BancoFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
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
	
	public  List<BancoFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapBancoFormaPago();
					//entity.setMapBancoFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapBancoFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBancoFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=BancoFormaPagoDataAccess.getEntityBancoFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBancoFormaPagoOriginal( new BancoFormaPago());
					////entity.setBancoFormaPagoOriginal(super.getEntity("",entity.getBancoFormaPagoOriginal(),resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setBancoFormaPagoOriginal(this.getEntityBancoFormaPago("",entity.getBancoFormaPagoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBancoFormaPagos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public BancoFormaPago getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		BancoFormaPago entity = new BancoFormaPago();		  
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
	
	public  BancoFormaPago getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		BancoFormaPago entity = new BancoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapBancoFormaPago();
					//entity.setMapBancoFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapBancoFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBancoFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=BancoFormaPagoDataAccess.getEntityBancoFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBancoFormaPagoOriginal( new BancoFormaPago());
					////entity.setBancoFormaPagoOriginal(super.getEntity("",entity.getBancoFormaPagoOriginal(),resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setBancoFormaPagoOriginal(this.getEntityBancoFormaPago("",entity.getBancoFormaPagoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseBancoFormaPago(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static BancoFormaPago getEntityBancoFormaPago(String strPrefijo,BancoFormaPago entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = BancoFormaPago.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = BancoFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					BancoFormaPagoDataAccess.setFieldReflectionBancoFormaPago(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasBancoFormaPago=BancoFormaPagoConstantesFunciones.getTodosTiposColumnasBancoFormaPago();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasBancoFormaPago) {
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
							field = BancoFormaPago.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = BancoFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						BancoFormaPagoDataAccess.setFieldReflectionBancoFormaPago(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionBancoFormaPago(Field field,String strPrefijo,String sColumn,BancoFormaPago entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case BancoFormaPagoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.NOMBREBANCO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.NOMBREGIRADOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.VALORMONTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoFormaPagoConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<BancoFormaPago>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new BancoFormaPago();
					entity=super.getEntity("",entity,resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityBancoFormaPago("",entity,resultSet);
					
					//entity.setBancoFormaPagoOriginal( new BancoFormaPago());
					//entity.setBancoFormaPagoOriginal(super.getEntity("",entity.getBancoFormaPagoOriginal(),resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA));         		
					//entity.setBancoFormaPagoOriginal(this.getEntityBancoFormaPago("",entity.getBancoFormaPagoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseBancoFormaPagos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<BancoFormaPago>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BancoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<BancoFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
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
	
	public  List<BancoFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBancoFormaPago("",entity,resultSet);
      	    	
				//entity.setBancoFormaPagoOriginal( new BancoFormaPago());
      	    	//entity.setBancoFormaPagoOriginal(super.getEntity("",entity.getBancoFormaPagoOriginal(),resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoFormaPagoOriginal(this.getEntityBancoFormaPago("",entity.getBancoFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseBancoFormaPagos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<BancoFormaPago> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
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
	
	public  List<BancoFormaPago> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BancoFormaPago> entities = new  ArrayList<BancoFormaPago>();
		BancoFormaPago entity = new BancoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBancoFormaPago("",entity,resultSet);
      	    	
				//entity.setBancoFormaPagoOriginal( new BancoFormaPago());
      	    	//entity.setBancoFormaPagoOriginal(super.getEntity("",entity.getBancoFormaPagoOriginal(),resultSet,BancoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoFormaPagoOriginal(this.getEntityBancoFormaPago("",entity.getBancoFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBancoFormaPagos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public BancoFormaPago getEntityBancoFormaPago(String strPrefijo,BancoFormaPago entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+BancoFormaPagoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+BancoFormaPagoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+BancoFormaPagoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+BancoFormaPagoConstantesFunciones.IDPERIODO));
				entity.setid_factura(resultSet.getLong(strPrefijo+BancoFormaPagoConstantesFunciones.IDFACTURA));
				entity.setid_deta_forma_pago(resultSet.getLong(strPrefijo+BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO));
				entity.setid_tipo_banco_forma_pago(resultSet.getLong(strPrefijo+BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO));
				entity.setnombre_banco(resultSet.getString(strPrefijo+BancoFormaPagoConstantesFunciones.NOMBREBANCO));
				entity.setnombre_girador(resultSet.getString(strPrefijo+BancoFormaPagoConstantesFunciones.NOMBREGIRADOR));
				entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+BancoFormaPagoConstantesFunciones.FECHAVENCE).getTime()));
				entity.setnumero_cuenta_banco(resultSet.getString(strPrefijo+BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO));
				entity.setnumero_cheque(resultSet.getString(strPrefijo+BancoFormaPagoConstantesFunciones.NUMEROCHEQUE));
				entity.setvalor_monto(resultSet.getDouble(strPrefijo+BancoFormaPagoConstantesFunciones.VALORMONTO));
				entity.setid_anio(resultSet.getLong(strPrefijo+BancoFormaPagoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+BancoFormaPagoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowBancoFormaPago(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(BancoFormaPago entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=BancoFormaPagoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=BancoFormaPagoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=BancoFormaPagoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=BancoFormaPagoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(BancoFormaPagoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,BancoFormaPagoDataAccess.TABLENAME,BancoFormaPagoDataAccess.ISWITHSTOREPROCEDURES);
			
			BancoFormaPagoDataAccess.setBancoFormaPagoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,BancoFormaPago relbancoformapago)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relbancoformapago.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,BancoFormaPago relbancoformapago)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relbancoformapago.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,BancoFormaPago relbancoformapago)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relbancoformapago.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,BancoFormaPago relbancoformapago)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relbancoformapago.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Factura getFactura(Connexion connexion,BancoFormaPago relbancoformapago)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relbancoformapago.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public DetaFormaPago getDetaFormaPago(Connexion connexion,BancoFormaPago relbancoformapago)throws SQLException,Exception {

		DetaFormaPago detaformapago= new DetaFormaPago();

		try {
			DetaFormaPagoDataAccess detaformapagoDataAccess=new DetaFormaPagoDataAccess();

			detaformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detaformapagoDataAccess.setConnexionType(this.connexionType);
			detaformapagoDataAccess.setParameterDbType(this.parameterDbType);

			detaformapago=detaformapagoDataAccess.getEntity(connexion,relbancoformapago.getid_deta_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detaformapago;

	}

	public TipoBancoFormaPago getTipoBancoFormaPago(Connexion connexion,BancoFormaPago relbancoformapago)throws SQLException,Exception {

		TipoBancoFormaPago tipobancoformapago= new TipoBancoFormaPago();

		try {
			TipoBancoFormaPagoDataAccess tipobancoformapagoDataAccess=new TipoBancoFormaPagoDataAccess();

			tipobancoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipobancoformapagoDataAccess.setConnexionType(this.connexionType);
			tipobancoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipobancoformapago=tipobancoformapagoDataAccess.getEntity(connexion,relbancoformapago.getid_tipo_banco_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipobancoformapago;

	}

	public Anio getAnio(Connexion connexion,BancoFormaPago relbancoformapago)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relbancoformapago.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,BancoFormaPago relbancoformapago)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relbancoformapago.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,BancoFormaPago bancoformapago) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!bancoformapago.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(bancoformapago.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(bancoformapago.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(bancoformapago.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(bancoformapago.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(bancoformapago.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_deta_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_deta_forma_pago.setValue(bancoformapago.getid_deta_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_deta_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_banco_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_banco_forma_pago.setValue(bancoformapago.getid_tipo_banco_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_banco_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_banco=new ParameterValue<String>();
					parameterMaintenanceValuenombre_banco.setValue(bancoformapago.getnombre_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_girador=new ParameterValue<String>();
					parameterMaintenanceValuenombre_girador.setValue(bancoformapago.getnombre_girador());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_girador);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vence=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vence.setValue(bancoformapago.getfecha_vence());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vence);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cuenta_banco=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cuenta_banco.setValue(bancoformapago.getnumero_cuenta_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuenta_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cheque=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cheque.setValue(bancoformapago.getnumero_cheque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cheque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_monto=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_monto.setValue(bancoformapago.getvalor_monto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_monto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(bancoformapago.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(bancoformapago.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!bancoformapago.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(bancoformapago.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(bancoformapago.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(bancoformapago.getId());
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
	
	public void setIsNewIsChangedFalseBancoFormaPago(BancoFormaPago bancoformapago)throws Exception  {		
		bancoformapago.setIsNew(false);
		bancoformapago.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseBancoFormaPagos(List<BancoFormaPago> bancoformapagos)throws Exception  {				
		for(BancoFormaPago bancoformapago:bancoformapagos) {
			bancoformapago.setIsNew(false);
			bancoformapago.setIsChanged(false);
		}
	}
	
	public void generarExportarBancoFormaPago(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
