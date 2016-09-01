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
package com.bydan.erp.activosfijos.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.activosfijos.util.VehiculoConstantesFunciones;
import com.bydan.erp.activosfijos.util.VehiculoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.VehiculoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VehiculoConstantesFunciones extends VehiculoConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="Vehiculo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Vehiculo"+VehiculoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VehiculoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VehiculoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VehiculoConstantesFunciones.SCHEMA+"_"+VehiculoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VehiculoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VehiculoConstantesFunciones.SCHEMA+"_"+VehiculoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VehiculoConstantesFunciones.SCHEMA+"_"+VehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VehiculoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VehiculoConstantesFunciones.SCHEMA+"_"+VehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VehiculoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VehiculoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VehiculoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VehiculoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VehiculoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VehiculoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Vehiculos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Vehiculo";
	public static final String SCLASSWEBTITULO_LOWER="Vehiculo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Vehiculo";
	public static final String OBJECTNAME="vehiculo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="vehiculo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select vehiculo from "+VehiculoConstantesFunciones.SPERSISTENCENAME+" vehiculo";
	public static String QUERYSELECTNATIVE="select "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".version_row,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id_empresa,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id_sucursal,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id_aseguradora,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_poliza,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".fecha_emision,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".valor_asegurado,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".valor_deducible,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_matricula,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_motor,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_chasis,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_placa,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".valor_comercial,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".descripcion from "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME;//+" as "+VehiculoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VehiculoConstantesFuncionesAdditional vehiculoConstantesFuncionesAdditional=null;
	
	public VehiculoConstantesFuncionesAdditional getVehiculoConstantesFuncionesAdditional() {
		return this.vehiculoConstantesFuncionesAdditional;
	}
	
	public void setVehiculoConstantesFuncionesAdditional(VehiculoConstantesFuncionesAdditional vehiculoConstantesFuncionesAdditional) {
		try {
			this.vehiculoConstantesFuncionesAdditional=vehiculoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDDETALLEACTIVOFIJO= "id_detalle_activo_fijo";
    public static final String IDASEGURADORA= "id_aseguradora";
    public static final String NUMEROPOLIZA= "numero_poliza";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String VALORASEGURADO= "valor_asegurado";
    public static final String VALORDEDUCIBLE= "valor_deducible";
    public static final String NUMEROMATRICULA= "numero_matricula";
    public static final String NUMEROMOTOR= "numero_motor";
    public static final String NUMEROCHASIS= "numero_chasis";
    public static final String NUMEROPLACA= "numero_placa";
    public static final String VALORCOMERCIAL= "valor_comercial";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDDETALLEACTIVOFIJO= "Detalle Activo Fijo";
		public static final String LABEL_IDDETALLEACTIVOFIJO_LOWER= "Detalle Activo Fijo";
    	public static final String LABEL_IDASEGURADORA= "Aseguradora";
		public static final String LABEL_IDASEGURADORA_LOWER= "Aseguradora";
    	public static final String LABEL_NUMEROPOLIZA= "Numero Poliza";
		public static final String LABEL_NUMEROPOLIZA_LOWER= "Numero Poliza";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_VALORASEGURADO= "Valor Asegurado";
		public static final String LABEL_VALORASEGURADO_LOWER= "Valor Asegurado";
    	public static final String LABEL_VALORDEDUCIBLE= "Valor Deducible";
		public static final String LABEL_VALORDEDUCIBLE_LOWER= "Valor Deducible";
    	public static final String LABEL_NUMEROMATRICULA= "Numero Matricula";
		public static final String LABEL_NUMEROMATRICULA_LOWER= "Numero Matricula";
    	public static final String LABEL_NUMEROMOTOR= "Numero Motor";
		public static final String LABEL_NUMEROMOTOR_LOWER= "Numero Motor";
    	public static final String LABEL_NUMEROCHASIS= "Numero Chasis";
		public static final String LABEL_NUMEROCHASIS_LOWER= "Numero Chasis";
    	public static final String LABEL_NUMEROPLACA= "Numero Placa";
		public static final String LABEL_NUMEROPLACA_LOWER= "Numero Placa";
    	public static final String LABEL_VALORCOMERCIAL= "Valor Comercial";
		public static final String LABEL_VALORCOMERCIAL_LOWER= "Valor Comercial";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_POLIZA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_POLIZA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXNUMERO_MATRICULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MATRICULA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MOTOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MOTOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHASIS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHASIS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PLACA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PLACA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVehiculoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VehiculoConstantesFunciones.IDEMPRESA)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.IDASEGURADORA)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_IDASEGURADORA;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.NUMEROPOLIZA)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_NUMEROPOLIZA;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.FECHAEMISION)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.VALORASEGURADO)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_VALORASEGURADO;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.VALORDEDUCIBLE)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_VALORDEDUCIBLE;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.NUMEROMATRICULA)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_NUMEROMATRICULA;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.NUMEROMOTOR)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_NUMEROMOTOR;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.NUMEROCHASIS)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_NUMEROCHASIS;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.NUMEROPLACA)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_NUMEROPLACA;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.VALORCOMERCIAL)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_VALORCOMERCIAL;}
		if(sNombreColumna.equals(VehiculoConstantesFunciones.DESCRIPCION)) {sLabelColumna=VehiculoConstantesFunciones.LABEL_DESCRIPCION;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVehiculoDescripcion(Vehiculo vehiculo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(vehiculo !=null/* && vehiculo.getId()!=0*/) {
			if(vehiculo.getId()!=null) {
				sDescripcion=vehiculo.getId().toString();
			}//vehiculovehiculo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVehiculoDescripcionDetallado(Vehiculo vehiculo) {
		String sDescripcion="";
			
		sDescripcion+=VehiculoConstantesFunciones.ID+"=";
		sDescripcion+=vehiculo.getId().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=vehiculo.getVersionRow().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=vehiculo.getid_empresa().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=vehiculo.getid_sucursal().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO+"=";
		sDescripcion+=vehiculo.getid_detalle_activo_fijo().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.IDASEGURADORA+"=";
		sDescripcion+=vehiculo.getid_aseguradora().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.NUMEROPOLIZA+"=";
		sDescripcion+=vehiculo.getnumero_poliza()+",";
		sDescripcion+=VehiculoConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=vehiculo.getfecha_emision().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=vehiculo.getfecha_vencimiento().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.VALORASEGURADO+"=";
		sDescripcion+=vehiculo.getvalor_asegurado().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.VALORDEDUCIBLE+"=";
		sDescripcion+=vehiculo.getvalor_deducible().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.NUMEROMATRICULA+"=";
		sDescripcion+=vehiculo.getnumero_matricula()+",";
		sDescripcion+=VehiculoConstantesFunciones.NUMEROMOTOR+"=";
		sDescripcion+=vehiculo.getnumero_motor()+",";
		sDescripcion+=VehiculoConstantesFunciones.NUMEROCHASIS+"=";
		sDescripcion+=vehiculo.getnumero_chasis()+",";
		sDescripcion+=VehiculoConstantesFunciones.NUMEROPLACA+"=";
		sDescripcion+=vehiculo.getnumero_placa()+",";
		sDescripcion+=VehiculoConstantesFunciones.VALORCOMERCIAL+"=";
		sDescripcion+=vehiculo.getvalor_comercial().toString()+",";
		sDescripcion+=VehiculoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=vehiculo.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setVehiculoDescripcion(Vehiculo vehiculo,String sValor) throws Exception {			
		if(vehiculo !=null) {
			//vehiculovehiculo.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getDetalleActivoFijoDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleactivofijo!=null/*&&detalleactivofijo.getId()>0*/) {
			sDescripcion=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(detalleactivofijo);
		}

		return sDescripcion;
	}

	public static String getAseguradoraDescripcion(Aseguradora aseguradora) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(aseguradora!=null/*&&aseguradora.getId()>0*/) {
			sDescripcion=AseguradoraConstantesFunciones.getAseguradoraDescripcion(aseguradora);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAseguradora")) {
			sNombreIndice="Tipo=  Por Aseguradora";
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAseguradora(Long id_aseguradora) {
		String sDetalleIndice=" Parametros->";
		if(id_aseguradora!=null) {sDetalleIndice+=" Codigo Unico De Aseguradora="+id_aseguradora.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleActivoFijo(Long id_detalle_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Activo Fijo="+id_detalle_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVehiculo(Vehiculo vehiculo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		vehiculo.setnumero_poliza(vehiculo.getnumero_poliza().trim());
		vehiculo.setnumero_matricula(vehiculo.getnumero_matricula().trim());
		vehiculo.setnumero_motor(vehiculo.getnumero_motor().trim());
		vehiculo.setnumero_chasis(vehiculo.getnumero_chasis().trim());
		vehiculo.setnumero_placa(vehiculo.getnumero_placa().trim());
		vehiculo.setdescripcion(vehiculo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosVehiculos(List<Vehiculo> vehiculos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Vehiculo vehiculo: vehiculos) {
			vehiculo.setnumero_poliza(vehiculo.getnumero_poliza().trim());
			vehiculo.setnumero_matricula(vehiculo.getnumero_matricula().trim());
			vehiculo.setnumero_motor(vehiculo.getnumero_motor().trim());
			vehiculo.setnumero_chasis(vehiculo.getnumero_chasis().trim());
			vehiculo.setnumero_placa(vehiculo.getnumero_placa().trim());
			vehiculo.setdescripcion(vehiculo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVehiculo(Vehiculo vehiculo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && vehiculo.getConCambioAuxiliar()) {
			vehiculo.setIsDeleted(vehiculo.getIsDeletedAuxiliar());	
			vehiculo.setIsNew(vehiculo.getIsNewAuxiliar());	
			vehiculo.setIsChanged(vehiculo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			vehiculo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			vehiculo.setIsDeletedAuxiliar(false);	
			vehiculo.setIsNewAuxiliar(false);	
			vehiculo.setIsChangedAuxiliar(false);
			
			vehiculo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVehiculos(List<Vehiculo> vehiculos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Vehiculo vehiculo : vehiculos) {
			if(conAsignarBase && vehiculo.getConCambioAuxiliar()) {
				vehiculo.setIsDeleted(vehiculo.getIsDeletedAuxiliar());	
				vehiculo.setIsNew(vehiculo.getIsNewAuxiliar());	
				vehiculo.setIsChanged(vehiculo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				vehiculo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				vehiculo.setIsDeletedAuxiliar(false);	
				vehiculo.setIsNewAuxiliar(false);	
				vehiculo.setIsChangedAuxiliar(false);
				
				vehiculo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVehiculo(Vehiculo vehiculo,Boolean conEnteros) throws Exception  {
		vehiculo.setvalor_asegurado(0.0);
		vehiculo.setvalor_deducible(0.0);
		vehiculo.setvalor_comercial(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVehiculos(List<Vehiculo> vehiculos,Boolean conEnteros) throws Exception  {
		
		for(Vehiculo vehiculo: vehiculos) {
			vehiculo.setvalor_asegurado(0.0);
			vehiculo.setvalor_deducible(0.0);
			vehiculo.setvalor_comercial(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVehiculo(List<Vehiculo> vehiculos,Vehiculo vehiculoAux) throws Exception  {
		VehiculoConstantesFunciones.InicializarValoresVehiculo(vehiculoAux,true);
		
		for(Vehiculo vehiculo: vehiculos) {
			if(vehiculo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vehiculoAux.setvalor_asegurado(vehiculoAux.getvalor_asegurado()+vehiculo.getvalor_asegurado());			
			vehiculoAux.setvalor_deducible(vehiculoAux.getvalor_deducible()+vehiculo.getvalor_deducible());			
			vehiculoAux.setvalor_comercial(vehiculoAux.getvalor_comercial()+vehiculo.getvalor_comercial());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVehiculo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VehiculoConstantesFunciones.getArrayColumnasGlobalesVehiculo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVehiculo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VehiculoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VehiculoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VehiculoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VehiculoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVehiculo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Vehiculo> vehiculos,Vehiculo vehiculo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Vehiculo vehiculoAux: vehiculos) {
			if(vehiculoAux!=null && vehiculo!=null) {
				if((vehiculoAux.getId()==null && vehiculo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(vehiculoAux.getId()!=null && vehiculo.getId()!=null){
					if(vehiculoAux.getId().equals(vehiculo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVehiculo(List<Vehiculo> vehiculos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_aseguradoTotal=0.0;
		Double valor_deducibleTotal=0.0;
		Double valor_comercialTotal=0.0;
	
		for(Vehiculo vehiculo: vehiculos) {			
			if(vehiculo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_aseguradoTotal+=vehiculo.getvalor_asegurado();
			valor_deducibleTotal+=vehiculo.getvalor_deducible();
			valor_comercialTotal+=vehiculo.getvalor_comercial();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VehiculoConstantesFunciones.VALORASEGURADO);
		datoGeneral.setsDescripcion(VehiculoConstantesFunciones.LABEL_VALORASEGURADO);
		datoGeneral.setdValorDouble(valor_aseguradoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VehiculoConstantesFunciones.VALORDEDUCIBLE);
		datoGeneral.setsDescripcion(VehiculoConstantesFunciones.LABEL_VALORDEDUCIBLE);
		datoGeneral.setdValorDouble(valor_deducibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VehiculoConstantesFunciones.VALORCOMERCIAL);
		datoGeneral.setsDescripcion(VehiculoConstantesFunciones.LABEL_VALORCOMERCIAL);
		datoGeneral.setdValorDouble(valor_comercialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVehiculo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_ID, VehiculoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_VERSIONROW, VehiculoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_IDEMPRESA, VehiculoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_IDSUCURSAL, VehiculoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO, VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_IDASEGURADORA, VehiculoConstantesFunciones.IDASEGURADORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_NUMEROPOLIZA, VehiculoConstantesFunciones.NUMEROPOLIZA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_FECHAEMISION, VehiculoConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_FECHAVENCIMIENTO, VehiculoConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_VALORASEGURADO, VehiculoConstantesFunciones.VALORASEGURADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_VALORDEDUCIBLE, VehiculoConstantesFunciones.VALORDEDUCIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_NUMEROMATRICULA, VehiculoConstantesFunciones.NUMEROMATRICULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_NUMEROMOTOR, VehiculoConstantesFunciones.NUMEROMOTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_NUMEROCHASIS, VehiculoConstantesFunciones.NUMEROCHASIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_NUMEROPLACA, VehiculoConstantesFunciones.NUMEROPLACA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_VALORCOMERCIAL, VehiculoConstantesFunciones.VALORCOMERCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoConstantesFunciones.LABEL_DESCRIPCION, VehiculoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVehiculo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.IDASEGURADORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.NUMEROPOLIZA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.VALORASEGURADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.VALORDEDUCIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.NUMEROMATRICULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.NUMEROMOTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.NUMEROCHASIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.NUMEROPLACA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.VALORCOMERCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVehiculo() throws Exception  {
		return VehiculoConstantesFunciones.getTiposSeleccionarVehiculo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVehiculo(Boolean conFk) throws Exception  {
		return VehiculoConstantesFunciones.getTiposSeleccionarVehiculo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVehiculo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_IDASEGURADORA);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_IDASEGURADORA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_NUMEROPOLIZA);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_NUMEROPOLIZA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_VALORASEGURADO);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_VALORASEGURADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_VALORDEDUCIBLE);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_VALORDEDUCIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_NUMEROMATRICULA);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_NUMEROMATRICULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_NUMEROMOTOR);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_NUMEROMOTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_NUMEROCHASIS);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_NUMEROCHASIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_NUMEROPLACA);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_NUMEROPLACA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_VALORCOMERCIAL);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_VALORCOMERCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(VehiculoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVehiculo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVehiculo(Vehiculo vehiculoAux) throws Exception {
		
			vehiculoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vehiculoAux.getEmpresa()));
			vehiculoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(vehiculoAux.getSucursal()));
			vehiculoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(vehiculoAux.getDetalleActivoFijo()));
			vehiculoAux.setaseguradora_descripcion(AseguradoraConstantesFunciones.getAseguradoraDescripcion(vehiculoAux.getAseguradora()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVehiculo(List<Vehiculo> vehiculosTemp) throws Exception {
		for(Vehiculo vehiculoAux:vehiculosTemp) {
			
			vehiculoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vehiculoAux.getEmpresa()));
			vehiculoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(vehiculoAux.getSucursal()));
			vehiculoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(vehiculoAux.getDetalleActivoFijo()));
			vehiculoAux.setaseguradora_descripcion(AseguradoraConstantesFunciones.getAseguradoraDescripcion(vehiculoAux.getAseguradora()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(DetalleActivoFijo.class));
				classes.add(new Classe(Aseguradora.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Aseguradora.class)) {
						classes.add(new Classe(Aseguradora.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVehiculo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(Aseguradora.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Aseguradora.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(Aseguradora.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Aseguradora.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VehiculoConstantesFunciones.getClassesRelationshipsOfVehiculo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ServicioTransporte.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ServicioTransporte.class)) {
						classes.add(new Classe(ServicioTransporte.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVehiculo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VehiculoConstantesFunciones.getClassesRelationshipsFromStringsOfVehiculo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVehiculo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioTransporte.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioTransporte.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Vehiculo vehiculo,List<Vehiculo> vehiculos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Vehiculo vehiculoEncontrado=null;
			
			for(Vehiculo vehiculoLocal:vehiculos) {
				if(vehiculoLocal.getId().equals(vehiculo.getId())) {
					vehiculoEncontrado=vehiculoLocal;
					
					vehiculoLocal.setIsChanged(vehiculo.getIsChanged());
					vehiculoLocal.setIsNew(vehiculo.getIsNew());
					vehiculoLocal.setIsDeleted(vehiculo.getIsDeleted());
					
					vehiculoLocal.setGeneralEntityOriginal(vehiculo.getGeneralEntityOriginal());
					
					vehiculoLocal.setId(vehiculo.getId());	
					vehiculoLocal.setVersionRow(vehiculo.getVersionRow());	
					vehiculoLocal.setid_empresa(vehiculo.getid_empresa());	
					vehiculoLocal.setid_sucursal(vehiculo.getid_sucursal());	
					vehiculoLocal.setid_detalle_activo_fijo(vehiculo.getid_detalle_activo_fijo());	
					vehiculoLocal.setid_aseguradora(vehiculo.getid_aseguradora());	
					vehiculoLocal.setnumero_poliza(vehiculo.getnumero_poliza());	
					vehiculoLocal.setfecha_emision(vehiculo.getfecha_emision());	
					vehiculoLocal.setfecha_vencimiento(vehiculo.getfecha_vencimiento());	
					vehiculoLocal.setvalor_asegurado(vehiculo.getvalor_asegurado());	
					vehiculoLocal.setvalor_deducible(vehiculo.getvalor_deducible());	
					vehiculoLocal.setnumero_matricula(vehiculo.getnumero_matricula());	
					vehiculoLocal.setnumero_motor(vehiculo.getnumero_motor());	
					vehiculoLocal.setnumero_chasis(vehiculo.getnumero_chasis());	
					vehiculoLocal.setnumero_placa(vehiculo.getnumero_placa());	
					vehiculoLocal.setvalor_comercial(vehiculo.getvalor_comercial());	
					vehiculoLocal.setdescripcion(vehiculo.getdescripcion());	
					
					
					vehiculoLocal.setServicioTransportes(vehiculo.getServicioTransportes());
					
					existe=true;
					break;
				}
			}
			
			if(!vehiculo.getIsDeleted()) {
				if(!existe) {
					vehiculos.add(vehiculo);
				}
			} else {
				if(vehiculoEncontrado!=null && permiteQuitar)  {
					vehiculos.remove(vehiculoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Vehiculo vehiculo,List<Vehiculo> vehiculos) throws Exception {
		try	{			
			for(Vehiculo vehiculoLocal:vehiculos) {
				if(vehiculoLocal.getId().equals(vehiculo.getId())) {
					vehiculoLocal.setIsSelected(vehiculo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVehiculo(List<Vehiculo> vehiculosAux) throws Exception {
		//this.vehiculosAux=vehiculosAux;
		
		for(Vehiculo vehiculoAux:vehiculosAux) {
			if(vehiculoAux.getIsChanged()) {
				vehiculoAux.setIsChanged(false);
			}		
			
			if(vehiculoAux.getIsNew()) {
				vehiculoAux.setIsNew(false);
			}	
			
			if(vehiculoAux.getIsDeleted()) {
				vehiculoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVehiculo(Vehiculo vehiculoAux) throws Exception {
		//this.vehiculoAux=vehiculoAux;
		
			if(vehiculoAux.getIsChanged()) {
				vehiculoAux.setIsChanged(false);
			}		
			
			if(vehiculoAux.getIsNew()) {
				vehiculoAux.setIsNew(false);
			}	
			
			if(vehiculoAux.getIsDeleted()) {
				vehiculoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Vehiculo vehiculoAsignar,Vehiculo vehiculo) throws Exception {
		vehiculoAsignar.setId(vehiculo.getId());	
		vehiculoAsignar.setVersionRow(vehiculo.getVersionRow());	
		vehiculoAsignar.setid_empresa(vehiculo.getid_empresa());
		vehiculoAsignar.setempresa_descripcion(vehiculo.getempresa_descripcion());	
		vehiculoAsignar.setid_sucursal(vehiculo.getid_sucursal());
		vehiculoAsignar.setsucursal_descripcion(vehiculo.getsucursal_descripcion());	
		vehiculoAsignar.setid_detalle_activo_fijo(vehiculo.getid_detalle_activo_fijo());
		vehiculoAsignar.setdetalleactivofijo_descripcion(vehiculo.getdetalleactivofijo_descripcion());	
		vehiculoAsignar.setid_aseguradora(vehiculo.getid_aseguradora());
		vehiculoAsignar.setaseguradora_descripcion(vehiculo.getaseguradora_descripcion());	
		vehiculoAsignar.setnumero_poliza(vehiculo.getnumero_poliza());	
		vehiculoAsignar.setfecha_emision(vehiculo.getfecha_emision());	
		vehiculoAsignar.setfecha_vencimiento(vehiculo.getfecha_vencimiento());	
		vehiculoAsignar.setvalor_asegurado(vehiculo.getvalor_asegurado());	
		vehiculoAsignar.setvalor_deducible(vehiculo.getvalor_deducible());	
		vehiculoAsignar.setnumero_matricula(vehiculo.getnumero_matricula());	
		vehiculoAsignar.setnumero_motor(vehiculo.getnumero_motor());	
		vehiculoAsignar.setnumero_chasis(vehiculo.getnumero_chasis());	
		vehiculoAsignar.setnumero_placa(vehiculo.getnumero_placa());	
		vehiculoAsignar.setvalor_comercial(vehiculo.getvalor_comercial());	
		vehiculoAsignar.setdescripcion(vehiculo.getdescripcion());	
	}
	
	public static void inicializarVehiculo(Vehiculo vehiculo) throws Exception {
		try {
				vehiculo.setId(0L);	
					
				vehiculo.setid_empresa(-1L);	
				vehiculo.setid_sucursal(-1L);	
				vehiculo.setid_detalle_activo_fijo(-1L);	
				vehiculo.setid_aseguradora(-1L);	
				vehiculo.setnumero_poliza("");	
				vehiculo.setfecha_emision(new Date());	
				vehiculo.setfecha_vencimiento(new Date());	
				vehiculo.setvalor_asegurado(0.0);	
				vehiculo.setvalor_deducible(0.0);	
				vehiculo.setnumero_matricula("");	
				vehiculo.setnumero_motor("");	
				vehiculo.setnumero_chasis("");	
				vehiculo.setnumero_placa("");	
				vehiculo.setvalor_comercial(0.0);	
				vehiculo.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVehiculo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_IDASEGURADORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_NUMEROPOLIZA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_VALORASEGURADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_VALORDEDUCIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_NUMEROMATRICULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_NUMEROMOTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_NUMEROCHASIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_NUMEROPLACA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_VALORCOMERCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVehiculo(String sTipo,Row row,Workbook workbook,Vehiculo vehiculo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getdetalleactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getaseguradora_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getnumero_poliza());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getvalor_asegurado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getvalor_deducible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getnumero_matricula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getnumero_motor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getnumero_chasis());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getnumero_placa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getvalor_comercial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVehiculo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVehiculo() {
		return this.sFinalQueryVehiculo;
	}
	
	public void setsFinalQueryVehiculo(String sFinalQueryVehiculo) {
		this.sFinalQueryVehiculo= sFinalQueryVehiculo;
	}
	
	public Border resaltarSeleccionarVehiculo=null;
	
	public Border setResaltarSeleccionarVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVehiculo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVehiculo() {
		return this.resaltarSeleccionarVehiculo;
	}
	
	public void setResaltarSeleccionarVehiculo(Border borderResaltarSeleccionarVehiculo) {
		this.resaltarSeleccionarVehiculo= borderResaltarSeleccionarVehiculo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVehiculo=null;
	public Boolean mostraridVehiculo=true;
	public Boolean activaridVehiculo=true;

	public Border resaltarid_empresaVehiculo=null;
	public Boolean mostrarid_empresaVehiculo=true;
	public Boolean activarid_empresaVehiculo=true;
	public Boolean cargarid_empresaVehiculo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVehiculo=false;//ConEventDepend=true

	public Border resaltarid_sucursalVehiculo=null;
	public Boolean mostrarid_sucursalVehiculo=true;
	public Boolean activarid_sucursalVehiculo=true;
	public Boolean cargarid_sucursalVehiculo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalVehiculo=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijoVehiculo=null;
	public Boolean mostrarid_detalle_activo_fijoVehiculo=true;
	public Boolean activarid_detalle_activo_fijoVehiculo=true;
	public Boolean cargarid_detalle_activo_fijoVehiculo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijoVehiculo=false;//ConEventDepend=true

	public Border resaltarid_aseguradoraVehiculo=null;
	public Boolean mostrarid_aseguradoraVehiculo=true;
	public Boolean activarid_aseguradoraVehiculo=true;
	public Boolean cargarid_aseguradoraVehiculo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_aseguradoraVehiculo=false;//ConEventDepend=true

	public Border resaltarnumero_polizaVehiculo=null;
	public Boolean mostrarnumero_polizaVehiculo=true;
	public Boolean activarnumero_polizaVehiculo=true;

	public Border resaltarfecha_emisionVehiculo=null;
	public Boolean mostrarfecha_emisionVehiculo=true;
	public Boolean activarfecha_emisionVehiculo=false;

	public Border resaltarfecha_vencimientoVehiculo=null;
	public Boolean mostrarfecha_vencimientoVehiculo=true;
	public Boolean activarfecha_vencimientoVehiculo=false;

	public Border resaltarvalor_aseguradoVehiculo=null;
	public Boolean mostrarvalor_aseguradoVehiculo=true;
	public Boolean activarvalor_aseguradoVehiculo=true;

	public Border resaltarvalor_deducibleVehiculo=null;
	public Boolean mostrarvalor_deducibleVehiculo=true;
	public Boolean activarvalor_deducibleVehiculo=true;

	public Border resaltarnumero_matriculaVehiculo=null;
	public Boolean mostrarnumero_matriculaVehiculo=true;
	public Boolean activarnumero_matriculaVehiculo=true;

	public Border resaltarnumero_motorVehiculo=null;
	public Boolean mostrarnumero_motorVehiculo=true;
	public Boolean activarnumero_motorVehiculo=true;

	public Border resaltarnumero_chasisVehiculo=null;
	public Boolean mostrarnumero_chasisVehiculo=true;
	public Boolean activarnumero_chasisVehiculo=true;

	public Border resaltarnumero_placaVehiculo=null;
	public Boolean mostrarnumero_placaVehiculo=true;
	public Boolean activarnumero_placaVehiculo=true;

	public Border resaltarvalor_comercialVehiculo=null;
	public Boolean mostrarvalor_comercialVehiculo=true;
	public Boolean activarvalor_comercialVehiculo=true;

	public Border resaltardescripcionVehiculo=null;
	public Boolean mostrardescripcionVehiculo=true;
	public Boolean activardescripcionVehiculo=true;

	
	

	public Border setResaltaridVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltaridVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVehiculo() {
		return this.resaltaridVehiculo;
	}

	public void setResaltaridVehiculo(Border borderResaltar) {
		this.resaltaridVehiculo= borderResaltar;
	}

	public Boolean getMostraridVehiculo() {
		return this.mostraridVehiculo;
	}

	public void setMostraridVehiculo(Boolean mostraridVehiculo) {
		this.mostraridVehiculo= mostraridVehiculo;
	}

	public Boolean getActivaridVehiculo() {
		return this.activaridVehiculo;
	}

	public void setActivaridVehiculo(Boolean activaridVehiculo) {
		this.activaridVehiculo= activaridVehiculo;
	}

	public Border setResaltarid_empresaVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarid_empresaVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVehiculo() {
		return this.resaltarid_empresaVehiculo;
	}

	public void setResaltarid_empresaVehiculo(Border borderResaltar) {
		this.resaltarid_empresaVehiculo= borderResaltar;
	}

	public Boolean getMostrarid_empresaVehiculo() {
		return this.mostrarid_empresaVehiculo;
	}

	public void setMostrarid_empresaVehiculo(Boolean mostrarid_empresaVehiculo) {
		this.mostrarid_empresaVehiculo= mostrarid_empresaVehiculo;
	}

	public Boolean getActivarid_empresaVehiculo() {
		return this.activarid_empresaVehiculo;
	}

	public void setActivarid_empresaVehiculo(Boolean activarid_empresaVehiculo) {
		this.activarid_empresaVehiculo= activarid_empresaVehiculo;
	}

	public Boolean getCargarid_empresaVehiculo() {
		return this.cargarid_empresaVehiculo;
	}

	public void setCargarid_empresaVehiculo(Boolean cargarid_empresaVehiculo) {
		this.cargarid_empresaVehiculo= cargarid_empresaVehiculo;
	}

	public Border setResaltarid_sucursalVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarid_sucursalVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalVehiculo() {
		return this.resaltarid_sucursalVehiculo;
	}

	public void setResaltarid_sucursalVehiculo(Border borderResaltar) {
		this.resaltarid_sucursalVehiculo= borderResaltar;
	}

	public Boolean getMostrarid_sucursalVehiculo() {
		return this.mostrarid_sucursalVehiculo;
	}

	public void setMostrarid_sucursalVehiculo(Boolean mostrarid_sucursalVehiculo) {
		this.mostrarid_sucursalVehiculo= mostrarid_sucursalVehiculo;
	}

	public Boolean getActivarid_sucursalVehiculo() {
		return this.activarid_sucursalVehiculo;
	}

	public void setActivarid_sucursalVehiculo(Boolean activarid_sucursalVehiculo) {
		this.activarid_sucursalVehiculo= activarid_sucursalVehiculo;
	}

	public Boolean getCargarid_sucursalVehiculo() {
		return this.cargarid_sucursalVehiculo;
	}

	public void setCargarid_sucursalVehiculo(Boolean cargarid_sucursalVehiculo) {
		this.cargarid_sucursalVehiculo= cargarid_sucursalVehiculo;
	}

	public Border setResaltarid_detalle_activo_fijoVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijoVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijoVehiculo() {
		return this.resaltarid_detalle_activo_fijoVehiculo;
	}

	public void setResaltarid_detalle_activo_fijoVehiculo(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijoVehiculo= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijoVehiculo() {
		return this.mostrarid_detalle_activo_fijoVehiculo;
	}

	public void setMostrarid_detalle_activo_fijoVehiculo(Boolean mostrarid_detalle_activo_fijoVehiculo) {
		this.mostrarid_detalle_activo_fijoVehiculo= mostrarid_detalle_activo_fijoVehiculo;
	}

	public Boolean getActivarid_detalle_activo_fijoVehiculo() {
		return this.activarid_detalle_activo_fijoVehiculo;
	}

	public void setActivarid_detalle_activo_fijoVehiculo(Boolean activarid_detalle_activo_fijoVehiculo) {
		this.activarid_detalle_activo_fijoVehiculo= activarid_detalle_activo_fijoVehiculo;
	}

	public Boolean getCargarid_detalle_activo_fijoVehiculo() {
		return this.cargarid_detalle_activo_fijoVehiculo;
	}

	public void setCargarid_detalle_activo_fijoVehiculo(Boolean cargarid_detalle_activo_fijoVehiculo) {
		this.cargarid_detalle_activo_fijoVehiculo= cargarid_detalle_activo_fijoVehiculo;
	}

	public Border setResaltarid_aseguradoraVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarid_aseguradoraVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_aseguradoraVehiculo() {
		return this.resaltarid_aseguradoraVehiculo;
	}

	public void setResaltarid_aseguradoraVehiculo(Border borderResaltar) {
		this.resaltarid_aseguradoraVehiculo= borderResaltar;
	}

	public Boolean getMostrarid_aseguradoraVehiculo() {
		return this.mostrarid_aseguradoraVehiculo;
	}

	public void setMostrarid_aseguradoraVehiculo(Boolean mostrarid_aseguradoraVehiculo) {
		this.mostrarid_aseguradoraVehiculo= mostrarid_aseguradoraVehiculo;
	}

	public Boolean getActivarid_aseguradoraVehiculo() {
		return this.activarid_aseguradoraVehiculo;
	}

	public void setActivarid_aseguradoraVehiculo(Boolean activarid_aseguradoraVehiculo) {
		this.activarid_aseguradoraVehiculo= activarid_aseguradoraVehiculo;
	}

	public Boolean getCargarid_aseguradoraVehiculo() {
		return this.cargarid_aseguradoraVehiculo;
	}

	public void setCargarid_aseguradoraVehiculo(Boolean cargarid_aseguradoraVehiculo) {
		this.cargarid_aseguradoraVehiculo= cargarid_aseguradoraVehiculo;
	}

	public Border setResaltarnumero_polizaVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarnumero_polizaVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_polizaVehiculo() {
		return this.resaltarnumero_polizaVehiculo;
	}

	public void setResaltarnumero_polizaVehiculo(Border borderResaltar) {
		this.resaltarnumero_polizaVehiculo= borderResaltar;
	}

	public Boolean getMostrarnumero_polizaVehiculo() {
		return this.mostrarnumero_polizaVehiculo;
	}

	public void setMostrarnumero_polizaVehiculo(Boolean mostrarnumero_polizaVehiculo) {
		this.mostrarnumero_polizaVehiculo= mostrarnumero_polizaVehiculo;
	}

	public Boolean getActivarnumero_polizaVehiculo() {
		return this.activarnumero_polizaVehiculo;
	}

	public void setActivarnumero_polizaVehiculo(Boolean activarnumero_polizaVehiculo) {
		this.activarnumero_polizaVehiculo= activarnumero_polizaVehiculo;
	}

	public Border setResaltarfecha_emisionVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionVehiculo() {
		return this.resaltarfecha_emisionVehiculo;
	}

	public void setResaltarfecha_emisionVehiculo(Border borderResaltar) {
		this.resaltarfecha_emisionVehiculo= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionVehiculo() {
		return this.mostrarfecha_emisionVehiculo;
	}

	public void setMostrarfecha_emisionVehiculo(Boolean mostrarfecha_emisionVehiculo) {
		this.mostrarfecha_emisionVehiculo= mostrarfecha_emisionVehiculo;
	}

	public Boolean getActivarfecha_emisionVehiculo() {
		return this.activarfecha_emisionVehiculo;
	}

	public void setActivarfecha_emisionVehiculo(Boolean activarfecha_emisionVehiculo) {
		this.activarfecha_emisionVehiculo= activarfecha_emisionVehiculo;
	}

	public Border setResaltarfecha_vencimientoVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoVehiculo() {
		return this.resaltarfecha_vencimientoVehiculo;
	}

	public void setResaltarfecha_vencimientoVehiculo(Border borderResaltar) {
		this.resaltarfecha_vencimientoVehiculo= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoVehiculo() {
		return this.mostrarfecha_vencimientoVehiculo;
	}

	public void setMostrarfecha_vencimientoVehiculo(Boolean mostrarfecha_vencimientoVehiculo) {
		this.mostrarfecha_vencimientoVehiculo= mostrarfecha_vencimientoVehiculo;
	}

	public Boolean getActivarfecha_vencimientoVehiculo() {
		return this.activarfecha_vencimientoVehiculo;
	}

	public void setActivarfecha_vencimientoVehiculo(Boolean activarfecha_vencimientoVehiculo) {
		this.activarfecha_vencimientoVehiculo= activarfecha_vencimientoVehiculo;
	}

	public Border setResaltarvalor_aseguradoVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarvalor_aseguradoVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_aseguradoVehiculo() {
		return this.resaltarvalor_aseguradoVehiculo;
	}

	public void setResaltarvalor_aseguradoVehiculo(Border borderResaltar) {
		this.resaltarvalor_aseguradoVehiculo= borderResaltar;
	}

	public Boolean getMostrarvalor_aseguradoVehiculo() {
		return this.mostrarvalor_aseguradoVehiculo;
	}

	public void setMostrarvalor_aseguradoVehiculo(Boolean mostrarvalor_aseguradoVehiculo) {
		this.mostrarvalor_aseguradoVehiculo= mostrarvalor_aseguradoVehiculo;
	}

	public Boolean getActivarvalor_aseguradoVehiculo() {
		return this.activarvalor_aseguradoVehiculo;
	}

	public void setActivarvalor_aseguradoVehiculo(Boolean activarvalor_aseguradoVehiculo) {
		this.activarvalor_aseguradoVehiculo= activarvalor_aseguradoVehiculo;
	}

	public Border setResaltarvalor_deducibleVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarvalor_deducibleVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_deducibleVehiculo() {
		return this.resaltarvalor_deducibleVehiculo;
	}

	public void setResaltarvalor_deducibleVehiculo(Border borderResaltar) {
		this.resaltarvalor_deducibleVehiculo= borderResaltar;
	}

	public Boolean getMostrarvalor_deducibleVehiculo() {
		return this.mostrarvalor_deducibleVehiculo;
	}

	public void setMostrarvalor_deducibleVehiculo(Boolean mostrarvalor_deducibleVehiculo) {
		this.mostrarvalor_deducibleVehiculo= mostrarvalor_deducibleVehiculo;
	}

	public Boolean getActivarvalor_deducibleVehiculo() {
		return this.activarvalor_deducibleVehiculo;
	}

	public void setActivarvalor_deducibleVehiculo(Boolean activarvalor_deducibleVehiculo) {
		this.activarvalor_deducibleVehiculo= activarvalor_deducibleVehiculo;
	}

	public Border setResaltarnumero_matriculaVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarnumero_matriculaVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_matriculaVehiculo() {
		return this.resaltarnumero_matriculaVehiculo;
	}

	public void setResaltarnumero_matriculaVehiculo(Border borderResaltar) {
		this.resaltarnumero_matriculaVehiculo= borderResaltar;
	}

	public Boolean getMostrarnumero_matriculaVehiculo() {
		return this.mostrarnumero_matriculaVehiculo;
	}

	public void setMostrarnumero_matriculaVehiculo(Boolean mostrarnumero_matriculaVehiculo) {
		this.mostrarnumero_matriculaVehiculo= mostrarnumero_matriculaVehiculo;
	}

	public Boolean getActivarnumero_matriculaVehiculo() {
		return this.activarnumero_matriculaVehiculo;
	}

	public void setActivarnumero_matriculaVehiculo(Boolean activarnumero_matriculaVehiculo) {
		this.activarnumero_matriculaVehiculo= activarnumero_matriculaVehiculo;
	}

	public Border setResaltarnumero_motorVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarnumero_motorVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_motorVehiculo() {
		return this.resaltarnumero_motorVehiculo;
	}

	public void setResaltarnumero_motorVehiculo(Border borderResaltar) {
		this.resaltarnumero_motorVehiculo= borderResaltar;
	}

	public Boolean getMostrarnumero_motorVehiculo() {
		return this.mostrarnumero_motorVehiculo;
	}

	public void setMostrarnumero_motorVehiculo(Boolean mostrarnumero_motorVehiculo) {
		this.mostrarnumero_motorVehiculo= mostrarnumero_motorVehiculo;
	}

	public Boolean getActivarnumero_motorVehiculo() {
		return this.activarnumero_motorVehiculo;
	}

	public void setActivarnumero_motorVehiculo(Boolean activarnumero_motorVehiculo) {
		this.activarnumero_motorVehiculo= activarnumero_motorVehiculo;
	}

	public Border setResaltarnumero_chasisVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarnumero_chasisVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chasisVehiculo() {
		return this.resaltarnumero_chasisVehiculo;
	}

	public void setResaltarnumero_chasisVehiculo(Border borderResaltar) {
		this.resaltarnumero_chasisVehiculo= borderResaltar;
	}

	public Boolean getMostrarnumero_chasisVehiculo() {
		return this.mostrarnumero_chasisVehiculo;
	}

	public void setMostrarnumero_chasisVehiculo(Boolean mostrarnumero_chasisVehiculo) {
		this.mostrarnumero_chasisVehiculo= mostrarnumero_chasisVehiculo;
	}

	public Boolean getActivarnumero_chasisVehiculo() {
		return this.activarnumero_chasisVehiculo;
	}

	public void setActivarnumero_chasisVehiculo(Boolean activarnumero_chasisVehiculo) {
		this.activarnumero_chasisVehiculo= activarnumero_chasisVehiculo;
	}

	public Border setResaltarnumero_placaVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarnumero_placaVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_placaVehiculo() {
		return this.resaltarnumero_placaVehiculo;
	}

	public void setResaltarnumero_placaVehiculo(Border borderResaltar) {
		this.resaltarnumero_placaVehiculo= borderResaltar;
	}

	public Boolean getMostrarnumero_placaVehiculo() {
		return this.mostrarnumero_placaVehiculo;
	}

	public void setMostrarnumero_placaVehiculo(Boolean mostrarnumero_placaVehiculo) {
		this.mostrarnumero_placaVehiculo= mostrarnumero_placaVehiculo;
	}

	public Boolean getActivarnumero_placaVehiculo() {
		return this.activarnumero_placaVehiculo;
	}

	public void setActivarnumero_placaVehiculo(Boolean activarnumero_placaVehiculo) {
		this.activarnumero_placaVehiculo= activarnumero_placaVehiculo;
	}

	public Border setResaltarvalor_comercialVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltarvalor_comercialVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_comercialVehiculo() {
		return this.resaltarvalor_comercialVehiculo;
	}

	public void setResaltarvalor_comercialVehiculo(Border borderResaltar) {
		this.resaltarvalor_comercialVehiculo= borderResaltar;
	}

	public Boolean getMostrarvalor_comercialVehiculo() {
		return this.mostrarvalor_comercialVehiculo;
	}

	public void setMostrarvalor_comercialVehiculo(Boolean mostrarvalor_comercialVehiculo) {
		this.mostrarvalor_comercialVehiculo= mostrarvalor_comercialVehiculo;
	}

	public Boolean getActivarvalor_comercialVehiculo() {
		return this.activarvalor_comercialVehiculo;
	}

	public void setActivarvalor_comercialVehiculo(Boolean activarvalor_comercialVehiculo) {
		this.activarvalor_comercialVehiculo= activarvalor_comercialVehiculo;
	}

	public Border setResaltardescripcionVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltar);
		
		this.resaltardescripcionVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionVehiculo() {
		return this.resaltardescripcionVehiculo;
	}

	public void setResaltardescripcionVehiculo(Border borderResaltar) {
		this.resaltardescripcionVehiculo= borderResaltar;
	}

	public Boolean getMostrardescripcionVehiculo() {
		return this.mostrardescripcionVehiculo;
	}

	public void setMostrardescripcionVehiculo(Boolean mostrardescripcionVehiculo) {
		this.mostrardescripcionVehiculo= mostrardescripcionVehiculo;
	}

	public Boolean getActivardescripcionVehiculo() {
		return this.activardescripcionVehiculo;
	}

	public void setActivardescripcionVehiculo(Boolean activardescripcionVehiculo) {
		this.activardescripcionVehiculo= activardescripcionVehiculo;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridVehiculo(esInicial);
		this.setMostrarid_empresaVehiculo(esInicial);
		this.setMostrarid_sucursalVehiculo(esInicial);
		this.setMostrarid_detalle_activo_fijoVehiculo(esInicial);
		this.setMostrarid_aseguradoraVehiculo(esInicial);
		this.setMostrarnumero_polizaVehiculo(esInicial);
		this.setMostrarfecha_emisionVehiculo(esInicial);
		this.setMostrarfecha_vencimientoVehiculo(esInicial);
		this.setMostrarvalor_aseguradoVehiculo(esInicial);
		this.setMostrarvalor_deducibleVehiculo(esInicial);
		this.setMostrarnumero_matriculaVehiculo(esInicial);
		this.setMostrarnumero_motorVehiculo(esInicial);
		this.setMostrarnumero_chasisVehiculo(esInicial);
		this.setMostrarnumero_placaVehiculo(esInicial);
		this.setMostrarvalor_comercialVehiculo(esInicial);
		this.setMostrardescripcionVehiculo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VehiculoConstantesFunciones.ID)) {
				this.setMostraridVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setMostrarid_detalle_activo_fijoVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDASEGURADORA)) {
				this.setMostrarid_aseguradoraVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROPOLIZA)) {
				this.setMostrarnumero_polizaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.VALORASEGURADO)) {
				this.setMostrarvalor_aseguradoVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.VALORDEDUCIBLE)) {
				this.setMostrarvalor_deducibleVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROMATRICULA)) {
				this.setMostrarnumero_matriculaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROMOTOR)) {
				this.setMostrarnumero_motorVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROCHASIS)) {
				this.setMostrarnumero_chasisVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROPLACA)) {
				this.setMostrarnumero_placaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.VALORCOMERCIAL)) {
				this.setMostrarvalor_comercialVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionVehiculo(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridVehiculo(esInicial);
		this.setActivarid_empresaVehiculo(esInicial);
		this.setActivarid_sucursalVehiculo(esInicial);
		this.setActivarid_detalle_activo_fijoVehiculo(esInicial);
		this.setActivarid_aseguradoraVehiculo(esInicial);
		this.setActivarnumero_polizaVehiculo(esInicial);
		this.setActivarfecha_emisionVehiculo(esInicial);
		this.setActivarfecha_vencimientoVehiculo(esInicial);
		this.setActivarvalor_aseguradoVehiculo(esInicial);
		this.setActivarvalor_deducibleVehiculo(esInicial);
		this.setActivarnumero_matriculaVehiculo(esInicial);
		this.setActivarnumero_motorVehiculo(esInicial);
		this.setActivarnumero_chasisVehiculo(esInicial);
		this.setActivarnumero_placaVehiculo(esInicial);
		this.setActivarvalor_comercialVehiculo(esInicial);
		this.setActivardescripcionVehiculo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VehiculoConstantesFunciones.ID)) {
				this.setActivaridVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setActivarid_detalle_activo_fijoVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDASEGURADORA)) {
				this.setActivarid_aseguradoraVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROPOLIZA)) {
				this.setActivarnumero_polizaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.VALORASEGURADO)) {
				this.setActivarvalor_aseguradoVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.VALORDEDUCIBLE)) {
				this.setActivarvalor_deducibleVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROMATRICULA)) {
				this.setActivarnumero_matriculaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROMOTOR)) {
				this.setActivarnumero_motorVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROCHASIS)) {
				this.setActivarnumero_chasisVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROPLACA)) {
				this.setActivarnumero_placaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.VALORCOMERCIAL)) {
				this.setActivarvalor_comercialVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionVehiculo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVehiculo(esInicial);
		this.setResaltarid_empresaVehiculo(esInicial);
		this.setResaltarid_sucursalVehiculo(esInicial);
		this.setResaltarid_detalle_activo_fijoVehiculo(esInicial);
		this.setResaltarid_aseguradoraVehiculo(esInicial);
		this.setResaltarnumero_polizaVehiculo(esInicial);
		this.setResaltarfecha_emisionVehiculo(esInicial);
		this.setResaltarfecha_vencimientoVehiculo(esInicial);
		this.setResaltarvalor_aseguradoVehiculo(esInicial);
		this.setResaltarvalor_deducibleVehiculo(esInicial);
		this.setResaltarnumero_matriculaVehiculo(esInicial);
		this.setResaltarnumero_motorVehiculo(esInicial);
		this.setResaltarnumero_chasisVehiculo(esInicial);
		this.setResaltarnumero_placaVehiculo(esInicial);
		this.setResaltarvalor_comercialVehiculo(esInicial);
		this.setResaltardescripcionVehiculo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VehiculoConstantesFunciones.ID)) {
				this.setResaltaridVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setResaltarid_detalle_activo_fijoVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.IDASEGURADORA)) {
				this.setResaltarid_aseguradoraVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROPOLIZA)) {
				this.setResaltarnumero_polizaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.VALORASEGURADO)) {
				this.setResaltarvalor_aseguradoVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.VALORDEDUCIBLE)) {
				this.setResaltarvalor_deducibleVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROMATRICULA)) {
				this.setResaltarnumero_matriculaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROMOTOR)) {
				this.setResaltarnumero_motorVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROCHASIS)) {
				this.setResaltarnumero_chasisVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.NUMEROPLACA)) {
				this.setResaltarnumero_placaVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.VALORCOMERCIAL)) {
				this.setResaltarvalor_comercialVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionVehiculo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarServicioTransporteVehiculo=null;

	public Border getResaltarServicioTransporteVehiculo() {
		return this.resaltarServicioTransporteVehiculo;
	}

	public void setResaltarServicioTransporteVehiculo(Border borderResaltarServicioTransporte) {
		if(borderResaltarServicioTransporte!=null) {
			this.resaltarServicioTransporteVehiculo= borderResaltarServicioTransporte;
		}
	}

	public Border setResaltarServicioTransporteVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltarServicioTransporte=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vehiculoBeanSwingJInternalFrame.jTtoolBarVehiculo.setBorder(borderResaltarServicioTransporte);
			
		this.resaltarServicioTransporteVehiculo= borderResaltarServicioTransporte;

		 return borderResaltarServicioTransporte;
	}



	public Boolean mostrarServicioTransporteVehiculo=true;

	public Boolean getMostrarServicioTransporteVehiculo() {
		return this.mostrarServicioTransporteVehiculo;
	}

	public void setMostrarServicioTransporteVehiculo(Boolean visibilidadResaltarServicioTransporte) {
		this.mostrarServicioTransporteVehiculo= visibilidadResaltarServicioTransporte;
	}



	public Boolean activarServicioTransporteVehiculo=true;

	public Boolean gethabilitarResaltarServicioTransporteVehiculo() {
		return this.activarServicioTransporteVehiculo;
	}

	public void setActivarServicioTransporteVehiculo(Boolean habilitarResaltarServicioTransporte) {
		this.activarServicioTransporteVehiculo= habilitarResaltarServicioTransporte;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarServicioTransporteVehiculo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ServicioTransporte.class)) {
				this.setMostrarServicioTransporteVehiculo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarServicioTransporteVehiculo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ServicioTransporte.class)) {
				this.setActivarServicioTransporteVehiculo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarServicioTransporteVehiculo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ServicioTransporte.class)) {
				this.setResaltarServicioTransporteVehiculo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAseguradoraVehiculo=true;

	public Boolean getMostrarFK_IdAseguradoraVehiculo() {
		return this.mostrarFK_IdAseguradoraVehiculo;
	}

	public void setMostrarFK_IdAseguradoraVehiculo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAseguradoraVehiculo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleActivoFijoVehiculo=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoVehiculo() {
		return this.mostrarFK_IdDetalleActivoFijoVehiculo;
	}

	public void setMostrarFK_IdDetalleActivoFijoVehiculo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoVehiculo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaVehiculo=true;

	public Boolean getMostrarFK_IdEmpresaVehiculo() {
		return this.mostrarFK_IdEmpresaVehiculo;
	}

	public void setMostrarFK_IdEmpresaVehiculo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVehiculo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalVehiculo=true;

	public Boolean getMostrarFK_IdSucursalVehiculo() {
		return this.mostrarFK_IdSucursalVehiculo;
	}

	public void setMostrarFK_IdSucursalVehiculo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalVehiculo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAseguradoraVehiculo=true;

	public Boolean getActivarFK_IdAseguradoraVehiculo() {
		return this.activarFK_IdAseguradoraVehiculo;
	}

	public void setActivarFK_IdAseguradoraVehiculo(Boolean habilitarResaltar) {
		this.activarFK_IdAseguradoraVehiculo= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleActivoFijoVehiculo=true;

	public Boolean getActivarFK_IdDetalleActivoFijoVehiculo() {
		return this.activarFK_IdDetalleActivoFijoVehiculo;
	}

	public void setActivarFK_IdDetalleActivoFijoVehiculo(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoVehiculo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaVehiculo=true;

	public Boolean getActivarFK_IdEmpresaVehiculo() {
		return this.activarFK_IdEmpresaVehiculo;
	}

	public void setActivarFK_IdEmpresaVehiculo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVehiculo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalVehiculo=true;

	public Boolean getActivarFK_IdSucursalVehiculo() {
		return this.activarFK_IdSucursalVehiculo;
	}

	public void setActivarFK_IdSucursalVehiculo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalVehiculo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAseguradoraVehiculo=null;

	public Border getResaltarFK_IdAseguradoraVehiculo() {
		return this.resaltarFK_IdAseguradoraVehiculo;
	}

	public void setResaltarFK_IdAseguradoraVehiculo(Border borderResaltar) {
		this.resaltarFK_IdAseguradoraVehiculo= borderResaltar;
	}

	public void setResaltarFK_IdAseguradoraVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAseguradoraVehiculo= borderResaltar;
	}

	public Border resaltarFK_IdDetalleActivoFijoVehiculo=null;

	public Border getResaltarFK_IdDetalleActivoFijoVehiculo() {
		return this.resaltarFK_IdDetalleActivoFijoVehiculo;
	}

	public void setResaltarFK_IdDetalleActivoFijoVehiculo(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoVehiculo= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoVehiculo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaVehiculo=null;

	public Border getResaltarFK_IdEmpresaVehiculo() {
		return this.resaltarFK_IdEmpresaVehiculo;
	}

	public void setResaltarFK_IdEmpresaVehiculo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVehiculo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVehiculo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalVehiculo=null;

	public Border getResaltarFK_IdSucursalVehiculo() {
		return this.resaltarFK_IdSucursalVehiculo;
	}

	public void setResaltarFK_IdSucursalVehiculo(Border borderResaltar) {
		this.resaltarFK_IdSucursalVehiculo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoBeanSwingJInternalFrame vehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalVehiculo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}