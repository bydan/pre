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
import com.bydan.erp.facturacion.util.*;//GuiaRemisionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class GuiaRemisionDataAccess extends  GuiaRemisionDataAccessAdditional{ //GuiaRemisionDataAccessAdditional,DataAccessHelper<GuiaRemision>
	//static Logger logger = Logger.getLogger(GuiaRemisionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="guia_remision";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_usuario,secuencial,fecha_emision,id_formato,id_tipo_precio,id_moneda,numero_camion,id_cliente,id_vendedor,id_factura,id_transportista,identificacion,fecha_origen,fecha_destino,transporte_codigo,cantidad_bultos,id_consultor,id_transporte,id_sub_cliente,id_empleado,id_ciudad_origen,id_ciudad_destino,id_tipo_llamada,hora_inicio,hora_fin,cupo,saldo,documento,disponible,descripcion,total_iva,total_sin_iva,descuento,flete,otro,financiamiento,iva,total,monto_retencion,id_tipo_cambio,fecha,ruc_cliente,nombre_cliente,telefono_cliente,direccion_cliente,numero_pre_impreso,peso_bruto,fecha_autorizacion,fecha_vencimiento)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_usuario=?,secuencial=?,fecha_emision=?,id_formato=?,id_tipo_precio=?,id_moneda=?,numero_camion=?,id_cliente=?,id_vendedor=?,id_factura=?,id_transportista=?,identificacion=?,fecha_origen=?,fecha_destino=?,transporte_codigo=?,cantidad_bultos=?,id_consultor=?,id_transporte=?,id_sub_cliente=?,id_empleado=?,id_ciudad_origen=?,id_ciudad_destino=?,id_tipo_llamada=?,hora_inicio=?,hora_fin=?,cupo=?,saldo=?,documento=?,disponible=?,descripcion=?,total_iva=?,total_sin_iva=?,descuento=?,flete=?,otro=?,financiamiento=?,iva=?,total=?,monto_retencion=?,id_tipo_cambio=?,fecha=?,ruc_cliente=?,nombre_cliente=?,telefono_cliente=?,direccion_cliente=?,numero_pre_impreso=?,peso_bruto=?,fecha_autorizacion=?,fecha_vencimiento=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select guiaremision from "+GuiaRemisionConstantesFunciones.SPERSISTENCENAME+" guiaremision";
	public static String QUERYSELECTNATIVE="select "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".version_row,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_empresa,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_sucursal,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_ejercicio,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_periodo,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_usuario,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".secuencial,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_emision,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_formato,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_tipo_precio,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_moneda,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".numero_camion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_vendedor,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_factura,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_transportista,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".identificacion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_origen,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_destino,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".transporte_codigo,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".cantidad_bultos,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_consultor,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_transporte,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_sub_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_empleado,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_ciudad_origen,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_ciudad_destino,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_tipo_llamada,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".hora_inicio,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".hora_fin,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".cupo,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".saldo,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".documento,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".disponible,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".descripcion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".total_iva,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".total_sin_iva,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".descuento,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".flete,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".otro,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".financiamiento,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".iva,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".total,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".monto_retencion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_tipo_cambio,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".ruc_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".nombre_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".telefono_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".direccion_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".numero_pre_impreso,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".peso_bruto,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_autorizacion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_vencimiento from "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME;//+" as "+GuiaRemisionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".version_row from "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME;//+" as "+GuiaRemisionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_usuario=?,secuencial=?,fecha_emision=?,id_formato=?,id_tipo_precio=?,id_moneda=?,numero_camion=?,id_cliente=?,id_vendedor=?,id_factura=?,id_transportista=?,identificacion=?,fecha_origen=?,fecha_destino=?,transporte_codigo=?,cantidad_bultos=?,id_consultor=?,id_transporte=?,id_sub_cliente=?,id_empleado=?,id_ciudad_origen=?,id_ciudad_destino=?,id_tipo_llamada=?,hora_inicio=?,hora_fin=?,cupo=?,saldo=?,documento=?,disponible=?,descripcion=?,total_iva=?,total_sin_iva=?,descuento=?,flete=?,otro=?,financiamiento=?,iva=?,total=?,monto_retencion=?,id_tipo_cambio=?,fecha=?,ruc_cliente=?,nombre_cliente=?,telefono_cliente=?,direccion_cliente=?,numero_pre_impreso=?,peso_bruto=?,fecha_autorizacion=?,fecha_vencimiento=?";
	
	public static String STOREPROCEDUREINSERT="call SP_GUIAREMISION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_GUIAREMISION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_GUIAREMISION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_GUIAREMISION_SELECT(?,?)";
	
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
	
	
	protected GuiaRemisionDataAccessAdditional guiaremisionDataAccessAdditional=null;
	
	public GuiaRemisionDataAccessAdditional getGuiaRemisionDataAccessAdditional() {
		return this.guiaremisionDataAccessAdditional;
	}
	
	public void setGuiaRemisionDataAccessAdditional(GuiaRemisionDataAccessAdditional guiaremisionDataAccessAdditional) {
		try {
			this.guiaremisionDataAccessAdditional=guiaremisionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public GuiaRemisionDataAccess() {
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
		GuiaRemisionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		GuiaRemisionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		GuiaRemisionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setGuiaRemisionOriginal(GuiaRemision guiaremision)throws Exception  {
		guiaremision.setGuiaRemisionOriginal((GuiaRemision)guiaremision.clone());		
	}
	
	public void setGuiaRemisionsOriginal(List<GuiaRemision> guiaremisions)throws Exception  {
		
		for(GuiaRemision guiaremision:guiaremisions){
			guiaremision.setGuiaRemisionOriginal((GuiaRemision)guiaremision.clone());
		}
	}
	
	public static void setGuiaRemisionOriginalStatic(GuiaRemision guiaremision)throws Exception  {
		guiaremision.setGuiaRemisionOriginal((GuiaRemision)guiaremision.clone());		
	}
	
	public static void setGuiaRemisionsOriginalStatic(List<GuiaRemision> guiaremisions)throws Exception  {
		
		for(GuiaRemision guiaremision:guiaremisions){
			guiaremision.setGuiaRemisionOriginal((GuiaRemision)guiaremision.clone());
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
	
	public  GuiaRemision getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		GuiaRemision entity = new GuiaRemision();		
		
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
	
	public  GuiaRemision getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		GuiaRemision entity = new GuiaRemision();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.GuiaRemision.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setGuiaRemisionOriginal(new GuiaRemision());
      	    	entity=super.getEntity("",entity,resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGuiaRemision("",entity,resultSet); 
				
				//entity.setGuiaRemisionOriginal(super.getEntity("",entity.getGuiaRemisionOriginal(),resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGuiaRemisionOriginal(this.getEntityGuiaRemision("",entity.getGuiaRemisionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseGuiaRemision(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  GuiaRemision getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GuiaRemision entity = new GuiaRemision();
				
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
	
	public  GuiaRemision getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GuiaRemision entity = new GuiaRemision();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.GuiaRemision.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setGuiaRemisionOriginal(new GuiaRemision());
      	    	entity=super.getEntity("",entity,resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGuiaRemision("",entity,resultSet);    
				
				//entity.setGuiaRemisionOriginal(super.getEntity("",entity.getGuiaRemisionOriginal(),resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGuiaRemisionOriginal(this.getEntityGuiaRemision("",entity.getGuiaRemisionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseGuiaRemision(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //GuiaRemision
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		GuiaRemision entity = new GuiaRemision();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.GuiaRemision.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseGuiaRemision(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<GuiaRemision> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
		
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
	
	public  List<GuiaRemision> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GuiaRemision();
      	    	entity=super.getEntity("",entity,resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGuiaRemision("",entity,resultSet);
      	    	
				//entity.setGuiaRemisionOriginal( new GuiaRemision());
      	    	//entity.setGuiaRemisionOriginal(super.getEntity("",entity.getGuiaRemisionOriginal(),resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGuiaRemisionOriginal(this.getEntityGuiaRemision("",entity.getGuiaRemisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGuiaRemisions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GuiaRemision> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
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
	
	public  List<GuiaRemision> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GuiaRemision();
				
				if(conMapGenerico) {
					entity.inicializarMapGuiaRemision();
					//entity.setMapGuiaRemision(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapGuiaRemisionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGuiaRemision().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA);         		
					entity=GuiaRemisionDataAccess.getEntityGuiaRemision("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGuiaRemisionOriginal( new GuiaRemision());
					////entity.setGuiaRemisionOriginal(super.getEntity("",entity.getGuiaRemisionOriginal(),resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA));         		
					////entity.setGuiaRemisionOriginal(this.getEntityGuiaRemision("",entity.getGuiaRemisionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGuiaRemisions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public GuiaRemision getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GuiaRemision entity = new GuiaRemision();		  
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
	
	public  GuiaRemision getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GuiaRemision entity = new GuiaRemision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GuiaRemision();
				
				if(conMapGenerico) {
					entity.inicializarMapGuiaRemision();
					//entity.setMapGuiaRemision(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapGuiaRemisionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGuiaRemision().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA);         		
					entity=GuiaRemisionDataAccess.getEntityGuiaRemision("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGuiaRemisionOriginal( new GuiaRemision());
					////entity.setGuiaRemisionOriginal(super.getEntity("",entity.getGuiaRemisionOriginal(),resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA));         		
					////entity.setGuiaRemisionOriginal(this.getEntityGuiaRemision("",entity.getGuiaRemisionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseGuiaRemision(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static GuiaRemision getEntityGuiaRemision(String strPrefijo,GuiaRemision entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = GuiaRemision.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = GuiaRemision.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					GuiaRemisionDataAccess.setFieldReflectionGuiaRemision(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasGuiaRemision=GuiaRemisionConstantesFunciones.getTodosTiposColumnasGuiaRemision();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasGuiaRemision) {
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
							field = GuiaRemision.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = GuiaRemision.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						GuiaRemisionDataAccess.setFieldReflectionGuiaRemision(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionGuiaRemision(Field field,String strPrefijo,String sColumn,GuiaRemision entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case GuiaRemisionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case GuiaRemisionConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.NUMEROCAMION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDENTIFICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.FECHAORIGEN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case GuiaRemisionConstantesFunciones.FECHADESTINO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case GuiaRemisionConstantesFunciones.TRANSPORTECODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.CANTIDADBULTOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDCONSULTOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDTRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDSUBCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDCIUDADORIGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDCIUDADDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDTIPOLLAMADA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.HORAINICIO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.HORAFIN:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.CUPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.SALDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.DOCUMENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.DISPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.OTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.MONTORETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case GuiaRemisionConstantesFunciones.RUCCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.TELEFONOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.PESOBRUTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuiaRemisionConstantesFunciones.FECHAAUTORIZACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GuiaRemision>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new GuiaRemision();
					entity=super.getEntity("",entity,resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityGuiaRemision("",entity,resultSet);
					
					//entity.setGuiaRemisionOriginal( new GuiaRemision());
					//entity.setGuiaRemisionOriginal(super.getEntity("",entity.getGuiaRemisionOriginal(),resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA));         		
					//entity.setGuiaRemisionOriginal(this.getEntityGuiaRemision("",entity.getGuiaRemisionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseGuiaRemisions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GuiaRemision>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<GuiaRemision> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
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
	
	public  List<GuiaRemision> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GuiaRemision();
      	    	entity=super.getEntity("",entity,resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGuiaRemision("",entity,resultSet);
      	    	
				//entity.setGuiaRemisionOriginal( new GuiaRemision());
      	    	//entity.setGuiaRemisionOriginal(super.getEntity("",entity.getGuiaRemisionOriginal(),resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGuiaRemisionOriginal(this.getEntityGuiaRemision("",entity.getGuiaRemisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseGuiaRemisions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GuiaRemision> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
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
	
	public  List<GuiaRemision> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GuiaRemision> entities = new  ArrayList<GuiaRemision>();
		GuiaRemision entity = new GuiaRemision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GuiaRemision();
      	    	entity=super.getEntity("",entity,resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGuiaRemision("",entity,resultSet);
      	    	
				//entity.setGuiaRemisionOriginal( new GuiaRemision());
      	    	//entity.setGuiaRemisionOriginal(super.getEntity("",entity.getGuiaRemisionOriginal(),resultSet,GuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGuiaRemisionOriginal(this.getEntityGuiaRemision("",entity.getGuiaRemisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGuiaRemisions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public GuiaRemision getEntityGuiaRemision(String strPrefijo,GuiaRemision entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDPERIODO));
				entity.setid_usuario(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDUSUARIO));
				entity.setsecuencial(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.SECUENCIAL));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+GuiaRemisionConstantesFunciones.FECHAEMISION).getTime()));
				entity.setid_formato(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDTIPOPRECIO));
				entity.setid_moneda(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDMONEDA));
				entity.setnumero_camion(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.NUMEROCAMION));
				entity.setid_cliente(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDCLIENTE));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDVENDEDOR));if(resultSet.wasNull()) {entity.setid_vendedor(null); }
				entity.setid_factura(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDFACTURA));if(resultSet.wasNull()) {entity.setid_factura(null); }
				entity.setid_transportista(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDTRANSPORTISTA));if(resultSet.wasNull()) {entity.setid_transportista(null); }
				entity.setidentificacion(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.IDENTIFICACION));
				entity.setfecha_origen(new Date(resultSet.getDate(strPrefijo+GuiaRemisionConstantesFunciones.FECHAORIGEN).getTime()));
				entity.setfecha_destino(new Date(resultSet.getDate(strPrefijo+GuiaRemisionConstantesFunciones.FECHADESTINO).getTime()));
				entity.settransporte_codigo(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.TRANSPORTECODIGO));
				entity.setcantidad_bultos(resultSet.getInt(strPrefijo+GuiaRemisionConstantesFunciones.CANTIDADBULTOS));
				entity.setid_consultor(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDCONSULTOR));
				entity.setid_transporte(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDTRANSPORTE));
				entity.setid_sub_cliente(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDSUBCLIENTE));
				entity.setid_empleado(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDEMPLEADO));
				entity.setid_ciudad_origen(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDCIUDADORIGEN));if(resultSet.wasNull()) {entity.setid_ciudad_origen(null); }
				entity.setid_ciudad_destino(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDCIUDADDESTINO));if(resultSet.wasNull()) {entity.setid_ciudad_destino(null); }
				entity.setid_tipo_llamada(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDTIPOLLAMADA));
				entity.sethora_inicio(resultSet.getTime(strPrefijo+GuiaRemisionConstantesFunciones.HORAINICIO));
				entity.sethora_fin(resultSet.getTime(strPrefijo+GuiaRemisionConstantesFunciones.HORAFIN));
				entity.setcupo(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.CUPO));
				entity.setsaldo(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.SALDO));
				entity.setdocumento(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.DOCUMENTO));
				entity.setdisponible(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.DISPONIBLE));
				entity.setdescripcion(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.DESCRIPCION));
				entity.settotal_iva(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.TOTALIVA));
				entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.TOTALSINIVA));
				entity.setdescuento(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.DESCUENTO));
				entity.setflete(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.FLETE));
				entity.setotro(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.OTRO));
				entity.setfinanciamiento(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.FINANCIAMIENTO));
				entity.setiva(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.IVA));
				entity.settotal(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.TOTAL));
				entity.setmonto_retencion(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.MONTORETENCION));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+GuiaRemisionConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+GuiaRemisionConstantesFunciones.FECHA).getTime()));
				entity.setruc_cliente(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.RUCCLIENTE));
				entity.setnombre_cliente(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.NOMBRECLIENTE));
				entity.settelefono_cliente(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.TELEFONOCLIENTE));
				entity.setdireccion_cliente(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE));
				entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO));
				entity.setpeso_bruto(resultSet.getDouble(strPrefijo+GuiaRemisionConstantesFunciones.PESOBRUTO));
				entity.setfecha_autorizacion(new Date(resultSet.getDate(strPrefijo+GuiaRemisionConstantesFunciones.FECHAAUTORIZACION).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowGuiaRemision(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(GuiaRemision entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=GuiaRemisionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=GuiaRemisionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=GuiaRemisionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=GuiaRemisionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(GuiaRemisionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,GuiaRemisionDataAccess.TABLENAME,GuiaRemisionDataAccess.ISWITHSTOREPROCEDURES);
			
			GuiaRemisionDataAccess.setGuiaRemisionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relguiaremision.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relguiaremision.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relguiaremision.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relguiaremision.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Usuario getUsuario(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relguiaremision.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Formato getFormato(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relguiaremision.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relguiaremision.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Moneda getMoneda(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relguiaremision.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Cliente getCliente(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relguiaremision.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Vendedor getVendedor(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relguiaremision.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Factura getFactura(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relguiaremision.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Transportista getTransportista(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relguiaremision.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}

	public Consultor getConsultor(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Consultor consultor= new Consultor();

		try {
			ConsultorDataAccess consultorDataAccess=new ConsultorDataAccess();

			consultorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			consultorDataAccess.setConnexionType(this.connexionType);
			consultorDataAccess.setParameterDbType(this.parameterDbType);

			consultor=consultorDataAccess.getEntity(connexion,relguiaremision.getid_consultor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consultor;

	}

	public Transporte getTransporte(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Transporte transporte= new Transporte();

		try {
			TransporteDataAccess transporteDataAccess=new TransporteDataAccess();

			transporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transporteDataAccess.setConnexionType(this.connexionType);
			transporteDataAccess.setParameterDbType(this.parameterDbType);

			transporte=transporteDataAccess.getEntity(connexion,relguiaremision.getid_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transporte;

	}

	public SubCliente getSubCliente(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		SubCliente subcliente= new SubCliente();

		try {
			SubClienteDataAccess subclienteDataAccess=new SubClienteDataAccess();

			subclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			subclienteDataAccess.setConnexionType(this.connexionType);
			subclienteDataAccess.setParameterDbType(this.parameterDbType);

			subcliente=subclienteDataAccess.getEntity(connexion,relguiaremision.getid_sub_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subcliente;

	}

	public Empleado getEmpleado(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relguiaremision.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Ciudad getCiudadOrigen(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relguiaremision.getid_ciudad_origen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Ciudad getCiudadDestino(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relguiaremision.getid_ciudad_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public TipoLlamada getTipoLlamada(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		TipoLlamada tipollamada= new TipoLlamada();

		try {
			TipoLlamadaDataAccess tipollamadaDataAccess=new TipoLlamadaDataAccess();

			tipollamadaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipollamadaDataAccess.setConnexionType(this.connexionType);
			tipollamadaDataAccess.setParameterDbType(this.parameterDbType);

			tipollamada=tipollamadaDataAccess.getEntity(connexion,relguiaremision.getid_tipo_llamada());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipollamada;

	}

	public TipoCambio getTipoCambio(Connexion connexion,GuiaRemision relguiaremision)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relguiaremision.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}


		
		public List<MovimientoInventario> getMovimientoInventarios(Connexion connexion,GuiaRemision guiaremision)throws SQLException,Exception {

		List<MovimientoInventario> movimientoinventarios= new ArrayList<MovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision ON "+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario.id_guia_remision="+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id WHERE "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id="+String.valueOf(guiaremision.getId());
			} else {
				sQuery=" INNER JOIN movimientoinventario.GuiaRemision WHERE movimientoinventario.GuiaRemision.id="+String.valueOf(guiaremision.getId());

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

	public List<DetalleGuiaRemision> getDetalleGuiaRemisions(Connexion connexion,GuiaRemision guiaremision)throws SQLException,Exception {

		List<DetalleGuiaRemision> detalleguiaremisions= new ArrayList<DetalleGuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision ON "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+".detalle_guia_remision.id_guia_remision="+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id WHERE "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id="+String.valueOf(guiaremision.getId());
			} else {
				sQuery=" INNER JOIN detalleguiaremision.GuiaRemision WHERE detalleguiaremision.GuiaRemision.id="+String.valueOf(guiaremision.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleGuiaRemisionDataAccess detalleguiaremisionDataAccess=new DetalleGuiaRemisionDataAccess();

			detalleguiaremisionDataAccess.setConnexionType(this.connexionType);
			detalleguiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleguiaremisions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,GuiaRemision guiaremision) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!guiaremision.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(guiaremision.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(guiaremision.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(guiaremision.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(guiaremision.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(guiaremision.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(guiaremision.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(guiaremision.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(guiaremision.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(guiaremision.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(guiaremision.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_camion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_camion.setValue(guiaremision.getnumero_camion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_camion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(guiaremision.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(guiaremision.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(guiaremision.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(guiaremision.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueidentificacion=new ParameterValue<String>();
					parameterMaintenanceValueidentificacion.setValue(guiaremision.getidentificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidentificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_origen=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_origen.setValue(guiaremision.getfecha_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_destino=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_destino.setValue(guiaremision.getfecha_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetransporte_codigo=new ParameterValue<String>();
					parameterMaintenanceValuetransporte_codigo.setValue(guiaremision.gettransporte_codigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetransporte_codigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_bultos=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_bultos.setValue(guiaremision.getcantidad_bultos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_bultos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_consultor=new ParameterValue<Long>();
					parameterMaintenanceValueid_consultor.setValue(guiaremision.getid_consultor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_consultor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_transporte.setValue(guiaremision.getid_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sub_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_sub_cliente.setValue(guiaremision.getid_sub_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sub_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(guiaremision.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad_origen=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad_origen.setValue(guiaremision.getid_ciudad_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad_destino.setValue(guiaremision.getid_ciudad_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_llamada=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_llamada.setValue(guiaremision.getid_tipo_llamada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_llamada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_inicio=new ParameterValue<Time>();
					parameterMaintenanceValuehora_inicio.setValue(guiaremision.gethora_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_fin=new ParameterValue<Time>();
					parameterMaintenanceValuehora_fin.setValue(guiaremision.gethora_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecupo=new ParameterValue<Double>();
					parameterMaintenanceValuecupo.setValue(guiaremision.getcupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesaldo=new ParameterValue<Double>();
					parameterMaintenanceValuesaldo.setValue(guiaremision.getsaldo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesaldo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedocumento=new ParameterValue<Double>();
					parameterMaintenanceValuedocumento.setValue(guiaremision.getdocumento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedocumento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedisponible=new ParameterValue<Double>();
					parameterMaintenanceValuedisponible.setValue(guiaremision.getdisponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedisponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(guiaremision.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_iva.setValue(guiaremision.gettotal_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_sin_iva.setValue(guiaremision.gettotal_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(guiaremision.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(guiaremision.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotro=new ParameterValue<Double>();
					parameterMaintenanceValueotro.setValue(guiaremision.getotro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciamiento=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciamiento.setValue(guiaremision.getfinanciamiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciamiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(guiaremision.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(guiaremision.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_retencion.setValue(guiaremision.getmonto_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(guiaremision.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(guiaremision.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc_cliente=new ParameterValue<String>();
					parameterMaintenanceValueruc_cliente.setValue(guiaremision.getruc_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_cliente=new ParameterValue<String>();
					parameterMaintenanceValuenombre_cliente.setValue(guiaremision.getnombre_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_cliente=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_cliente.setValue(guiaremision.gettelefono_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_cliente=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_cliente.setValue(guiaremision.getdireccion_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_pre_impreso=new ParameterValue<String>();
					parameterMaintenanceValuenumero_pre_impreso.setValue(guiaremision.getnumero_pre_impreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_pre_impreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepeso_bruto=new ParameterValue<Double>();
					parameterMaintenanceValuepeso_bruto.setValue(guiaremision.getpeso_bruto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepeso_bruto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_autorizacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_autorizacion.setValue(guiaremision.getfecha_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(guiaremision.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
						if(!guiaremision.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(guiaremision.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(guiaremision.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(guiaremision.getId());
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
	
	public void setIsNewIsChangedFalseGuiaRemision(GuiaRemision guiaremision)throws Exception  {		
		guiaremision.setIsNew(false);
		guiaremision.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseGuiaRemisions(List<GuiaRemision> guiaremisions)throws Exception  {				
		for(GuiaRemision guiaremision:guiaremisions) {
			guiaremision.setIsNew(false);
			guiaremision.setIsChanged(false);
		}
	}
	
	public void generarExportarGuiaRemision(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
