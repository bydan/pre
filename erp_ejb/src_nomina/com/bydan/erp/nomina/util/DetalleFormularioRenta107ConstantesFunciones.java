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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.DetalleFormularioRenta107ConstantesFunciones;
import com.bydan.erp.nomina.util.DetalleFormularioRenta107ParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DetalleFormularioRenta107ParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleFormularioRenta107ConstantesFunciones extends DetalleFormularioRenta107ConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleFormularioRenta107";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleFormularioRenta107"+DetalleFormularioRenta107ConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleFormularioRenta107HomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleFormularioRenta107HomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"_"+DetalleFormularioRenta107ConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFormularioRenta107HomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"_"+DetalleFormularioRenta107ConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"_"+DetalleFormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFormularioRenta107HomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"_"+DetalleFormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFormularioRenta107HomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFormularioRenta107HomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleFormularioRenta107ConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleFormularioRenta107ConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleFormularioRenta107ConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleFormularioRenta107ConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Formulario Renta107es";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Formulario Renta107";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Formulario Renta107";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleFormularioRenta107";
	public static final String OBJECTNAME="detalleformulariorenta107";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="detalle_formulario_renta107";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleformulariorenta107 from "+DetalleFormularioRenta107ConstantesFunciones.SPERSISTENCENAME+" detalleformulariorenta107";
	public static String QUERYSELECTNATIVE="select "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".version_row,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id_empresa,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id_empleado,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id_formulario_renta107,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".sueldos_301,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".sobre_sueldos_303,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".decimo_tercero_305,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".decimo_cuarto_307,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".fondo_reserva_309,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".utilidades_311,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".desahucio_313,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".iess_personal_315,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_vivienda_317,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_salud_319,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_educacion_321,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_alimentacion_323,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_vestimenta_325,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".descuento_discapacidad_327,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".descuento_tercera_edad_329,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".asume_empleador_331,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".sub_empleador_351,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".numero_meses_trabajados_353,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".ingreso_otros_empleadores_401,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".deduccion_gastos_otros_empleadores_403,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".rebajas_otros_empleadores_405,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".base_imponible_anual_407,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".impuesto_causado_409,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".impuesto_retenido_empleador_411,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".impuesto_retenido_otros_empleadores_413 from "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME;//+" as "+DetalleFormularioRenta107ConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleFormularioRenta107ConstantesFuncionesAdditional detalleformulariorenta107ConstantesFuncionesAdditional=null;
	
	public DetalleFormularioRenta107ConstantesFuncionesAdditional getDetalleFormularioRenta107ConstantesFuncionesAdditional() {
		return this.detalleformulariorenta107ConstantesFuncionesAdditional;
	}
	
	public void setDetalleFormularioRenta107ConstantesFuncionesAdditional(DetalleFormularioRenta107ConstantesFuncionesAdditional detalleformulariorenta107ConstantesFuncionesAdditional) {
		try {
			this.detalleformulariorenta107ConstantesFuncionesAdditional=detalleformulariorenta107ConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDFORMULARIORENTA107= "id_formulario_renta107";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String SUELDOS_301= "sueldos_301";
    public static final String SOBRESUELDOS_303= "sobre_sueldos_303";
    public static final String DECIMOTERCERO_305= "decimo_tercero_305";
    public static final String DECIMOCUARTO_307= "decimo_cuarto_307";
    public static final String FONDORESERVA_309= "fondo_reserva_309";
    public static final String UTILIDADES_311= "utilidades_311";
    public static final String DESAHUCIO_313= "desahucio_313";
    public static final String IESSPERSONAL_315= "iess_personal_315";
    public static final String GASTOSVIVIENDA_317= "gastos_vivienda_317";
    public static final String GASTOSSALUD_319= "gastos_salud_319";
    public static final String GASTOSEDUCACION_321= "gastos_educacion_321";
    public static final String GASTOSALIMENTACION_323= "gastos_alimentacion_323";
    public static final String GASTOSVESTIMENTA_325= "gastos_vestimenta_325";
    public static final String DESCUENTODISCAPACIDAD_327= "descuento_discapacidad_327";
    public static final String DESCUENTOTERCERAEDAD_329= "descuento_tercera_edad_329";
    public static final String ASUMEEMPLEADOR_331= "asume_empleador_331";
    public static final String SUBEMPLEADOR_351= "sub_empleador_351";
    public static final String NUMEROMESESTRABAJADOS_353= "numero_meses_trabajados_353";
    public static final String INGRESOOTROSEMPLEADORES_401= "ingreso_otros_empleadores_401";
    public static final String DEDUCCIONGASTOSOTROSEMPLEADORES_403= "deduccion_gastos_otros_empleadores_403";
    public static final String REBAJASOTROSEMPLEADORES_405= "rebajas_otros_empleadores_405";
    public static final String BASEIMPONIBLEANUAL_407= "base_imponible_anual_407";
    public static final String IMPUESTOCAUSADO_409= "impuesto_causado_409";
    public static final String IMPUESTORETENIDOEMPLEADOR_411= "impuesto_retenido_empleador_411";
    public static final String IMPUESTORETENIDOOTROSEMPLEADORES_413= "impuesto_retenido_otros_empleadores_413";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDFORMULARIORENTA107= "Formulario Renta107";
		public static final String LABEL_IDFORMULARIORENTA107_LOWER= "Formulario Renta107";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_SUELDOS_301= "Sueldos_301";
		public static final String LABEL_SUELDOS_301_LOWER= "Sueldos_301";
    	public static final String LABEL_SOBRESUELDOS_303= "Sobre Sueldos_303";
		public static final String LABEL_SOBRESUELDOS_303_LOWER= "Sobre Sueldos_303";
    	public static final String LABEL_DECIMOTERCERO_305= "Decimo Tercero_305";
		public static final String LABEL_DECIMOTERCERO_305_LOWER= "Decimo Tercero_305";
    	public static final String LABEL_DECIMOCUARTO_307= "Decimo Cuarto_307";
		public static final String LABEL_DECIMOCUARTO_307_LOWER= "Decimo Cuarto_307";
    	public static final String LABEL_FONDORESERVA_309= "Fondo Reserva_309";
		public static final String LABEL_FONDORESERVA_309_LOWER= "Fondo Reserva_309";
    	public static final String LABEL_UTILIDADES_311= "Utilidades_311";
		public static final String LABEL_UTILIDADES_311_LOWER= "Utilidades_311";
    	public static final String LABEL_DESAHUCIO_313= "Desahucio_313";
		public static final String LABEL_DESAHUCIO_313_LOWER= "Desahucio_313";
    	public static final String LABEL_IESSPERSONAL_315= "Iess Personal_315";
		public static final String LABEL_IESSPERSONAL_315_LOWER= "Iess Personal_315";
    	public static final String LABEL_GASTOSVIVIENDA_317= "Gastos Vivienda_317";
		public static final String LABEL_GASTOSVIVIENDA_317_LOWER= "Gastos Vivienda_317";
    	public static final String LABEL_GASTOSSALUD_319= "Gastos Salud_319";
		public static final String LABEL_GASTOSSALUD_319_LOWER= "Gastos Salud_319";
    	public static final String LABEL_GASTOSEDUCACION_321= "Gastos Educacion_321";
		public static final String LABEL_GASTOSEDUCACION_321_LOWER= "Gastos Educacion_321";
    	public static final String LABEL_GASTOSALIMENTACION_323= "Gastos Alimentacion_323";
		public static final String LABEL_GASTOSALIMENTACION_323_LOWER= "Gastos Alimentacion_323";
    	public static final String LABEL_GASTOSVESTIMENTA_325= "Gastos Vestimenta_325";
		public static final String LABEL_GASTOSVESTIMENTA_325_LOWER= "Gastos Vestimenta_325";
    	public static final String LABEL_DESCUENTODISCAPACIDAD_327= "Descuento Discapacidad_327";
		public static final String LABEL_DESCUENTODISCAPACIDAD_327_LOWER= "Descuento Discapacidad_327";
    	public static final String LABEL_DESCUENTOTERCERAEDAD_329= "Descuento Tercera Edad_329";
		public static final String LABEL_DESCUENTOTERCERAEDAD_329_LOWER= "Descuento Tercera Edad_329";
    	public static final String LABEL_ASUMEEMPLEADOR_331= "Asume Empleador_331";
		public static final String LABEL_ASUMEEMPLEADOR_331_LOWER= "Asume Empleador_331";
    	public static final String LABEL_SUBEMPLEADOR_351= "Sub Empleador_351";
		public static final String LABEL_SUBEMPLEADOR_351_LOWER= "Sub Empleador_351";
    	public static final String LABEL_NUMEROMESESTRABAJADOS_353= "Numero Meses Trabajados_353";
		public static final String LABEL_NUMEROMESESTRABAJADOS_353_LOWER= "Numero Meses Trabajados_353";
    	public static final String LABEL_INGRESOOTROSEMPLEADORES_401= "Ingreso Otros Empleadores_401";
		public static final String LABEL_INGRESOOTROSEMPLEADORES_401_LOWER= "Ingreso Otros Empleadores_401";
    	public static final String LABEL_DEDUCCIONGASTOSOTROSEMPLEADORES_403= "Deduccion Gastos Otros Empleadores_403";
		public static final String LABEL_DEDUCCIONGASTOSOTROSEMPLEADORES_403_LOWER= "Deduccion Gastos Otros Empleadores_403";
    	public static final String LABEL_REBAJASOTROSEMPLEADORES_405= "Rebajas Otros Empleadores_405";
		public static final String LABEL_REBAJASOTROSEMPLEADORES_405_LOWER= "Rebajas Otros Empleadores_405";
    	public static final String LABEL_BASEIMPONIBLEANUAL_407= "Base Imponible Anual_407";
		public static final String LABEL_BASEIMPONIBLEANUAL_407_LOWER= "Base Imponible Anual_407";
    	public static final String LABEL_IMPUESTOCAUSADO_409= "Impuesto Causado_409";
		public static final String LABEL_IMPUESTOCAUSADO_409_LOWER= "Impuesto Causado_409";
    	public static final String LABEL_IMPUESTORETENIDOEMPLEADOR_411= "Impuesto Retenido Empleador_411";
		public static final String LABEL_IMPUESTORETENIDOEMPLEADOR_411_LOWER= "Impuesto Retenido Empleador_411";
    	public static final String LABEL_IMPUESTORETENIDOOTROSEMPLEADORES_413= "Impuesto Retenido Otros Empleadores_413";
		public static final String LABEL_IMPUESTORETENIDOOTROSEMPLEADORES_413_LOWER= "Impuesto Retenido Otros Empleadores_413";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetalleFormularioRenta107LabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_IDFORMULARIORENTA107;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_SUELDOS_301;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_SOBRESUELDOS_303;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOTERCERO_305;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOCUARTO_307;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_FONDORESERVA_309;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_UTILIDADES_311;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_DESAHUCIO_313;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_IESSPERSONAL_315;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVIVIENDA_317;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSSALUD_319;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSEDUCACION_321;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSALIMENTACION_323;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVESTIMENTA_325;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTODISCAPACIDAD_327;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTOTERCERAEDAD_329;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_ASUMEEMPLEADOR_331;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_SUBEMPLEADOR_351;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_NUMEROMESESTRABAJADOS_353;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_INGRESOOTROSEMPLEADORES_401;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_DEDUCCIONGASTOSOTROSEMPLEADORES_403;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_REBAJASOTROSEMPLEADORES_405;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_BASEIMPONIBLEANUAL_407;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTOCAUSADO_409;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOEMPLEADOR_411;}
		if(sNombreColumna.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413)) {sLabelColumna=DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOOTROSEMPLEADORES_413;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleFormularioRenta107Descripcion(DetalleFormularioRenta107 detalleformulariorenta107) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleformulariorenta107 !=null/* && detalleformulariorenta107.getId()!=0*/) {
			if(detalleformulariorenta107.getId()!=null) {
				sDescripcion=detalleformulariorenta107.getId().toString();
			}//detalleformulariorenta107detalleformulariorenta107.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleFormularioRenta107DescripcionDetallado(DetalleFormularioRenta107 detalleformulariorenta107) {
		String sDescripcion="";
			
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.ID+"=";
		sDescripcion+=detalleformulariorenta107.getId().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleformulariorenta107.getVersionRow().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleformulariorenta107.getid_empresa().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=detalleformulariorenta107.getid_empleado().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107+"=";
		sDescripcion+=detalleformulariorenta107.getid_formulario_renta107().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleformulariorenta107.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301+"=";
		sDescripcion+=detalleformulariorenta107.getsueldos_301().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303+"=";
		sDescripcion+=detalleformulariorenta107.getsobre_sueldos_303().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305+"=";
		sDescripcion+=detalleformulariorenta107.getdecimo_tercero_305().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307+"=";
		sDescripcion+=detalleformulariorenta107.getdecimo_cuarto_307().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309+"=";
		sDescripcion+=detalleformulariorenta107.getfondo_reserva_309().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311+"=";
		sDescripcion+=detalleformulariorenta107.getutilidades_311().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313+"=";
		sDescripcion+=detalleformulariorenta107.getdesahucio_313().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315+"=";
		sDescripcion+=detalleformulariorenta107.getiess_personal_315().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317+"=";
		sDescripcion+=detalleformulariorenta107.getgastos_vivienda_317().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319+"=";
		sDescripcion+=detalleformulariorenta107.getgastos_salud_319().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321+"=";
		sDescripcion+=detalleformulariorenta107.getgastos_educacion_321().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323+"=";
		sDescripcion+=detalleformulariorenta107.getgastos_alimentacion_323().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325+"=";
		sDescripcion+=detalleformulariorenta107.getgastos_vestimenta_325().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327+"=";
		sDescripcion+=detalleformulariorenta107.getdescuento_discapacidad_327().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329+"=";
		sDescripcion+=detalleformulariorenta107.getdescuento_tercera_edad_329().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331+"=";
		sDescripcion+=detalleformulariorenta107.getasume_empleador_331().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351+"=";
		sDescripcion+=detalleformulariorenta107.getsub_empleador_351().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353+"=";
		sDescripcion+=detalleformulariorenta107.getnumero_meses_trabajados_353().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401+"=";
		sDescripcion+=detalleformulariorenta107.getingreso_otros_empleadores_401().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403+"=";
		sDescripcion+=detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405+"=";
		sDescripcion+=detalleformulariorenta107.getrebajas_otros_empleadores_405().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407+"=";
		sDescripcion+=detalleformulariorenta107.getbase_imponible_anual_407().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409+"=";
		sDescripcion+=detalleformulariorenta107.getimpuesto_causado_409().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411+"=";
		sDescripcion+=detalleformulariorenta107.getimpuesto_retenido_empleador_411().toString()+",";
		sDescripcion+=DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413+"=";
		sDescripcion+=detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleFormularioRenta107Descripcion(DetalleFormularioRenta107 detalleformulariorenta107,String sValor) throws Exception {			
		if(detalleformulariorenta107 !=null) {
			//detalleformulariorenta107detalleformulariorenta107.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getFormularioRenta107Descripcion(FormularioRenta107 formulariorenta107) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formulariorenta107!=null/*&&formulariorenta107.getId()>0*/) {
			sDescripcion=FormularioRenta107ConstantesFunciones.getFormularioRenta107Descripcion(formulariorenta107);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormularioRenta107")) {
			sNombreIndice="Tipo=  Por Formulario Renta107";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormularioRenta107(Long id_formulario_renta107) {
		String sDetalleIndice=" Parametros->";
		if(id_formulario_renta107!=null) {sDetalleIndice+=" Codigo Unico De Formulario Renta107="+id_formulario_renta107.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleFormularioRenta107(DetalleFormularioRenta107 detalleformulariorenta107,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetalleFormularioRenta107s(List<DetalleFormularioRenta107> detalleformulariorenta107s,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleFormularioRenta107 detalleformulariorenta107: detalleformulariorenta107s) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFormularioRenta107(DetalleFormularioRenta107 detalleformulariorenta107,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleformulariorenta107.getConCambioAuxiliar()) {
			detalleformulariorenta107.setIsDeleted(detalleformulariorenta107.getIsDeletedAuxiliar());	
			detalleformulariorenta107.setIsNew(detalleformulariorenta107.getIsNewAuxiliar());	
			detalleformulariorenta107.setIsChanged(detalleformulariorenta107.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleformulariorenta107.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleformulariorenta107.setIsDeletedAuxiliar(false);	
			detalleformulariorenta107.setIsNewAuxiliar(false);	
			detalleformulariorenta107.setIsChangedAuxiliar(false);
			
			detalleformulariorenta107.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFormularioRenta107s(List<DetalleFormularioRenta107> detalleformulariorenta107s,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleFormularioRenta107 detalleformulariorenta107 : detalleformulariorenta107s) {
			if(conAsignarBase && detalleformulariorenta107.getConCambioAuxiliar()) {
				detalleformulariorenta107.setIsDeleted(detalleformulariorenta107.getIsDeletedAuxiliar());	
				detalleformulariorenta107.setIsNew(detalleformulariorenta107.getIsNewAuxiliar());	
				detalleformulariorenta107.setIsChanged(detalleformulariorenta107.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleformulariorenta107.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleformulariorenta107.setIsDeletedAuxiliar(false);	
				detalleformulariorenta107.setIsNewAuxiliar(false);	
				detalleformulariorenta107.setIsChangedAuxiliar(false);
				
				detalleformulariorenta107.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleFormularioRenta107(DetalleFormularioRenta107 detalleformulariorenta107,Boolean conEnteros) throws Exception  {
		detalleformulariorenta107.setsueldos_301(0.0);
		detalleformulariorenta107.setsobre_sueldos_303(0.0);
		detalleformulariorenta107.setdecimo_tercero_305(0.0);
		detalleformulariorenta107.setdecimo_cuarto_307(0.0);
		detalleformulariorenta107.setfondo_reserva_309(0.0);
		detalleformulariorenta107.setutilidades_311(0.0);
		detalleformulariorenta107.setdesahucio_313(0.0);
		detalleformulariorenta107.setiess_personal_315(0.0);
		detalleformulariorenta107.setgastos_vivienda_317(0.0);
		detalleformulariorenta107.setgastos_salud_319(0.0);
		detalleformulariorenta107.setgastos_educacion_321(0.0);
		detalleformulariorenta107.setgastos_alimentacion_323(0.0);
		detalleformulariorenta107.setgastos_vestimenta_325(0.0);
		detalleformulariorenta107.setdescuento_discapacidad_327(0.0);
		detalleformulariorenta107.setdescuento_tercera_edad_329(0.0);
		detalleformulariorenta107.setasume_empleador_331(0.0);
		detalleformulariorenta107.setsub_empleador_351(0.0);
		detalleformulariorenta107.setingreso_otros_empleadores_401(0.0);
		detalleformulariorenta107.setdeduccion_gastos_otros_empleadores_403(0.0);
		detalleformulariorenta107.setrebajas_otros_empleadores_405(0.0);
		detalleformulariorenta107.setbase_imponible_anual_407(0.0);
		detalleformulariorenta107.setimpuesto_causado_409(0.0);
		detalleformulariorenta107.setimpuesto_retenido_empleador_411(0.0);
		detalleformulariorenta107.setimpuesto_retenido_otros_empleadores_413(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleformulariorenta107.setnumero_meses_trabajados_353(0);
		}
	}		
	
	public static void InicializarValoresDetalleFormularioRenta107s(List<DetalleFormularioRenta107> detalleformulariorenta107s,Boolean conEnteros) throws Exception  {
		
		for(DetalleFormularioRenta107 detalleformulariorenta107: detalleformulariorenta107s) {
			detalleformulariorenta107.setsueldos_301(0.0);
			detalleformulariorenta107.setsobre_sueldos_303(0.0);
			detalleformulariorenta107.setdecimo_tercero_305(0.0);
			detalleformulariorenta107.setdecimo_cuarto_307(0.0);
			detalleformulariorenta107.setfondo_reserva_309(0.0);
			detalleformulariorenta107.setutilidades_311(0.0);
			detalleformulariorenta107.setdesahucio_313(0.0);
			detalleformulariorenta107.setiess_personal_315(0.0);
			detalleformulariorenta107.setgastos_vivienda_317(0.0);
			detalleformulariorenta107.setgastos_salud_319(0.0);
			detalleformulariorenta107.setgastos_educacion_321(0.0);
			detalleformulariorenta107.setgastos_alimentacion_323(0.0);
			detalleformulariorenta107.setgastos_vestimenta_325(0.0);
			detalleformulariorenta107.setdescuento_discapacidad_327(0.0);
			detalleformulariorenta107.setdescuento_tercera_edad_329(0.0);
			detalleformulariorenta107.setasume_empleador_331(0.0);
			detalleformulariorenta107.setsub_empleador_351(0.0);
			detalleformulariorenta107.setingreso_otros_empleadores_401(0.0);
			detalleformulariorenta107.setdeduccion_gastos_otros_empleadores_403(0.0);
			detalleformulariorenta107.setrebajas_otros_empleadores_405(0.0);
			detalleformulariorenta107.setbase_imponible_anual_407(0.0);
			detalleformulariorenta107.setimpuesto_causado_409(0.0);
			detalleformulariorenta107.setimpuesto_retenido_empleador_411(0.0);
			detalleformulariorenta107.setimpuesto_retenido_otros_empleadores_413(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleformulariorenta107.setnumero_meses_trabajados_353(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleFormularioRenta107(List<DetalleFormularioRenta107> detalleformulariorenta107s,DetalleFormularioRenta107 detalleformulariorenta107Aux) throws Exception  {
		DetalleFormularioRenta107ConstantesFunciones.InicializarValoresDetalleFormularioRenta107(detalleformulariorenta107Aux,true);
		
		for(DetalleFormularioRenta107 detalleformulariorenta107: detalleformulariorenta107s) {
			if(detalleformulariorenta107.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleformulariorenta107Aux.setsueldos_301(detalleformulariorenta107Aux.getsueldos_301()+detalleformulariorenta107.getsueldos_301());			
			detalleformulariorenta107Aux.setsobre_sueldos_303(detalleformulariorenta107Aux.getsobre_sueldos_303()+detalleformulariorenta107.getsobre_sueldos_303());			
			detalleformulariorenta107Aux.setdecimo_tercero_305(detalleformulariorenta107Aux.getdecimo_tercero_305()+detalleformulariorenta107.getdecimo_tercero_305());			
			detalleformulariorenta107Aux.setdecimo_cuarto_307(detalleformulariorenta107Aux.getdecimo_cuarto_307()+detalleformulariorenta107.getdecimo_cuarto_307());			
			detalleformulariorenta107Aux.setfondo_reserva_309(detalleformulariorenta107Aux.getfondo_reserva_309()+detalleformulariorenta107.getfondo_reserva_309());			
			detalleformulariorenta107Aux.setutilidades_311(detalleformulariorenta107Aux.getutilidades_311()+detalleformulariorenta107.getutilidades_311());			
			detalleformulariorenta107Aux.setdesahucio_313(detalleformulariorenta107Aux.getdesahucio_313()+detalleformulariorenta107.getdesahucio_313());			
			detalleformulariorenta107Aux.setiess_personal_315(detalleformulariorenta107Aux.getiess_personal_315()+detalleformulariorenta107.getiess_personal_315());			
			detalleformulariorenta107Aux.setgastos_vivienda_317(detalleformulariorenta107Aux.getgastos_vivienda_317()+detalleformulariorenta107.getgastos_vivienda_317());			
			detalleformulariorenta107Aux.setgastos_salud_319(detalleformulariorenta107Aux.getgastos_salud_319()+detalleformulariorenta107.getgastos_salud_319());			
			detalleformulariorenta107Aux.setgastos_educacion_321(detalleformulariorenta107Aux.getgastos_educacion_321()+detalleformulariorenta107.getgastos_educacion_321());			
			detalleformulariorenta107Aux.setgastos_alimentacion_323(detalleformulariorenta107Aux.getgastos_alimentacion_323()+detalleformulariorenta107.getgastos_alimentacion_323());			
			detalleformulariorenta107Aux.setgastos_vestimenta_325(detalleformulariorenta107Aux.getgastos_vestimenta_325()+detalleformulariorenta107.getgastos_vestimenta_325());			
			detalleformulariorenta107Aux.setdescuento_discapacidad_327(detalleformulariorenta107Aux.getdescuento_discapacidad_327()+detalleformulariorenta107.getdescuento_discapacidad_327());			
			detalleformulariorenta107Aux.setdescuento_tercera_edad_329(detalleformulariorenta107Aux.getdescuento_tercera_edad_329()+detalleformulariorenta107.getdescuento_tercera_edad_329());			
			detalleformulariorenta107Aux.setasume_empleador_331(detalleformulariorenta107Aux.getasume_empleador_331()+detalleformulariorenta107.getasume_empleador_331());			
			detalleformulariorenta107Aux.setsub_empleador_351(detalleformulariorenta107Aux.getsub_empleador_351()+detalleformulariorenta107.getsub_empleador_351());			
			detalleformulariorenta107Aux.setnumero_meses_trabajados_353(detalleformulariorenta107Aux.getnumero_meses_trabajados_353()+detalleformulariorenta107.getnumero_meses_trabajados_353());			
			detalleformulariorenta107Aux.setingreso_otros_empleadores_401(detalleformulariorenta107Aux.getingreso_otros_empleadores_401()+detalleformulariorenta107.getingreso_otros_empleadores_401());			
			detalleformulariorenta107Aux.setdeduccion_gastos_otros_empleadores_403(detalleformulariorenta107Aux.getdeduccion_gastos_otros_empleadores_403()+detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403());			
			detalleformulariorenta107Aux.setrebajas_otros_empleadores_405(detalleformulariorenta107Aux.getrebajas_otros_empleadores_405()+detalleformulariorenta107.getrebajas_otros_empleadores_405());			
			detalleformulariorenta107Aux.setbase_imponible_anual_407(detalleformulariorenta107Aux.getbase_imponible_anual_407()+detalleformulariorenta107.getbase_imponible_anual_407());			
			detalleformulariorenta107Aux.setimpuesto_causado_409(detalleformulariorenta107Aux.getimpuesto_causado_409()+detalleformulariorenta107.getimpuesto_causado_409());			
			detalleformulariorenta107Aux.setimpuesto_retenido_empleador_411(detalleformulariorenta107Aux.getimpuesto_retenido_empleador_411()+detalleformulariorenta107.getimpuesto_retenido_empleador_411());			
			detalleformulariorenta107Aux.setimpuesto_retenido_otros_empleadores_413(detalleformulariorenta107Aux.getimpuesto_retenido_otros_empleadores_413()+detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFormularioRenta107(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleFormularioRenta107ConstantesFunciones.getArrayColumnasGlobalesDetalleFormularioRenta107(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFormularioRenta107(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleFormularioRenta107(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleFormularioRenta107> detalleformulariorenta107s,DetalleFormularioRenta107 detalleformulariorenta107,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleFormularioRenta107 detalleformulariorenta107Aux: detalleformulariorenta107s) {
			if(detalleformulariorenta107Aux!=null && detalleformulariorenta107!=null) {
				if((detalleformulariorenta107Aux.getId()==null && detalleformulariorenta107.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleformulariorenta107Aux.getId()!=null && detalleformulariorenta107.getId()!=null){
					if(detalleformulariorenta107Aux.getId().equals(detalleformulariorenta107.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleFormularioRenta107(List<DetalleFormularioRenta107> detalleformulariorenta107s) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double sueldos_301Total=0.0;
		Double sobre_sueldos_303Total=0.0;
		Double decimo_tercero_305Total=0.0;
		Double decimo_cuarto_307Total=0.0;
		Double fondo_reserva_309Total=0.0;
		Double utilidades_311Total=0.0;
		Double desahucio_313Total=0.0;
		Double iess_personal_315Total=0.0;
		Double gastos_vivienda_317Total=0.0;
		Double gastos_salud_319Total=0.0;
		Double gastos_educacion_321Total=0.0;
		Double gastos_alimentacion_323Total=0.0;
		Double gastos_vestimenta_325Total=0.0;
		Double descuento_discapacidad_327Total=0.0;
		Double descuento_tercera_edad_329Total=0.0;
		Double asume_empleador_331Total=0.0;
		Double sub_empleador_351Total=0.0;
		Double ingreso_otros_empleadores_401Total=0.0;
		Double deduccion_gastos_otros_empleadores_403Total=0.0;
		Double rebajas_otros_empleadores_405Total=0.0;
		Double base_imponible_anual_407Total=0.0;
		Double impuesto_causado_409Total=0.0;
		Double impuesto_retenido_empleador_411Total=0.0;
		Double impuesto_retenido_otros_empleadores_413Total=0.0;
	
		for(DetalleFormularioRenta107 detalleformulariorenta107: detalleformulariorenta107s) {			
			if(detalleformulariorenta107.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			sueldos_301Total+=detalleformulariorenta107.getsueldos_301();
			sobre_sueldos_303Total+=detalleformulariorenta107.getsobre_sueldos_303();
			decimo_tercero_305Total+=detalleformulariorenta107.getdecimo_tercero_305();
			decimo_cuarto_307Total+=detalleformulariorenta107.getdecimo_cuarto_307();
			fondo_reserva_309Total+=detalleformulariorenta107.getfondo_reserva_309();
			utilidades_311Total+=detalleformulariorenta107.getutilidades_311();
			desahucio_313Total+=detalleformulariorenta107.getdesahucio_313();
			iess_personal_315Total+=detalleformulariorenta107.getiess_personal_315();
			gastos_vivienda_317Total+=detalleformulariorenta107.getgastos_vivienda_317();
			gastos_salud_319Total+=detalleformulariorenta107.getgastos_salud_319();
			gastos_educacion_321Total+=detalleformulariorenta107.getgastos_educacion_321();
			gastos_alimentacion_323Total+=detalleformulariorenta107.getgastos_alimentacion_323();
			gastos_vestimenta_325Total+=detalleformulariorenta107.getgastos_vestimenta_325();
			descuento_discapacidad_327Total+=detalleformulariorenta107.getdescuento_discapacidad_327();
			descuento_tercera_edad_329Total+=detalleformulariorenta107.getdescuento_tercera_edad_329();
			asume_empleador_331Total+=detalleformulariorenta107.getasume_empleador_331();
			sub_empleador_351Total+=detalleformulariorenta107.getsub_empleador_351();
			ingreso_otros_empleadores_401Total+=detalleformulariorenta107.getingreso_otros_empleadores_401();
			deduccion_gastos_otros_empleadores_403Total+=detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403();
			rebajas_otros_empleadores_405Total+=detalleformulariorenta107.getrebajas_otros_empleadores_405();
			base_imponible_anual_407Total+=detalleformulariorenta107.getbase_imponible_anual_407();
			impuesto_causado_409Total+=detalleformulariorenta107.getimpuesto_causado_409();
			impuesto_retenido_empleador_411Total+=detalleformulariorenta107.getimpuesto_retenido_empleador_411();
			impuesto_retenido_otros_empleadores_413Total+=detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_SUELDOS_301);
		datoGeneral.setdValorDouble(sueldos_301Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_SOBRESUELDOS_303);
		datoGeneral.setdValorDouble(sobre_sueldos_303Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOTERCERO_305);
		datoGeneral.setdValorDouble(decimo_tercero_305Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOCUARTO_307);
		datoGeneral.setdValorDouble(decimo_cuarto_307Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_FONDORESERVA_309);
		datoGeneral.setdValorDouble(fondo_reserva_309Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_UTILIDADES_311);
		datoGeneral.setdValorDouble(utilidades_311Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESAHUCIO_313);
		datoGeneral.setdValorDouble(desahucio_313Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IESSPERSONAL_315);
		datoGeneral.setdValorDouble(iess_personal_315Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVIVIENDA_317);
		datoGeneral.setdValorDouble(gastos_vivienda_317Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSSALUD_319);
		datoGeneral.setdValorDouble(gastos_salud_319Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSEDUCACION_321);
		datoGeneral.setdValorDouble(gastos_educacion_321Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSALIMENTACION_323);
		datoGeneral.setdValorDouble(gastos_alimentacion_323Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVESTIMENTA_325);
		datoGeneral.setdValorDouble(gastos_vestimenta_325Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTODISCAPACIDAD_327);
		datoGeneral.setdValorDouble(descuento_discapacidad_327Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTOTERCERAEDAD_329);
		datoGeneral.setdValorDouble(descuento_tercera_edad_329Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_ASUMEEMPLEADOR_331);
		datoGeneral.setdValorDouble(asume_empleador_331Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_SUBEMPLEADOR_351);
		datoGeneral.setdValorDouble(sub_empleador_351Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_INGRESOOTROSEMPLEADORES_401);
		datoGeneral.setdValorDouble(ingreso_otros_empleadores_401Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DEDUCCIONGASTOSOTROSEMPLEADORES_403);
		datoGeneral.setdValorDouble(deduccion_gastos_otros_empleadores_403Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_REBAJASOTROSEMPLEADORES_405);
		datoGeneral.setdValorDouble(rebajas_otros_empleadores_405Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_BASEIMPONIBLEANUAL_407);
		datoGeneral.setdValorDouble(base_imponible_anual_407Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTOCAUSADO_409);
		datoGeneral.setdValorDouble(impuesto_causado_409Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOEMPLEADOR_411);
		datoGeneral.setdValorDouble(impuesto_retenido_empleador_411Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413);
		datoGeneral.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOOTROSEMPLEADORES_413);
		datoGeneral.setdValorDouble(impuesto_retenido_otros_empleadores_413Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleFormularioRenta107() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_ID, DetalleFormularioRenta107ConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_VERSIONROW, DetalleFormularioRenta107ConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA, DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO, DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_IDFORMULARIORENTA107, DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO, DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_SUELDOS_301, DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_SOBRESUELDOS_303, DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOTERCERO_305, DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOCUARTO_307, DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_FONDORESERVA_309, DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_UTILIDADES_311, DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_DESAHUCIO_313, DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_IESSPERSONAL_315, DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVIVIENDA_317, DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSSALUD_319, DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSEDUCACION_321, DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSALIMENTACION_323, DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVESTIMENTA_325, DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTODISCAPACIDAD_327, DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTOTERCERAEDAD_329, DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_ASUMEEMPLEADOR_331, DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_SUBEMPLEADOR_351, DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_NUMEROMESESTRABAJADOS_353, DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_INGRESOOTROSEMPLEADORES_401, DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_DEDUCCIONGASTOSOTROSEMPLEADORES_403, DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_REBAJASOTROSEMPLEADORES_405, DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_BASEIMPONIBLEANUAL_407, DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTOCAUSADO_409, DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOEMPLEADOR_411, DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOOTROSEMPLEADORES_413, DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleFormularioRenta107() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFormularioRenta107() throws Exception  {
		return DetalleFormularioRenta107ConstantesFunciones.getTiposSeleccionarDetalleFormularioRenta107(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFormularioRenta107(Boolean conFk) throws Exception  {
		return DetalleFormularioRenta107ConstantesFunciones.getTiposSeleccionarDetalleFormularioRenta107(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFormularioRenta107(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDFORMULARIORENTA107);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDFORMULARIORENTA107);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_SUELDOS_301);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_SUELDOS_301);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_SOBRESUELDOS_303);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_SOBRESUELDOS_303);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOTERCERO_305);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOTERCERO_305);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOCUARTO_307);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOCUARTO_307);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_FONDORESERVA_309);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_FONDORESERVA_309);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_UTILIDADES_311);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_UTILIDADES_311);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESAHUCIO_313);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESAHUCIO_313);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_IESSPERSONAL_315);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IESSPERSONAL_315);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVIVIENDA_317);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVIVIENDA_317);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSSALUD_319);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSSALUD_319);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSEDUCACION_321);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSEDUCACION_321);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSALIMENTACION_323);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSALIMENTACION_323);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVESTIMENTA_325);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVESTIMENTA_325);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTODISCAPACIDAD_327);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTODISCAPACIDAD_327);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTOTERCERAEDAD_329);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTOTERCERAEDAD_329);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_ASUMEEMPLEADOR_331);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_ASUMEEMPLEADOR_331);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_SUBEMPLEADOR_351);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_SUBEMPLEADOR_351);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_NUMEROMESESTRABAJADOS_353);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_NUMEROMESESTRABAJADOS_353);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_INGRESOOTROSEMPLEADORES_401);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_INGRESOOTROSEMPLEADORES_401);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_DEDUCCIONGASTOSOTROSEMPLEADORES_403);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_DEDUCCIONGASTOSOTROSEMPLEADORES_403);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_REBAJASOTROSEMPLEADORES_405);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_REBAJASOTROSEMPLEADORES_405);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_BASEIMPONIBLEANUAL_407);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_BASEIMPONIBLEANUAL_407);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTOCAUSADO_409);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTOCAUSADO_409);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOEMPLEADOR_411);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOEMPLEADOR_411);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOOTROSEMPLEADORES_413);
			reporte.setsDescripcion(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOOTROSEMPLEADORES_413);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleFormularioRenta107(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFormularioRenta107(DetalleFormularioRenta107 detalleformulariorenta107Aux) throws Exception {
		
			detalleformulariorenta107Aux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleformulariorenta107Aux.getEmpresa()));
			detalleformulariorenta107Aux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(detalleformulariorenta107Aux.getEmpleado()));
			detalleformulariorenta107Aux.setformulariorenta107_descripcion(FormularioRenta107ConstantesFunciones.getFormularioRenta107Descripcion(detalleformulariorenta107Aux.getFormularioRenta107()));
			detalleformulariorenta107Aux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleformulariorenta107Aux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFormularioRenta107(List<DetalleFormularioRenta107> detalleformulariorenta107sTemp) throws Exception {
		for(DetalleFormularioRenta107 detalleformulariorenta107Aux:detalleformulariorenta107sTemp) {
			
			detalleformulariorenta107Aux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleformulariorenta107Aux.getEmpresa()));
			detalleformulariorenta107Aux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(detalleformulariorenta107Aux.getEmpleado()));
			detalleformulariorenta107Aux.setformulariorenta107_descripcion(FormularioRenta107ConstantesFunciones.getFormularioRenta107Descripcion(detalleformulariorenta107Aux.getFormularioRenta107()));
			detalleformulariorenta107Aux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleformulariorenta107Aux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(FormularioRenta107.class));
				classes.add(new Classe(Ejercicio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormularioRenta107.class)) {
						classes.add(new Classe(FormularioRenta107.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleFormularioRenta107(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(FormularioRenta107.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRenta107.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(FormularioRenta107.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRenta107.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFormularioRenta107ConstantesFunciones.getClassesRelationshipsOfDetalleFormularioRenta107(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFormularioRenta107(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFormularioRenta107ConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleFormularioRenta107(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFormularioRenta107(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleFormularioRenta107 detalleformulariorenta107,List<DetalleFormularioRenta107> detalleformulariorenta107s,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleFormularioRenta107 detalleformulariorenta107Encontrado=null;
			
			for(DetalleFormularioRenta107 detalleformulariorenta107Local:detalleformulariorenta107s) {
				if(detalleformulariorenta107Local.getId().equals(detalleformulariorenta107.getId())) {
					detalleformulariorenta107Encontrado=detalleformulariorenta107Local;
					
					detalleformulariorenta107Local.setIsChanged(detalleformulariorenta107.getIsChanged());
					detalleformulariorenta107Local.setIsNew(detalleformulariorenta107.getIsNew());
					detalleformulariorenta107Local.setIsDeleted(detalleformulariorenta107.getIsDeleted());
					
					detalleformulariorenta107Local.setGeneralEntityOriginal(detalleformulariorenta107.getGeneralEntityOriginal());
					
					detalleformulariorenta107Local.setId(detalleformulariorenta107.getId());	
					detalleformulariorenta107Local.setVersionRow(detalleformulariorenta107.getVersionRow());	
					detalleformulariorenta107Local.setid_empresa(detalleformulariorenta107.getid_empresa());	
					detalleformulariorenta107Local.setid_empleado(detalleformulariorenta107.getid_empleado());	
					detalleformulariorenta107Local.setid_formulario_renta107(detalleformulariorenta107.getid_formulario_renta107());	
					detalleformulariorenta107Local.setid_ejercicio(detalleformulariorenta107.getid_ejercicio());	
					detalleformulariorenta107Local.setsueldos_301(detalleformulariorenta107.getsueldos_301());	
					detalleformulariorenta107Local.setsobre_sueldos_303(detalleformulariorenta107.getsobre_sueldos_303());	
					detalleformulariorenta107Local.setdecimo_tercero_305(detalleformulariorenta107.getdecimo_tercero_305());	
					detalleformulariorenta107Local.setdecimo_cuarto_307(detalleformulariorenta107.getdecimo_cuarto_307());	
					detalleformulariorenta107Local.setfondo_reserva_309(detalleformulariorenta107.getfondo_reserva_309());	
					detalleformulariorenta107Local.setutilidades_311(detalleformulariorenta107.getutilidades_311());	
					detalleformulariorenta107Local.setdesahucio_313(detalleformulariorenta107.getdesahucio_313());	
					detalleformulariorenta107Local.setiess_personal_315(detalleformulariorenta107.getiess_personal_315());	
					detalleformulariorenta107Local.setgastos_vivienda_317(detalleformulariorenta107.getgastos_vivienda_317());	
					detalleformulariorenta107Local.setgastos_salud_319(detalleformulariorenta107.getgastos_salud_319());	
					detalleformulariorenta107Local.setgastos_educacion_321(detalleformulariorenta107.getgastos_educacion_321());	
					detalleformulariorenta107Local.setgastos_alimentacion_323(detalleformulariorenta107.getgastos_alimentacion_323());	
					detalleformulariorenta107Local.setgastos_vestimenta_325(detalleformulariorenta107.getgastos_vestimenta_325());	
					detalleformulariorenta107Local.setdescuento_discapacidad_327(detalleformulariorenta107.getdescuento_discapacidad_327());	
					detalleformulariorenta107Local.setdescuento_tercera_edad_329(detalleformulariorenta107.getdescuento_tercera_edad_329());	
					detalleformulariorenta107Local.setasume_empleador_331(detalleformulariorenta107.getasume_empleador_331());	
					detalleformulariorenta107Local.setsub_empleador_351(detalleformulariorenta107.getsub_empleador_351());	
					detalleformulariorenta107Local.setnumero_meses_trabajados_353(detalleformulariorenta107.getnumero_meses_trabajados_353());	
					detalleformulariorenta107Local.setingreso_otros_empleadores_401(detalleformulariorenta107.getingreso_otros_empleadores_401());	
					detalleformulariorenta107Local.setdeduccion_gastos_otros_empleadores_403(detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403());	
					detalleformulariorenta107Local.setrebajas_otros_empleadores_405(detalleformulariorenta107.getrebajas_otros_empleadores_405());	
					detalleformulariorenta107Local.setbase_imponible_anual_407(detalleformulariorenta107.getbase_imponible_anual_407());	
					detalleformulariorenta107Local.setimpuesto_causado_409(detalleformulariorenta107.getimpuesto_causado_409());	
					detalleformulariorenta107Local.setimpuesto_retenido_empleador_411(detalleformulariorenta107.getimpuesto_retenido_empleador_411());	
					detalleformulariorenta107Local.setimpuesto_retenido_otros_empleadores_413(detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleformulariorenta107.getIsDeleted()) {
				if(!existe) {
					detalleformulariorenta107s.add(detalleformulariorenta107);
				}
			} else {
				if(detalleformulariorenta107Encontrado!=null && permiteQuitar)  {
					detalleformulariorenta107s.remove(detalleformulariorenta107Encontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleFormularioRenta107 detalleformulariorenta107,List<DetalleFormularioRenta107> detalleformulariorenta107s) throws Exception {
		try	{			
			for(DetalleFormularioRenta107 detalleformulariorenta107Local:detalleformulariorenta107s) {
				if(detalleformulariorenta107Local.getId().equals(detalleformulariorenta107.getId())) {
					detalleformulariorenta107Local.setIsSelected(detalleformulariorenta107.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleFormularioRenta107(List<DetalleFormularioRenta107> detalleformulariorenta107sAux) throws Exception {
		//this.detalleformulariorenta107sAux=detalleformulariorenta107sAux;
		
		for(DetalleFormularioRenta107 detalleformulariorenta107Aux:detalleformulariorenta107sAux) {
			if(detalleformulariorenta107Aux.getIsChanged()) {
				detalleformulariorenta107Aux.setIsChanged(false);
			}		
			
			if(detalleformulariorenta107Aux.getIsNew()) {
				detalleformulariorenta107Aux.setIsNew(false);
			}	
			
			if(detalleformulariorenta107Aux.getIsDeleted()) {
				detalleformulariorenta107Aux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleFormularioRenta107(DetalleFormularioRenta107 detalleformulariorenta107Aux) throws Exception {
		//this.detalleformulariorenta107Aux=detalleformulariorenta107Aux;
		
			if(detalleformulariorenta107Aux.getIsChanged()) {
				detalleformulariorenta107Aux.setIsChanged(false);
			}		
			
			if(detalleformulariorenta107Aux.getIsNew()) {
				detalleformulariorenta107Aux.setIsNew(false);
			}	
			
			if(detalleformulariorenta107Aux.getIsDeleted()) {
				detalleformulariorenta107Aux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleFormularioRenta107 detalleformulariorenta107Asignar,DetalleFormularioRenta107 detalleformulariorenta107) throws Exception {
		detalleformulariorenta107Asignar.setId(detalleformulariorenta107.getId());	
		detalleformulariorenta107Asignar.setVersionRow(detalleformulariorenta107.getVersionRow());	
		detalleformulariorenta107Asignar.setid_empresa(detalleformulariorenta107.getid_empresa());
		detalleformulariorenta107Asignar.setempresa_descripcion(detalleformulariorenta107.getempresa_descripcion());	
		detalleformulariorenta107Asignar.setid_empleado(detalleformulariorenta107.getid_empleado());
		detalleformulariorenta107Asignar.setempleado_descripcion(detalleformulariorenta107.getempleado_descripcion());	
		detalleformulariorenta107Asignar.setid_formulario_renta107(detalleformulariorenta107.getid_formulario_renta107());
		detalleformulariorenta107Asignar.setformulariorenta107_descripcion(detalleformulariorenta107.getformulariorenta107_descripcion());	
		detalleformulariorenta107Asignar.setid_ejercicio(detalleformulariorenta107.getid_ejercicio());
		detalleformulariorenta107Asignar.setejercicio_descripcion(detalleformulariorenta107.getejercicio_descripcion());	
		detalleformulariorenta107Asignar.setsueldos_301(detalleformulariorenta107.getsueldos_301());	
		detalleformulariorenta107Asignar.setsobre_sueldos_303(detalleformulariorenta107.getsobre_sueldos_303());	
		detalleformulariorenta107Asignar.setdecimo_tercero_305(detalleformulariorenta107.getdecimo_tercero_305());	
		detalleformulariorenta107Asignar.setdecimo_cuarto_307(detalleformulariorenta107.getdecimo_cuarto_307());	
		detalleformulariorenta107Asignar.setfondo_reserva_309(detalleformulariorenta107.getfondo_reserva_309());	
		detalleformulariorenta107Asignar.setutilidades_311(detalleformulariorenta107.getutilidades_311());	
		detalleformulariorenta107Asignar.setdesahucio_313(detalleformulariorenta107.getdesahucio_313());	
		detalleformulariorenta107Asignar.setiess_personal_315(detalleformulariorenta107.getiess_personal_315());	
		detalleformulariorenta107Asignar.setgastos_vivienda_317(detalleformulariorenta107.getgastos_vivienda_317());	
		detalleformulariorenta107Asignar.setgastos_salud_319(detalleformulariorenta107.getgastos_salud_319());	
		detalleformulariorenta107Asignar.setgastos_educacion_321(detalleformulariorenta107.getgastos_educacion_321());	
		detalleformulariorenta107Asignar.setgastos_alimentacion_323(detalleformulariorenta107.getgastos_alimentacion_323());	
		detalleformulariorenta107Asignar.setgastos_vestimenta_325(detalleformulariorenta107.getgastos_vestimenta_325());	
		detalleformulariorenta107Asignar.setdescuento_discapacidad_327(detalleformulariorenta107.getdescuento_discapacidad_327());	
		detalleformulariorenta107Asignar.setdescuento_tercera_edad_329(detalleformulariorenta107.getdescuento_tercera_edad_329());	
		detalleformulariorenta107Asignar.setasume_empleador_331(detalleformulariorenta107.getasume_empleador_331());	
		detalleformulariorenta107Asignar.setsub_empleador_351(detalleformulariorenta107.getsub_empleador_351());	
		detalleformulariorenta107Asignar.setnumero_meses_trabajados_353(detalleformulariorenta107.getnumero_meses_trabajados_353());	
		detalleformulariorenta107Asignar.setingreso_otros_empleadores_401(detalleformulariorenta107.getingreso_otros_empleadores_401());	
		detalleformulariorenta107Asignar.setdeduccion_gastos_otros_empleadores_403(detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403());	
		detalleformulariorenta107Asignar.setrebajas_otros_empleadores_405(detalleformulariorenta107.getrebajas_otros_empleadores_405());	
		detalleformulariorenta107Asignar.setbase_imponible_anual_407(detalleformulariorenta107.getbase_imponible_anual_407());	
		detalleformulariorenta107Asignar.setimpuesto_causado_409(detalleformulariorenta107.getimpuesto_causado_409());	
		detalleformulariorenta107Asignar.setimpuesto_retenido_empleador_411(detalleformulariorenta107.getimpuesto_retenido_empleador_411());	
		detalleformulariorenta107Asignar.setimpuesto_retenido_otros_empleadores_413(detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413());	
	}
	
	public static void inicializarDetalleFormularioRenta107(DetalleFormularioRenta107 detalleformulariorenta107) throws Exception {
		try {
				detalleformulariorenta107.setId(0L);	
					
				detalleformulariorenta107.setid_empresa(-1L);	
				detalleformulariorenta107.setid_empleado(-1L);	
				detalleformulariorenta107.setid_formulario_renta107(-1L);	
				detalleformulariorenta107.setid_ejercicio(-1L);	
				detalleformulariorenta107.setsueldos_301(0.0);	
				detalleformulariorenta107.setsobre_sueldos_303(0.0);	
				detalleformulariorenta107.setdecimo_tercero_305(0.0);	
				detalleformulariorenta107.setdecimo_cuarto_307(0.0);	
				detalleformulariorenta107.setfondo_reserva_309(0.0);	
				detalleformulariorenta107.setutilidades_311(0.0);	
				detalleformulariorenta107.setdesahucio_313(0.0);	
				detalleformulariorenta107.setiess_personal_315(0.0);	
				detalleformulariorenta107.setgastos_vivienda_317(0.0);	
				detalleformulariorenta107.setgastos_salud_319(0.0);	
				detalleformulariorenta107.setgastos_educacion_321(0.0);	
				detalleformulariorenta107.setgastos_alimentacion_323(0.0);	
				detalleformulariorenta107.setgastos_vestimenta_325(0.0);	
				detalleformulariorenta107.setdescuento_discapacidad_327(0.0);	
				detalleformulariorenta107.setdescuento_tercera_edad_329(0.0);	
				detalleformulariorenta107.setasume_empleador_331(0.0);	
				detalleformulariorenta107.setsub_empleador_351(0.0);	
				detalleformulariorenta107.setnumero_meses_trabajados_353(0);	
				detalleformulariorenta107.setingreso_otros_empleadores_401(0.0);	
				detalleformulariorenta107.setdeduccion_gastos_otros_empleadores_403(0.0);	
				detalleformulariorenta107.setrebajas_otros_empleadores_405(0.0);	
				detalleformulariorenta107.setbase_imponible_anual_407(0.0);	
				detalleformulariorenta107.setimpuesto_causado_409(0.0);	
				detalleformulariorenta107.setimpuesto_retenido_empleador_411(0.0);	
				detalleformulariorenta107.setimpuesto_retenido_otros_empleadores_413(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleFormularioRenta107(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDFORMULARIORENTA107);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_SUELDOS_301);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_SOBRESUELDOS_303);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOTERCERO_305);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_DECIMOCUARTO_307);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_FONDORESERVA_309);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_UTILIDADES_311);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESAHUCIO_313);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_IESSPERSONAL_315);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVIVIENDA_317);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSSALUD_319);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSEDUCACION_321);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSALIMENTACION_323);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_GASTOSVESTIMENTA_325);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTODISCAPACIDAD_327);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_DESCUENTOTERCERAEDAD_329);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_ASUMEEMPLEADOR_331);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_SUBEMPLEADOR_351);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_NUMEROMESESTRABAJADOS_353);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_INGRESOOTROSEMPLEADORES_401);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_DEDUCCIONGASTOSOTROSEMPLEADORES_403);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_REBAJASOTROSEMPLEADORES_405);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_BASEIMPONIBLEANUAL_407);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTOCAUSADO_409);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOEMPLEADOR_411);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFormularioRenta107ConstantesFunciones.LABEL_IMPUESTORETENIDOOTROSEMPLEADORES_413);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleFormularioRenta107(String sTipo,Row row,Workbook workbook,DetalleFormularioRenta107 detalleformulariorenta107,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getformulariorenta107_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getsueldos_301());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getsobre_sueldos_303());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getdecimo_tercero_305());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getdecimo_cuarto_307());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getfondo_reserva_309());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getutilidades_311());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getdesahucio_313());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getiess_personal_315());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getgastos_vivienda_317());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getgastos_salud_319());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getgastos_educacion_321());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getgastos_alimentacion_323());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getgastos_vestimenta_325());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getdescuento_discapacidad_327());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getdescuento_tercera_edad_329());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getasume_empleador_331());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getsub_empleador_351());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getnumero_meses_trabajados_353());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getingreso_otros_empleadores_401());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getrebajas_otros_empleadores_405());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getbase_imponible_anual_407());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getimpuesto_causado_409());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getimpuesto_retenido_empleador_411());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleFormularioRenta107=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleFormularioRenta107() {
		return this.sFinalQueryDetalleFormularioRenta107;
	}
	
	public void setsFinalQueryDetalleFormularioRenta107(String sFinalQueryDetalleFormularioRenta107) {
		this.sFinalQueryDetalleFormularioRenta107= sFinalQueryDetalleFormularioRenta107;
	}
	
	public Border resaltarSeleccionarDetalleFormularioRenta107=null;
	
	public Border setResaltarSeleccionarDetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleFormularioRenta107= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleFormularioRenta107() {
		return this.resaltarSeleccionarDetalleFormularioRenta107;
	}
	
	public void setResaltarSeleccionarDetalleFormularioRenta107(Border borderResaltarSeleccionarDetalleFormularioRenta107) {
		this.resaltarSeleccionarDetalleFormularioRenta107= borderResaltarSeleccionarDetalleFormularioRenta107;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleFormularioRenta107=null;
	public Boolean mostraridDetalleFormularioRenta107=true;
	public Boolean activaridDetalleFormularioRenta107=true;

	public Border resaltarid_empresaDetalleFormularioRenta107=null;
	public Boolean mostrarid_empresaDetalleFormularioRenta107=true;
	public Boolean activarid_empresaDetalleFormularioRenta107=true;
	public Boolean cargarid_empresaDetalleFormularioRenta107=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleFormularioRenta107=false;//ConEventDepend=true

	public Border resaltarid_empleadoDetalleFormularioRenta107=null;
	public Boolean mostrarid_empleadoDetalleFormularioRenta107=true;
	public Boolean activarid_empleadoDetalleFormularioRenta107=true;
	public Boolean cargarid_empleadoDetalleFormularioRenta107=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoDetalleFormularioRenta107=false;//ConEventDepend=true

	public Border resaltarid_formulario_renta107DetalleFormularioRenta107=null;
	public Boolean mostrarid_formulario_renta107DetalleFormularioRenta107=true;
	public Boolean activarid_formulario_renta107DetalleFormularioRenta107=true;
	public Boolean cargarid_formulario_renta107DetalleFormularioRenta107=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formulario_renta107DetalleFormularioRenta107=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleFormularioRenta107=null;
	public Boolean mostrarid_ejercicioDetalleFormularioRenta107=true;
	public Boolean activarid_ejercicioDetalleFormularioRenta107=true;
	public Boolean cargarid_ejercicioDetalleFormularioRenta107=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleFormularioRenta107=false;//ConEventDepend=true

	public Border resaltarsueldos_301DetalleFormularioRenta107=null;
	public Boolean mostrarsueldos_301DetalleFormularioRenta107=true;
	public Boolean activarsueldos_301DetalleFormularioRenta107=true;

	public Border resaltarsobre_sueldos_303DetalleFormularioRenta107=null;
	public Boolean mostrarsobre_sueldos_303DetalleFormularioRenta107=true;
	public Boolean activarsobre_sueldos_303DetalleFormularioRenta107=true;

	public Border resaltardecimo_tercero_305DetalleFormularioRenta107=null;
	public Boolean mostrardecimo_tercero_305DetalleFormularioRenta107=true;
	public Boolean activardecimo_tercero_305DetalleFormularioRenta107=true;

	public Border resaltardecimo_cuarto_307DetalleFormularioRenta107=null;
	public Boolean mostrardecimo_cuarto_307DetalleFormularioRenta107=true;
	public Boolean activardecimo_cuarto_307DetalleFormularioRenta107=true;

	public Border resaltarfondo_reserva_309DetalleFormularioRenta107=null;
	public Boolean mostrarfondo_reserva_309DetalleFormularioRenta107=true;
	public Boolean activarfondo_reserva_309DetalleFormularioRenta107=true;

	public Border resaltarutilidades_311DetalleFormularioRenta107=null;
	public Boolean mostrarutilidades_311DetalleFormularioRenta107=true;
	public Boolean activarutilidades_311DetalleFormularioRenta107=true;

	public Border resaltardesahucio_313DetalleFormularioRenta107=null;
	public Boolean mostrardesahucio_313DetalleFormularioRenta107=true;
	public Boolean activardesahucio_313DetalleFormularioRenta107=true;

	public Border resaltariess_personal_315DetalleFormularioRenta107=null;
	public Boolean mostrariess_personal_315DetalleFormularioRenta107=true;
	public Boolean activariess_personal_315DetalleFormularioRenta107=true;

	public Border resaltargastos_vivienda_317DetalleFormularioRenta107=null;
	public Boolean mostrargastos_vivienda_317DetalleFormularioRenta107=true;
	public Boolean activargastos_vivienda_317DetalleFormularioRenta107=true;

	public Border resaltargastos_salud_319DetalleFormularioRenta107=null;
	public Boolean mostrargastos_salud_319DetalleFormularioRenta107=true;
	public Boolean activargastos_salud_319DetalleFormularioRenta107=true;

	public Border resaltargastos_educacion_321DetalleFormularioRenta107=null;
	public Boolean mostrargastos_educacion_321DetalleFormularioRenta107=true;
	public Boolean activargastos_educacion_321DetalleFormularioRenta107=true;

	public Border resaltargastos_alimentacion_323DetalleFormularioRenta107=null;
	public Boolean mostrargastos_alimentacion_323DetalleFormularioRenta107=true;
	public Boolean activargastos_alimentacion_323DetalleFormularioRenta107=true;

	public Border resaltargastos_vestimenta_325DetalleFormularioRenta107=null;
	public Boolean mostrargastos_vestimenta_325DetalleFormularioRenta107=true;
	public Boolean activargastos_vestimenta_325DetalleFormularioRenta107=true;

	public Border resaltardescuento_discapacidad_327DetalleFormularioRenta107=null;
	public Boolean mostrardescuento_discapacidad_327DetalleFormularioRenta107=true;
	public Boolean activardescuento_discapacidad_327DetalleFormularioRenta107=true;

	public Border resaltardescuento_tercera_edad_329DetalleFormularioRenta107=null;
	public Boolean mostrardescuento_tercera_edad_329DetalleFormularioRenta107=true;
	public Boolean activardescuento_tercera_edad_329DetalleFormularioRenta107=true;

	public Border resaltarasume_empleador_331DetalleFormularioRenta107=null;
	public Boolean mostrarasume_empleador_331DetalleFormularioRenta107=true;
	public Boolean activarasume_empleador_331DetalleFormularioRenta107=true;

	public Border resaltarsub_empleador_351DetalleFormularioRenta107=null;
	public Boolean mostrarsub_empleador_351DetalleFormularioRenta107=true;
	public Boolean activarsub_empleador_351DetalleFormularioRenta107=true;

	public Border resaltarnumero_meses_trabajados_353DetalleFormularioRenta107=null;
	public Boolean mostrarnumero_meses_trabajados_353DetalleFormularioRenta107=true;
	public Boolean activarnumero_meses_trabajados_353DetalleFormularioRenta107=true;

	public Border resaltaringreso_otros_empleadores_401DetalleFormularioRenta107=null;
	public Boolean mostraringreso_otros_empleadores_401DetalleFormularioRenta107=true;
	public Boolean activaringreso_otros_empleadores_401DetalleFormularioRenta107=true;

	public Border resaltardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107=null;
	public Boolean mostrardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107=true;
	public Boolean activardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107=true;

	public Border resaltarrebajas_otros_empleadores_405DetalleFormularioRenta107=null;
	public Boolean mostrarrebajas_otros_empleadores_405DetalleFormularioRenta107=true;
	public Boolean activarrebajas_otros_empleadores_405DetalleFormularioRenta107=true;

	public Border resaltarbase_imponible_anual_407DetalleFormularioRenta107=null;
	public Boolean mostrarbase_imponible_anual_407DetalleFormularioRenta107=true;
	public Boolean activarbase_imponible_anual_407DetalleFormularioRenta107=true;

	public Border resaltarimpuesto_causado_409DetalleFormularioRenta107=null;
	public Boolean mostrarimpuesto_causado_409DetalleFormularioRenta107=true;
	public Boolean activarimpuesto_causado_409DetalleFormularioRenta107=true;

	public Border resaltarimpuesto_retenido_empleador_411DetalleFormularioRenta107=null;
	public Boolean mostrarimpuesto_retenido_empleador_411DetalleFormularioRenta107=true;
	public Boolean activarimpuesto_retenido_empleador_411DetalleFormularioRenta107=true;

	public Border resaltarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107=null;
	public Boolean mostrarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107=true;
	public Boolean activarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107=true;

	
	

	public Border setResaltaridDetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltaridDetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleFormularioRenta107() {
		return this.resaltaridDetalleFormularioRenta107;
	}

	public void setResaltaridDetalleFormularioRenta107(Border borderResaltar) {
		this.resaltaridDetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostraridDetalleFormularioRenta107() {
		return this.mostraridDetalleFormularioRenta107;
	}

	public void setMostraridDetalleFormularioRenta107(Boolean mostraridDetalleFormularioRenta107) {
		this.mostraridDetalleFormularioRenta107= mostraridDetalleFormularioRenta107;
	}

	public Boolean getActivaridDetalleFormularioRenta107() {
		return this.activaridDetalleFormularioRenta107;
	}

	public void setActivaridDetalleFormularioRenta107(Boolean activaridDetalleFormularioRenta107) {
		this.activaridDetalleFormularioRenta107= activaridDetalleFormularioRenta107;
	}

	public Border setResaltarid_empresaDetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleFormularioRenta107() {
		return this.resaltarid_empresaDetalleFormularioRenta107;
	}

	public void setResaltarid_empresaDetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarid_empresaDetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleFormularioRenta107() {
		return this.mostrarid_empresaDetalleFormularioRenta107;
	}

	public void setMostrarid_empresaDetalleFormularioRenta107(Boolean mostrarid_empresaDetalleFormularioRenta107) {
		this.mostrarid_empresaDetalleFormularioRenta107= mostrarid_empresaDetalleFormularioRenta107;
	}

	public Boolean getActivarid_empresaDetalleFormularioRenta107() {
		return this.activarid_empresaDetalleFormularioRenta107;
	}

	public void setActivarid_empresaDetalleFormularioRenta107(Boolean activarid_empresaDetalleFormularioRenta107) {
		this.activarid_empresaDetalleFormularioRenta107= activarid_empresaDetalleFormularioRenta107;
	}

	public Boolean getCargarid_empresaDetalleFormularioRenta107() {
		return this.cargarid_empresaDetalleFormularioRenta107;
	}

	public void setCargarid_empresaDetalleFormularioRenta107(Boolean cargarid_empresaDetalleFormularioRenta107) {
		this.cargarid_empresaDetalleFormularioRenta107= cargarid_empresaDetalleFormularioRenta107;
	}

	public Border setResaltarid_empleadoDetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarid_empleadoDetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoDetalleFormularioRenta107() {
		return this.resaltarid_empleadoDetalleFormularioRenta107;
	}

	public void setResaltarid_empleadoDetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarid_empleadoDetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarid_empleadoDetalleFormularioRenta107() {
		return this.mostrarid_empleadoDetalleFormularioRenta107;
	}

	public void setMostrarid_empleadoDetalleFormularioRenta107(Boolean mostrarid_empleadoDetalleFormularioRenta107) {
		this.mostrarid_empleadoDetalleFormularioRenta107= mostrarid_empleadoDetalleFormularioRenta107;
	}

	public Boolean getActivarid_empleadoDetalleFormularioRenta107() {
		return this.activarid_empleadoDetalleFormularioRenta107;
	}

	public void setActivarid_empleadoDetalleFormularioRenta107(Boolean activarid_empleadoDetalleFormularioRenta107) {
		this.activarid_empleadoDetalleFormularioRenta107= activarid_empleadoDetalleFormularioRenta107;
	}

	public Boolean getCargarid_empleadoDetalleFormularioRenta107() {
		return this.cargarid_empleadoDetalleFormularioRenta107;
	}

	public void setCargarid_empleadoDetalleFormularioRenta107(Boolean cargarid_empleadoDetalleFormularioRenta107) {
		this.cargarid_empleadoDetalleFormularioRenta107= cargarid_empleadoDetalleFormularioRenta107;
	}

	public Border setResaltarid_formulario_renta107DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarid_formulario_renta107DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formulario_renta107DetalleFormularioRenta107() {
		return this.resaltarid_formulario_renta107DetalleFormularioRenta107;
	}

	public void setResaltarid_formulario_renta107DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarid_formulario_renta107DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarid_formulario_renta107DetalleFormularioRenta107() {
		return this.mostrarid_formulario_renta107DetalleFormularioRenta107;
	}

	public void setMostrarid_formulario_renta107DetalleFormularioRenta107(Boolean mostrarid_formulario_renta107DetalleFormularioRenta107) {
		this.mostrarid_formulario_renta107DetalleFormularioRenta107= mostrarid_formulario_renta107DetalleFormularioRenta107;
	}

	public Boolean getActivarid_formulario_renta107DetalleFormularioRenta107() {
		return this.activarid_formulario_renta107DetalleFormularioRenta107;
	}

	public void setActivarid_formulario_renta107DetalleFormularioRenta107(Boolean activarid_formulario_renta107DetalleFormularioRenta107) {
		this.activarid_formulario_renta107DetalleFormularioRenta107= activarid_formulario_renta107DetalleFormularioRenta107;
	}

	public Boolean getCargarid_formulario_renta107DetalleFormularioRenta107() {
		return this.cargarid_formulario_renta107DetalleFormularioRenta107;
	}

	public void setCargarid_formulario_renta107DetalleFormularioRenta107(Boolean cargarid_formulario_renta107DetalleFormularioRenta107) {
		this.cargarid_formulario_renta107DetalleFormularioRenta107= cargarid_formulario_renta107DetalleFormularioRenta107;
	}

	public Border setResaltarid_ejercicioDetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleFormularioRenta107() {
		return this.resaltarid_ejercicioDetalleFormularioRenta107;
	}

	public void setResaltarid_ejercicioDetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleFormularioRenta107() {
		return this.mostrarid_ejercicioDetalleFormularioRenta107;
	}

	public void setMostrarid_ejercicioDetalleFormularioRenta107(Boolean mostrarid_ejercicioDetalleFormularioRenta107) {
		this.mostrarid_ejercicioDetalleFormularioRenta107= mostrarid_ejercicioDetalleFormularioRenta107;
	}

	public Boolean getActivarid_ejercicioDetalleFormularioRenta107() {
		return this.activarid_ejercicioDetalleFormularioRenta107;
	}

	public void setActivarid_ejercicioDetalleFormularioRenta107(Boolean activarid_ejercicioDetalleFormularioRenta107) {
		this.activarid_ejercicioDetalleFormularioRenta107= activarid_ejercicioDetalleFormularioRenta107;
	}

	public Boolean getCargarid_ejercicioDetalleFormularioRenta107() {
		return this.cargarid_ejercicioDetalleFormularioRenta107;
	}

	public void setCargarid_ejercicioDetalleFormularioRenta107(Boolean cargarid_ejercicioDetalleFormularioRenta107) {
		this.cargarid_ejercicioDetalleFormularioRenta107= cargarid_ejercicioDetalleFormularioRenta107;
	}

	public Border setResaltarsueldos_301DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarsueldos_301DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsueldos_301DetalleFormularioRenta107() {
		return this.resaltarsueldos_301DetalleFormularioRenta107;
	}

	public void setResaltarsueldos_301DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarsueldos_301DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarsueldos_301DetalleFormularioRenta107() {
		return this.mostrarsueldos_301DetalleFormularioRenta107;
	}

	public void setMostrarsueldos_301DetalleFormularioRenta107(Boolean mostrarsueldos_301DetalleFormularioRenta107) {
		this.mostrarsueldos_301DetalleFormularioRenta107= mostrarsueldos_301DetalleFormularioRenta107;
	}

	public Boolean getActivarsueldos_301DetalleFormularioRenta107() {
		return this.activarsueldos_301DetalleFormularioRenta107;
	}

	public void setActivarsueldos_301DetalleFormularioRenta107(Boolean activarsueldos_301DetalleFormularioRenta107) {
		this.activarsueldos_301DetalleFormularioRenta107= activarsueldos_301DetalleFormularioRenta107;
	}

	public Border setResaltarsobre_sueldos_303DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarsobre_sueldos_303DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsobre_sueldos_303DetalleFormularioRenta107() {
		return this.resaltarsobre_sueldos_303DetalleFormularioRenta107;
	}

	public void setResaltarsobre_sueldos_303DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarsobre_sueldos_303DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarsobre_sueldos_303DetalleFormularioRenta107() {
		return this.mostrarsobre_sueldos_303DetalleFormularioRenta107;
	}

	public void setMostrarsobre_sueldos_303DetalleFormularioRenta107(Boolean mostrarsobre_sueldos_303DetalleFormularioRenta107) {
		this.mostrarsobre_sueldos_303DetalleFormularioRenta107= mostrarsobre_sueldos_303DetalleFormularioRenta107;
	}

	public Boolean getActivarsobre_sueldos_303DetalleFormularioRenta107() {
		return this.activarsobre_sueldos_303DetalleFormularioRenta107;
	}

	public void setActivarsobre_sueldos_303DetalleFormularioRenta107(Boolean activarsobre_sueldos_303DetalleFormularioRenta107) {
		this.activarsobre_sueldos_303DetalleFormularioRenta107= activarsobre_sueldos_303DetalleFormularioRenta107;
	}

	public Border setResaltardecimo_tercero_305DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltardecimo_tercero_305DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardecimo_tercero_305DetalleFormularioRenta107() {
		return this.resaltardecimo_tercero_305DetalleFormularioRenta107;
	}

	public void setResaltardecimo_tercero_305DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltardecimo_tercero_305DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrardecimo_tercero_305DetalleFormularioRenta107() {
		return this.mostrardecimo_tercero_305DetalleFormularioRenta107;
	}

	public void setMostrardecimo_tercero_305DetalleFormularioRenta107(Boolean mostrardecimo_tercero_305DetalleFormularioRenta107) {
		this.mostrardecimo_tercero_305DetalleFormularioRenta107= mostrardecimo_tercero_305DetalleFormularioRenta107;
	}

	public Boolean getActivardecimo_tercero_305DetalleFormularioRenta107() {
		return this.activardecimo_tercero_305DetalleFormularioRenta107;
	}

	public void setActivardecimo_tercero_305DetalleFormularioRenta107(Boolean activardecimo_tercero_305DetalleFormularioRenta107) {
		this.activardecimo_tercero_305DetalleFormularioRenta107= activardecimo_tercero_305DetalleFormularioRenta107;
	}

	public Border setResaltardecimo_cuarto_307DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltardecimo_cuarto_307DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardecimo_cuarto_307DetalleFormularioRenta107() {
		return this.resaltardecimo_cuarto_307DetalleFormularioRenta107;
	}

	public void setResaltardecimo_cuarto_307DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltardecimo_cuarto_307DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrardecimo_cuarto_307DetalleFormularioRenta107() {
		return this.mostrardecimo_cuarto_307DetalleFormularioRenta107;
	}

	public void setMostrardecimo_cuarto_307DetalleFormularioRenta107(Boolean mostrardecimo_cuarto_307DetalleFormularioRenta107) {
		this.mostrardecimo_cuarto_307DetalleFormularioRenta107= mostrardecimo_cuarto_307DetalleFormularioRenta107;
	}

	public Boolean getActivardecimo_cuarto_307DetalleFormularioRenta107() {
		return this.activardecimo_cuarto_307DetalleFormularioRenta107;
	}

	public void setActivardecimo_cuarto_307DetalleFormularioRenta107(Boolean activardecimo_cuarto_307DetalleFormularioRenta107) {
		this.activardecimo_cuarto_307DetalleFormularioRenta107= activardecimo_cuarto_307DetalleFormularioRenta107;
	}

	public Border setResaltarfondo_reserva_309DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarfondo_reserva_309DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfondo_reserva_309DetalleFormularioRenta107() {
		return this.resaltarfondo_reserva_309DetalleFormularioRenta107;
	}

	public void setResaltarfondo_reserva_309DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarfondo_reserva_309DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarfondo_reserva_309DetalleFormularioRenta107() {
		return this.mostrarfondo_reserva_309DetalleFormularioRenta107;
	}

	public void setMostrarfondo_reserva_309DetalleFormularioRenta107(Boolean mostrarfondo_reserva_309DetalleFormularioRenta107) {
		this.mostrarfondo_reserva_309DetalleFormularioRenta107= mostrarfondo_reserva_309DetalleFormularioRenta107;
	}

	public Boolean getActivarfondo_reserva_309DetalleFormularioRenta107() {
		return this.activarfondo_reserva_309DetalleFormularioRenta107;
	}

	public void setActivarfondo_reserva_309DetalleFormularioRenta107(Boolean activarfondo_reserva_309DetalleFormularioRenta107) {
		this.activarfondo_reserva_309DetalleFormularioRenta107= activarfondo_reserva_309DetalleFormularioRenta107;
	}

	public Border setResaltarutilidades_311DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarutilidades_311DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidades_311DetalleFormularioRenta107() {
		return this.resaltarutilidades_311DetalleFormularioRenta107;
	}

	public void setResaltarutilidades_311DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarutilidades_311DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarutilidades_311DetalleFormularioRenta107() {
		return this.mostrarutilidades_311DetalleFormularioRenta107;
	}

	public void setMostrarutilidades_311DetalleFormularioRenta107(Boolean mostrarutilidades_311DetalleFormularioRenta107) {
		this.mostrarutilidades_311DetalleFormularioRenta107= mostrarutilidades_311DetalleFormularioRenta107;
	}

	public Boolean getActivarutilidades_311DetalleFormularioRenta107() {
		return this.activarutilidades_311DetalleFormularioRenta107;
	}

	public void setActivarutilidades_311DetalleFormularioRenta107(Boolean activarutilidades_311DetalleFormularioRenta107) {
		this.activarutilidades_311DetalleFormularioRenta107= activarutilidades_311DetalleFormularioRenta107;
	}

	public Border setResaltardesahucio_313DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltardesahucio_313DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardesahucio_313DetalleFormularioRenta107() {
		return this.resaltardesahucio_313DetalleFormularioRenta107;
	}

	public void setResaltardesahucio_313DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltardesahucio_313DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrardesahucio_313DetalleFormularioRenta107() {
		return this.mostrardesahucio_313DetalleFormularioRenta107;
	}

	public void setMostrardesahucio_313DetalleFormularioRenta107(Boolean mostrardesahucio_313DetalleFormularioRenta107) {
		this.mostrardesahucio_313DetalleFormularioRenta107= mostrardesahucio_313DetalleFormularioRenta107;
	}

	public Boolean getActivardesahucio_313DetalleFormularioRenta107() {
		return this.activardesahucio_313DetalleFormularioRenta107;
	}

	public void setActivardesahucio_313DetalleFormularioRenta107(Boolean activardesahucio_313DetalleFormularioRenta107) {
		this.activardesahucio_313DetalleFormularioRenta107= activardesahucio_313DetalleFormularioRenta107;
	}

	public Border setResaltariess_personal_315DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltariess_personal_315DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariess_personal_315DetalleFormularioRenta107() {
		return this.resaltariess_personal_315DetalleFormularioRenta107;
	}

	public void setResaltariess_personal_315DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltariess_personal_315DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrariess_personal_315DetalleFormularioRenta107() {
		return this.mostrariess_personal_315DetalleFormularioRenta107;
	}

	public void setMostrariess_personal_315DetalleFormularioRenta107(Boolean mostrariess_personal_315DetalleFormularioRenta107) {
		this.mostrariess_personal_315DetalleFormularioRenta107= mostrariess_personal_315DetalleFormularioRenta107;
	}

	public Boolean getActivariess_personal_315DetalleFormularioRenta107() {
		return this.activariess_personal_315DetalleFormularioRenta107;
	}

	public void setActivariess_personal_315DetalleFormularioRenta107(Boolean activariess_personal_315DetalleFormularioRenta107) {
		this.activariess_personal_315DetalleFormularioRenta107= activariess_personal_315DetalleFormularioRenta107;
	}

	public Border setResaltargastos_vivienda_317DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltargastos_vivienda_317DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargastos_vivienda_317DetalleFormularioRenta107() {
		return this.resaltargastos_vivienda_317DetalleFormularioRenta107;
	}

	public void setResaltargastos_vivienda_317DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltargastos_vivienda_317DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrargastos_vivienda_317DetalleFormularioRenta107() {
		return this.mostrargastos_vivienda_317DetalleFormularioRenta107;
	}

	public void setMostrargastos_vivienda_317DetalleFormularioRenta107(Boolean mostrargastos_vivienda_317DetalleFormularioRenta107) {
		this.mostrargastos_vivienda_317DetalleFormularioRenta107= mostrargastos_vivienda_317DetalleFormularioRenta107;
	}

	public Boolean getActivargastos_vivienda_317DetalleFormularioRenta107() {
		return this.activargastos_vivienda_317DetalleFormularioRenta107;
	}

	public void setActivargastos_vivienda_317DetalleFormularioRenta107(Boolean activargastos_vivienda_317DetalleFormularioRenta107) {
		this.activargastos_vivienda_317DetalleFormularioRenta107= activargastos_vivienda_317DetalleFormularioRenta107;
	}

	public Border setResaltargastos_salud_319DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltargastos_salud_319DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargastos_salud_319DetalleFormularioRenta107() {
		return this.resaltargastos_salud_319DetalleFormularioRenta107;
	}

	public void setResaltargastos_salud_319DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltargastos_salud_319DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrargastos_salud_319DetalleFormularioRenta107() {
		return this.mostrargastos_salud_319DetalleFormularioRenta107;
	}

	public void setMostrargastos_salud_319DetalleFormularioRenta107(Boolean mostrargastos_salud_319DetalleFormularioRenta107) {
		this.mostrargastos_salud_319DetalleFormularioRenta107= mostrargastos_salud_319DetalleFormularioRenta107;
	}

	public Boolean getActivargastos_salud_319DetalleFormularioRenta107() {
		return this.activargastos_salud_319DetalleFormularioRenta107;
	}

	public void setActivargastos_salud_319DetalleFormularioRenta107(Boolean activargastos_salud_319DetalleFormularioRenta107) {
		this.activargastos_salud_319DetalleFormularioRenta107= activargastos_salud_319DetalleFormularioRenta107;
	}

	public Border setResaltargastos_educacion_321DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltargastos_educacion_321DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargastos_educacion_321DetalleFormularioRenta107() {
		return this.resaltargastos_educacion_321DetalleFormularioRenta107;
	}

	public void setResaltargastos_educacion_321DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltargastos_educacion_321DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrargastos_educacion_321DetalleFormularioRenta107() {
		return this.mostrargastos_educacion_321DetalleFormularioRenta107;
	}

	public void setMostrargastos_educacion_321DetalleFormularioRenta107(Boolean mostrargastos_educacion_321DetalleFormularioRenta107) {
		this.mostrargastos_educacion_321DetalleFormularioRenta107= mostrargastos_educacion_321DetalleFormularioRenta107;
	}

	public Boolean getActivargastos_educacion_321DetalleFormularioRenta107() {
		return this.activargastos_educacion_321DetalleFormularioRenta107;
	}

	public void setActivargastos_educacion_321DetalleFormularioRenta107(Boolean activargastos_educacion_321DetalleFormularioRenta107) {
		this.activargastos_educacion_321DetalleFormularioRenta107= activargastos_educacion_321DetalleFormularioRenta107;
	}

	public Border setResaltargastos_alimentacion_323DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltargastos_alimentacion_323DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargastos_alimentacion_323DetalleFormularioRenta107() {
		return this.resaltargastos_alimentacion_323DetalleFormularioRenta107;
	}

	public void setResaltargastos_alimentacion_323DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltargastos_alimentacion_323DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrargastos_alimentacion_323DetalleFormularioRenta107() {
		return this.mostrargastos_alimentacion_323DetalleFormularioRenta107;
	}

	public void setMostrargastos_alimentacion_323DetalleFormularioRenta107(Boolean mostrargastos_alimentacion_323DetalleFormularioRenta107) {
		this.mostrargastos_alimentacion_323DetalleFormularioRenta107= mostrargastos_alimentacion_323DetalleFormularioRenta107;
	}

	public Boolean getActivargastos_alimentacion_323DetalleFormularioRenta107() {
		return this.activargastos_alimentacion_323DetalleFormularioRenta107;
	}

	public void setActivargastos_alimentacion_323DetalleFormularioRenta107(Boolean activargastos_alimentacion_323DetalleFormularioRenta107) {
		this.activargastos_alimentacion_323DetalleFormularioRenta107= activargastos_alimentacion_323DetalleFormularioRenta107;
	}

	public Border setResaltargastos_vestimenta_325DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltargastos_vestimenta_325DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargastos_vestimenta_325DetalleFormularioRenta107() {
		return this.resaltargastos_vestimenta_325DetalleFormularioRenta107;
	}

	public void setResaltargastos_vestimenta_325DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltargastos_vestimenta_325DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrargastos_vestimenta_325DetalleFormularioRenta107() {
		return this.mostrargastos_vestimenta_325DetalleFormularioRenta107;
	}

	public void setMostrargastos_vestimenta_325DetalleFormularioRenta107(Boolean mostrargastos_vestimenta_325DetalleFormularioRenta107) {
		this.mostrargastos_vestimenta_325DetalleFormularioRenta107= mostrargastos_vestimenta_325DetalleFormularioRenta107;
	}

	public Boolean getActivargastos_vestimenta_325DetalleFormularioRenta107() {
		return this.activargastos_vestimenta_325DetalleFormularioRenta107;
	}

	public void setActivargastos_vestimenta_325DetalleFormularioRenta107(Boolean activargastos_vestimenta_325DetalleFormularioRenta107) {
		this.activargastos_vestimenta_325DetalleFormularioRenta107= activargastos_vestimenta_325DetalleFormularioRenta107;
	}

	public Border setResaltardescuento_discapacidad_327DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltardescuento_discapacidad_327DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_discapacidad_327DetalleFormularioRenta107() {
		return this.resaltardescuento_discapacidad_327DetalleFormularioRenta107;
	}

	public void setResaltardescuento_discapacidad_327DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltardescuento_discapacidad_327DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrardescuento_discapacidad_327DetalleFormularioRenta107() {
		return this.mostrardescuento_discapacidad_327DetalleFormularioRenta107;
	}

	public void setMostrardescuento_discapacidad_327DetalleFormularioRenta107(Boolean mostrardescuento_discapacidad_327DetalleFormularioRenta107) {
		this.mostrardescuento_discapacidad_327DetalleFormularioRenta107= mostrardescuento_discapacidad_327DetalleFormularioRenta107;
	}

	public Boolean getActivardescuento_discapacidad_327DetalleFormularioRenta107() {
		return this.activardescuento_discapacidad_327DetalleFormularioRenta107;
	}

	public void setActivardescuento_discapacidad_327DetalleFormularioRenta107(Boolean activardescuento_discapacidad_327DetalleFormularioRenta107) {
		this.activardescuento_discapacidad_327DetalleFormularioRenta107= activardescuento_discapacidad_327DetalleFormularioRenta107;
	}

	public Border setResaltardescuento_tercera_edad_329DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltardescuento_tercera_edad_329DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_tercera_edad_329DetalleFormularioRenta107() {
		return this.resaltardescuento_tercera_edad_329DetalleFormularioRenta107;
	}

	public void setResaltardescuento_tercera_edad_329DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltardescuento_tercera_edad_329DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrardescuento_tercera_edad_329DetalleFormularioRenta107() {
		return this.mostrardescuento_tercera_edad_329DetalleFormularioRenta107;
	}

	public void setMostrardescuento_tercera_edad_329DetalleFormularioRenta107(Boolean mostrardescuento_tercera_edad_329DetalleFormularioRenta107) {
		this.mostrardescuento_tercera_edad_329DetalleFormularioRenta107= mostrardescuento_tercera_edad_329DetalleFormularioRenta107;
	}

	public Boolean getActivardescuento_tercera_edad_329DetalleFormularioRenta107() {
		return this.activardescuento_tercera_edad_329DetalleFormularioRenta107;
	}

	public void setActivardescuento_tercera_edad_329DetalleFormularioRenta107(Boolean activardescuento_tercera_edad_329DetalleFormularioRenta107) {
		this.activardescuento_tercera_edad_329DetalleFormularioRenta107= activardescuento_tercera_edad_329DetalleFormularioRenta107;
	}

	public Border setResaltarasume_empleador_331DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarasume_empleador_331DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarasume_empleador_331DetalleFormularioRenta107() {
		return this.resaltarasume_empleador_331DetalleFormularioRenta107;
	}

	public void setResaltarasume_empleador_331DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarasume_empleador_331DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarasume_empleador_331DetalleFormularioRenta107() {
		return this.mostrarasume_empleador_331DetalleFormularioRenta107;
	}

	public void setMostrarasume_empleador_331DetalleFormularioRenta107(Boolean mostrarasume_empleador_331DetalleFormularioRenta107) {
		this.mostrarasume_empleador_331DetalleFormularioRenta107= mostrarasume_empleador_331DetalleFormularioRenta107;
	}

	public Boolean getActivarasume_empleador_331DetalleFormularioRenta107() {
		return this.activarasume_empleador_331DetalleFormularioRenta107;
	}

	public void setActivarasume_empleador_331DetalleFormularioRenta107(Boolean activarasume_empleador_331DetalleFormularioRenta107) {
		this.activarasume_empleador_331DetalleFormularioRenta107= activarasume_empleador_331DetalleFormularioRenta107;
	}

	public Border setResaltarsub_empleador_351DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarsub_empleador_351DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_empleador_351DetalleFormularioRenta107() {
		return this.resaltarsub_empleador_351DetalleFormularioRenta107;
	}

	public void setResaltarsub_empleador_351DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarsub_empleador_351DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarsub_empleador_351DetalleFormularioRenta107() {
		return this.mostrarsub_empleador_351DetalleFormularioRenta107;
	}

	public void setMostrarsub_empleador_351DetalleFormularioRenta107(Boolean mostrarsub_empleador_351DetalleFormularioRenta107) {
		this.mostrarsub_empleador_351DetalleFormularioRenta107= mostrarsub_empleador_351DetalleFormularioRenta107;
	}

	public Boolean getActivarsub_empleador_351DetalleFormularioRenta107() {
		return this.activarsub_empleador_351DetalleFormularioRenta107;
	}

	public void setActivarsub_empleador_351DetalleFormularioRenta107(Boolean activarsub_empleador_351DetalleFormularioRenta107) {
		this.activarsub_empleador_351DetalleFormularioRenta107= activarsub_empleador_351DetalleFormularioRenta107;
	}

	public Border setResaltarnumero_meses_trabajados_353DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarnumero_meses_trabajados_353DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_meses_trabajados_353DetalleFormularioRenta107() {
		return this.resaltarnumero_meses_trabajados_353DetalleFormularioRenta107;
	}

	public void setResaltarnumero_meses_trabajados_353DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarnumero_meses_trabajados_353DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarnumero_meses_trabajados_353DetalleFormularioRenta107() {
		return this.mostrarnumero_meses_trabajados_353DetalleFormularioRenta107;
	}

	public void setMostrarnumero_meses_trabajados_353DetalleFormularioRenta107(Boolean mostrarnumero_meses_trabajados_353DetalleFormularioRenta107) {
		this.mostrarnumero_meses_trabajados_353DetalleFormularioRenta107= mostrarnumero_meses_trabajados_353DetalleFormularioRenta107;
	}

	public Boolean getActivarnumero_meses_trabajados_353DetalleFormularioRenta107() {
		return this.activarnumero_meses_trabajados_353DetalleFormularioRenta107;
	}

	public void setActivarnumero_meses_trabajados_353DetalleFormularioRenta107(Boolean activarnumero_meses_trabajados_353DetalleFormularioRenta107) {
		this.activarnumero_meses_trabajados_353DetalleFormularioRenta107= activarnumero_meses_trabajados_353DetalleFormularioRenta107;
	}

	public Border setResaltaringreso_otros_empleadores_401DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltaringreso_otros_empleadores_401DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringreso_otros_empleadores_401DetalleFormularioRenta107() {
		return this.resaltaringreso_otros_empleadores_401DetalleFormularioRenta107;
	}

	public void setResaltaringreso_otros_empleadores_401DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltaringreso_otros_empleadores_401DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostraringreso_otros_empleadores_401DetalleFormularioRenta107() {
		return this.mostraringreso_otros_empleadores_401DetalleFormularioRenta107;
	}

	public void setMostraringreso_otros_empleadores_401DetalleFormularioRenta107(Boolean mostraringreso_otros_empleadores_401DetalleFormularioRenta107) {
		this.mostraringreso_otros_empleadores_401DetalleFormularioRenta107= mostraringreso_otros_empleadores_401DetalleFormularioRenta107;
	}

	public Boolean getActivaringreso_otros_empleadores_401DetalleFormularioRenta107() {
		return this.activaringreso_otros_empleadores_401DetalleFormularioRenta107;
	}

	public void setActivaringreso_otros_empleadores_401DetalleFormularioRenta107(Boolean activaringreso_otros_empleadores_401DetalleFormularioRenta107) {
		this.activaringreso_otros_empleadores_401DetalleFormularioRenta107= activaringreso_otros_empleadores_401DetalleFormularioRenta107;
	}

	public Border setResaltardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107() {
		return this.resaltardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107;
	}

	public void setResaltardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107() {
		return this.mostrardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107;
	}

	public void setMostrardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(Boolean mostrardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107) {
		this.mostrardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107= mostrardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107;
	}

	public Boolean getActivardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107() {
		return this.activardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107;
	}

	public void setActivardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(Boolean activardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107) {
		this.activardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107= activardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107;
	}

	public Border setResaltarrebajas_otros_empleadores_405DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarrebajas_otros_empleadores_405DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrebajas_otros_empleadores_405DetalleFormularioRenta107() {
		return this.resaltarrebajas_otros_empleadores_405DetalleFormularioRenta107;
	}

	public void setResaltarrebajas_otros_empleadores_405DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarrebajas_otros_empleadores_405DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarrebajas_otros_empleadores_405DetalleFormularioRenta107() {
		return this.mostrarrebajas_otros_empleadores_405DetalleFormularioRenta107;
	}

	public void setMostrarrebajas_otros_empleadores_405DetalleFormularioRenta107(Boolean mostrarrebajas_otros_empleadores_405DetalleFormularioRenta107) {
		this.mostrarrebajas_otros_empleadores_405DetalleFormularioRenta107= mostrarrebajas_otros_empleadores_405DetalleFormularioRenta107;
	}

	public Boolean getActivarrebajas_otros_empleadores_405DetalleFormularioRenta107() {
		return this.activarrebajas_otros_empleadores_405DetalleFormularioRenta107;
	}

	public void setActivarrebajas_otros_empleadores_405DetalleFormularioRenta107(Boolean activarrebajas_otros_empleadores_405DetalleFormularioRenta107) {
		this.activarrebajas_otros_empleadores_405DetalleFormularioRenta107= activarrebajas_otros_empleadores_405DetalleFormularioRenta107;
	}

	public Border setResaltarbase_imponible_anual_407DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarbase_imponible_anual_407DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponible_anual_407DetalleFormularioRenta107() {
		return this.resaltarbase_imponible_anual_407DetalleFormularioRenta107;
	}

	public void setResaltarbase_imponible_anual_407DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarbase_imponible_anual_407DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarbase_imponible_anual_407DetalleFormularioRenta107() {
		return this.mostrarbase_imponible_anual_407DetalleFormularioRenta107;
	}

	public void setMostrarbase_imponible_anual_407DetalleFormularioRenta107(Boolean mostrarbase_imponible_anual_407DetalleFormularioRenta107) {
		this.mostrarbase_imponible_anual_407DetalleFormularioRenta107= mostrarbase_imponible_anual_407DetalleFormularioRenta107;
	}

	public Boolean getActivarbase_imponible_anual_407DetalleFormularioRenta107() {
		return this.activarbase_imponible_anual_407DetalleFormularioRenta107;
	}

	public void setActivarbase_imponible_anual_407DetalleFormularioRenta107(Boolean activarbase_imponible_anual_407DetalleFormularioRenta107) {
		this.activarbase_imponible_anual_407DetalleFormularioRenta107= activarbase_imponible_anual_407DetalleFormularioRenta107;
	}

	public Border setResaltarimpuesto_causado_409DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarimpuesto_causado_409DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuesto_causado_409DetalleFormularioRenta107() {
		return this.resaltarimpuesto_causado_409DetalleFormularioRenta107;
	}

	public void setResaltarimpuesto_causado_409DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarimpuesto_causado_409DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarimpuesto_causado_409DetalleFormularioRenta107() {
		return this.mostrarimpuesto_causado_409DetalleFormularioRenta107;
	}

	public void setMostrarimpuesto_causado_409DetalleFormularioRenta107(Boolean mostrarimpuesto_causado_409DetalleFormularioRenta107) {
		this.mostrarimpuesto_causado_409DetalleFormularioRenta107= mostrarimpuesto_causado_409DetalleFormularioRenta107;
	}

	public Boolean getActivarimpuesto_causado_409DetalleFormularioRenta107() {
		return this.activarimpuesto_causado_409DetalleFormularioRenta107;
	}

	public void setActivarimpuesto_causado_409DetalleFormularioRenta107(Boolean activarimpuesto_causado_409DetalleFormularioRenta107) {
		this.activarimpuesto_causado_409DetalleFormularioRenta107= activarimpuesto_causado_409DetalleFormularioRenta107;
	}

	public Border setResaltarimpuesto_retenido_empleador_411DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarimpuesto_retenido_empleador_411DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuesto_retenido_empleador_411DetalleFormularioRenta107() {
		return this.resaltarimpuesto_retenido_empleador_411DetalleFormularioRenta107;
	}

	public void setResaltarimpuesto_retenido_empleador_411DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarimpuesto_retenido_empleador_411DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarimpuesto_retenido_empleador_411DetalleFormularioRenta107() {
		return this.mostrarimpuesto_retenido_empleador_411DetalleFormularioRenta107;
	}

	public void setMostrarimpuesto_retenido_empleador_411DetalleFormularioRenta107(Boolean mostrarimpuesto_retenido_empleador_411DetalleFormularioRenta107) {
		this.mostrarimpuesto_retenido_empleador_411DetalleFormularioRenta107= mostrarimpuesto_retenido_empleador_411DetalleFormularioRenta107;
	}

	public Boolean getActivarimpuesto_retenido_empleador_411DetalleFormularioRenta107() {
		return this.activarimpuesto_retenido_empleador_411DetalleFormularioRenta107;
	}

	public void setActivarimpuesto_retenido_empleador_411DetalleFormularioRenta107(Boolean activarimpuesto_retenido_empleador_411DetalleFormularioRenta107) {
		this.activarimpuesto_retenido_empleador_411DetalleFormularioRenta107= activarimpuesto_retenido_empleador_411DetalleFormularioRenta107;
	}

	public Border setResaltarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleformulariorenta107BeanSwingJInternalFrame.jTtoolBarDetalleFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107() {
		return this.resaltarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107;
	}

	public void setResaltarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107() {
		return this.mostrarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107;
	}

	public void setMostrarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(Boolean mostrarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107) {
		this.mostrarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107= mostrarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107;
	}

	public Boolean getActivarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107() {
		return this.activarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107;
	}

	public void setActivarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(Boolean activarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107) {
		this.activarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107= activarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107;
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
		
		
		this.setMostraridDetalleFormularioRenta107(esInicial);
		this.setMostrarid_empresaDetalleFormularioRenta107(esInicial);
		this.setMostrarid_empleadoDetalleFormularioRenta107(esInicial);
		this.setMostrarid_formulario_renta107DetalleFormularioRenta107(esInicial);
		this.setMostrarid_ejercicioDetalleFormularioRenta107(esInicial);
		this.setMostrarsueldos_301DetalleFormularioRenta107(esInicial);
		this.setMostrarsobre_sueldos_303DetalleFormularioRenta107(esInicial);
		this.setMostrardecimo_tercero_305DetalleFormularioRenta107(esInicial);
		this.setMostrardecimo_cuarto_307DetalleFormularioRenta107(esInicial);
		this.setMostrarfondo_reserva_309DetalleFormularioRenta107(esInicial);
		this.setMostrarutilidades_311DetalleFormularioRenta107(esInicial);
		this.setMostrardesahucio_313DetalleFormularioRenta107(esInicial);
		this.setMostrariess_personal_315DetalleFormularioRenta107(esInicial);
		this.setMostrargastos_vivienda_317DetalleFormularioRenta107(esInicial);
		this.setMostrargastos_salud_319DetalleFormularioRenta107(esInicial);
		this.setMostrargastos_educacion_321DetalleFormularioRenta107(esInicial);
		this.setMostrargastos_alimentacion_323DetalleFormularioRenta107(esInicial);
		this.setMostrargastos_vestimenta_325DetalleFormularioRenta107(esInicial);
		this.setMostrardescuento_discapacidad_327DetalleFormularioRenta107(esInicial);
		this.setMostrardescuento_tercera_edad_329DetalleFormularioRenta107(esInicial);
		this.setMostrarasume_empleador_331DetalleFormularioRenta107(esInicial);
		this.setMostrarsub_empleador_351DetalleFormularioRenta107(esInicial);
		this.setMostrarnumero_meses_trabajados_353DetalleFormularioRenta107(esInicial);
		this.setMostraringreso_otros_empleadores_401DetalleFormularioRenta107(esInicial);
		this.setMostrardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(esInicial);
		this.setMostrarrebajas_otros_empleadores_405DetalleFormularioRenta107(esInicial);
		this.setMostrarbase_imponible_anual_407DetalleFormularioRenta107(esInicial);
		this.setMostrarimpuesto_causado_409DetalleFormularioRenta107(esInicial);
		this.setMostrarimpuesto_retenido_empleador_411DetalleFormularioRenta107(esInicial);
		this.setMostrarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.ID)) {
				this.setMostraridDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107)) {
				this.setMostrarid_formulario_renta107DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301)) {
				this.setMostrarsueldos_301DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303)) {
				this.setMostrarsobre_sueldos_303DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305)) {
				this.setMostrardecimo_tercero_305DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307)) {
				this.setMostrardecimo_cuarto_307DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309)) {
				this.setMostrarfondo_reserva_309DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311)) {
				this.setMostrarutilidades_311DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313)) {
				this.setMostrardesahucio_313DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315)) {
				this.setMostrariess_personal_315DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317)) {
				this.setMostrargastos_vivienda_317DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319)) {
				this.setMostrargastos_salud_319DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321)) {
				this.setMostrargastos_educacion_321DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323)) {
				this.setMostrargastos_alimentacion_323DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325)) {
				this.setMostrargastos_vestimenta_325DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327)) {
				this.setMostrardescuento_discapacidad_327DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329)) {
				this.setMostrardescuento_tercera_edad_329DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331)) {
				this.setMostrarasume_empleador_331DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351)) {
				this.setMostrarsub_empleador_351DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353)) {
				this.setMostrarnumero_meses_trabajados_353DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401)) {
				this.setMostraringreso_otros_empleadores_401DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403)) {
				this.setMostrardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405)) {
				this.setMostrarrebajas_otros_empleadores_405DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407)) {
				this.setMostrarbase_imponible_anual_407DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409)) {
				this.setMostrarimpuesto_causado_409DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411)) {
				this.setMostrarimpuesto_retenido_empleador_411DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413)) {
				this.setMostrarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(esAsigna);
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
		
		
		this.setActivaridDetalleFormularioRenta107(esInicial);
		this.setActivarid_empresaDetalleFormularioRenta107(esInicial);
		this.setActivarid_empleadoDetalleFormularioRenta107(esInicial);
		this.setActivarid_formulario_renta107DetalleFormularioRenta107(esInicial);
		this.setActivarid_ejercicioDetalleFormularioRenta107(esInicial);
		this.setActivarsueldos_301DetalleFormularioRenta107(esInicial);
		this.setActivarsobre_sueldos_303DetalleFormularioRenta107(esInicial);
		this.setActivardecimo_tercero_305DetalleFormularioRenta107(esInicial);
		this.setActivardecimo_cuarto_307DetalleFormularioRenta107(esInicial);
		this.setActivarfondo_reserva_309DetalleFormularioRenta107(esInicial);
		this.setActivarutilidades_311DetalleFormularioRenta107(esInicial);
		this.setActivardesahucio_313DetalleFormularioRenta107(esInicial);
		this.setActivariess_personal_315DetalleFormularioRenta107(esInicial);
		this.setActivargastos_vivienda_317DetalleFormularioRenta107(esInicial);
		this.setActivargastos_salud_319DetalleFormularioRenta107(esInicial);
		this.setActivargastos_educacion_321DetalleFormularioRenta107(esInicial);
		this.setActivargastos_alimentacion_323DetalleFormularioRenta107(esInicial);
		this.setActivargastos_vestimenta_325DetalleFormularioRenta107(esInicial);
		this.setActivardescuento_discapacidad_327DetalleFormularioRenta107(esInicial);
		this.setActivardescuento_tercera_edad_329DetalleFormularioRenta107(esInicial);
		this.setActivarasume_empleador_331DetalleFormularioRenta107(esInicial);
		this.setActivarsub_empleador_351DetalleFormularioRenta107(esInicial);
		this.setActivarnumero_meses_trabajados_353DetalleFormularioRenta107(esInicial);
		this.setActivaringreso_otros_empleadores_401DetalleFormularioRenta107(esInicial);
		this.setActivardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(esInicial);
		this.setActivarrebajas_otros_empleadores_405DetalleFormularioRenta107(esInicial);
		this.setActivarbase_imponible_anual_407DetalleFormularioRenta107(esInicial);
		this.setActivarimpuesto_causado_409DetalleFormularioRenta107(esInicial);
		this.setActivarimpuesto_retenido_empleador_411DetalleFormularioRenta107(esInicial);
		this.setActivarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.ID)) {
				this.setActivaridDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107)) {
				this.setActivarid_formulario_renta107DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301)) {
				this.setActivarsueldos_301DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303)) {
				this.setActivarsobre_sueldos_303DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305)) {
				this.setActivardecimo_tercero_305DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307)) {
				this.setActivardecimo_cuarto_307DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309)) {
				this.setActivarfondo_reserva_309DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311)) {
				this.setActivarutilidades_311DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313)) {
				this.setActivardesahucio_313DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315)) {
				this.setActivariess_personal_315DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317)) {
				this.setActivargastos_vivienda_317DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319)) {
				this.setActivargastos_salud_319DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321)) {
				this.setActivargastos_educacion_321DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323)) {
				this.setActivargastos_alimentacion_323DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325)) {
				this.setActivargastos_vestimenta_325DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327)) {
				this.setActivardescuento_discapacidad_327DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329)) {
				this.setActivardescuento_tercera_edad_329DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331)) {
				this.setActivarasume_empleador_331DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351)) {
				this.setActivarsub_empleador_351DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353)) {
				this.setActivarnumero_meses_trabajados_353DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401)) {
				this.setActivaringreso_otros_empleadores_401DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403)) {
				this.setActivardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405)) {
				this.setActivarrebajas_otros_empleadores_405DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407)) {
				this.setActivarbase_imponible_anual_407DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409)) {
				this.setActivarimpuesto_causado_409DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411)) {
				this.setActivarimpuesto_retenido_empleador_411DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413)) {
				this.setActivarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleFormularioRenta107(esInicial);
		this.setResaltarid_empresaDetalleFormularioRenta107(esInicial);
		this.setResaltarid_empleadoDetalleFormularioRenta107(esInicial);
		this.setResaltarid_formulario_renta107DetalleFormularioRenta107(esInicial);
		this.setResaltarid_ejercicioDetalleFormularioRenta107(esInicial);
		this.setResaltarsueldos_301DetalleFormularioRenta107(esInicial);
		this.setResaltarsobre_sueldos_303DetalleFormularioRenta107(esInicial);
		this.setResaltardecimo_tercero_305DetalleFormularioRenta107(esInicial);
		this.setResaltardecimo_cuarto_307DetalleFormularioRenta107(esInicial);
		this.setResaltarfondo_reserva_309DetalleFormularioRenta107(esInicial);
		this.setResaltarutilidades_311DetalleFormularioRenta107(esInicial);
		this.setResaltardesahucio_313DetalleFormularioRenta107(esInicial);
		this.setResaltariess_personal_315DetalleFormularioRenta107(esInicial);
		this.setResaltargastos_vivienda_317DetalleFormularioRenta107(esInicial);
		this.setResaltargastos_salud_319DetalleFormularioRenta107(esInicial);
		this.setResaltargastos_educacion_321DetalleFormularioRenta107(esInicial);
		this.setResaltargastos_alimentacion_323DetalleFormularioRenta107(esInicial);
		this.setResaltargastos_vestimenta_325DetalleFormularioRenta107(esInicial);
		this.setResaltardescuento_discapacidad_327DetalleFormularioRenta107(esInicial);
		this.setResaltardescuento_tercera_edad_329DetalleFormularioRenta107(esInicial);
		this.setResaltarasume_empleador_331DetalleFormularioRenta107(esInicial);
		this.setResaltarsub_empleador_351DetalleFormularioRenta107(esInicial);
		this.setResaltarnumero_meses_trabajados_353DetalleFormularioRenta107(esInicial);
		this.setResaltaringreso_otros_empleadores_401DetalleFormularioRenta107(esInicial);
		this.setResaltardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(esInicial);
		this.setResaltarrebajas_otros_empleadores_405DetalleFormularioRenta107(esInicial);
		this.setResaltarbase_imponible_anual_407DetalleFormularioRenta107(esInicial);
		this.setResaltarimpuesto_causado_409DetalleFormularioRenta107(esInicial);
		this.setResaltarimpuesto_retenido_empleador_411DetalleFormularioRenta107(esInicial);
		this.setResaltarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.ID)) {
				this.setResaltaridDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107)) {
				this.setResaltarid_formulario_renta107DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301)) {
				this.setResaltarsueldos_301DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303)) {
				this.setResaltarsobre_sueldos_303DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305)) {
				this.setResaltardecimo_tercero_305DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307)) {
				this.setResaltardecimo_cuarto_307DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309)) {
				this.setResaltarfondo_reserva_309DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311)) {
				this.setResaltarutilidades_311DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313)) {
				this.setResaltardesahucio_313DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315)) {
				this.setResaltariess_personal_315DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317)) {
				this.setResaltargastos_vivienda_317DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319)) {
				this.setResaltargastos_salud_319DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321)) {
				this.setResaltargastos_educacion_321DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323)) {
				this.setResaltargastos_alimentacion_323DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325)) {
				this.setResaltargastos_vestimenta_325DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327)) {
				this.setResaltardescuento_discapacidad_327DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329)) {
				this.setResaltardescuento_tercera_edad_329DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331)) {
				this.setResaltarasume_empleador_331DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351)) {
				this.setResaltarsub_empleador_351DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353)) {
				this.setResaltarnumero_meses_trabajados_353DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401)) {
				this.setResaltaringreso_otros_empleadores_401DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403)) {
				this.setResaltardeduccion_gastos_otros_empleadores_403DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405)) {
				this.setResaltarrebajas_otros_empleadores_405DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407)) {
				this.setResaltarbase_imponible_anual_407DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409)) {
				this.setResaltarimpuesto_causado_409DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411)) {
				this.setResaltarimpuesto_retenido_empleador_411DetalleFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413)) {
				this.setResaltarimpuesto_retenido_otros_empleadores_413DetalleFormularioRenta107(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEjercicioDetalleFormularioRenta107=true;

	public Boolean getMostrarFK_IdEjercicioDetalleFormularioRenta107() {
		return this.mostrarFK_IdEjercicioDetalleFormularioRenta107;
	}

	public void setMostrarFK_IdEjercicioDetalleFormularioRenta107(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleFormularioRenta107= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoDetalleFormularioRenta107=true;

	public Boolean getMostrarFK_IdEmpleadoDetalleFormularioRenta107() {
		return this.mostrarFK_IdEmpleadoDetalleFormularioRenta107;
	}

	public void setMostrarFK_IdEmpleadoDetalleFormularioRenta107(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoDetalleFormularioRenta107= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleFormularioRenta107=true;

	public Boolean getMostrarFK_IdEmpresaDetalleFormularioRenta107() {
		return this.mostrarFK_IdEmpresaDetalleFormularioRenta107;
	}

	public void setMostrarFK_IdEmpresaDetalleFormularioRenta107(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleFormularioRenta107= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormularioRenta107DetalleFormularioRenta107=true;

	public Boolean getMostrarFK_IdFormularioRenta107DetalleFormularioRenta107() {
		return this.mostrarFK_IdFormularioRenta107DetalleFormularioRenta107;
	}

	public void setMostrarFK_IdFormularioRenta107DetalleFormularioRenta107(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormularioRenta107DetalleFormularioRenta107= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioDetalleFormularioRenta107=true;

	public Boolean getActivarFK_IdEjercicioDetalleFormularioRenta107() {
		return this.activarFK_IdEjercicioDetalleFormularioRenta107;
	}

	public void setActivarFK_IdEjercicioDetalleFormularioRenta107(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleFormularioRenta107= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoDetalleFormularioRenta107=true;

	public Boolean getActivarFK_IdEmpleadoDetalleFormularioRenta107() {
		return this.activarFK_IdEmpleadoDetalleFormularioRenta107;
	}

	public void setActivarFK_IdEmpleadoDetalleFormularioRenta107(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoDetalleFormularioRenta107= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleFormularioRenta107=true;

	public Boolean getActivarFK_IdEmpresaDetalleFormularioRenta107() {
		return this.activarFK_IdEmpresaDetalleFormularioRenta107;
	}

	public void setActivarFK_IdEmpresaDetalleFormularioRenta107(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleFormularioRenta107= habilitarResaltar;
	}

	public Boolean activarFK_IdFormularioRenta107DetalleFormularioRenta107=true;

	public Boolean getActivarFK_IdFormularioRenta107DetalleFormularioRenta107() {
		return this.activarFK_IdFormularioRenta107DetalleFormularioRenta107;
	}

	public void setActivarFK_IdFormularioRenta107DetalleFormularioRenta107(Boolean habilitarResaltar) {
		this.activarFK_IdFormularioRenta107DetalleFormularioRenta107= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioDetalleFormularioRenta107=null;

	public Border getResaltarFK_IdEjercicioDetalleFormularioRenta107() {
		return this.resaltarFK_IdEjercicioDetalleFormularioRenta107;
	}

	public void setResaltarFK_IdEjercicioDetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleFormularioRenta107= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleFormularioRenta107= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoDetalleFormularioRenta107=null;

	public Border getResaltarFK_IdEmpleadoDetalleFormularioRenta107() {
		return this.resaltarFK_IdEmpleadoDetalleFormularioRenta107;
	}

	public void setResaltarFK_IdEmpleadoDetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoDetalleFormularioRenta107= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoDetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoDetalleFormularioRenta107= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleFormularioRenta107=null;

	public Border getResaltarFK_IdEmpresaDetalleFormularioRenta107() {
		return this.resaltarFK_IdEmpresaDetalleFormularioRenta107;
	}

	public void setResaltarFK_IdEmpresaDetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleFormularioRenta107= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleFormularioRenta107= borderResaltar;
	}

	public Border resaltarFK_IdFormularioRenta107DetalleFormularioRenta107=null;

	public Border getResaltarFK_IdFormularioRenta107DetalleFormularioRenta107() {
		return this.resaltarFK_IdFormularioRenta107DetalleFormularioRenta107;
	}

	public void setResaltarFK_IdFormularioRenta107DetalleFormularioRenta107(Border borderResaltar) {
		this.resaltarFK_IdFormularioRenta107DetalleFormularioRenta107= borderResaltar;
	}

	public void setResaltarFK_IdFormularioRenta107DetalleFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFormularioRenta107BeanSwingJInternalFrame detalleformulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormularioRenta107DetalleFormularioRenta107= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}