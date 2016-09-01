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
import com.bydan.erp.facturacion.util.*;//DetaFormaPagoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class DetaFormaPagoDataAccess extends  DetaFormaPagoDataAccessAdditional{ //DetaFormaPagoDataAccessAdditional,DataAccessHelper<DetaFormaPago>
	//static Logger logger = Logger.getLogger(DetaFormaPagoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="deta_forma_pago";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_factura,id_tipo_forma_pago,id_tipo_deta_forma_pago,id_deta_forma_pago_factu,id_cuenta_contable,id_tipo_retencion,valor,fecha_inicial,fecha_final,porcentaje,retencion,porcentaje_retencion,base_retencion,valor_retencion,numero_retencion,numero_dias,numero_cuota,descripcion,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_factura=?,id_tipo_forma_pago=?,id_tipo_deta_forma_pago=?,id_deta_forma_pago_factu=?,id_cuenta_contable=?,id_tipo_retencion=?,valor=?,fecha_inicial=?,fecha_final=?,porcentaje=?,retencion=?,porcentaje_retencion=?,base_retencion=?,valor_retencion=?,numero_retencion=?,numero_dias=?,numero_cuota=?,descripcion=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detaformapago from "+DetaFormaPagoConstantesFunciones.SPERSISTENCENAME+" detaformapago";
	public static String QUERYSELECTNATIVE="select "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".version_row,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_ejercicio,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_periodo,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_factura,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_tipo_deta_forma_pago,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_deta_forma_pago_factu,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_tipo_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".valor,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".fecha_inicial,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".fecha_final,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".porcentaje,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".porcentaje_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".base_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".valor_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".numero_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".numero_dias,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".numero_cuota,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".descripcion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_anio,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_mes from "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME;//+" as "+DetaFormaPagoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".version_row from "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME;//+" as "+DetaFormaPagoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_factura=?,id_tipo_forma_pago=?,id_tipo_deta_forma_pago=?,id_deta_forma_pago_factu=?,id_cuenta_contable=?,id_tipo_retencion=?,valor=?,fecha_inicial=?,fecha_final=?,porcentaje=?,retencion=?,porcentaje_retencion=?,base_retencion=?,valor_retencion=?,numero_retencion=?,numero_dias=?,numero_cuota=?,descripcion=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETAFORMAPAGO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETAFORMAPAGO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETAFORMAPAGO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETAFORMAPAGO_SELECT(?,?)";
	
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
	
	
	protected DetaFormaPagoDataAccessAdditional detaformapagoDataAccessAdditional=null;
	
	public DetaFormaPagoDataAccessAdditional getDetaFormaPagoDataAccessAdditional() {
		return this.detaformapagoDataAccessAdditional;
	}
	
	public void setDetaFormaPagoDataAccessAdditional(DetaFormaPagoDataAccessAdditional detaformapagoDataAccessAdditional) {
		try {
			this.detaformapagoDataAccessAdditional=detaformapagoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetaFormaPagoDataAccess() {
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
		DetaFormaPagoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetaFormaPagoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetaFormaPagoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetaFormaPagoOriginal(DetaFormaPago detaformapago)throws Exception  {
		detaformapago.setDetaFormaPagoOriginal((DetaFormaPago)detaformapago.clone());		
	}
	
	public void setDetaFormaPagosOriginal(List<DetaFormaPago> detaformapagos)throws Exception  {
		
		for(DetaFormaPago detaformapago:detaformapagos){
			detaformapago.setDetaFormaPagoOriginal((DetaFormaPago)detaformapago.clone());
		}
	}
	
	public static void setDetaFormaPagoOriginalStatic(DetaFormaPago detaformapago)throws Exception  {
		detaformapago.setDetaFormaPagoOriginal((DetaFormaPago)detaformapago.clone());		
	}
	
	public static void setDetaFormaPagosOriginalStatic(List<DetaFormaPago> detaformapagos)throws Exception  {
		
		for(DetaFormaPago detaformapago:detaformapagos){
			detaformapago.setDetaFormaPagoOriginal((DetaFormaPago)detaformapago.clone());
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
	
	public  DetaFormaPago getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetaFormaPago entity = new DetaFormaPago();		
		
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
	
	public  DetaFormaPago getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetaFormaPago entity = new DetaFormaPago();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetaFormaPago.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetaFormaPagoOriginal(new DetaFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetaFormaPago("",entity,resultSet); 
				
				//entity.setDetaFormaPagoOriginal(super.getEntity("",entity.getDetaFormaPagoOriginal(),resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoOriginal(this.getEntityDetaFormaPago("",entity.getDetaFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetaFormaPago(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetaFormaPago getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetaFormaPago entity = new DetaFormaPago();
				
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
	
	public  DetaFormaPago getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetaFormaPago entity = new DetaFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetaFormaPago.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetaFormaPagoOriginal(new DetaFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetaFormaPago("",entity,resultSet);    
				
				//entity.setDetaFormaPagoOriginal(super.getEntity("",entity.getDetaFormaPagoOriginal(),resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoOriginal(this.getEntityDetaFormaPago("",entity.getDetaFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetaFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetaFormaPago
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetaFormaPago entity = new DetaFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetaFormaPago.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetaFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetaFormaPago> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
		
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
	
	public  List<DetaFormaPago> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaFormaPago("",entity,resultSet);
      	    	
				//entity.setDetaFormaPagoOriginal( new DetaFormaPago());
      	    	//entity.setDetaFormaPagoOriginal(super.getEntity("",entity.getDetaFormaPagoOriginal(),resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoOriginal(this.getEntityDetaFormaPago("",entity.getDetaFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaFormaPagos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetaFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
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
	
	public  List<DetaFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapDetaFormaPago();
					//entity.setMapDetaFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetaFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetaFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=DetaFormaPagoDataAccess.getEntityDetaFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetaFormaPagoOriginal( new DetaFormaPago());
					////entity.setDetaFormaPagoOriginal(super.getEntity("",entity.getDetaFormaPagoOriginal(),resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetaFormaPagoOriginal(this.getEntityDetaFormaPago("",entity.getDetaFormaPagoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaFormaPagos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetaFormaPago getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetaFormaPago entity = new DetaFormaPago();		  
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
	
	public  DetaFormaPago getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetaFormaPago entity = new DetaFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapDetaFormaPago();
					//entity.setMapDetaFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetaFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetaFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=DetaFormaPagoDataAccess.getEntityDetaFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetaFormaPagoOriginal( new DetaFormaPago());
					////entity.setDetaFormaPagoOriginal(super.getEntity("",entity.getDetaFormaPagoOriginal(),resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetaFormaPagoOriginal(this.getEntityDetaFormaPago("",entity.getDetaFormaPagoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetaFormaPago(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetaFormaPago getEntityDetaFormaPago(String strPrefijo,DetaFormaPago entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetaFormaPago.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetaFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetaFormaPagoDataAccess.setFieldReflectionDetaFormaPago(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetaFormaPago=DetaFormaPagoConstantesFunciones.getTodosTiposColumnasDetaFormaPago();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetaFormaPago) {
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
							field = DetaFormaPago.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetaFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetaFormaPagoDataAccess.setFieldReflectionDetaFormaPago(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetaFormaPago(Field field,String strPrefijo,String sColumn,DetaFormaPago entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetaFormaPagoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDTIPORETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.FECHAINICIAL:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetaFormaPagoConstantesFunciones.FECHAFINAL:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetaFormaPagoConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.RETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.BASERETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.VALORRETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.NUMERORETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.NUMERODIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.NUMEROCUOTA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetaFormaPago>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetaFormaPago();
					entity=super.getEntity("",entity,resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetaFormaPago("",entity,resultSet);
					
					//entity.setDetaFormaPagoOriginal( new DetaFormaPago());
					//entity.setDetaFormaPagoOriginal(super.getEntity("",entity.getDetaFormaPagoOriginal(),resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA));         		
					//entity.setDetaFormaPagoOriginal(this.getEntityDetaFormaPago("",entity.getDetaFormaPagoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetaFormaPagos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetaFormaPago>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetaFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
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
	
	public  List<DetaFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaFormaPago("",entity,resultSet);
      	    	
				//entity.setDetaFormaPagoOriginal( new DetaFormaPago());
      	    	//entity.setDetaFormaPagoOriginal(super.getEntity("",entity.getDetaFormaPagoOriginal(),resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoOriginal(this.getEntityDetaFormaPago("",entity.getDetaFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetaFormaPagos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetaFormaPago> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
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
	
	public  List<DetaFormaPago> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaFormaPago> entities = new  ArrayList<DetaFormaPago>();
		DetaFormaPago entity = new DetaFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaFormaPago("",entity,resultSet);
      	    	
				//entity.setDetaFormaPagoOriginal( new DetaFormaPago());
      	    	//entity.setDetaFormaPagoOriginal(super.getEntity("",entity.getDetaFormaPagoOriginal(),resultSet,DetaFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoOriginal(this.getEntityDetaFormaPago("",entity.getDetaFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaFormaPagos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetaFormaPago getEntityDetaFormaPago(String strPrefijo,DetaFormaPago entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDPERIODO));
				entity.setid_factura(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDFACTURA));
				entity.setid_tipo_forma_pago(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO));
				entity.setid_tipo_deta_forma_pago(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO));
				entity.setid_deta_forma_pago_factu(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE));if(resultSet.wasNull()) {entity.setid_cuenta_contable(null); }
				entity.setid_tipo_retencion(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDTIPORETENCION));
				entity.setvalor(resultSet.getDouble(strPrefijo+DetaFormaPagoConstantesFunciones.VALOR));
				entity.setfecha_inicial(new Date(resultSet.getDate(strPrefijo+DetaFormaPagoConstantesFunciones.FECHAINICIAL).getTime()));
				entity.setfecha_final(new Date(resultSet.getDate(strPrefijo+DetaFormaPagoConstantesFunciones.FECHAFINAL).getTime()));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+DetaFormaPagoConstantesFunciones.PORCENTAJE));
				entity.setretencion(resultSet.getDouble(strPrefijo+DetaFormaPagoConstantesFunciones.RETENCION));
				entity.setporcentaje_retencion(resultSet.getDouble(strPrefijo+DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION));
				entity.setbase_retencion(resultSet.getDouble(strPrefijo+DetaFormaPagoConstantesFunciones.BASERETENCION));
				entity.setvalor_retencion(resultSet.getDouble(strPrefijo+DetaFormaPagoConstantesFunciones.VALORRETENCION));
				entity.setnumero_retencion(resultSet.getString(strPrefijo+DetaFormaPagoConstantesFunciones.NUMERORETENCION));
				entity.setnumero_dias(resultSet.getInt(strPrefijo+DetaFormaPagoConstantesFunciones.NUMERODIAS));
				entity.setnumero_cuota(resultSet.getInt(strPrefijo+DetaFormaPagoConstantesFunciones.NUMEROCUOTA));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetaFormaPagoConstantesFunciones.DESCRIPCION));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetaFormaPagoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetaFormaPago(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetaFormaPago entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetaFormaPagoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetaFormaPagoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetaFormaPagoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetaFormaPagoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetaFormaPagoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetaFormaPagoDataAccess.TABLENAME,DetaFormaPagoDataAccess.ISWITHSTOREPROCEDURES);
			
			DetaFormaPagoDataAccess.setDetaFormaPagoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetaformapago.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetaformapago.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetaformapago.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetaformapago.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Factura getFactura(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,reldetaformapago.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public TipoFormaPago getTipoFormaPago(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		TipoFormaPago tipoformapago= new TipoFormaPago();

		try {
			TipoFormaPagoDataAccess tipoformapagoDataAccess=new TipoFormaPagoDataAccess();

			tipoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoformapagoDataAccess.setConnexionType(this.connexionType);
			tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipoformapago=tipoformapagoDataAccess.getEntity(connexion,reldetaformapago.getid_tipo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformapago;

	}

	public TipoDetaFormaPago getTipoDetaFormaPago(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		TipoDetaFormaPago tipodetaformapago= new TipoDetaFormaPago();

		try {
			TipoDetaFormaPagoDataAccess tipodetaformapagoDataAccess=new TipoDetaFormaPagoDataAccess();

			tipodetaformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodetaformapagoDataAccess.setConnexionType(this.connexionType);
			tipodetaformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipodetaformapago=tipodetaformapagoDataAccess.getEntity(connexion,reldetaformapago.getid_tipo_deta_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodetaformapago;

	}

	public DetaFormaPagoFactu getDetaFormaPagoFactu(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		DetaFormaPagoFactu detaformapagofactu= new DetaFormaPagoFactu();

		try {
			DetaFormaPagoFactuDataAccess detaformapagofactuDataAccess=new DetaFormaPagoFactuDataAccess();

			detaformapagofactuDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detaformapagofactuDataAccess.setConnexionType(this.connexionType);
			detaformapagofactuDataAccess.setParameterDbType(this.parameterDbType);

			detaformapagofactu=detaformapagofactuDataAccess.getEntity(connexion,reldetaformapago.getid_deta_forma_pago_factu());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detaformapagofactu;

	}

	public CuentaContable getCuentaContable(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldetaformapago.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public TipoRetencion getTipoRetencion(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,reldetaformapago.getid_tipo_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public Anio getAnio(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetaformapago.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetaFormaPago reldetaformapago)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetaformapago.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<BancoFormaPago> getBancoFormaPagos(Connexion connexion,DetaFormaPago detaformapago)throws SQLException,Exception {

		List<BancoFormaPago> bancoformapagos= new ArrayList<BancoFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetaFormaPagoConstantesFunciones.SCHEMA+".deta_forma_pago ON "+BancoFormaPagoConstantesFunciones.SCHEMA+".banco_forma_pago.id_deta_forma_pago="+DetaFormaPagoConstantesFunciones.SCHEMA+".deta_forma_pago.id WHERE "+DetaFormaPagoConstantesFunciones.SCHEMA+".deta_forma_pago.id="+String.valueOf(detaformapago.getId());
			} else {
				sQuery=" INNER JOIN bancoformapago.DetaFormaPago WHERE bancoformapago.DetaFormaPago.id="+String.valueOf(detaformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BancoFormaPagoDataAccess bancoformapagoDataAccess=new BancoFormaPagoDataAccess();

			bancoformapagoDataAccess.setConnexionType(this.connexionType);
			bancoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bancoformapagos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetaFormaPago detaformapago) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detaformapago.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detaformapago.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detaformapago.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detaformapago.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detaformapago.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(detaformapago.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_forma_pago.setValue(detaformapago.getid_tipo_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_deta_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_deta_forma_pago.setValue(detaformapago.getid_tipo_deta_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_deta_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_deta_forma_pago_factu=new ParameterValue<Long>();
					parameterMaintenanceValueid_deta_forma_pago_factu.setValue(detaformapago.getid_deta_forma_pago_factu());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_deta_forma_pago_factu);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(detaformapago.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion.setValue(detaformapago.getid_tipo_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(detaformapago.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicial=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicial.setValue(detaformapago.getfecha_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_final=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_final.setValue(detaformapago.getfecha_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(detaformapago.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion=new ParameterValue<Double>();
					parameterMaintenanceValueretencion.setValue(detaformapago.getretencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_retencion=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_retencion.setValue(detaformapago.getporcentaje_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuebase_retencion.setValue(detaformapago.getbase_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_retencion.setValue(detaformapago.getvalor_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion.setValue(detaformapago.getnumero_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias.setValue(detaformapago.getnumero_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_cuota=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_cuota.setValue(detaformapago.getnumero_cuota());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuota);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detaformapago.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detaformapago.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detaformapago.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!detaformapago.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detaformapago.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detaformapago.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detaformapago.getId());
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
	
	public void setIsNewIsChangedFalseDetaFormaPago(DetaFormaPago detaformapago)throws Exception  {		
		detaformapago.setIsNew(false);
		detaformapago.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetaFormaPagos(List<DetaFormaPago> detaformapagos)throws Exception  {				
		for(DetaFormaPago detaformapago:detaformapagos) {
			detaformapago.setIsNew(false);
			detaformapago.setIsChanged(false);
		}
	}
	
	public void generarExportarDetaFormaPago(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
