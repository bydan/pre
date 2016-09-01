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
package com.bydan.erp.sris.util.report;

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


import com.bydan.erp.sris.util.report.GuardarIvasVentasConstantesFunciones;
import com.bydan.erp.sris.util.report.GuardarIvasVentasParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.GuardarIvasVentasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GuardarIvasVentasConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="GuardarIvasVentas";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GuardarIvasVentas"+GuardarIvasVentasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GuardarIvasVentasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GuardarIvasVentasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GuardarIvasVentasConstantesFunciones.SCHEMA+"_"+GuardarIvasVentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GuardarIvasVentasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GuardarIvasVentasConstantesFunciones.SCHEMA+"_"+GuardarIvasVentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GuardarIvasVentasConstantesFunciones.SCHEMA+"_"+GuardarIvasVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GuardarIvasVentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GuardarIvasVentasConstantesFunciones.SCHEMA+"_"+GuardarIvasVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuardarIvasVentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GuardarIvasVentasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuardarIvasVentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuardarIvasVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GuardarIvasVentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuardarIvasVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GuardarIvasVentasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GuardarIvasVentasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GuardarIvasVentasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GuardarIvasVentasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Guardar Ivas Ventases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Guardar Ivas Ventas";
	public static final String SCLASSWEBTITULO_LOWER="Guardar Ivas Ventas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GuardarIvasVentas";
	public static final String OBJECTNAME="guardarivasventas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="guardar_ivas_ventas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select guardarivasventas from "+GuardarIvasVentasConstantesFunciones.SPERSISTENCENAME+" guardarivasventas";
	public static String QUERYSELECTNATIVE="select "+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".id,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".version_row,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".id_empresa,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".id_ejercicio,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".id_periodo,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente_iva,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".codigo_estado_asiento_contable,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".nombre_periodo,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".nombre_tipo_retencion_fuente_iva,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".porcentaje,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".base_imponible,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".valor,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".numero,"+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME+".ruc_benef from "+GuardarIvasVentasConstantesFunciones.SCHEMA+"."+GuardarIvasVentasConstantesFunciones.TABLENAME;//+" as "+GuardarIvasVentasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDTIPORETENCIONFUENTEIVA= "id_tipo_retencion_fuente_iva";
    public static final String CODIGOESTADOASIENTOCONTABLE= "codigo_estado_asiento_contable";
    public static final String NOMBREPERIODO= "nombre_periodo";
    public static final String NOMBRETIPORETENCIONFUENTEIVA= "nombre_tipo_retencion_fuente_iva";
    public static final String PORCENTAJE= "porcentaje";
    public static final String BASEIMPONIBLE= "base_imponible";
    public static final String VALOR= "valor";
    public static final String NUMERO= "numero";
    public static final String RUCBENEF= "ruc_benef";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDTIPORETENCIONFUENTEIVA= "Tipo Retencion Fuente Iva";
		public static final String LABEL_IDTIPORETENCIONFUENTEIVA_LOWER= "Tipo Retencion Fuente Iva";
    	public static final String LABEL_CODIGOESTADOASIENTOCONTABLE= "Codigo Estado Asiento Contable";
		public static final String LABEL_CODIGOESTADOASIENTOCONTABLE_LOWER= "Codigo Estado Asiento Contable";
    	public static final String LABEL_NOMBREPERIODO= "Nombre Periodo";
		public static final String LABEL_NOMBREPERIODO_LOWER= "Nombre Periodo";
    	public static final String LABEL_NOMBRETIPORETENCIONFUENTEIVA= "Nombre Tipo Retencion Fuente Iva";
		public static final String LABEL_NOMBRETIPORETENCIONFUENTEIVA_LOWER= "Nombre Tipo Retencion Fuente Iva";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_BASEIMPONIBLE= "Base Imponible";
		public static final String LABEL_BASEIMPONIBLE_LOWER= "Base Imponible";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_RUCBENEF= "Ruc Benef";
		public static final String LABEL_RUCBENEF_LOWER= "Ruc Benef";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO_ESTADO_ASIENTO_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ESTADO_ASIENTO_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PERIODO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PERIODO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_RETENCION_FUENTE_IVA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_RETENCION_FUENTE_IVA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getGuardarIvasVentasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.IDEMPRESA)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.IDEJERCICIO)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.IDPERIODO)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.IDTIPORETENCIONFUENTEIVA)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_IDTIPORETENCIONFUENTEIVA;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.CODIGOESTADOASIENTOCONTABLE)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_CODIGOESTADOASIENTOCONTABLE;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.NOMBREPERIODO)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_NOMBREPERIODO;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.NOMBRETIPORETENCIONFUENTEIVA)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTEIVA;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.PORCENTAJE)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_BASEIMPONIBLE;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.VALOR)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.NUMERO)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(GuardarIvasVentasConstantesFunciones.RUCBENEF)) {sLabelColumna=GuardarIvasVentasConstantesFunciones.LABEL_RUCBENEF;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getGuardarIvasVentasDescripcion(GuardarIvasVentas guardarivasventas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(guardarivasventas !=null/* && guardarivasventas.getId()!=0*/) {
			if(guardarivasventas.getId()!=null) {
				sDescripcion=guardarivasventas.getId().toString();
			}//guardarivasventasguardarivasventas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getGuardarIvasVentasDescripcionDetallado(GuardarIvasVentas guardarivasventas) {
		String sDescripcion="";
			
		sDescripcion+=GuardarIvasVentasConstantesFunciones.ID+"=";
		sDescripcion+=guardarivasventas.getId().toString()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=guardarivasventas.getVersionRow().toString()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=guardarivasventas.getid_empresa().toString()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=guardarivasventas.getid_ejercicio().toString()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=guardarivasventas.getid_periodo().toString()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.IDTIPORETENCIONFUENTEIVA+"=";
		sDescripcion+=guardarivasventas.getid_tipo_retencion_fuente_iva().toString()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.CODIGOESTADOASIENTOCONTABLE+"=";
		sDescripcion+=guardarivasventas.getcodigo_estado_asiento_contable()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.NOMBREPERIODO+"=";
		sDescripcion+=guardarivasventas.getnombre_periodo()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.NOMBRETIPORETENCIONFUENTEIVA+"=";
		sDescripcion+=guardarivasventas.getnombre_tipo_retencion_fuente_iva()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=guardarivasventas.getporcentaje().toString()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE+"=";
		sDescripcion+=guardarivasventas.getbase_imponible().toString()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.VALOR+"=";
		sDescripcion+=guardarivasventas.getvalor().toString()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.NUMERO+"=";
		sDescripcion+=guardarivasventas.getnumero()+",";
		sDescripcion+=GuardarIvasVentasConstantesFunciones.RUCBENEF+"=";
		sDescripcion+=guardarivasventas.getruc_benef()+",";
			
		return sDescripcion;
	}
	
	public static void setGuardarIvasVentasDescripcion(GuardarIvasVentas guardarivasventas,String sValor) throws Exception {			
		if(guardarivasventas !=null) {
			//guardarivasventasguardarivasventas.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionFuenteIvaDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaGuardarIvasVentas")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo Por Tipo Retencion Fuente Iva";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionFuenteIva")) {
			sNombreIndice="Tipo=  Por Tipo Retencion Fuente Iva";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaGuardarIvasVentas(Long id_ejercicio,Long id_periodo,Long id_tipo_retencion_fuente_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();}
		if(id_tipo_retencion_fuente_iva!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion Fuente Iva="+id_tipo_retencion_fuente_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionFuenteIva(Long id_tipo_retencion_fuente_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_fuente_iva!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion Fuente Iva="+id_tipo_retencion_fuente_iva.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGuardarIvasVentas(GuardarIvasVentas guardarivasventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		guardarivasventas.setcodigo_estado_asiento_contable(guardarivasventas.getcodigo_estado_asiento_contable().trim());
		guardarivasventas.setnombre_periodo(guardarivasventas.getnombre_periodo().trim());
		guardarivasventas.setnombre_tipo_retencion_fuente_iva(guardarivasventas.getnombre_tipo_retencion_fuente_iva().trim());
		guardarivasventas.setnumero(guardarivasventas.getnumero().trim());
		guardarivasventas.setruc_benef(guardarivasventas.getruc_benef().trim());
	}
	
	public static void quitarEspaciosGuardarIvasVentass(List<GuardarIvasVentas> guardarivasventass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GuardarIvasVentas guardarivasventas: guardarivasventass) {
			guardarivasventas.setcodigo_estado_asiento_contable(guardarivasventas.getcodigo_estado_asiento_contable().trim());
			guardarivasventas.setnombre_periodo(guardarivasventas.getnombre_periodo().trim());
			guardarivasventas.setnombre_tipo_retencion_fuente_iva(guardarivasventas.getnombre_tipo_retencion_fuente_iva().trim());
			guardarivasventas.setnumero(guardarivasventas.getnumero().trim());
			guardarivasventas.setruc_benef(guardarivasventas.getruc_benef().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGuardarIvasVentas(GuardarIvasVentas guardarivasventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && guardarivasventas.getConCambioAuxiliar()) {
			guardarivasventas.setIsDeleted(guardarivasventas.getIsDeletedAuxiliar());	
			guardarivasventas.setIsNew(guardarivasventas.getIsNewAuxiliar());	
			guardarivasventas.setIsChanged(guardarivasventas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			guardarivasventas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			guardarivasventas.setIsDeletedAuxiliar(false);	
			guardarivasventas.setIsNewAuxiliar(false);	
			guardarivasventas.setIsChangedAuxiliar(false);
			
			guardarivasventas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGuardarIvasVentass(List<GuardarIvasVentas> guardarivasventass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GuardarIvasVentas guardarivasventas : guardarivasventass) {
			if(conAsignarBase && guardarivasventas.getConCambioAuxiliar()) {
				guardarivasventas.setIsDeleted(guardarivasventas.getIsDeletedAuxiliar());	
				guardarivasventas.setIsNew(guardarivasventas.getIsNewAuxiliar());	
				guardarivasventas.setIsChanged(guardarivasventas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				guardarivasventas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				guardarivasventas.setIsDeletedAuxiliar(false);	
				guardarivasventas.setIsNewAuxiliar(false);	
				guardarivasventas.setIsChangedAuxiliar(false);
				
				guardarivasventas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGuardarIvasVentas(GuardarIvasVentas guardarivasventas,Boolean conEnteros) throws Exception  {
		guardarivasventas.setporcentaje(0.0);
		guardarivasventas.setbase_imponible(0.0);
		guardarivasventas.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGuardarIvasVentass(List<GuardarIvasVentas> guardarivasventass,Boolean conEnteros) throws Exception  {
		
		for(GuardarIvasVentas guardarivasventas: guardarivasventass) {
			guardarivasventas.setporcentaje(0.0);
			guardarivasventas.setbase_imponible(0.0);
			guardarivasventas.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGuardarIvasVentas(List<GuardarIvasVentas> guardarivasventass,GuardarIvasVentas guardarivasventasAux) throws Exception  {
		GuardarIvasVentasConstantesFunciones.InicializarValoresGuardarIvasVentas(guardarivasventasAux,true);
		
		for(GuardarIvasVentas guardarivasventas: guardarivasventass) {
			if(guardarivasventas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			guardarivasventasAux.setporcentaje(guardarivasventasAux.getporcentaje()+guardarivasventas.getporcentaje());			
			guardarivasventasAux.setbase_imponible(guardarivasventasAux.getbase_imponible()+guardarivasventas.getbase_imponible());			
			guardarivasventasAux.setvalor(guardarivasventasAux.getvalor()+guardarivasventas.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGuardarIvasVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GuardarIvasVentasConstantesFunciones.getArrayColumnasGlobalesGuardarIvasVentas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGuardarIvasVentas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuardarIvasVentasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuardarIvasVentasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuardarIvasVentasConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuardarIvasVentasConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuardarIvasVentasConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuardarIvasVentasConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGuardarIvasVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GuardarIvasVentas> guardarivasventass,GuardarIvasVentas guardarivasventas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GuardarIvasVentas guardarivasventasAux: guardarivasventass) {
			if(guardarivasventasAux!=null && guardarivasventas!=null) {
				if((guardarivasventasAux.getId()==null && guardarivasventas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(guardarivasventasAux.getId()!=null && guardarivasventas.getId()!=null){
					if(guardarivasventasAux.getId().equals(guardarivasventas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGuardarIvasVentas(List<GuardarIvasVentas> guardarivasventass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double valorTotal=0.0;
	
		for(GuardarIvasVentas guardarivasventas: guardarivasventass) {			
			if(guardarivasventas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=guardarivasventas.getporcentaje();
			base_imponibleTotal+=guardarivasventas.getbase_imponible();
			valorTotal+=guardarivasventas.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuardarIvasVentasConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuardarIvasVentasConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGuardarIvasVentas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_ID, GuardarIvasVentasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_VERSIONROW, GuardarIvasVentasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_CODIGOESTADOASIENTOCONTABLE, GuardarIvasVentasConstantesFunciones.CODIGOESTADOASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_NOMBREPERIODO, GuardarIvasVentasConstantesFunciones.NOMBREPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTEIVA, GuardarIvasVentasConstantesFunciones.NOMBRETIPORETENCIONFUENTEIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_PORCENTAJE, GuardarIvasVentasConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_BASEIMPONIBLE, GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_VALOR, GuardarIvasVentasConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_NUMERO, GuardarIvasVentasConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuardarIvasVentasConstantesFunciones.LABEL_RUCBENEF, GuardarIvasVentasConstantesFunciones.RUCBENEF,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGuardarIvasVentas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.CODIGOESTADOASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.NOMBREPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.NOMBRETIPORETENCIONFUENTEIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuardarIvasVentasConstantesFunciones.RUCBENEF;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGuardarIvasVentas() throws Exception  {
		return GuardarIvasVentasConstantesFunciones.getTiposSeleccionarGuardarIvasVentas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGuardarIvasVentas(Boolean conFk) throws Exception  {
		return GuardarIvasVentasConstantesFunciones.getTiposSeleccionarGuardarIvasVentas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGuardarIvasVentas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_IDTIPORETENCIONFUENTEIVA);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_IDTIPORETENCIONFUENTEIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_CODIGOESTADOASIENTOCONTABLE);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_CODIGOESTADOASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_NOMBREPERIODO);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_NOMBREPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTEIVA);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTEIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_BASEIMPONIBLE);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_BASEIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuardarIvasVentasConstantesFunciones.LABEL_RUCBENEF);
			reporte.setsDescripcion(GuardarIvasVentasConstantesFunciones.LABEL_RUCBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGuardarIvasVentas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGuardarIvasVentas(GuardarIvasVentas guardarivasventasAux) throws Exception {
		
			guardarivasventasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(guardarivasventasAux.getEmpresa()));
			guardarivasventasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(guardarivasventasAux.getEjercicio()));
			guardarivasventasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(guardarivasventasAux.getPeriodo()));
			guardarivasventasAux.settiporetencionfuenteiva_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(guardarivasventasAux.getTipoRetencionFuenteIva()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGuardarIvasVentas(List<GuardarIvasVentas> guardarivasventassTemp) throws Exception {
		for(GuardarIvasVentas guardarivasventasAux:guardarivasventassTemp) {
			
			guardarivasventasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(guardarivasventasAux.getEmpresa()));
			guardarivasventasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(guardarivasventasAux.getEjercicio()));
			guardarivasventasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(guardarivasventasAux.getPeriodo()));
			guardarivasventasAux.settiporetencionfuenteiva_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(guardarivasventasAux.getTipoRetencionFuenteIva()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGuardarIvasVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(TipoRetencion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGuardarIvasVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGuardarIvasVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GuardarIvasVentasConstantesFunciones.getClassesRelationshipsOfGuardarIvasVentas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGuardarIvasVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGuardarIvasVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GuardarIvasVentasConstantesFunciones.getClassesRelationshipsFromStringsOfGuardarIvasVentas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGuardarIvasVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(GuardarIvasVentas guardarivasventas,List<GuardarIvasVentas> guardarivasventass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(GuardarIvasVentas guardarivasventas,List<GuardarIvasVentas> guardarivasventass) throws Exception {
		try	{			
			for(GuardarIvasVentas guardarivasventasLocal:guardarivasventass) {
				if(guardarivasventasLocal.getId().equals(guardarivasventas.getId())) {
					guardarivasventasLocal.setIsSelected(guardarivasventas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGuardarIvasVentas(List<GuardarIvasVentas> guardarivasventassAux) throws Exception {
		//this.guardarivasventassAux=guardarivasventassAux;
		
		for(GuardarIvasVentas guardarivasventasAux:guardarivasventassAux) {
			if(guardarivasventasAux.getIsChanged()) {
				guardarivasventasAux.setIsChanged(false);
			}		
			
			if(guardarivasventasAux.getIsNew()) {
				guardarivasventasAux.setIsNew(false);
			}	
			
			if(guardarivasventasAux.getIsDeleted()) {
				guardarivasventasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGuardarIvasVentas(GuardarIvasVentas guardarivasventasAux) throws Exception {
		//this.guardarivasventasAux=guardarivasventasAux;
		
			if(guardarivasventasAux.getIsChanged()) {
				guardarivasventasAux.setIsChanged(false);
			}		
			
			if(guardarivasventasAux.getIsNew()) {
				guardarivasventasAux.setIsNew(false);
			}	
			
			if(guardarivasventasAux.getIsDeleted()) {
				guardarivasventasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GuardarIvasVentas guardarivasventasAsignar,GuardarIvasVentas guardarivasventas) throws Exception {
		guardarivasventasAsignar.setId(guardarivasventas.getId());	
		guardarivasventasAsignar.setVersionRow(guardarivasventas.getVersionRow());	
		guardarivasventasAsignar.setcodigo_estado_asiento_contable(guardarivasventas.getcodigo_estado_asiento_contable());	
		guardarivasventasAsignar.setnombre_periodo(guardarivasventas.getnombre_periodo());	
		guardarivasventasAsignar.setnombre_tipo_retencion_fuente_iva(guardarivasventas.getnombre_tipo_retencion_fuente_iva());	
		guardarivasventasAsignar.setporcentaje(guardarivasventas.getporcentaje());	
		guardarivasventasAsignar.setbase_imponible(guardarivasventas.getbase_imponible());	
		guardarivasventasAsignar.setvalor(guardarivasventas.getvalor());	
		guardarivasventasAsignar.setnumero(guardarivasventas.getnumero());	
		guardarivasventasAsignar.setruc_benef(guardarivasventas.getruc_benef());	
	}
	
	public static void inicializarGuardarIvasVentas(GuardarIvasVentas guardarivasventas) throws Exception {
		try {
				guardarivasventas.setId(0L);	
					
				guardarivasventas.setcodigo_estado_asiento_contable("");	
				guardarivasventas.setnombre_periodo("");	
				guardarivasventas.setnombre_tipo_retencion_fuente_iva("");	
				guardarivasventas.setporcentaje(0.0);	
				guardarivasventas.setbase_imponible(0.0);	
				guardarivasventas.setvalor(0.0);	
				guardarivasventas.setnumero("");	
				guardarivasventas.setruc_benef("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGuardarIvasVentas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_IDTIPORETENCIONFUENTEIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_CODIGOESTADOASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_NOMBREPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_NOMBRETIPORETENCIONFUENTEIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_BASEIMPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuardarIvasVentasConstantesFunciones.LABEL_RUCBENEF);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGuardarIvasVentas(String sTipo,Row row,Workbook workbook,GuardarIvasVentas guardarivasventas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.gettiporetencionfuenteiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getcodigo_estado_asiento_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getnombre_periodo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getnombre_tipo_retencion_fuente_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getbase_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guardarivasventas.getruc_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGuardarIvasVentas="";
	
	public String getsFinalQueryGuardarIvasVentas() {
		return this.sFinalQueryGuardarIvasVentas;
	}
	
	public void setsFinalQueryGuardarIvasVentas(String sFinalQueryGuardarIvasVentas) {
		this.sFinalQueryGuardarIvasVentas= sFinalQueryGuardarIvasVentas;
	}
	
	public Border resaltarSeleccionarGuardarIvasVentas=null;
	
	public Border setResaltarSeleccionarGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGuardarIvasVentas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGuardarIvasVentas() {
		return this.resaltarSeleccionarGuardarIvasVentas;
	}
	
	public void setResaltarSeleccionarGuardarIvasVentas(Border borderResaltarSeleccionarGuardarIvasVentas) {
		this.resaltarSeleccionarGuardarIvasVentas= borderResaltarSeleccionarGuardarIvasVentas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGuardarIvasVentas=null;
	public Boolean mostraridGuardarIvasVentas=true;
	public Boolean activaridGuardarIvasVentas=true;

	public Border resaltarid_empresaGuardarIvasVentas=null;
	public Boolean mostrarid_empresaGuardarIvasVentas=true;
	public Boolean activarid_empresaGuardarIvasVentas=true;
	public Boolean cargarid_empresaGuardarIvasVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGuardarIvasVentas=false;//ConEventDepend=true

	public Border resaltarid_ejercicioGuardarIvasVentas=null;
	public Boolean mostrarid_ejercicioGuardarIvasVentas=true;
	public Boolean activarid_ejercicioGuardarIvasVentas=true;
	public Boolean cargarid_ejercicioGuardarIvasVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioGuardarIvasVentas=false;//ConEventDepend=true

	public Border resaltarid_periodoGuardarIvasVentas=null;
	public Boolean mostrarid_periodoGuardarIvasVentas=true;
	public Boolean activarid_periodoGuardarIvasVentas=true;
	public Boolean cargarid_periodoGuardarIvasVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoGuardarIvasVentas=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_fuente_ivaGuardarIvasVentas=null;
	public Boolean mostrarid_tipo_retencion_fuente_ivaGuardarIvasVentas=true;
	public Boolean activarid_tipo_retencion_fuente_ivaGuardarIvasVentas=true;
	public Boolean cargarid_tipo_retencion_fuente_ivaGuardarIvasVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_fuente_ivaGuardarIvasVentas=false;//ConEventDepend=true

	public Border resaltarcodigo_estado_asiento_contableGuardarIvasVentas=null;
	public Boolean mostrarcodigo_estado_asiento_contableGuardarIvasVentas=true;
	public Boolean activarcodigo_estado_asiento_contableGuardarIvasVentas=true;

	public Border resaltarnombre_periodoGuardarIvasVentas=null;
	public Boolean mostrarnombre_periodoGuardarIvasVentas=true;
	public Boolean activarnombre_periodoGuardarIvasVentas=true;

	public Border resaltarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas=null;
	public Boolean mostrarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas=true;
	public Boolean activarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas=true;

	public Border resaltarporcentajeGuardarIvasVentas=null;
	public Boolean mostrarporcentajeGuardarIvasVentas=true;
	public Boolean activarporcentajeGuardarIvasVentas=true;

	public Border resaltarbase_imponibleGuardarIvasVentas=null;
	public Boolean mostrarbase_imponibleGuardarIvasVentas=true;
	public Boolean activarbase_imponibleGuardarIvasVentas=true;

	public Border resaltarvalorGuardarIvasVentas=null;
	public Boolean mostrarvalorGuardarIvasVentas=true;
	public Boolean activarvalorGuardarIvasVentas=true;

	public Border resaltarnumeroGuardarIvasVentas=null;
	public Boolean mostrarnumeroGuardarIvasVentas=true;
	public Boolean activarnumeroGuardarIvasVentas=true;

	public Border resaltarruc_benefGuardarIvasVentas=null;
	public Boolean mostrarruc_benefGuardarIvasVentas=true;
	public Boolean activarruc_benefGuardarIvasVentas=true;

	
	

	public Border setResaltaridGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltaridGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGuardarIvasVentas() {
		return this.resaltaridGuardarIvasVentas;
	}

	public void setResaltaridGuardarIvasVentas(Border borderResaltar) {
		this.resaltaridGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostraridGuardarIvasVentas() {
		return this.mostraridGuardarIvasVentas;
	}

	public void setMostraridGuardarIvasVentas(Boolean mostraridGuardarIvasVentas) {
		this.mostraridGuardarIvasVentas= mostraridGuardarIvasVentas;
	}

	public Boolean getActivaridGuardarIvasVentas() {
		return this.activaridGuardarIvasVentas;
	}

	public void setActivaridGuardarIvasVentas(Boolean activaridGuardarIvasVentas) {
		this.activaridGuardarIvasVentas= activaridGuardarIvasVentas;
	}

	public Border setResaltarid_empresaGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarid_empresaGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGuardarIvasVentas() {
		return this.resaltarid_empresaGuardarIvasVentas;
	}

	public void setResaltarid_empresaGuardarIvasVentas(Border borderResaltar) {
		this.resaltarid_empresaGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarid_empresaGuardarIvasVentas() {
		return this.mostrarid_empresaGuardarIvasVentas;
	}

	public void setMostrarid_empresaGuardarIvasVentas(Boolean mostrarid_empresaGuardarIvasVentas) {
		this.mostrarid_empresaGuardarIvasVentas= mostrarid_empresaGuardarIvasVentas;
	}

	public Boolean getActivarid_empresaGuardarIvasVentas() {
		return this.activarid_empresaGuardarIvasVentas;
	}

	public void setActivarid_empresaGuardarIvasVentas(Boolean activarid_empresaGuardarIvasVentas) {
		this.activarid_empresaGuardarIvasVentas= activarid_empresaGuardarIvasVentas;
	}

	public Boolean getCargarid_empresaGuardarIvasVentas() {
		return this.cargarid_empresaGuardarIvasVentas;
	}

	public void setCargarid_empresaGuardarIvasVentas(Boolean cargarid_empresaGuardarIvasVentas) {
		this.cargarid_empresaGuardarIvasVentas= cargarid_empresaGuardarIvasVentas;
	}

	public Border setResaltarid_ejercicioGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioGuardarIvasVentas() {
		return this.resaltarid_ejercicioGuardarIvasVentas;
	}

	public void setResaltarid_ejercicioGuardarIvasVentas(Border borderResaltar) {
		this.resaltarid_ejercicioGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioGuardarIvasVentas() {
		return this.mostrarid_ejercicioGuardarIvasVentas;
	}

	public void setMostrarid_ejercicioGuardarIvasVentas(Boolean mostrarid_ejercicioGuardarIvasVentas) {
		this.mostrarid_ejercicioGuardarIvasVentas= mostrarid_ejercicioGuardarIvasVentas;
	}

	public Boolean getActivarid_ejercicioGuardarIvasVentas() {
		return this.activarid_ejercicioGuardarIvasVentas;
	}

	public void setActivarid_ejercicioGuardarIvasVentas(Boolean activarid_ejercicioGuardarIvasVentas) {
		this.activarid_ejercicioGuardarIvasVentas= activarid_ejercicioGuardarIvasVentas;
	}

	public Boolean getCargarid_ejercicioGuardarIvasVentas() {
		return this.cargarid_ejercicioGuardarIvasVentas;
	}

	public void setCargarid_ejercicioGuardarIvasVentas(Boolean cargarid_ejercicioGuardarIvasVentas) {
		this.cargarid_ejercicioGuardarIvasVentas= cargarid_ejercicioGuardarIvasVentas;
	}

	public Border setResaltarid_periodoGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarid_periodoGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoGuardarIvasVentas() {
		return this.resaltarid_periodoGuardarIvasVentas;
	}

	public void setResaltarid_periodoGuardarIvasVentas(Border borderResaltar) {
		this.resaltarid_periodoGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarid_periodoGuardarIvasVentas() {
		return this.mostrarid_periodoGuardarIvasVentas;
	}

	public void setMostrarid_periodoGuardarIvasVentas(Boolean mostrarid_periodoGuardarIvasVentas) {
		this.mostrarid_periodoGuardarIvasVentas= mostrarid_periodoGuardarIvasVentas;
	}

	public Boolean getActivarid_periodoGuardarIvasVentas() {
		return this.activarid_periodoGuardarIvasVentas;
	}

	public void setActivarid_periodoGuardarIvasVentas(Boolean activarid_periodoGuardarIvasVentas) {
		this.activarid_periodoGuardarIvasVentas= activarid_periodoGuardarIvasVentas;
	}

	public Boolean getCargarid_periodoGuardarIvasVentas() {
		return this.cargarid_periodoGuardarIvasVentas;
	}

	public void setCargarid_periodoGuardarIvasVentas(Boolean cargarid_periodoGuardarIvasVentas) {
		this.cargarid_periodoGuardarIvasVentas= cargarid_periodoGuardarIvasVentas;
	}

	public Border setResaltarid_tipo_retencion_fuente_ivaGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_fuente_ivaGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_fuente_ivaGuardarIvasVentas() {
		return this.resaltarid_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public void setResaltarid_tipo_retencion_fuente_ivaGuardarIvasVentas(Border borderResaltar) {
		this.resaltarid_tipo_retencion_fuente_ivaGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_fuente_ivaGuardarIvasVentas() {
		return this.mostrarid_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public void setMostrarid_tipo_retencion_fuente_ivaGuardarIvasVentas(Boolean mostrarid_tipo_retencion_fuente_ivaGuardarIvasVentas) {
		this.mostrarid_tipo_retencion_fuente_ivaGuardarIvasVentas= mostrarid_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public Boolean getActivarid_tipo_retencion_fuente_ivaGuardarIvasVentas() {
		return this.activarid_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public void setActivarid_tipo_retencion_fuente_ivaGuardarIvasVentas(Boolean activarid_tipo_retencion_fuente_ivaGuardarIvasVentas) {
		this.activarid_tipo_retencion_fuente_ivaGuardarIvasVentas= activarid_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public Boolean getCargarid_tipo_retencion_fuente_ivaGuardarIvasVentas() {
		return this.cargarid_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public void setCargarid_tipo_retencion_fuente_ivaGuardarIvasVentas(Boolean cargarid_tipo_retencion_fuente_ivaGuardarIvasVentas) {
		this.cargarid_tipo_retencion_fuente_ivaGuardarIvasVentas= cargarid_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public Border setResaltarcodigo_estado_asiento_contableGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarcodigo_estado_asiento_contableGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_estado_asiento_contableGuardarIvasVentas() {
		return this.resaltarcodigo_estado_asiento_contableGuardarIvasVentas;
	}

	public void setResaltarcodigo_estado_asiento_contableGuardarIvasVentas(Border borderResaltar) {
		this.resaltarcodigo_estado_asiento_contableGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarcodigo_estado_asiento_contableGuardarIvasVentas() {
		return this.mostrarcodigo_estado_asiento_contableGuardarIvasVentas;
	}

	public void setMostrarcodigo_estado_asiento_contableGuardarIvasVentas(Boolean mostrarcodigo_estado_asiento_contableGuardarIvasVentas) {
		this.mostrarcodigo_estado_asiento_contableGuardarIvasVentas= mostrarcodigo_estado_asiento_contableGuardarIvasVentas;
	}

	public Boolean getActivarcodigo_estado_asiento_contableGuardarIvasVentas() {
		return this.activarcodigo_estado_asiento_contableGuardarIvasVentas;
	}

	public void setActivarcodigo_estado_asiento_contableGuardarIvasVentas(Boolean activarcodigo_estado_asiento_contableGuardarIvasVentas) {
		this.activarcodigo_estado_asiento_contableGuardarIvasVentas= activarcodigo_estado_asiento_contableGuardarIvasVentas;
	}

	public Border setResaltarnombre_periodoGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarnombre_periodoGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_periodoGuardarIvasVentas() {
		return this.resaltarnombre_periodoGuardarIvasVentas;
	}

	public void setResaltarnombre_periodoGuardarIvasVentas(Border borderResaltar) {
		this.resaltarnombre_periodoGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarnombre_periodoGuardarIvasVentas() {
		return this.mostrarnombre_periodoGuardarIvasVentas;
	}

	public void setMostrarnombre_periodoGuardarIvasVentas(Boolean mostrarnombre_periodoGuardarIvasVentas) {
		this.mostrarnombre_periodoGuardarIvasVentas= mostrarnombre_periodoGuardarIvasVentas;
	}

	public Boolean getActivarnombre_periodoGuardarIvasVentas() {
		return this.activarnombre_periodoGuardarIvasVentas;
	}

	public void setActivarnombre_periodoGuardarIvasVentas(Boolean activarnombre_periodoGuardarIvasVentas) {
		this.activarnombre_periodoGuardarIvasVentas= activarnombre_periodoGuardarIvasVentas;
	}

	public Border setResaltarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas() {
		return this.resaltarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public void setResaltarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(Border borderResaltar) {
		this.resaltarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas() {
		return this.mostrarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public void setMostrarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(Boolean mostrarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas) {
		this.mostrarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas= mostrarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public Boolean getActivarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas() {
		return this.activarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public void setActivarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(Boolean activarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas) {
		this.activarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas= activarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas;
	}

	public Border setResaltarporcentajeGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarporcentajeGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeGuardarIvasVentas() {
		return this.resaltarporcentajeGuardarIvasVentas;
	}

	public void setResaltarporcentajeGuardarIvasVentas(Border borderResaltar) {
		this.resaltarporcentajeGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarporcentajeGuardarIvasVentas() {
		return this.mostrarporcentajeGuardarIvasVentas;
	}

	public void setMostrarporcentajeGuardarIvasVentas(Boolean mostrarporcentajeGuardarIvasVentas) {
		this.mostrarporcentajeGuardarIvasVentas= mostrarporcentajeGuardarIvasVentas;
	}

	public Boolean getActivarporcentajeGuardarIvasVentas() {
		return this.activarporcentajeGuardarIvasVentas;
	}

	public void setActivarporcentajeGuardarIvasVentas(Boolean activarporcentajeGuardarIvasVentas) {
		this.activarporcentajeGuardarIvasVentas= activarporcentajeGuardarIvasVentas;
	}

	public Border setResaltarbase_imponibleGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarbase_imponibleGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponibleGuardarIvasVentas() {
		return this.resaltarbase_imponibleGuardarIvasVentas;
	}

	public void setResaltarbase_imponibleGuardarIvasVentas(Border borderResaltar) {
		this.resaltarbase_imponibleGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarbase_imponibleGuardarIvasVentas() {
		return this.mostrarbase_imponibleGuardarIvasVentas;
	}

	public void setMostrarbase_imponibleGuardarIvasVentas(Boolean mostrarbase_imponibleGuardarIvasVentas) {
		this.mostrarbase_imponibleGuardarIvasVentas= mostrarbase_imponibleGuardarIvasVentas;
	}

	public Boolean getActivarbase_imponibleGuardarIvasVentas() {
		return this.activarbase_imponibleGuardarIvasVentas;
	}

	public void setActivarbase_imponibleGuardarIvasVentas(Boolean activarbase_imponibleGuardarIvasVentas) {
		this.activarbase_imponibleGuardarIvasVentas= activarbase_imponibleGuardarIvasVentas;
	}

	public Border setResaltarvalorGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarvalorGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorGuardarIvasVentas() {
		return this.resaltarvalorGuardarIvasVentas;
	}

	public void setResaltarvalorGuardarIvasVentas(Border borderResaltar) {
		this.resaltarvalorGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarvalorGuardarIvasVentas() {
		return this.mostrarvalorGuardarIvasVentas;
	}

	public void setMostrarvalorGuardarIvasVentas(Boolean mostrarvalorGuardarIvasVentas) {
		this.mostrarvalorGuardarIvasVentas= mostrarvalorGuardarIvasVentas;
	}

	public Boolean getActivarvalorGuardarIvasVentas() {
		return this.activarvalorGuardarIvasVentas;
	}

	public void setActivarvalorGuardarIvasVentas(Boolean activarvalorGuardarIvasVentas) {
		this.activarvalorGuardarIvasVentas= activarvalorGuardarIvasVentas;
	}

	public Border setResaltarnumeroGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarnumeroGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroGuardarIvasVentas() {
		return this.resaltarnumeroGuardarIvasVentas;
	}

	public void setResaltarnumeroGuardarIvasVentas(Border borderResaltar) {
		this.resaltarnumeroGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarnumeroGuardarIvasVentas() {
		return this.mostrarnumeroGuardarIvasVentas;
	}

	public void setMostrarnumeroGuardarIvasVentas(Boolean mostrarnumeroGuardarIvasVentas) {
		this.mostrarnumeroGuardarIvasVentas= mostrarnumeroGuardarIvasVentas;
	}

	public Boolean getActivarnumeroGuardarIvasVentas() {
		return this.activarnumeroGuardarIvasVentas;
	}

	public void setActivarnumeroGuardarIvasVentas(Boolean activarnumeroGuardarIvasVentas) {
		this.activarnumeroGuardarIvasVentas= activarnumeroGuardarIvasVentas;
	}

	public Border setResaltarruc_benefGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guardarivasventasBeanSwingJInternalFrame.jTtoolBarGuardarIvasVentas.setBorder(borderResaltar);
		
		this.resaltarruc_benefGuardarIvasVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_benefGuardarIvasVentas() {
		return this.resaltarruc_benefGuardarIvasVentas;
	}

	public void setResaltarruc_benefGuardarIvasVentas(Border borderResaltar) {
		this.resaltarruc_benefGuardarIvasVentas= borderResaltar;
	}

	public Boolean getMostrarruc_benefGuardarIvasVentas() {
		return this.mostrarruc_benefGuardarIvasVentas;
	}

	public void setMostrarruc_benefGuardarIvasVentas(Boolean mostrarruc_benefGuardarIvasVentas) {
		this.mostrarruc_benefGuardarIvasVentas= mostrarruc_benefGuardarIvasVentas;
	}

	public Boolean getActivarruc_benefGuardarIvasVentas() {
		return this.activarruc_benefGuardarIvasVentas;
	}

	public void setActivarruc_benefGuardarIvasVentas(Boolean activarruc_benefGuardarIvasVentas) {
		this.activarruc_benefGuardarIvasVentas= activarruc_benefGuardarIvasVentas;
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
		
		
		this.setMostraridGuardarIvasVentas(esInicial);
		this.setMostrarid_empresaGuardarIvasVentas(esInicial);
		this.setMostrarid_ejercicioGuardarIvasVentas(esInicial);
		this.setMostrarid_periodoGuardarIvasVentas(esInicial);
		this.setMostrarid_tipo_retencion_fuente_ivaGuardarIvasVentas(esInicial);
		this.setMostrarcodigo_estado_asiento_contableGuardarIvasVentas(esInicial);
		this.setMostrarnombre_periodoGuardarIvasVentas(esInicial);
		this.setMostrarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(esInicial);
		this.setMostrarporcentajeGuardarIvasVentas(esInicial);
		this.setMostrarbase_imponibleGuardarIvasVentas(esInicial);
		this.setMostrarvalorGuardarIvasVentas(esInicial);
		this.setMostrarnumeroGuardarIvasVentas(esInicial);
		this.setMostrarruc_benefGuardarIvasVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.ID)) {
				this.setMostraridGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDTIPORETENCIONFUENTEIVA)) {
				this.setMostrarid_tipo_retencion_fuente_ivaGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.CODIGOESTADOASIENTOCONTABLE)) {
				this.setMostrarcodigo_estado_asiento_contableGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.NOMBREPERIODO)) {
				this.setMostrarnombre_periodoGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.NOMBRETIPORETENCIONFUENTEIVA)) {
				this.setMostrarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE)) {
				this.setMostrarbase_imponibleGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.VALOR)) {
				this.setMostrarvalorGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.RUCBENEF)) {
				this.setMostrarruc_benefGuardarIvasVentas(esAsigna);
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
		
		
		this.setActivaridGuardarIvasVentas(esInicial);
		this.setActivarid_empresaGuardarIvasVentas(esInicial);
		this.setActivarid_ejercicioGuardarIvasVentas(esInicial);
		this.setActivarid_periodoGuardarIvasVentas(esInicial);
		this.setActivarid_tipo_retencion_fuente_ivaGuardarIvasVentas(esInicial);
		this.setActivarcodigo_estado_asiento_contableGuardarIvasVentas(esInicial);
		this.setActivarnombre_periodoGuardarIvasVentas(esInicial);
		this.setActivarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(esInicial);
		this.setActivarporcentajeGuardarIvasVentas(esInicial);
		this.setActivarbase_imponibleGuardarIvasVentas(esInicial);
		this.setActivarvalorGuardarIvasVentas(esInicial);
		this.setActivarnumeroGuardarIvasVentas(esInicial);
		this.setActivarruc_benefGuardarIvasVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.ID)) {
				this.setActivaridGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDTIPORETENCIONFUENTEIVA)) {
				this.setActivarid_tipo_retencion_fuente_ivaGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.CODIGOESTADOASIENTOCONTABLE)) {
				this.setActivarcodigo_estado_asiento_contableGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.NOMBREPERIODO)) {
				this.setActivarnombre_periodoGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.NOMBRETIPORETENCIONFUENTEIVA)) {
				this.setActivarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE)) {
				this.setActivarbase_imponibleGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.VALOR)) {
				this.setActivarvalorGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.NUMERO)) {
				this.setActivarnumeroGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.RUCBENEF)) {
				this.setActivarruc_benefGuardarIvasVentas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGuardarIvasVentas(esInicial);
		this.setResaltarid_empresaGuardarIvasVentas(esInicial);
		this.setResaltarid_ejercicioGuardarIvasVentas(esInicial);
		this.setResaltarid_periodoGuardarIvasVentas(esInicial);
		this.setResaltarid_tipo_retencion_fuente_ivaGuardarIvasVentas(esInicial);
		this.setResaltarcodigo_estado_asiento_contableGuardarIvasVentas(esInicial);
		this.setResaltarnombre_periodoGuardarIvasVentas(esInicial);
		this.setResaltarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(esInicial);
		this.setResaltarporcentajeGuardarIvasVentas(esInicial);
		this.setResaltarbase_imponibleGuardarIvasVentas(esInicial);
		this.setResaltarvalorGuardarIvasVentas(esInicial);
		this.setResaltarnumeroGuardarIvasVentas(esInicial);
		this.setResaltarruc_benefGuardarIvasVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.ID)) {
				this.setResaltaridGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.IDTIPORETENCIONFUENTEIVA)) {
				this.setResaltarid_tipo_retencion_fuente_ivaGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.CODIGOESTADOASIENTOCONTABLE)) {
				this.setResaltarcodigo_estado_asiento_contableGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.NOMBREPERIODO)) {
				this.setResaltarnombre_periodoGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.NOMBRETIPORETENCIONFUENTEIVA)) {
				this.setResaltarnombre_tipo_retencion_fuente_ivaGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE)) {
				this.setResaltarbase_imponibleGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.VALOR)) {
				this.setResaltarvalorGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroGuardarIvasVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuardarIvasVentasConstantesFunciones.RUCBENEF)) {
				this.setResaltarruc_benefGuardarIvasVentas(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaGuardarIvasVentasGuardarIvasVentas=true;

	public Boolean getMostrarBusquedaGuardarIvasVentasGuardarIvasVentas() {
		return this.mostrarBusquedaGuardarIvasVentasGuardarIvasVentas;
	}

	public void setMostrarBusquedaGuardarIvasVentasGuardarIvasVentas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaGuardarIvasVentasGuardarIvasVentas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaGuardarIvasVentasGuardarIvasVentas=true;

	public Boolean getActivarBusquedaGuardarIvasVentasGuardarIvasVentas() {
		return this.activarBusquedaGuardarIvasVentasGuardarIvasVentas;
	}

	public void setActivarBusquedaGuardarIvasVentasGuardarIvasVentas(Boolean habilitarResaltar) {
		this.activarBusquedaGuardarIvasVentasGuardarIvasVentas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaGuardarIvasVentasGuardarIvasVentas=null;

	public Border getResaltarBusquedaGuardarIvasVentasGuardarIvasVentas() {
		return this.resaltarBusquedaGuardarIvasVentasGuardarIvasVentas;
	}

	public void setResaltarBusquedaGuardarIvasVentasGuardarIvasVentas(Border borderResaltar) {
		this.resaltarBusquedaGuardarIvasVentasGuardarIvasVentas= borderResaltar;
	}

	public void setResaltarBusquedaGuardarIvasVentasGuardarIvasVentas(ParametroGeneralUsuario parametroGeneralUsuario/*GuardarIvasVentasBeanSwingJInternalFrame guardarivasventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaGuardarIvasVentasGuardarIvasVentas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}