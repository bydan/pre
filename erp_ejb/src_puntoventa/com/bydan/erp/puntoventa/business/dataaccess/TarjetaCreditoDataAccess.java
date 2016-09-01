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
import com.bydan.erp.puntoventa.util.*;//TarjetaCreditoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TarjetaCreditoDataAccess extends  TarjetaCreditoDataAccessAdditional{ //TarjetaCreditoDataAccessAdditional,DataAccessHelper<TarjetaCredito>
	//static Logger logger = Logger.getLogger(TarjetaCreditoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tarjeta_credito";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_banco,codigo,nombre,nombre_corto,digito_valido,digito_tarjeta,comision,interes,monto_minimo,porcentaje_retencion,comision_retencion,es_retencion_redondeo,es_pago_banco_redondeo,es_comision_redondeo,id_tipo_retencion,id_cuenta_contable,id_tipo_retencion_iva,id_cuenta_contable_comision,id_formula_pago_banco,id_cuenta_contable_diferencia,id_formula_retencion,id_formula_comision)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_banco=?,codigo=?,nombre=?,nombre_corto=?,digito_valido=?,digito_tarjeta=?,comision=?,interes=?,monto_minimo=?,porcentaje_retencion=?,comision_retencion=?,es_retencion_redondeo=?,es_pago_banco_redondeo=?,es_comision_redondeo=?,id_tipo_retencion=?,id_cuenta_contable=?,id_tipo_retencion_iva=?,id_cuenta_contable_comision=?,id_formula_pago_banco=?,id_cuenta_contable_diferencia=?,id_formula_retencion=?,id_formula_comision=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tarjetacredito from "+TarjetaCreditoConstantesFunciones.SPERSISTENCENAME+" tarjetacredito";
	public static String QUERYSELECTNATIVE="select "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".version_row,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_empresa,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_sucursal,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_banco,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".codigo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".nombre,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".nombre_corto,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".digito_valido,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".digito_tarjeta,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".comision,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".interes,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".monto_minimo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".porcentaje_retencion,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".comision_retencion,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".es_retencion_redondeo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".es_pago_banco_redondeo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".es_comision_redondeo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_tipo_retencion,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_tipo_retencion_iva,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_cuenta_contable_comision,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_formula_pago_banco,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_cuenta_contable_diferencia,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_formula_retencion,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_formula_comision from "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME;//+" as "+TarjetaCreditoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".version_row,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".codigo from "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME;//+" as "+TarjetaCreditoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_banco=?,codigo=?,nombre=?,nombre_corto=?,digito_valido=?,digito_tarjeta=?,comision=?,interes=?,monto_minimo=?,porcentaje_retencion=?,comision_retencion=?,es_retencion_redondeo=?,es_pago_banco_redondeo=?,es_comision_redondeo=?,id_tipo_retencion=?,id_cuenta_contable=?,id_tipo_retencion_iva=?,id_cuenta_contable_comision=?,id_formula_pago_banco=?,id_cuenta_contable_diferencia=?,id_formula_retencion=?,id_formula_comision=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TARJETACREDITO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TARJETACREDITO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TARJETACREDITO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TARJETACREDITO_SELECT(?,?)";
	
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
	
	
	protected TarjetaCreditoDataAccessAdditional tarjetacreditoDataAccessAdditional=null;
	
	public TarjetaCreditoDataAccessAdditional getTarjetaCreditoDataAccessAdditional() {
		return this.tarjetacreditoDataAccessAdditional;
	}
	
	public void setTarjetaCreditoDataAccessAdditional(TarjetaCreditoDataAccessAdditional tarjetacreditoDataAccessAdditional) {
		try {
			this.tarjetacreditoDataAccessAdditional=tarjetacreditoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TarjetaCreditoDataAccess() {
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
		TarjetaCreditoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TarjetaCreditoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TarjetaCreditoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTarjetaCreditoOriginal(TarjetaCredito tarjetacredito)throws Exception  {
		tarjetacredito.setTarjetaCreditoOriginal((TarjetaCredito)tarjetacredito.clone());		
	}
	
	public void setTarjetaCreditosOriginal(List<TarjetaCredito> tarjetacreditos)throws Exception  {
		
		for(TarjetaCredito tarjetacredito:tarjetacreditos){
			tarjetacredito.setTarjetaCreditoOriginal((TarjetaCredito)tarjetacredito.clone());
		}
	}
	
	public static void setTarjetaCreditoOriginalStatic(TarjetaCredito tarjetacredito)throws Exception  {
		tarjetacredito.setTarjetaCreditoOriginal((TarjetaCredito)tarjetacredito.clone());		
	}
	
	public static void setTarjetaCreditosOriginalStatic(List<TarjetaCredito> tarjetacreditos)throws Exception  {
		
		for(TarjetaCredito tarjetacredito:tarjetacreditos){
			tarjetacredito.setTarjetaCreditoOriginal((TarjetaCredito)tarjetacredito.clone());
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
	
	public  TarjetaCredito getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TarjetaCredito entity = new TarjetaCredito();		
		
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
	
	public  TarjetaCredito getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TarjetaCredito entity = new TarjetaCredito();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.TarjetaCredito.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTarjetaCreditoOriginal(new TarjetaCredito());
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTarjetaCredito("",entity,resultSet); 
				
				//entity.setTarjetaCreditoOriginal(super.getEntity("",entity.getTarjetaCreditoOriginal(),resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoOriginal(this.getEntityTarjetaCredito("",entity.getTarjetaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTarjetaCredito(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TarjetaCredito getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TarjetaCredito entity = new TarjetaCredito();
				
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
	
	public  TarjetaCredito getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TarjetaCredito entity = new TarjetaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TarjetaCredito.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTarjetaCreditoOriginal(new TarjetaCredito());
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTarjetaCredito("",entity,resultSet);    
				
				//entity.setTarjetaCreditoOriginal(super.getEntity("",entity.getTarjetaCreditoOriginal(),resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoOriginal(this.getEntityTarjetaCredito("",entity.getTarjetaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTarjetaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TarjetaCredito
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TarjetaCredito entity = new TarjetaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TarjetaCredito.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTarjetaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TarjetaCredito> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
		
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
	
	public  List<TarjetaCredito> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCredito();
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTarjetaCredito("",entity,resultSet);
      	    	
				//entity.setTarjetaCreditoOriginal( new TarjetaCredito());
      	    	//entity.setTarjetaCreditoOriginal(super.getEntity("",entity.getTarjetaCreditoOriginal(),resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoOriginal(this.getEntityTarjetaCredito("",entity.getTarjetaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TarjetaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
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
	
	public  List<TarjetaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapTarjetaCredito();
					//entity.setMapTarjetaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTarjetaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTarjetaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=TarjetaCreditoDataAccess.getEntityTarjetaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTarjetaCreditoOriginal( new TarjetaCredito());
					////entity.setTarjetaCreditoOriginal(super.getEntity("",entity.getTarjetaCreditoOriginal(),resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setTarjetaCreditoOriginal(this.getEntityTarjetaCredito("",entity.getTarjetaCreditoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TarjetaCredito getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TarjetaCredito entity = new TarjetaCredito();		  
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
	
	public  TarjetaCredito getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TarjetaCredito entity = new TarjetaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapTarjetaCredito();
					//entity.setMapTarjetaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTarjetaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTarjetaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=TarjetaCreditoDataAccess.getEntityTarjetaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTarjetaCreditoOriginal( new TarjetaCredito());
					////entity.setTarjetaCreditoOriginal(super.getEntity("",entity.getTarjetaCreditoOriginal(),resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setTarjetaCreditoOriginal(this.getEntityTarjetaCredito("",entity.getTarjetaCreditoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTarjetaCredito(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TarjetaCredito getEntityTarjetaCredito(String strPrefijo,TarjetaCredito entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TarjetaCredito.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TarjetaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TarjetaCreditoDataAccess.setFieldReflectionTarjetaCredito(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTarjetaCredito=TarjetaCreditoConstantesFunciones.getTodosTiposColumnasTarjetaCredito();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTarjetaCredito) {
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
							field = TarjetaCredito.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TarjetaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TarjetaCreditoDataAccess.setFieldReflectionTarjetaCredito(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTarjetaCredito(Field field,String strPrefijo,String sColumn,TarjetaCredito entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TarjetaCreditoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.NOMBRECORTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.DIGITOVALIDO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.DIGITOTARJETA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.COMISION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.INTERES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.MONTOMINIMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.COMISIONRETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDTIPORETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDFORMULARETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConstantesFunciones.IDFORMULACOMISION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TarjetaCredito>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TarjetaCredito();
					entity=super.getEntity("",entity,resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTarjetaCredito("",entity,resultSet);
					
					//entity.setTarjetaCreditoOriginal( new TarjetaCredito());
					//entity.setTarjetaCreditoOriginal(super.getEntity("",entity.getTarjetaCreditoOriginal(),resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA));         		
					//entity.setTarjetaCreditoOriginal(this.getEntityTarjetaCredito("",entity.getTarjetaCreditoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTarjetaCreditos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TarjetaCredito>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TarjetaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TarjetaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
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
	
	public  List<TarjetaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCredito();
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTarjetaCredito("",entity,resultSet);
      	    	
				//entity.setTarjetaCreditoOriginal( new TarjetaCredito());
      	    	//entity.setTarjetaCreditoOriginal(super.getEntity("",entity.getTarjetaCreditoOriginal(),resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoOriginal(this.getEntityTarjetaCredito("",entity.getTarjetaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTarjetaCreditos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TarjetaCredito> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
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
	
	public  List<TarjetaCredito> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCredito> entities = new  ArrayList<TarjetaCredito>();
		TarjetaCredito entity = new TarjetaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCredito();
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTarjetaCredito("",entity,resultSet);
      	    	
				//entity.setTarjetaCreditoOriginal( new TarjetaCredito());
      	    	//entity.setTarjetaCreditoOriginal(super.getEntity("",entity.getTarjetaCreditoOriginal(),resultSet,TarjetaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoOriginal(this.getEntityTarjetaCredito("",entity.getTarjetaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TarjetaCredito getEntityTarjetaCredito(String strPrefijo,TarjetaCredito entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDSUCURSAL));
				entity.setid_banco(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDBANCO));
				entity.setcodigo(resultSet.getString(strPrefijo+TarjetaCreditoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TarjetaCreditoConstantesFunciones.NOMBRE));
				entity.setnombre_corto(resultSet.getString(strPrefijo+TarjetaCreditoConstantesFunciones.NOMBRECORTO));
				entity.setdigito_valido(resultSet.getInt(strPrefijo+TarjetaCreditoConstantesFunciones.DIGITOVALIDO));
				entity.setdigito_tarjeta(resultSet.getInt(strPrefijo+TarjetaCreditoConstantesFunciones.DIGITOTARJETA));
				entity.setcomision(resultSet.getDouble(strPrefijo+TarjetaCreditoConstantesFunciones.COMISION));
				entity.setinteres(resultSet.getDouble(strPrefijo+TarjetaCreditoConstantesFunciones.INTERES));
				entity.setmonto_minimo(resultSet.getDouble(strPrefijo+TarjetaCreditoConstantesFunciones.MONTOMINIMO));
				entity.setporcentaje_retencion(resultSet.getDouble(strPrefijo+TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION));
				entity.setcomision_retencion(resultSet.getDouble(strPrefijo+TarjetaCreditoConstantesFunciones.COMISIONRETENCION));
				entity.setes_retencion_redondeo(resultSet.getBoolean(strPrefijo+TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO));
				entity.setes_pago_banco_redondeo(resultSet.getBoolean(strPrefijo+TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO));
				entity.setes_comision_redondeo(resultSet.getBoolean(strPrefijo+TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO));
				entity.setid_tipo_retencion(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDTIPORETENCION));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_tipo_retencion_iva(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA));
				entity.setid_cuenta_contable_comision(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION));
				entity.setid_formula_pago_banco(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO));
				entity.setid_cuenta_contable_diferencia(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA));
				entity.setid_formula_retencion(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDFORMULARETENCION));
				entity.setid_formula_comision(resultSet.getLong(strPrefijo+TarjetaCreditoConstantesFunciones.IDFORMULACOMISION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TarjetaCreditoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTarjetaCredito(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TarjetaCredito entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TarjetaCreditoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TarjetaCreditoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TarjetaCreditoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TarjetaCreditoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TarjetaCreditoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TarjetaCreditoDataAccess.TABLENAME,TarjetaCreditoDataAccess.ISWITHSTOREPROCEDURES);
			
			TarjetaCreditoDataAccess.setTarjetaCreditoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltarjetacredito.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltarjetacredito.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Banco getBanco(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,reltarjetacredito.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public TipoRetencion getTipoRetencion(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,reltarjetacredito.getid_tipo_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public CuentaContable getCuentaContable(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltarjetacredito.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public TipoRetencionIva getTipoRetencionIva(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		TipoRetencionIva tiporetencioniva= new TipoRetencionIva();

		try {
			TipoRetencionIvaDataAccess tiporetencionivaDataAccess=new TipoRetencionIvaDataAccess();

			tiporetencionivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionivaDataAccess.setConnexionType(this.connexionType);
			tiporetencionivaDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion,reltarjetacredito.getid_tipo_retencion_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencioniva;

	}

	public CuentaContable getCuentaContableComision(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltarjetacredito.getid_cuenta_contable_comision());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Formula getFormulaPagoBanco(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		Formula formula= new Formula();

		try {
			FormulaDataAccess formulaDataAccess=new FormulaDataAccess();

			formulaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formulaDataAccess.setConnexionType(this.connexionType);
			formulaDataAccess.setParameterDbType(this.parameterDbType);

			formula=formulaDataAccess.getEntity(connexion,reltarjetacredito.getid_formula_pago_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formula;

	}

	public CuentaContable getCuentaContableDiferencia(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltarjetacredito.getid_cuenta_contable_diferencia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Formula getFormulaRetencion(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		Formula formula= new Formula();

		try {
			FormulaDataAccess formulaDataAccess=new FormulaDataAccess();

			formulaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formulaDataAccess.setConnexionType(this.connexionType);
			formulaDataAccess.setParameterDbType(this.parameterDbType);

			formula=formulaDataAccess.getEntity(connexion,reltarjetacredito.getid_formula_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formula;

	}

	public Formula getFormulaComision(Connexion connexion,TarjetaCredito reltarjetacredito)throws SQLException,Exception {

		Formula formula= new Formula();

		try {
			FormulaDataAccess formulaDataAccess=new FormulaDataAccess();

			formulaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formulaDataAccess.setConnexionType(this.connexionType);
			formulaDataAccess.setParameterDbType(this.parameterDbType);

			formula=formulaDataAccess.getEntity(connexion,reltarjetacredito.getid_formula_comision());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formula;

	}


		
		public List<TarjetaCreditoConexion> getTarjetaCreditoConexions(Connexion connexion,TarjetaCredito tarjetacredito)throws SQLException,Exception {

		List<TarjetaCreditoConexion> tarjetacreditoconexions= new ArrayList<TarjetaCreditoConexion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito ON "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+".tarjeta_credito_conexion.id_tarjeta_credito="+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito.id WHERE "+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito.id="+String.valueOf(tarjetacredito.getId());
			} else {
				sQuery=" INNER JOIN tarjetacreditoconexion.TarjetaCredito WHERE tarjetacreditoconexion.TarjetaCredito.id="+String.valueOf(tarjetacredito.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TarjetaCreditoConexionDataAccess tarjetacreditoconexionDataAccess=new TarjetaCreditoConexionDataAccess();

			tarjetacreditoconexionDataAccess.setConnexionType(this.connexionType);
			tarjetacreditoconexionDataAccess.setParameterDbType(this.parameterDbType);
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacreditoconexions;

	}

	public List<TarjetaCreditoDescuento> getTarjetaCreditoDescuentos(Connexion connexion,TarjetaCredito tarjetacredito)throws SQLException,Exception {

		List<TarjetaCreditoDescuento> tarjetacreditodescuentos= new ArrayList<TarjetaCreditoDescuento>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito ON "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+".tarjeta_credito_descuento.id_tarjeta_credito="+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito.id WHERE "+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito.id="+String.valueOf(tarjetacredito.getId());
			} else {
				sQuery=" INNER JOIN tarjetacreditodescuento.TarjetaCredito WHERE tarjetacreditodescuento.TarjetaCredito.id="+String.valueOf(tarjetacredito.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TarjetaCreditoDescuentoDataAccess tarjetacreditodescuentoDataAccess=new TarjetaCreditoDescuentoDataAccess();

			tarjetacreditodescuentoDataAccess.setConnexionType(this.connexionType);
			tarjetacreditodescuentoDataAccess.setParameterDbType(this.parameterDbType);
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacreditodescuentos;

	}

	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas(Connexion connexion,TarjetaCredito tarjetacredito)throws SQLException,Exception {

		List<FormaPagoPuntoVenta> formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito ON "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+".forma_pago_punto_venta.id_tarjeta_credito="+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito.id WHERE "+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito.id="+String.valueOf(tarjetacredito.getId());
			} else {
				sQuery=" INNER JOIN formapagopuntoventa.TarjetaCredito WHERE formapagopuntoventa.TarjetaCredito.id="+String.valueOf(tarjetacredito.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoPuntoVentaDataAccess formapagopuntoventaDataAccess=new FormaPagoPuntoVentaDataAccess();

			formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagopuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TarjetaCredito tarjetacredito) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tarjetacredito.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tarjetacredito.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(tarjetacredito.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(tarjetacredito.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tarjetacredito.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tarjetacredito.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_corto=new ParameterValue<String>();
					parameterMaintenanceValuenombre_corto.setValue(tarjetacredito.getnombre_corto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_corto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedigito_valido=new ParameterValue<Integer>();
					parameterMaintenanceValuedigito_valido.setValue(tarjetacredito.getdigito_valido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedigito_valido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedigito_tarjeta=new ParameterValue<Integer>();
					parameterMaintenanceValuedigito_tarjeta.setValue(tarjetacredito.getdigito_tarjeta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedigito_tarjeta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecomision=new ParameterValue<Double>();
					parameterMaintenanceValuecomision.setValue(tarjetacredito.getcomision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecomision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueinteres=new ParameterValue<Double>();
					parameterMaintenanceValueinteres.setValue(tarjetacredito.getinteres());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueinteres);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_minimo=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_minimo.setValue(tarjetacredito.getmonto_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_retencion=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_retencion.setValue(tarjetacredito.getporcentaje_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecomision_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuecomision_retencion.setValue(tarjetacredito.getcomision_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecomision_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_retencion_redondeo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_retencion_redondeo.setValue(tarjetacredito.getes_retencion_redondeo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_retencion_redondeo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_pago_banco_redondeo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_pago_banco_redondeo.setValue(tarjetacredito.getes_pago_banco_redondeo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_pago_banco_redondeo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_comision_redondeo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_comision_redondeo.setValue(tarjetacredito.getes_comision_redondeo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_comision_redondeo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion.setValue(tarjetacredito.getid_tipo_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(tarjetacredito.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva.setValue(tarjetacredito.getid_tipo_retencion_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_comision=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_comision.setValue(tarjetacredito.getid_cuenta_contable_comision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_comision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formula_pago_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_formula_pago_banco.setValue(tarjetacredito.getid_formula_pago_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formula_pago_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_diferencia=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_diferencia.setValue(tarjetacredito.getid_cuenta_contable_diferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_diferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formula_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_formula_retencion.setValue(tarjetacredito.getid_formula_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formula_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formula_comision=new ParameterValue<Long>();
					parameterMaintenanceValueid_formula_comision.setValue(tarjetacredito.getid_formula_comision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formula_comision);
					parametersTemp.add(parameterMaintenance);
					
						if(!tarjetacredito.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tarjetacredito.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tarjetacredito.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tarjetacredito.getId());
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
	
	public void setIsNewIsChangedFalseTarjetaCredito(TarjetaCredito tarjetacredito)throws Exception  {		
		tarjetacredito.setIsNew(false);
		tarjetacredito.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTarjetaCreditos(List<TarjetaCredito> tarjetacreditos)throws Exception  {				
		for(TarjetaCredito tarjetacredito:tarjetacreditos) {
			tarjetacredito.setIsNew(false);
			tarjetacredito.setIsChanged(false);
		}
	}
	
	public void generarExportarTarjetaCredito(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
