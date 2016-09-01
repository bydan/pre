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
import com.bydan.erp.cartera.util.*;//NegocioClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class NegocioClienteDataAccess extends  NegocioClienteDataAccessAdditional{ //NegocioClienteDataAccessAdditional,DataAccessHelper<NegocioCliente>
	//static Logger logger = Logger.getLogger(NegocioClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="negocio_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cliente,nombre_quien_se_factura,fax,ruc,telefono,nombre_local,e_mail,direccion,es_local_propio,numero_anios,numero_meses,id_tipo_ubicacion_negocio,empleados_fijos,empleado_temporales,empleados_total,porcentaje_ventas_contado,porcentaje_ventas_credito,plazo_dias,numero_clientes,monto_maximo_ventas_mensual,monto_minimo_ventas_mensual,es_enero_alto,es_febrero_alto,es_marzo_alto,es_abril_alto,es_mayo_alto,es_junio_alto,es_julio_alto,es_agosto_alto,es_septiembre_alto,es_octubre_alto,es_noviembre_alto,es_diciembre_alto,es_enero_bajo,es_febrero_bajo,es_marzo_bajo,es_abril_bajo,es_mayo_bajo,es_junio_bajo,es_julio_bajo,es_agosto_bajo,es_septiembre_bajo,es_octubre_bajo,es_noviembre_bajo,es_diciembre_bajo,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,nombre_quien_se_factura=?,fax=?,ruc=?,telefono=?,nombre_local=?,e_mail=?,direccion=?,es_local_propio=?,numero_anios=?,numero_meses=?,id_tipo_ubicacion_negocio=?,empleados_fijos=?,empleado_temporales=?,empleados_total=?,porcentaje_ventas_contado=?,porcentaje_ventas_credito=?,plazo_dias=?,numero_clientes=?,monto_maximo_ventas_mensual=?,monto_minimo_ventas_mensual=?,es_enero_alto=?,es_febrero_alto=?,es_marzo_alto=?,es_abril_alto=?,es_mayo_alto=?,es_junio_alto=?,es_julio_alto=?,es_agosto_alto=?,es_septiembre_alto=?,es_octubre_alto=?,es_noviembre_alto=?,es_diciembre_alto=?,es_enero_bajo=?,es_febrero_bajo=?,es_marzo_bajo=?,es_abril_bajo=?,es_mayo_bajo=?,es_junio_bajo=?,es_julio_bajo=?,es_agosto_bajo=?,es_septiembre_bajo=?,es_octubre_bajo=?,es_noviembre_bajo=?,es_diciembre_bajo=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select negociocliente from "+NegocioClienteConstantesFunciones.SPERSISTENCENAME+" negociocliente";
	public static String QUERYSELECTNATIVE="select "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".id,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".version_row,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".id_empresa,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".id_cliente,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".nombre_quien_se_factura,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".fax,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".ruc,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".telefono,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".nombre_local,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".e_mail,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".direccion,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_local_propio,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".numero_anios,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".numero_meses,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".id_tipo_ubicacion_negocio,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".empleados_fijos,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".empleado_temporales,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".empleados_total,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".porcentaje_ventas_contado,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".porcentaje_ventas_credito,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".plazo_dias,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".numero_clientes,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".monto_maximo_ventas_mensual,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".monto_minimo_ventas_mensual,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_enero_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_febrero_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_marzo_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_abril_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_mayo_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_junio_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_julio_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_agosto_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_septiembre_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_octubre_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_noviembre_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_diciembre_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_enero_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_febrero_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_marzo_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_abril_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_mayo_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_junio_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_julio_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_agosto_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_septiembre_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_octubre_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_noviembre_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_diciembre_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".descripcion from "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME;//+" as "+NegocioClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".id,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".version_row,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".nombre_quien_se_factura from "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME;//+" as "+NegocioClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,nombre_quien_se_factura=?,fax=?,ruc=?,telefono=?,nombre_local=?,e_mail=?,direccion=?,es_local_propio=?,numero_anios=?,numero_meses=?,id_tipo_ubicacion_negocio=?,empleados_fijos=?,empleado_temporales=?,empleados_total=?,porcentaje_ventas_contado=?,porcentaje_ventas_credito=?,plazo_dias=?,numero_clientes=?,monto_maximo_ventas_mensual=?,monto_minimo_ventas_mensual=?,es_enero_alto=?,es_febrero_alto=?,es_marzo_alto=?,es_abril_alto=?,es_mayo_alto=?,es_junio_alto=?,es_julio_alto=?,es_agosto_alto=?,es_septiembre_alto=?,es_octubre_alto=?,es_noviembre_alto=?,es_diciembre_alto=?,es_enero_bajo=?,es_febrero_bajo=?,es_marzo_bajo=?,es_abril_bajo=?,es_mayo_bajo=?,es_junio_bajo=?,es_julio_bajo=?,es_agosto_bajo=?,es_septiembre_bajo=?,es_octubre_bajo=?,es_noviembre_bajo=?,es_diciembre_bajo=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NEGOCIOCLIENTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NEGOCIOCLIENTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NEGOCIOCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NEGOCIOCLIENTE_SELECT(?,?)";
	
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
	
	
	protected NegocioClienteDataAccessAdditional negocioclienteDataAccessAdditional=null;
	
	public NegocioClienteDataAccessAdditional getNegocioClienteDataAccessAdditional() {
		return this.negocioclienteDataAccessAdditional;
	}
	
	public void setNegocioClienteDataAccessAdditional(NegocioClienteDataAccessAdditional negocioclienteDataAccessAdditional) {
		try {
			this.negocioclienteDataAccessAdditional=negocioclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NegocioClienteDataAccess() {
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
		NegocioClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NegocioClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NegocioClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNegocioClienteOriginal(NegocioCliente negociocliente)throws Exception  {
		negociocliente.setNegocioClienteOriginal((NegocioCliente)negociocliente.clone());		
	}
	
	public void setNegocioClientesOriginal(List<NegocioCliente> negocioclientes)throws Exception  {
		
		for(NegocioCliente negociocliente:negocioclientes){
			negociocliente.setNegocioClienteOriginal((NegocioCliente)negociocliente.clone());
		}
	}
	
	public static void setNegocioClienteOriginalStatic(NegocioCliente negociocliente)throws Exception  {
		negociocliente.setNegocioClienteOriginal((NegocioCliente)negociocliente.clone());		
	}
	
	public static void setNegocioClientesOriginalStatic(List<NegocioCliente> negocioclientes)throws Exception  {
		
		for(NegocioCliente negociocliente:negocioclientes){
			negociocliente.setNegocioClienteOriginal((NegocioCliente)negociocliente.clone());
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
	
	public  NegocioCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NegocioCliente entity = new NegocioCliente();		
		
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
	
	public  NegocioCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NegocioCliente entity = new NegocioCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.NegocioCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNegocioClienteOriginal(new NegocioCliente());
      	    	entity=super.getEntity("",entity,resultSet,NegocioClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNegocioCliente("",entity,resultSet); 
				
				//entity.setNegocioClienteOriginal(super.getEntity("",entity.getNegocioClienteOriginal(),resultSet,NegocioClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNegocioClienteOriginal(this.getEntityNegocioCliente("",entity.getNegocioClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNegocioCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NegocioCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NegocioCliente entity = new NegocioCliente();
				
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
	
	public  NegocioCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NegocioCliente entity = new NegocioCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NegocioClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.NegocioCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNegocioClienteOriginal(new NegocioCliente());
      	    	entity=super.getEntity("",entity,resultSet,NegocioClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNegocioCliente("",entity,resultSet);    
				
				//entity.setNegocioClienteOriginal(super.getEntity("",entity.getNegocioClienteOriginal(),resultSet,NegocioClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNegocioClienteOriginal(this.getEntityNegocioCliente("",entity.getNegocioClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNegocioCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NegocioCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NegocioCliente entity = new NegocioCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NegocioClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.NegocioCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNegocioCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NegocioCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
		
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
	
	public  List<NegocioCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NegocioClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NegocioCliente();
      	    	entity=super.getEntity("",entity,resultSet,NegocioClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNegocioCliente("",entity,resultSet);
      	    	
				//entity.setNegocioClienteOriginal( new NegocioCliente());
      	    	//entity.setNegocioClienteOriginal(super.getEntity("",entity.getNegocioClienteOriginal(),resultSet,NegocioClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNegocioClienteOriginal(this.getEntityNegocioCliente("",entity.getNegocioClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNegocioClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNegocioCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NegocioCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
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
	
	public  List<NegocioCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NegocioCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapNegocioCliente();
					//entity.setMapNegocioCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNegocioClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNegocioCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NegocioClienteDataAccess.ISWITHSCHEMA);         		
					entity=NegocioClienteDataAccess.getEntityNegocioCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNegocioClienteOriginal( new NegocioCliente());
					////entity.setNegocioClienteOriginal(super.getEntity("",entity.getNegocioClienteOriginal(),resultSet,NegocioClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setNegocioClienteOriginal(this.getEntityNegocioCliente("",entity.getNegocioClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNegocioClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNegocioCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NegocioCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NegocioCliente entity = new NegocioCliente();		  
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
	
	public  NegocioCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NegocioCliente entity = new NegocioCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NegocioCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapNegocioCliente();
					//entity.setMapNegocioCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNegocioClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNegocioCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NegocioClienteDataAccess.ISWITHSCHEMA);         		
					entity=NegocioClienteDataAccess.getEntityNegocioCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNegocioClienteOriginal( new NegocioCliente());
					////entity.setNegocioClienteOriginal(super.getEntity("",entity.getNegocioClienteOriginal(),resultSet,NegocioClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setNegocioClienteOriginal(this.getEntityNegocioCliente("",entity.getNegocioClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNegocioCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNegocioCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NegocioCliente getEntityNegocioCliente(String strPrefijo,NegocioCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NegocioCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NegocioCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NegocioClienteDataAccess.setFieldReflectionNegocioCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNegocioCliente=NegocioClienteConstantesFunciones.getTodosTiposColumnasNegocioCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNegocioCliente) {
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
							field = NegocioCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NegocioCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NegocioClienteDataAccess.setFieldReflectionNegocioCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNegocioCliente(Field field,String strPrefijo,String sColumn,NegocioCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NegocioClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.FAX:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.NOMBRELOCAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.EMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESLOCALPROPIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.NUMEROANIOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.NUMEROMESES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.EMPLEADOSFIJOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.EMPLEADOSTOTAL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.PLAZODIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.NUMEROCLIENTES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESENEROALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESFEBREROALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESMARZOALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESABRILALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESMAYOALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESJUNIOALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESJULIOALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESAGOSTOALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESOCTUBREALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESNOVIEMBREALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESDICIEMBREALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESENEROBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESFEBREROBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESMARZOBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESABRILBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESMAYOBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESJUNIOBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESJULIOBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESAGOSTOBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESOCTUBREBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.ESDICIEMBREBAJO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NegocioClienteConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NegocioCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NegocioClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NegocioCliente();
					entity=super.getEntity("",entity,resultSet,NegocioClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNegocioCliente("",entity,resultSet);
					
					//entity.setNegocioClienteOriginal( new NegocioCliente());
					//entity.setNegocioClienteOriginal(super.getEntity("",entity.getNegocioClienteOriginal(),resultSet,NegocioClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setNegocioClienteOriginal(this.getEntityNegocioCliente("",entity.getNegocioClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNegocioClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNegocioCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NegocioCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NegocioClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NegocioClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NegocioCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
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
	
	public  List<NegocioCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NegocioCliente();
      	    	entity=super.getEntity("",entity,resultSet,NegocioClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNegocioCliente("",entity,resultSet);
      	    	
				//entity.setNegocioClienteOriginal( new NegocioCliente());
      	    	//entity.setNegocioClienteOriginal(super.getEntity("",entity.getNegocioClienteOriginal(),resultSet,NegocioClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNegocioClienteOriginal(this.getEntityNegocioCliente("",entity.getNegocioClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNegocioClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNegocioCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NegocioCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
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
	
	public  List<NegocioCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NegocioCliente> entities = new  ArrayList<NegocioCliente>();
		NegocioCliente entity = new NegocioCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NegocioCliente();
      	    	entity=super.getEntity("",entity,resultSet,NegocioClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNegocioCliente("",entity,resultSet);
      	    	
				//entity.setNegocioClienteOriginal( new NegocioCliente());
      	    	//entity.setNegocioClienteOriginal(super.getEntity("",entity.getNegocioClienteOriginal(),resultSet,NegocioClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNegocioClienteOriginal(this.getEntityNegocioCliente("",entity.getNegocioClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNegocioClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NegocioCliente getEntityNegocioCliente(String strPrefijo,NegocioCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NegocioClienteConstantesFunciones.IDEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+NegocioClienteConstantesFunciones.IDCLIENTE));
				entity.setnombre_quien_se_factura(resultSet.getString(strPrefijo+NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA));
				entity.setfax(resultSet.getString(strPrefijo+NegocioClienteConstantesFunciones.FAX));
				entity.setruc(resultSet.getString(strPrefijo+NegocioClienteConstantesFunciones.RUC));
				entity.settelefono(resultSet.getString(strPrefijo+NegocioClienteConstantesFunciones.TELEFONO));
				entity.setnombre_local(resultSet.getString(strPrefijo+NegocioClienteConstantesFunciones.NOMBRELOCAL));
				entity.sete_mail(resultSet.getString(strPrefijo+NegocioClienteConstantesFunciones.EMAIL));
				entity.setdireccion(resultSet.getString(strPrefijo+NegocioClienteConstantesFunciones.DIRECCION));
				entity.setes_local_propio(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESLOCALPROPIO));
				entity.setnumero_anios(resultSet.getInt(strPrefijo+NegocioClienteConstantesFunciones.NUMEROANIOS));
				entity.setnumero_meses(resultSet.getInt(strPrefijo+NegocioClienteConstantesFunciones.NUMEROMESES));
				entity.setid_tipo_ubicacion_negocio(resultSet.getLong(strPrefijo+NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO));
				entity.setempleados_fijos(resultSet.getInt(strPrefijo+NegocioClienteConstantesFunciones.EMPLEADOSFIJOS));
				entity.setempleado_temporales(resultSet.getInt(strPrefijo+NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES));
				entity.setempleados_total(resultSet.getInt(strPrefijo+NegocioClienteConstantesFunciones.EMPLEADOSTOTAL));
				entity.setporcentaje_ventas_contado(resultSet.getDouble(strPrefijo+NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO));
				entity.setporcentaje_ventas_credito(resultSet.getDouble(strPrefijo+NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO));
				entity.setplazo_dias(resultSet.getInt(strPrefijo+NegocioClienteConstantesFunciones.PLAZODIAS));
				entity.setnumero_clientes(resultSet.getInt(strPrefijo+NegocioClienteConstantesFunciones.NUMEROCLIENTES));
				entity.setmonto_maximo_ventas_mensual(resultSet.getDouble(strPrefijo+NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL));
				entity.setmonto_minimo_ventas_mensual(resultSet.getDouble(strPrefijo+NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL));
				entity.setes_enero_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESENEROALTO));
				entity.setes_febrero_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESFEBREROALTO));
				entity.setes_marzo_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESMARZOALTO));
				entity.setes_abril_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESABRILALTO));
				entity.setes_mayo_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESMAYOALTO));
				entity.setes_junio_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESJUNIOALTO));
				entity.setes_julio_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESJULIOALTO));
				entity.setes_agosto_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESAGOSTOALTO));
				entity.setes_septiembre_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO));
				entity.setes_octubre_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESOCTUBREALTO));
				entity.setes_noviembre_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESNOVIEMBREALTO));
				entity.setes_diciembre_alto(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESDICIEMBREALTO));
				entity.setes_enero_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESENEROBAJO));
				entity.setes_febrero_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESFEBREROBAJO));
				entity.setes_marzo_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESMARZOBAJO));
				entity.setes_abril_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESABRILBAJO));
				entity.setes_mayo_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESMAYOBAJO));
				entity.setes_junio_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESJUNIOBAJO));
				entity.setes_julio_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESJULIOBAJO));
				entity.setes_agosto_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESAGOSTOBAJO));
				entity.setes_septiembre_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO));
				entity.setes_octubre_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESOCTUBREBAJO));
				entity.setes_noviembre_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO));
				entity.setes_diciembre_bajo(resultSet.getBoolean(strPrefijo+NegocioClienteConstantesFunciones.ESDICIEMBREBAJO));
				entity.setdescripcion(resultSet.getString(strPrefijo+NegocioClienteConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre_quien_se_factura(resultSet.getString(strPrefijo+NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNegocioCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NegocioCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NegocioClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NegocioClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NegocioClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NegocioClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NegocioClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NegocioClienteDataAccess.TABLENAME,NegocioClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			NegocioClienteDataAccess.setNegocioClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NegocioCliente relnegociocliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnegociocliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,NegocioCliente relnegociocliente)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relnegociocliente.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoUbicacionNegocio getTipoUbicacionNegocio(Connexion connexion,NegocioCliente relnegociocliente)throws SQLException,Exception {

		TipoUbicacionNegocio tipoubicacionnegocio= new TipoUbicacionNegocio();

		try {
			TipoUbicacionNegocioDataAccess tipoubicacionnegocioDataAccess=new TipoUbicacionNegocioDataAccess();

			tipoubicacionnegocioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoubicacionnegocioDataAccess.setConnexionType(this.connexionType);
			tipoubicacionnegocioDataAccess.setParameterDbType(this.parameterDbType);

			tipoubicacionnegocio=tipoubicacionnegocioDataAccess.getEntity(connexion,relnegociocliente.getid_tipo_ubicacion_negocio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoubicacionnegocio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NegocioCliente negociocliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!negociocliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(negociocliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(negociocliente.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_quien_se_factura=new ParameterValue<String>();
					parameterMaintenanceValuenombre_quien_se_factura.setValue(negociocliente.getnombre_quien_se_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_quien_se_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuefax=new ParameterValue<String>();
					parameterMaintenanceValuefax.setValue(negociocliente.getfax());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefax);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(negociocliente.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(negociocliente.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_local=new ParameterValue<String>();
					parameterMaintenanceValuenombre_local.setValue(negociocliente.getnombre_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuee_mail=new ParameterValue<String>();
					parameterMaintenanceValuee_mail.setValue(negociocliente.gete_mail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuee_mail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(negociocliente.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_local_propio=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_local_propio.setValue(negociocliente.getes_local_propio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_local_propio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_anios=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_anios.setValue(negociocliente.getnumero_anios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_anios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_meses=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_meses.setValue(negociocliente.getnumero_meses());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_meses);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_ubicacion_negocio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_ubicacion_negocio.setValue(negociocliente.getid_tipo_ubicacion_negocio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_ubicacion_negocio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueempleados_fijos=new ParameterValue<Integer>();
					parameterMaintenanceValueempleados_fijos.setValue(negociocliente.getempleados_fijos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueempleados_fijos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueempleado_temporales=new ParameterValue<Integer>();
					parameterMaintenanceValueempleado_temporales.setValue(negociocliente.getempleado_temporales());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueempleado_temporales);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueempleados_total=new ParameterValue<Integer>();
					parameterMaintenanceValueempleados_total.setValue(negociocliente.getempleados_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueempleados_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_ventas_contado=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_ventas_contado.setValue(negociocliente.getporcentaje_ventas_contado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_ventas_contado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_ventas_credito=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_ventas_credito.setValue(negociocliente.getporcentaje_ventas_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_ventas_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueplazo_dias=new ParameterValue<Integer>();
					parameterMaintenanceValueplazo_dias.setValue(negociocliente.getplazo_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueplazo_dias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_clientes=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_clientes.setValue(negociocliente.getnumero_clientes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_clientes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_maximo_ventas_mensual=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_maximo_ventas_mensual.setValue(negociocliente.getmonto_maximo_ventas_mensual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_maximo_ventas_mensual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_minimo_ventas_mensual=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_minimo_ventas_mensual.setValue(negociocliente.getmonto_minimo_ventas_mensual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_minimo_ventas_mensual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_enero_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_enero_alto.setValue(negociocliente.getes_enero_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_enero_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_febrero_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_febrero_alto.setValue(negociocliente.getes_febrero_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_febrero_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_marzo_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_marzo_alto.setValue(negociocliente.getes_marzo_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_marzo_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_abril_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_abril_alto.setValue(negociocliente.getes_abril_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_abril_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_mayo_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_mayo_alto.setValue(negociocliente.getes_mayo_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_mayo_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_junio_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_junio_alto.setValue(negociocliente.getes_junio_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_junio_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_julio_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_julio_alto.setValue(negociocliente.getes_julio_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_julio_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_agosto_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_agosto_alto.setValue(negociocliente.getes_agosto_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_agosto_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_septiembre_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_septiembre_alto.setValue(negociocliente.getes_septiembre_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_septiembre_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_octubre_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_octubre_alto.setValue(negociocliente.getes_octubre_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_octubre_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_noviembre_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_noviembre_alto.setValue(negociocliente.getes_noviembre_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_noviembre_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_diciembre_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_diciembre_alto.setValue(negociocliente.getes_diciembre_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_diciembre_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_enero_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_enero_bajo.setValue(negociocliente.getes_enero_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_enero_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_febrero_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_febrero_bajo.setValue(negociocliente.getes_febrero_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_febrero_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_marzo_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_marzo_bajo.setValue(negociocliente.getes_marzo_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_marzo_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_abril_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_abril_bajo.setValue(negociocliente.getes_abril_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_abril_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_mayo_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_mayo_bajo.setValue(negociocliente.getes_mayo_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_mayo_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_junio_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_junio_bajo.setValue(negociocliente.getes_junio_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_junio_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_julio_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_julio_bajo.setValue(negociocliente.getes_julio_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_julio_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_agosto_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_agosto_bajo.setValue(negociocliente.getes_agosto_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_agosto_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_septiembre_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_septiembre_bajo.setValue(negociocliente.getes_septiembre_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_septiembre_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_octubre_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_octubre_bajo.setValue(negociocliente.getes_octubre_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_octubre_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_noviembre_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_noviembre_bajo.setValue(negociocliente.getes_noviembre_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_noviembre_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_diciembre_bajo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_diciembre_bajo.setValue(negociocliente.getes_diciembre_bajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_diciembre_bajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(negociocliente.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!negociocliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(negociocliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(negociocliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(negociocliente.getId());
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
	
	public void setIsNewIsChangedFalseNegocioCliente(NegocioCliente negociocliente)throws Exception  {		
		negociocliente.setIsNew(false);
		negociocliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNegocioClientes(List<NegocioCliente> negocioclientes)throws Exception  {				
		for(NegocioCliente negociocliente:negocioclientes) {
			negociocliente.setIsNew(false);
			negociocliente.setIsChanged(false);
		}
	}
	
	public void generarExportarNegocioCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
