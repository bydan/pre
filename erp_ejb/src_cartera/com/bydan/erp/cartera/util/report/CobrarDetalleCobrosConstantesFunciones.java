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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.CobrarDetalleCobrosConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarDetalleCobrosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarDetalleCobrosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarDetalleCobrosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarDetalleCobros";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarDetalleCobros"+CobrarDetalleCobrosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarDetalleCobrosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarDetalleCobrosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarDetalleCobrosConstantesFunciones.SCHEMA+"_"+CobrarDetalleCobrosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarDetalleCobrosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarDetalleCobrosConstantesFunciones.SCHEMA+"_"+CobrarDetalleCobrosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarDetalleCobrosConstantesFunciones.SCHEMA+"_"+CobrarDetalleCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarDetalleCobrosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarDetalleCobrosConstantesFunciones.SCHEMA+"_"+CobrarDetalleCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarDetalleCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarDetalleCobrosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarDetalleCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarDetalleCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarDetalleCobrosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarDetalleCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarDetalleCobrosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarDetalleCobrosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarDetalleCobrosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarDetalleCobrosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Detalle Cobroses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Detalle Cobros";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Detalle Cobros";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarDetalleCobros";
	public static final String OBJECTNAME="cobrardetallecobros";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_detalle_cobros";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrardetallecobros from "+CobrarDetalleCobrosConstantesFunciones.SPERSISTENCENAME+" cobrardetallecobros";
	public static String QUERYSELECTNATIVE="select "+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".id,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".version_row,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".id_empresa,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".id_pais,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".id_ciudad,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".id_zona,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".id_grupo_cliente,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".id_vendedor,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".fecha_emision,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".nombre_vendedor,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".codigo,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".nombre,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".apellido,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".total_facturas,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".total_abonos,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".total_facturas_actual,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".abonos_anterior,"+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME+".abonos_actual from "+CobrarDetalleCobrosConstantesFunciones.SCHEMA+"."+CobrarDetalleCobrosConstantesFunciones.TABLENAME;//+" as "+CobrarDetalleCobrosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDZONA= "id_zona";
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String FECHAEMISIONDESDE= "fecha_emision";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREVENDEDOR= "nombre_vendedor";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String TOTALFACTURAS= "total_facturas";
    public static final String TOTALABONOS= "total_abonos";
    public static final String TOTALFACTURASACTUAL= "total_facturas_actual";
    public static final String ABONOSANTERIOR= "abonos_anterior";
    public static final String ABONOSACTUAL= "abonos_actual";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREVENDEDOR= "Nombre Vendedor";
		public static final String LABEL_NOMBREVENDEDOR_LOWER= "Nombre Vendedor";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_APELLIDO= "Apello";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_TOTALFACTURAS= "Total Facturas";
		public static final String LABEL_TOTALFACTURAS_LOWER= "Total Facturas";
    	public static final String LABEL_TOTALABONOS= "Total Abonos";
		public static final String LABEL_TOTALABONOS_LOWER= "Total Abonos";
    	public static final String LABEL_TOTALFACTURASACTUAL= "Total Facturas Actual";
		public static final String LABEL_TOTALFACTURASACTUAL_LOWER= "Total Facturas Actual";
    	public static final String LABEL_ABONOSANTERIOR= "Abonos Anterior";
		public static final String LABEL_ABONOSANTERIOR_LOWER= "Abonos Anterior";
    	public static final String LABEL_ABONOSACTUAL= "Abonos Actual";
		public static final String LABEL_ABONOSACTUAL_LOWER= "Abonos Actual";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getCobrarDetalleCobrosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.IDPAIS)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.IDCIUDAD)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.IDZONA)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.IDVENDEDOR)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.NOMBREVENDEDOR)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBREVENDEDOR;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.CODIGO)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.NOMBRE)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.APELLIDO)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURAS;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.TOTALABONOS)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALABONOS;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURASACTUAL;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSANTERIOR;}
		if(sNombreColumna.equals(CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL)) {sLabelColumna=CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSACTUAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarDetalleCobrosDescripcion(CobrarDetalleCobros cobrardetallecobros) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrardetallecobros !=null/* && cobrardetallecobros.getId()!=0*/) {
			sDescripcion=cobrardetallecobros.getcodigo();//cobrardetallecobroscobrardetallecobros.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarDetalleCobrosDescripcionDetallado(CobrarDetalleCobros cobrardetallecobros) {
		String sDescripcion="";
			
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.ID+"=";
		sDescripcion+=cobrardetallecobros.getId().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrardetallecobros.getVersionRow().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrardetallecobros.getid_empresa().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.IDPAIS+"=";
		sDescripcion+=cobrardetallecobros.getid_pais().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=cobrardetallecobros.getid_ciudad().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.IDZONA+"=";
		sDescripcion+=cobrardetallecobros.getid_zona().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=cobrardetallecobros.getid_grupo_cliente().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=cobrardetallecobros.getid_vendedor().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=cobrardetallecobros.getfecha_emision().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=cobrardetallecobros.getfecha_emision_hasta().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.NOMBREVENDEDOR+"=";
		sDescripcion+=cobrardetallecobros.getnombre_vendedor()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrardetallecobros.getcodigo()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cobrardetallecobros.getnombre()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.APELLIDO+"=";
		sDescripcion+=cobrardetallecobros.getapellido()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS+"=";
		sDescripcion+=cobrardetallecobros.gettotal_facturas().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.TOTALABONOS+"=";
		sDescripcion+=cobrardetallecobros.gettotal_abonos().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL+"=";
		sDescripcion+=cobrardetallecobros.gettotal_facturas_actual().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR+"=";
		sDescripcion+=cobrardetallecobros.getabonos_anterior().toString()+",";
		sDescripcion+=CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL+"=";
		sDescripcion+=cobrardetallecobros.getabonos_actual().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarDetalleCobrosDescripcion(CobrarDetalleCobros cobrardetallecobros,String sValor) throws Exception {			
		if(cobrardetallecobros !=null) {
			cobrardetallecobros.setcodigo(sValor);;//cobrardetallecobroscobrardetallecobros.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
		}

		return sDescripcion;
	}

	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocliente!=null/*&&grupocliente.getId()>0*/) {
			sDescripcion=GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupocliente);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarDetalleCobros")) {
			sNombreIndice="Tipo=  Por Pais Por Ciudad Por Zona Por Grupo Cliente Por Vendedor Por Fecha Emision Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarDetalleCobros(Long id_pais,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor,Date fecha_emision,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();}
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();}
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();}
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();}
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();}
		if(fecha_emision!=null) {sDetalleIndice+=" Fecha Emision="+fecha_emision.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoCliente(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarDetalleCobros(CobrarDetalleCobros cobrardetallecobros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrardetallecobros.setnombre_vendedor(cobrardetallecobros.getnombre_vendedor().trim());
		cobrardetallecobros.setcodigo(cobrardetallecobros.getcodigo().trim());
		cobrardetallecobros.setnombre(cobrardetallecobros.getnombre().trim());
		cobrardetallecobros.setapellido(cobrardetallecobros.getapellido().trim());
	}
	
	public static void quitarEspaciosCobrarDetalleCobross(List<CobrarDetalleCobros> cobrardetallecobross,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarDetalleCobros cobrardetallecobros: cobrardetallecobross) {
			cobrardetallecobros.setnombre_vendedor(cobrardetallecobros.getnombre_vendedor().trim());
			cobrardetallecobros.setcodigo(cobrardetallecobros.getcodigo().trim());
			cobrardetallecobros.setnombre(cobrardetallecobros.getnombre().trim());
			cobrardetallecobros.setapellido(cobrardetallecobros.getapellido().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarDetalleCobros(CobrarDetalleCobros cobrardetallecobros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrardetallecobros.getConCambioAuxiliar()) {
			cobrardetallecobros.setIsDeleted(cobrardetallecobros.getIsDeletedAuxiliar());	
			cobrardetallecobros.setIsNew(cobrardetallecobros.getIsNewAuxiliar());	
			cobrardetallecobros.setIsChanged(cobrardetallecobros.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrardetallecobros.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrardetallecobros.setIsDeletedAuxiliar(false);	
			cobrardetallecobros.setIsNewAuxiliar(false);	
			cobrardetallecobros.setIsChangedAuxiliar(false);
			
			cobrardetallecobros.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarDetalleCobross(List<CobrarDetalleCobros> cobrardetallecobross,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarDetalleCobros cobrardetallecobros : cobrardetallecobross) {
			if(conAsignarBase && cobrardetallecobros.getConCambioAuxiliar()) {
				cobrardetallecobros.setIsDeleted(cobrardetallecobros.getIsDeletedAuxiliar());	
				cobrardetallecobros.setIsNew(cobrardetallecobros.getIsNewAuxiliar());	
				cobrardetallecobros.setIsChanged(cobrardetallecobros.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrardetallecobros.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrardetallecobros.setIsDeletedAuxiliar(false);	
				cobrardetallecobros.setIsNewAuxiliar(false);	
				cobrardetallecobros.setIsChangedAuxiliar(false);
				
				cobrardetallecobros.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarDetalleCobros(CobrarDetalleCobros cobrardetallecobros,Boolean conEnteros) throws Exception  {
		cobrardetallecobros.settotal_facturas(0.0);
		cobrardetallecobros.settotal_abonos(0.0);
		cobrardetallecobros.settotal_facturas_actual(0.0);
		cobrardetallecobros.setabonos_anterior(0.0);
		cobrardetallecobros.setabonos_actual(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarDetalleCobross(List<CobrarDetalleCobros> cobrardetallecobross,Boolean conEnteros) throws Exception  {
		
		for(CobrarDetalleCobros cobrardetallecobros: cobrardetallecobross) {
			cobrardetallecobros.settotal_facturas(0.0);
			cobrardetallecobros.settotal_abonos(0.0);
			cobrardetallecobros.settotal_facturas_actual(0.0);
			cobrardetallecobros.setabonos_anterior(0.0);
			cobrardetallecobros.setabonos_actual(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarDetalleCobros(List<CobrarDetalleCobros> cobrardetallecobross,CobrarDetalleCobros cobrardetallecobrosAux) throws Exception  {
		CobrarDetalleCobrosConstantesFunciones.InicializarValoresCobrarDetalleCobros(cobrardetallecobrosAux,true);
		
		for(CobrarDetalleCobros cobrardetallecobros: cobrardetallecobross) {
			if(cobrardetallecobros.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobrardetallecobrosAux.settotal_facturas(cobrardetallecobrosAux.gettotal_facturas()+cobrardetallecobros.gettotal_facturas());			
			cobrardetallecobrosAux.settotal_abonos(cobrardetallecobrosAux.gettotal_abonos()+cobrardetallecobros.gettotal_abonos());			
			cobrardetallecobrosAux.settotal_facturas_actual(cobrardetallecobrosAux.gettotal_facturas_actual()+cobrardetallecobros.gettotal_facturas_actual());			
			cobrardetallecobrosAux.setabonos_anterior(cobrardetallecobrosAux.getabonos_anterior()+cobrardetallecobros.getabonos_anterior());			
			cobrardetallecobrosAux.setabonos_actual(cobrardetallecobrosAux.getabonos_actual()+cobrardetallecobros.getabonos_actual());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarDetalleCobros(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarDetalleCobrosConstantesFunciones.getArrayColumnasGlobalesCobrarDetalleCobros(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarDetalleCobros(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarDetalleCobrosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarDetalleCobrosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarDetalleCobros(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarDetalleCobros> cobrardetallecobross,CobrarDetalleCobros cobrardetallecobros,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarDetalleCobros cobrardetallecobrosAux: cobrardetallecobross) {
			if(cobrardetallecobrosAux!=null && cobrardetallecobros!=null) {
				if((cobrardetallecobrosAux.getId()==null && cobrardetallecobros.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrardetallecobrosAux.getId()!=null && cobrardetallecobros.getId()!=null){
					if(cobrardetallecobrosAux.getId().equals(cobrardetallecobros.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarDetalleCobros(List<CobrarDetalleCobros> cobrardetallecobross) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_facturasTotal=0.0;
		Double total_abonosTotal=0.0;
		Double total_facturas_actualTotal=0.0;
		Double abonos_anteriorTotal=0.0;
		Double abonos_actualTotal=0.0;
	
		for(CobrarDetalleCobros cobrardetallecobros: cobrardetallecobross) {			
			if(cobrardetallecobros.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_facturasTotal+=cobrardetallecobros.gettotal_facturas();
			total_abonosTotal+=cobrardetallecobros.gettotal_abonos();
			total_facturas_actualTotal+=cobrardetallecobros.gettotal_facturas_actual();
			abonos_anteriorTotal+=cobrardetallecobros.getabonos_anterior();
			abonos_actualTotal+=cobrardetallecobros.getabonos_actual();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURAS);
		datoGeneral.setdValorDouble(total_facturasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.TOTALABONOS);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALABONOS);
		datoGeneral.setdValorDouble(total_abonosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);
		datoGeneral.setdValorDouble(total_facturas_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSANTERIOR);
		datoGeneral.setdValorDouble(abonos_anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSACTUAL);
		datoGeneral.setdValorDouble(abonos_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarDetalleCobros() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_ID, CobrarDetalleCobrosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_VERSIONROW, CobrarDetalleCobrosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBREVENDEDOR, CobrarDetalleCobrosConstantesFunciones.NOMBREVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_CODIGO, CobrarDetalleCobrosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBRE, CobrarDetalleCobrosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_APELLIDO, CobrarDetalleCobrosConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURAS, CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALABONOS, CobrarDetalleCobrosConstantesFunciones.TOTALABONOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURASACTUAL, CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSANTERIOR, CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSACTUAL, CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarDetalleCobros() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.NOMBREVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.TOTALABONOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarDetalleCobros() throws Exception  {
		return CobrarDetalleCobrosConstantesFunciones.getTiposSeleccionarCobrarDetalleCobros(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarDetalleCobros(Boolean conFk) throws Exception  {
		return CobrarDetalleCobrosConstantesFunciones.getTiposSeleccionarCobrarDetalleCobros(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarDetalleCobros(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBREVENDEDOR);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBREVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURAS);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALABONOS);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALABONOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSANTERIOR);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSANTERIOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSACTUAL);
			reporte.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarDetalleCobros(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarDetalleCobros(CobrarDetalleCobros cobrardetallecobrosAux) throws Exception {
		
			cobrardetallecobrosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrardetallecobrosAux.getEmpresa()));
			cobrardetallecobrosAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(cobrardetallecobrosAux.getPais()));
			cobrardetallecobrosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(cobrardetallecobrosAux.getCiudad()));
			cobrardetallecobrosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(cobrardetallecobrosAux.getZona()));
			cobrardetallecobrosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(cobrardetallecobrosAux.getGrupoCliente()));
			cobrardetallecobrosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(cobrardetallecobrosAux.getVendedor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarDetalleCobros(List<CobrarDetalleCobros> cobrardetallecobrossTemp) throws Exception {
		for(CobrarDetalleCobros cobrardetallecobrosAux:cobrardetallecobrossTemp) {
			
			cobrardetallecobrosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrardetallecobrosAux.getEmpresa()));
			cobrardetallecobrosAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(cobrardetallecobrosAux.getPais()));
			cobrardetallecobrosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(cobrardetallecobrosAux.getCiudad()));
			cobrardetallecobrosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(cobrardetallecobrosAux.getZona()));
			cobrardetallecobrosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(cobrardetallecobrosAux.getGrupoCliente()));
			cobrardetallecobrosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(cobrardetallecobrosAux.getVendedor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarDetalleCobros(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Zona.class));
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(Vendedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoCliente.class)) {
						classes.add(new Classe(GrupoCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarDetalleCobros(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarDetalleCobros(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarDetalleCobrosConstantesFunciones.getClassesRelationshipsOfCobrarDetalleCobros(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarDetalleCobros(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarDetalleCobros(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarDetalleCobrosConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarDetalleCobros(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarDetalleCobros(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarDetalleCobros cobrardetallecobros,List<CobrarDetalleCobros> cobrardetallecobross,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarDetalleCobros cobrardetallecobros,List<CobrarDetalleCobros> cobrardetallecobross) throws Exception {
		try	{			
			for(CobrarDetalleCobros cobrardetallecobrosLocal:cobrardetallecobross) {
				if(cobrardetallecobrosLocal.getId().equals(cobrardetallecobros.getId())) {
					cobrardetallecobrosLocal.setIsSelected(cobrardetallecobros.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarDetalleCobros(List<CobrarDetalleCobros> cobrardetallecobrossAux) throws Exception {
		//this.cobrardetallecobrossAux=cobrardetallecobrossAux;
		
		for(CobrarDetalleCobros cobrardetallecobrosAux:cobrardetallecobrossAux) {
			if(cobrardetallecobrosAux.getIsChanged()) {
				cobrardetallecobrosAux.setIsChanged(false);
			}		
			
			if(cobrardetallecobrosAux.getIsNew()) {
				cobrardetallecobrosAux.setIsNew(false);
			}	
			
			if(cobrardetallecobrosAux.getIsDeleted()) {
				cobrardetallecobrosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarDetalleCobros(CobrarDetalleCobros cobrardetallecobrosAux) throws Exception {
		//this.cobrardetallecobrosAux=cobrardetallecobrosAux;
		
			if(cobrardetallecobrosAux.getIsChanged()) {
				cobrardetallecobrosAux.setIsChanged(false);
			}		
			
			if(cobrardetallecobrosAux.getIsNew()) {
				cobrardetallecobrosAux.setIsNew(false);
			}	
			
			if(cobrardetallecobrosAux.getIsDeleted()) {
				cobrardetallecobrosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarDetalleCobros cobrardetallecobrosAsignar,CobrarDetalleCobros cobrardetallecobros) throws Exception {
		cobrardetallecobrosAsignar.setId(cobrardetallecobros.getId());	
		cobrardetallecobrosAsignar.setVersionRow(cobrardetallecobros.getVersionRow());	
		cobrardetallecobrosAsignar.setnombre_vendedor(cobrardetallecobros.getnombre_vendedor());	
		cobrardetallecobrosAsignar.setcodigo(cobrardetallecobros.getcodigo());	
		cobrardetallecobrosAsignar.setnombre(cobrardetallecobros.getnombre());	
		cobrardetallecobrosAsignar.setapellido(cobrardetallecobros.getapellido());	
		cobrardetallecobrosAsignar.settotal_facturas(cobrardetallecobros.gettotal_facturas());	
		cobrardetallecobrosAsignar.settotal_abonos(cobrardetallecobros.gettotal_abonos());	
		cobrardetallecobrosAsignar.settotal_facturas_actual(cobrardetallecobros.gettotal_facturas_actual());	
		cobrardetallecobrosAsignar.setabonos_anterior(cobrardetallecobros.getabonos_anterior());	
		cobrardetallecobrosAsignar.setabonos_actual(cobrardetallecobros.getabonos_actual());	
	}
	
	public static void inicializarCobrarDetalleCobros(CobrarDetalleCobros cobrardetallecobros) throws Exception {
		try {
				cobrardetallecobros.setId(0L);	
					
				cobrardetallecobros.setnombre_vendedor("");	
				cobrardetallecobros.setcodigo("");	
				cobrardetallecobros.setnombre("");	
				cobrardetallecobros.setapellido("");	
				cobrardetallecobros.settotal_facturas(0.0);	
				cobrardetallecobros.settotal_abonos(0.0);	
				cobrardetallecobros.settotal_facturas_actual(0.0);	
				cobrardetallecobros.setabonos_anterior(0.0);	
				cobrardetallecobros.setabonos_actual(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarDetalleCobros(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBREVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALABONOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSANTERIOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSACTUAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarDetalleCobros(String sTipo,Row row,Workbook workbook,CobrarDetalleCobros cobrardetallecobros,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getnombre_vendedor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.gettotal_facturas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.gettotal_abonos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.gettotal_facturas_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getabonos_anterior());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrardetallecobros.getabonos_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarDetalleCobros="";
	
	public String getsFinalQueryCobrarDetalleCobros() {
		return this.sFinalQueryCobrarDetalleCobros;
	}
	
	public void setsFinalQueryCobrarDetalleCobros(String sFinalQueryCobrarDetalleCobros) {
		this.sFinalQueryCobrarDetalleCobros= sFinalQueryCobrarDetalleCobros;
	}
	
	public Border resaltarSeleccionarCobrarDetalleCobros=null;
	
	public Border setResaltarSeleccionarCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarDetalleCobros= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarDetalleCobros() {
		return this.resaltarSeleccionarCobrarDetalleCobros;
	}
	
	public void setResaltarSeleccionarCobrarDetalleCobros(Border borderResaltarSeleccionarCobrarDetalleCobros) {
		this.resaltarSeleccionarCobrarDetalleCobros= borderResaltarSeleccionarCobrarDetalleCobros;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarDetalleCobros=null;
	public Boolean mostraridCobrarDetalleCobros=true;
	public Boolean activaridCobrarDetalleCobros=true;

	public Border resaltarid_empresaCobrarDetalleCobros=null;
	public Boolean mostrarid_empresaCobrarDetalleCobros=true;
	public Boolean activarid_empresaCobrarDetalleCobros=true;
	public Boolean cargarid_empresaCobrarDetalleCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarDetalleCobros=false;//ConEventDepend=true

	public Border resaltarid_paisCobrarDetalleCobros=null;
	public Boolean mostrarid_paisCobrarDetalleCobros=true;
	public Boolean activarid_paisCobrarDetalleCobros=true;
	public Boolean cargarid_paisCobrarDetalleCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisCobrarDetalleCobros=false;//ConEventDepend=true

	public Border resaltarid_ciudadCobrarDetalleCobros=null;
	public Boolean mostrarid_ciudadCobrarDetalleCobros=true;
	public Boolean activarid_ciudadCobrarDetalleCobros=true;
	public Boolean cargarid_ciudadCobrarDetalleCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadCobrarDetalleCobros=false;//ConEventDepend=true

	public Border resaltarid_zonaCobrarDetalleCobros=null;
	public Boolean mostrarid_zonaCobrarDetalleCobros=true;
	public Boolean activarid_zonaCobrarDetalleCobros=true;
	public Boolean cargarid_zonaCobrarDetalleCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaCobrarDetalleCobros=false;//ConEventDepend=true

	public Border resaltarid_grupo_clienteCobrarDetalleCobros=null;
	public Boolean mostrarid_grupo_clienteCobrarDetalleCobros=true;
	public Boolean activarid_grupo_clienteCobrarDetalleCobros=true;
	public Boolean cargarid_grupo_clienteCobrarDetalleCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteCobrarDetalleCobros=false;//ConEventDepend=true

	public Border resaltarid_vendedorCobrarDetalleCobros=null;
	public Boolean mostrarid_vendedorCobrarDetalleCobros=true;
	public Boolean activarid_vendedorCobrarDetalleCobros=true;
	public Boolean cargarid_vendedorCobrarDetalleCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorCobrarDetalleCobros=false;//ConEventDepend=true

	public Border resaltarfecha_emisionCobrarDetalleCobros=null;
	public Boolean mostrarfecha_emisionCobrarDetalleCobros=true;
	public Boolean activarfecha_emisionCobrarDetalleCobros=true;

	public Border resaltarfecha_emision_hastaCobrarDetalleCobros=null;
	public Boolean mostrarfecha_emision_hastaCobrarDetalleCobros=true;
	public Boolean activarfecha_emision_hastaCobrarDetalleCobros=true;

	public Border resaltarnombre_vendedorCobrarDetalleCobros=null;
	public Boolean mostrarnombre_vendedorCobrarDetalleCobros=true;
	public Boolean activarnombre_vendedorCobrarDetalleCobros=true;

	public Border resaltarcodigoCobrarDetalleCobros=null;
	public Boolean mostrarcodigoCobrarDetalleCobros=true;
	public Boolean activarcodigoCobrarDetalleCobros=true;

	public Border resaltarnombreCobrarDetalleCobros=null;
	public Boolean mostrarnombreCobrarDetalleCobros=true;
	public Boolean activarnombreCobrarDetalleCobros=true;

	public Border resaltarapellidoCobrarDetalleCobros=null;
	public Boolean mostrarapellidoCobrarDetalleCobros=true;
	public Boolean activarapellidoCobrarDetalleCobros=true;

	public Border resaltartotal_facturasCobrarDetalleCobros=null;
	public Boolean mostrartotal_facturasCobrarDetalleCobros=true;
	public Boolean activartotal_facturasCobrarDetalleCobros=true;

	public Border resaltartotal_abonosCobrarDetalleCobros=null;
	public Boolean mostrartotal_abonosCobrarDetalleCobros=true;
	public Boolean activartotal_abonosCobrarDetalleCobros=true;

	public Border resaltartotal_facturas_actualCobrarDetalleCobros=null;
	public Boolean mostrartotal_facturas_actualCobrarDetalleCobros=true;
	public Boolean activartotal_facturas_actualCobrarDetalleCobros=true;

	public Border resaltarabonos_anteriorCobrarDetalleCobros=null;
	public Boolean mostrarabonos_anteriorCobrarDetalleCobros=true;
	public Boolean activarabonos_anteriorCobrarDetalleCobros=true;

	public Border resaltarabonos_actualCobrarDetalleCobros=null;
	public Boolean mostrarabonos_actualCobrarDetalleCobros=true;
	public Boolean activarabonos_actualCobrarDetalleCobros=true;

	
	

	public Border setResaltaridCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltaridCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarDetalleCobros() {
		return this.resaltaridCobrarDetalleCobros;
	}

	public void setResaltaridCobrarDetalleCobros(Border borderResaltar) {
		this.resaltaridCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostraridCobrarDetalleCobros() {
		return this.mostraridCobrarDetalleCobros;
	}

	public void setMostraridCobrarDetalleCobros(Boolean mostraridCobrarDetalleCobros) {
		this.mostraridCobrarDetalleCobros= mostraridCobrarDetalleCobros;
	}

	public Boolean getActivaridCobrarDetalleCobros() {
		return this.activaridCobrarDetalleCobros;
	}

	public void setActivaridCobrarDetalleCobros(Boolean activaridCobrarDetalleCobros) {
		this.activaridCobrarDetalleCobros= activaridCobrarDetalleCobros;
	}

	public Border setResaltarid_empresaCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarDetalleCobros() {
		return this.resaltarid_empresaCobrarDetalleCobros;
	}

	public void setResaltarid_empresaCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarid_empresaCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarDetalleCobros() {
		return this.mostrarid_empresaCobrarDetalleCobros;
	}

	public void setMostrarid_empresaCobrarDetalleCobros(Boolean mostrarid_empresaCobrarDetalleCobros) {
		this.mostrarid_empresaCobrarDetalleCobros= mostrarid_empresaCobrarDetalleCobros;
	}

	public Boolean getActivarid_empresaCobrarDetalleCobros() {
		return this.activarid_empresaCobrarDetalleCobros;
	}

	public void setActivarid_empresaCobrarDetalleCobros(Boolean activarid_empresaCobrarDetalleCobros) {
		this.activarid_empresaCobrarDetalleCobros= activarid_empresaCobrarDetalleCobros;
	}

	public Boolean getCargarid_empresaCobrarDetalleCobros() {
		return this.cargarid_empresaCobrarDetalleCobros;
	}

	public void setCargarid_empresaCobrarDetalleCobros(Boolean cargarid_empresaCobrarDetalleCobros) {
		this.cargarid_empresaCobrarDetalleCobros= cargarid_empresaCobrarDetalleCobros;
	}

	public Border setResaltarid_paisCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarid_paisCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisCobrarDetalleCobros() {
		return this.resaltarid_paisCobrarDetalleCobros;
	}

	public void setResaltarid_paisCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarid_paisCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarid_paisCobrarDetalleCobros() {
		return this.mostrarid_paisCobrarDetalleCobros;
	}

	public void setMostrarid_paisCobrarDetalleCobros(Boolean mostrarid_paisCobrarDetalleCobros) {
		this.mostrarid_paisCobrarDetalleCobros= mostrarid_paisCobrarDetalleCobros;
	}

	public Boolean getActivarid_paisCobrarDetalleCobros() {
		return this.activarid_paisCobrarDetalleCobros;
	}

	public void setActivarid_paisCobrarDetalleCobros(Boolean activarid_paisCobrarDetalleCobros) {
		this.activarid_paisCobrarDetalleCobros= activarid_paisCobrarDetalleCobros;
	}

	public Boolean getCargarid_paisCobrarDetalleCobros() {
		return this.cargarid_paisCobrarDetalleCobros;
	}

	public void setCargarid_paisCobrarDetalleCobros(Boolean cargarid_paisCobrarDetalleCobros) {
		this.cargarid_paisCobrarDetalleCobros= cargarid_paisCobrarDetalleCobros;
	}

	public Border setResaltarid_ciudadCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarid_ciudadCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadCobrarDetalleCobros() {
		return this.resaltarid_ciudadCobrarDetalleCobros;
	}

	public void setResaltarid_ciudadCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarid_ciudadCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarid_ciudadCobrarDetalleCobros() {
		return this.mostrarid_ciudadCobrarDetalleCobros;
	}

	public void setMostrarid_ciudadCobrarDetalleCobros(Boolean mostrarid_ciudadCobrarDetalleCobros) {
		this.mostrarid_ciudadCobrarDetalleCobros= mostrarid_ciudadCobrarDetalleCobros;
	}

	public Boolean getActivarid_ciudadCobrarDetalleCobros() {
		return this.activarid_ciudadCobrarDetalleCobros;
	}

	public void setActivarid_ciudadCobrarDetalleCobros(Boolean activarid_ciudadCobrarDetalleCobros) {
		this.activarid_ciudadCobrarDetalleCobros= activarid_ciudadCobrarDetalleCobros;
	}

	public Boolean getCargarid_ciudadCobrarDetalleCobros() {
		return this.cargarid_ciudadCobrarDetalleCobros;
	}

	public void setCargarid_ciudadCobrarDetalleCobros(Boolean cargarid_ciudadCobrarDetalleCobros) {
		this.cargarid_ciudadCobrarDetalleCobros= cargarid_ciudadCobrarDetalleCobros;
	}

	public Border setResaltarid_zonaCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarid_zonaCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaCobrarDetalleCobros() {
		return this.resaltarid_zonaCobrarDetalleCobros;
	}

	public void setResaltarid_zonaCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarid_zonaCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarid_zonaCobrarDetalleCobros() {
		return this.mostrarid_zonaCobrarDetalleCobros;
	}

	public void setMostrarid_zonaCobrarDetalleCobros(Boolean mostrarid_zonaCobrarDetalleCobros) {
		this.mostrarid_zonaCobrarDetalleCobros= mostrarid_zonaCobrarDetalleCobros;
	}

	public Boolean getActivarid_zonaCobrarDetalleCobros() {
		return this.activarid_zonaCobrarDetalleCobros;
	}

	public void setActivarid_zonaCobrarDetalleCobros(Boolean activarid_zonaCobrarDetalleCobros) {
		this.activarid_zonaCobrarDetalleCobros= activarid_zonaCobrarDetalleCobros;
	}

	public Boolean getCargarid_zonaCobrarDetalleCobros() {
		return this.cargarid_zonaCobrarDetalleCobros;
	}

	public void setCargarid_zonaCobrarDetalleCobros(Boolean cargarid_zonaCobrarDetalleCobros) {
		this.cargarid_zonaCobrarDetalleCobros= cargarid_zonaCobrarDetalleCobros;
	}

	public Border setResaltarid_grupo_clienteCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteCobrarDetalleCobros() {
		return this.resaltarid_grupo_clienteCobrarDetalleCobros;
	}

	public void setResaltarid_grupo_clienteCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarid_grupo_clienteCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteCobrarDetalleCobros() {
		return this.mostrarid_grupo_clienteCobrarDetalleCobros;
	}

	public void setMostrarid_grupo_clienteCobrarDetalleCobros(Boolean mostrarid_grupo_clienteCobrarDetalleCobros) {
		this.mostrarid_grupo_clienteCobrarDetalleCobros= mostrarid_grupo_clienteCobrarDetalleCobros;
	}

	public Boolean getActivarid_grupo_clienteCobrarDetalleCobros() {
		return this.activarid_grupo_clienteCobrarDetalleCobros;
	}

	public void setActivarid_grupo_clienteCobrarDetalleCobros(Boolean activarid_grupo_clienteCobrarDetalleCobros) {
		this.activarid_grupo_clienteCobrarDetalleCobros= activarid_grupo_clienteCobrarDetalleCobros;
	}

	public Boolean getCargarid_grupo_clienteCobrarDetalleCobros() {
		return this.cargarid_grupo_clienteCobrarDetalleCobros;
	}

	public void setCargarid_grupo_clienteCobrarDetalleCobros(Boolean cargarid_grupo_clienteCobrarDetalleCobros) {
		this.cargarid_grupo_clienteCobrarDetalleCobros= cargarid_grupo_clienteCobrarDetalleCobros;
	}

	public Border setResaltarid_vendedorCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarid_vendedorCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorCobrarDetalleCobros() {
		return this.resaltarid_vendedorCobrarDetalleCobros;
	}

	public void setResaltarid_vendedorCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarid_vendedorCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarid_vendedorCobrarDetalleCobros() {
		return this.mostrarid_vendedorCobrarDetalleCobros;
	}

	public void setMostrarid_vendedorCobrarDetalleCobros(Boolean mostrarid_vendedorCobrarDetalleCobros) {
		this.mostrarid_vendedorCobrarDetalleCobros= mostrarid_vendedorCobrarDetalleCobros;
	}

	public Boolean getActivarid_vendedorCobrarDetalleCobros() {
		return this.activarid_vendedorCobrarDetalleCobros;
	}

	public void setActivarid_vendedorCobrarDetalleCobros(Boolean activarid_vendedorCobrarDetalleCobros) {
		this.activarid_vendedorCobrarDetalleCobros= activarid_vendedorCobrarDetalleCobros;
	}

	public Boolean getCargarid_vendedorCobrarDetalleCobros() {
		return this.cargarid_vendedorCobrarDetalleCobros;
	}

	public void setCargarid_vendedorCobrarDetalleCobros(Boolean cargarid_vendedorCobrarDetalleCobros) {
		this.cargarid_vendedorCobrarDetalleCobros= cargarid_vendedorCobrarDetalleCobros;
	}

	public Border setResaltarfecha_emisionCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionCobrarDetalleCobros() {
		return this.resaltarfecha_emisionCobrarDetalleCobros;
	}

	public void setResaltarfecha_emisionCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarfecha_emisionCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionCobrarDetalleCobros() {
		return this.mostrarfecha_emisionCobrarDetalleCobros;
	}

	public void setMostrarfecha_emisionCobrarDetalleCobros(Boolean mostrarfecha_emisionCobrarDetalleCobros) {
		this.mostrarfecha_emisionCobrarDetalleCobros= mostrarfecha_emisionCobrarDetalleCobros;
	}

	public Boolean getActivarfecha_emisionCobrarDetalleCobros() {
		return this.activarfecha_emisionCobrarDetalleCobros;
	}

	public void setActivarfecha_emisionCobrarDetalleCobros(Boolean activarfecha_emisionCobrarDetalleCobros) {
		this.activarfecha_emisionCobrarDetalleCobros= activarfecha_emisionCobrarDetalleCobros;
	}

	public Border setResaltarfecha_emision_hastaCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaCobrarDetalleCobros() {
		return this.resaltarfecha_emision_hastaCobrarDetalleCobros;
	}

	public void setResaltarfecha_emision_hastaCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarfecha_emision_hastaCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaCobrarDetalleCobros() {
		return this.mostrarfecha_emision_hastaCobrarDetalleCobros;
	}

	public void setMostrarfecha_emision_hastaCobrarDetalleCobros(Boolean mostrarfecha_emision_hastaCobrarDetalleCobros) {
		this.mostrarfecha_emision_hastaCobrarDetalleCobros= mostrarfecha_emision_hastaCobrarDetalleCobros;
	}

	public Boolean getActivarfecha_emision_hastaCobrarDetalleCobros() {
		return this.activarfecha_emision_hastaCobrarDetalleCobros;
	}

	public void setActivarfecha_emision_hastaCobrarDetalleCobros(Boolean activarfecha_emision_hastaCobrarDetalleCobros) {
		this.activarfecha_emision_hastaCobrarDetalleCobros= activarfecha_emision_hastaCobrarDetalleCobros;
	}

	public Border setResaltarnombre_vendedorCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarnombre_vendedorCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_vendedorCobrarDetalleCobros() {
		return this.resaltarnombre_vendedorCobrarDetalleCobros;
	}

	public void setResaltarnombre_vendedorCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarnombre_vendedorCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarnombre_vendedorCobrarDetalleCobros() {
		return this.mostrarnombre_vendedorCobrarDetalleCobros;
	}

	public void setMostrarnombre_vendedorCobrarDetalleCobros(Boolean mostrarnombre_vendedorCobrarDetalleCobros) {
		this.mostrarnombre_vendedorCobrarDetalleCobros= mostrarnombre_vendedorCobrarDetalleCobros;
	}

	public Boolean getActivarnombre_vendedorCobrarDetalleCobros() {
		return this.activarnombre_vendedorCobrarDetalleCobros;
	}

	public void setActivarnombre_vendedorCobrarDetalleCobros(Boolean activarnombre_vendedorCobrarDetalleCobros) {
		this.activarnombre_vendedorCobrarDetalleCobros= activarnombre_vendedorCobrarDetalleCobros;
	}

	public Border setResaltarcodigoCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarDetalleCobros() {
		return this.resaltarcodigoCobrarDetalleCobros;
	}

	public void setResaltarcodigoCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarcodigoCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarDetalleCobros() {
		return this.mostrarcodigoCobrarDetalleCobros;
	}

	public void setMostrarcodigoCobrarDetalleCobros(Boolean mostrarcodigoCobrarDetalleCobros) {
		this.mostrarcodigoCobrarDetalleCobros= mostrarcodigoCobrarDetalleCobros;
	}

	public Boolean getActivarcodigoCobrarDetalleCobros() {
		return this.activarcodigoCobrarDetalleCobros;
	}

	public void setActivarcodigoCobrarDetalleCobros(Boolean activarcodigoCobrarDetalleCobros) {
		this.activarcodigoCobrarDetalleCobros= activarcodigoCobrarDetalleCobros;
	}

	public Border setResaltarnombreCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarnombreCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCobrarDetalleCobros() {
		return this.resaltarnombreCobrarDetalleCobros;
	}

	public void setResaltarnombreCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarnombreCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarnombreCobrarDetalleCobros() {
		return this.mostrarnombreCobrarDetalleCobros;
	}

	public void setMostrarnombreCobrarDetalleCobros(Boolean mostrarnombreCobrarDetalleCobros) {
		this.mostrarnombreCobrarDetalleCobros= mostrarnombreCobrarDetalleCobros;
	}

	public Boolean getActivarnombreCobrarDetalleCobros() {
		return this.activarnombreCobrarDetalleCobros;
	}

	public void setActivarnombreCobrarDetalleCobros(Boolean activarnombreCobrarDetalleCobros) {
		this.activarnombreCobrarDetalleCobros= activarnombreCobrarDetalleCobros;
	}

	public Border setResaltarapellidoCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarapellidoCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoCobrarDetalleCobros() {
		return this.resaltarapellidoCobrarDetalleCobros;
	}

	public void setResaltarapellidoCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarapellidoCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarapellidoCobrarDetalleCobros() {
		return this.mostrarapellidoCobrarDetalleCobros;
	}

	public void setMostrarapellidoCobrarDetalleCobros(Boolean mostrarapellidoCobrarDetalleCobros) {
		this.mostrarapellidoCobrarDetalleCobros= mostrarapellidoCobrarDetalleCobros;
	}

	public Boolean getActivarapellidoCobrarDetalleCobros() {
		return this.activarapellidoCobrarDetalleCobros;
	}

	public void setActivarapellidoCobrarDetalleCobros(Boolean activarapellidoCobrarDetalleCobros) {
		this.activarapellidoCobrarDetalleCobros= activarapellidoCobrarDetalleCobros;
	}

	public Border setResaltartotal_facturasCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltartotal_facturasCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_facturasCobrarDetalleCobros() {
		return this.resaltartotal_facturasCobrarDetalleCobros;
	}

	public void setResaltartotal_facturasCobrarDetalleCobros(Border borderResaltar) {
		this.resaltartotal_facturasCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrartotal_facturasCobrarDetalleCobros() {
		return this.mostrartotal_facturasCobrarDetalleCobros;
	}

	public void setMostrartotal_facturasCobrarDetalleCobros(Boolean mostrartotal_facturasCobrarDetalleCobros) {
		this.mostrartotal_facturasCobrarDetalleCobros= mostrartotal_facturasCobrarDetalleCobros;
	}

	public Boolean getActivartotal_facturasCobrarDetalleCobros() {
		return this.activartotal_facturasCobrarDetalleCobros;
	}

	public void setActivartotal_facturasCobrarDetalleCobros(Boolean activartotal_facturasCobrarDetalleCobros) {
		this.activartotal_facturasCobrarDetalleCobros= activartotal_facturasCobrarDetalleCobros;
	}

	public Border setResaltartotal_abonosCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltartotal_abonosCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_abonosCobrarDetalleCobros() {
		return this.resaltartotal_abonosCobrarDetalleCobros;
	}

	public void setResaltartotal_abonosCobrarDetalleCobros(Border borderResaltar) {
		this.resaltartotal_abonosCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrartotal_abonosCobrarDetalleCobros() {
		return this.mostrartotal_abonosCobrarDetalleCobros;
	}

	public void setMostrartotal_abonosCobrarDetalleCobros(Boolean mostrartotal_abonosCobrarDetalleCobros) {
		this.mostrartotal_abonosCobrarDetalleCobros= mostrartotal_abonosCobrarDetalleCobros;
	}

	public Boolean getActivartotal_abonosCobrarDetalleCobros() {
		return this.activartotal_abonosCobrarDetalleCobros;
	}

	public void setActivartotal_abonosCobrarDetalleCobros(Boolean activartotal_abonosCobrarDetalleCobros) {
		this.activartotal_abonosCobrarDetalleCobros= activartotal_abonosCobrarDetalleCobros;
	}

	public Border setResaltartotal_facturas_actualCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltartotal_facturas_actualCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_facturas_actualCobrarDetalleCobros() {
		return this.resaltartotal_facturas_actualCobrarDetalleCobros;
	}

	public void setResaltartotal_facturas_actualCobrarDetalleCobros(Border borderResaltar) {
		this.resaltartotal_facturas_actualCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrartotal_facturas_actualCobrarDetalleCobros() {
		return this.mostrartotal_facturas_actualCobrarDetalleCobros;
	}

	public void setMostrartotal_facturas_actualCobrarDetalleCobros(Boolean mostrartotal_facturas_actualCobrarDetalleCobros) {
		this.mostrartotal_facturas_actualCobrarDetalleCobros= mostrartotal_facturas_actualCobrarDetalleCobros;
	}

	public Boolean getActivartotal_facturas_actualCobrarDetalleCobros() {
		return this.activartotal_facturas_actualCobrarDetalleCobros;
	}

	public void setActivartotal_facturas_actualCobrarDetalleCobros(Boolean activartotal_facturas_actualCobrarDetalleCobros) {
		this.activartotal_facturas_actualCobrarDetalleCobros= activartotal_facturas_actualCobrarDetalleCobros;
	}

	public Border setResaltarabonos_anteriorCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarabonos_anteriorCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarabonos_anteriorCobrarDetalleCobros() {
		return this.resaltarabonos_anteriorCobrarDetalleCobros;
	}

	public void setResaltarabonos_anteriorCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarabonos_anteriorCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarabonos_anteriorCobrarDetalleCobros() {
		return this.mostrarabonos_anteriorCobrarDetalleCobros;
	}

	public void setMostrarabonos_anteriorCobrarDetalleCobros(Boolean mostrarabonos_anteriorCobrarDetalleCobros) {
		this.mostrarabonos_anteriorCobrarDetalleCobros= mostrarabonos_anteriorCobrarDetalleCobros;
	}

	public Boolean getActivarabonos_anteriorCobrarDetalleCobros() {
		return this.activarabonos_anteriorCobrarDetalleCobros;
	}

	public void setActivarabonos_anteriorCobrarDetalleCobros(Boolean activarabonos_anteriorCobrarDetalleCobros) {
		this.activarabonos_anteriorCobrarDetalleCobros= activarabonos_anteriorCobrarDetalleCobros;
	}

	public Border setResaltarabonos_actualCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrardetallecobrosBeanSwingJInternalFrame.jTtoolBarCobrarDetalleCobros.setBorder(borderResaltar);
		
		this.resaltarabonos_actualCobrarDetalleCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarabonos_actualCobrarDetalleCobros() {
		return this.resaltarabonos_actualCobrarDetalleCobros;
	}

	public void setResaltarabonos_actualCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarabonos_actualCobrarDetalleCobros= borderResaltar;
	}

	public Boolean getMostrarabonos_actualCobrarDetalleCobros() {
		return this.mostrarabonos_actualCobrarDetalleCobros;
	}

	public void setMostrarabonos_actualCobrarDetalleCobros(Boolean mostrarabonos_actualCobrarDetalleCobros) {
		this.mostrarabonos_actualCobrarDetalleCobros= mostrarabonos_actualCobrarDetalleCobros;
	}

	public Boolean getActivarabonos_actualCobrarDetalleCobros() {
		return this.activarabonos_actualCobrarDetalleCobros;
	}

	public void setActivarabonos_actualCobrarDetalleCobros(Boolean activarabonos_actualCobrarDetalleCobros) {
		this.activarabonos_actualCobrarDetalleCobros= activarabonos_actualCobrarDetalleCobros;
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
		
		
		this.setMostraridCobrarDetalleCobros(esInicial);
		this.setMostrarid_empresaCobrarDetalleCobros(esInicial);
		this.setMostrarid_paisCobrarDetalleCobros(esInicial);
		this.setMostrarid_ciudadCobrarDetalleCobros(esInicial);
		this.setMostrarid_zonaCobrarDetalleCobros(esInicial);
		this.setMostrarid_grupo_clienteCobrarDetalleCobros(esInicial);
		this.setMostrarid_vendedorCobrarDetalleCobros(esInicial);
		this.setMostrarfecha_emisionCobrarDetalleCobros(esInicial);
		this.setMostrarfecha_emision_hastaCobrarDetalleCobros(esInicial);
		this.setMostrarnombre_vendedorCobrarDetalleCobros(esInicial);
		this.setMostrarcodigoCobrarDetalleCobros(esInicial);
		this.setMostrarnombreCobrarDetalleCobros(esInicial);
		this.setMostrarapellidoCobrarDetalleCobros(esInicial);
		this.setMostrartotal_facturasCobrarDetalleCobros(esInicial);
		this.setMostrartotal_abonosCobrarDetalleCobros(esInicial);
		this.setMostrartotal_facturas_actualCobrarDetalleCobros(esInicial);
		this.setMostrarabonos_anteriorCobrarDetalleCobros(esInicial);
		this.setMostrarabonos_actualCobrarDetalleCobros(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.ID)) {
				this.setMostraridCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emisionCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setMostrarnombre_vendedorCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS)) {
				this.setMostrartotal_facturasCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.TOTALABONOS)) {
				this.setMostrartotal_abonosCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL)) {
				this.setMostrartotal_facturas_actualCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR)) {
				this.setMostrarabonos_anteriorCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL)) {
				this.setMostrarabonos_actualCobrarDetalleCobros(esAsigna);
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
		
		
		this.setActivaridCobrarDetalleCobros(esInicial);
		this.setActivarid_empresaCobrarDetalleCobros(esInicial);
		this.setActivarid_paisCobrarDetalleCobros(esInicial);
		this.setActivarid_ciudadCobrarDetalleCobros(esInicial);
		this.setActivarid_zonaCobrarDetalleCobros(esInicial);
		this.setActivarid_grupo_clienteCobrarDetalleCobros(esInicial);
		this.setActivarid_vendedorCobrarDetalleCobros(esInicial);
		this.setActivarfecha_emisionCobrarDetalleCobros(esInicial);
		this.setActivarfecha_emision_hastaCobrarDetalleCobros(esInicial);
		this.setActivarnombre_vendedorCobrarDetalleCobros(esInicial);
		this.setActivarcodigoCobrarDetalleCobros(esInicial);
		this.setActivarnombreCobrarDetalleCobros(esInicial);
		this.setActivarapellidoCobrarDetalleCobros(esInicial);
		this.setActivartotal_facturasCobrarDetalleCobros(esInicial);
		this.setActivartotal_abonosCobrarDetalleCobros(esInicial);
		this.setActivartotal_facturas_actualCobrarDetalleCobros(esInicial);
		this.setActivarabonos_anteriorCobrarDetalleCobros(esInicial);
		this.setActivarabonos_actualCobrarDetalleCobros(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.ID)) {
				this.setActivaridCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emisionCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setActivarnombre_vendedorCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS)) {
				this.setActivartotal_facturasCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.TOTALABONOS)) {
				this.setActivartotal_abonosCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL)) {
				this.setActivartotal_facturas_actualCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR)) {
				this.setActivarabonos_anteriorCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL)) {
				this.setActivarabonos_actualCobrarDetalleCobros(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarDetalleCobros(esInicial);
		this.setResaltarid_empresaCobrarDetalleCobros(esInicial);
		this.setResaltarid_paisCobrarDetalleCobros(esInicial);
		this.setResaltarid_ciudadCobrarDetalleCobros(esInicial);
		this.setResaltarid_zonaCobrarDetalleCobros(esInicial);
		this.setResaltarid_grupo_clienteCobrarDetalleCobros(esInicial);
		this.setResaltarid_vendedorCobrarDetalleCobros(esInicial);
		this.setResaltarfecha_emisionCobrarDetalleCobros(esInicial);
		this.setResaltarfecha_emision_hastaCobrarDetalleCobros(esInicial);
		this.setResaltarnombre_vendedorCobrarDetalleCobros(esInicial);
		this.setResaltarcodigoCobrarDetalleCobros(esInicial);
		this.setResaltarnombreCobrarDetalleCobros(esInicial);
		this.setResaltarapellidoCobrarDetalleCobros(esInicial);
		this.setResaltartotal_facturasCobrarDetalleCobros(esInicial);
		this.setResaltartotal_abonosCobrarDetalleCobros(esInicial);
		this.setResaltartotal_facturas_actualCobrarDetalleCobros(esInicial);
		this.setResaltarabonos_anteriorCobrarDetalleCobros(esInicial);
		this.setResaltarabonos_actualCobrarDetalleCobros(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.ID)) {
				this.setResaltaridCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emisionCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setResaltarnombre_vendedorCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS)) {
				this.setResaltartotal_facturasCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.TOTALABONOS)) {
				this.setResaltartotal_abonosCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL)) {
				this.setResaltartotal_facturas_actualCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR)) {
				this.setResaltarabonos_anteriorCobrarDetalleCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL)) {
				this.setResaltarabonos_actualCobrarDetalleCobros(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarDetalleCobrosCobrarDetalleCobros=true;

	public Boolean getMostrarBusquedaCobrarDetalleCobrosCobrarDetalleCobros() {
		return this.mostrarBusquedaCobrarDetalleCobrosCobrarDetalleCobros;
	}

	public void setMostrarBusquedaCobrarDetalleCobrosCobrarDetalleCobros(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarDetalleCobrosCobrarDetalleCobros= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarDetalleCobrosCobrarDetalleCobros=true;

	public Boolean getActivarBusquedaCobrarDetalleCobrosCobrarDetalleCobros() {
		return this.activarBusquedaCobrarDetalleCobrosCobrarDetalleCobros;
	}

	public void setActivarBusquedaCobrarDetalleCobrosCobrarDetalleCobros(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarDetalleCobrosCobrarDetalleCobros= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarDetalleCobrosCobrarDetalleCobros=null;

	public Border getResaltarBusquedaCobrarDetalleCobrosCobrarDetalleCobros() {
		return this.resaltarBusquedaCobrarDetalleCobrosCobrarDetalleCobros;
	}

	public void setResaltarBusquedaCobrarDetalleCobrosCobrarDetalleCobros(Border borderResaltar) {
		this.resaltarBusquedaCobrarDetalleCobrosCobrarDetalleCobros= borderResaltar;
	}

	public void setResaltarBusquedaCobrarDetalleCobrosCobrarDetalleCobros(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarDetalleCobrosBeanSwingJInternalFrame cobrardetallecobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarDetalleCobrosCobrarDetalleCobros= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}