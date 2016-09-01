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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.VentasLineasConstantesFunciones;
import com.bydan.erp.facturacion.util.report.VentasLineasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.VentasLineasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VentasLineasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VentasLineas";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentasLineas"+VentasLineasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentasLineasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentasLineasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentasLineasConstantesFunciones.SCHEMA+"_"+VentasLineasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentasLineasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentasLineasConstantesFunciones.SCHEMA+"_"+VentasLineasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentasLineasConstantesFunciones.SCHEMA+"_"+VentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentasLineasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentasLineasConstantesFunciones.SCHEMA+"_"+VentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasLineasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasLineasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentasLineasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentasLineasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentasLineasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentasLineasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ventas Lineases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ventas Lineas";
	public static final String SCLASSWEBTITULO_LOWER="Ventas Lineas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentasLineas";
	public static final String OBJECTNAME="ventaslineas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="ventas_lineas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventaslineas from "+VentasLineasConstantesFunciones.SPERSISTENCENAME+" ventaslineas";
	public static String QUERYSELECTNATIVE="select "+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".id,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".version_row,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".id_empresa,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".id_linea,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".id_linea_grupo,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".id_linea_categoria,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".id_linea_marca,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".nombre_linea,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".nombre_grupo,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".nombre_categoria,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".nombre_marca,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".monto,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".notas_credito,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".venta_neta,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".porcentaje,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".acumulado,"+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME+".tipo from "+VentasLineasConstantesFunciones.SCHEMA+"."+VentasLineasConstantesFunciones.TABLENAME;//+" as "+VentasLineasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBREGRUPO= "nombre_grupo";
    public static final String NOMBRECATEGORIA= "nombre_categoria";
    public static final String NOMBREMARCA= "nombre_marca";
    public static final String MONTO= "monto";
    public static final String NOTASCREDITO= "notas_credito";
    public static final String VENTANETA= "venta_neta";
    public static final String PORCENTAJE= "porcentaje";
    public static final String ACUMULADO= "acumulado";
    public static final String TIPO= "tipo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRELINEA= "Nombre Linea";
		public static final String LABEL_NOMBRELINEA_LOWER= "Nombre Linea";
    	public static final String LABEL_NOMBREGRUPO= "Nombre Grupo";
		public static final String LABEL_NOMBREGRUPO_LOWER= "Nombre Grupo";
    	public static final String LABEL_NOMBRECATEGORIA= "Nombre Categoria";
		public static final String LABEL_NOMBRECATEGORIA_LOWER= "Nombre Categoria";
    	public static final String LABEL_NOMBREMARCA= "Nombre Marca";
		public static final String LABEL_NOMBREMARCA_LOWER= "Nombre Marca";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_NOTASCREDITO= "Notas Credito";
		public static final String LABEL_NOTASCREDITO_LOWER= "Notas Credito";
    	public static final String LABEL_VENTANETA= "Venta Neta";
		public static final String LABEL_VENTANETA_LOWER= "Venta Neta";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_ACUMULADO= "Acumulado";
		public static final String LABEL_ACUMULADO_LOWER= "Acumulado";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_LINEA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CATEGORIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CATEGORIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MARCA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVentasLineasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.IDLINEA)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.NOMBRELINEA)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.NOMBREGRUPO)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_NOMBREGRUPO;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.NOMBRECATEGORIA)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_NOMBRECATEGORIA;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.NOMBREMARCA)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_NOMBREMARCA;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.MONTO)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.NOTASCREDITO)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_NOTASCREDITO;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.VENTANETA)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_VENTANETA;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.PORCENTAJE)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.ACUMULADO)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_ACUMULADO;}
		if(sNombreColumna.equals(VentasLineasConstantesFunciones.TIPO)) {sLabelColumna=VentasLineasConstantesFunciones.LABEL_TIPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentasLineasDescripcion(VentasLineas ventaslineas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventaslineas !=null/* && ventaslineas.getId()!=0*/) {
			if(ventaslineas.getId()!=null) {
				sDescripcion=ventaslineas.getId().toString();
			}//ventaslineasventaslineas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVentasLineasDescripcionDetallado(VentasLineas ventaslineas) {
		String sDescripcion="";
			
		sDescripcion+=VentasLineasConstantesFunciones.ID+"=";
		sDescripcion+=ventaslineas.getId().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventaslineas.getVersionRow().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventaslineas.getid_empresa().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.IDLINEA+"=";
		sDescripcion+=ventaslineas.getid_linea().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=ventaslineas.getid_linea_grupo().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=ventaslineas.getid_linea_categoria().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=ventaslineas.getid_linea_marca().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=ventaslineas.getfecha_emision_desde().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=ventaslineas.getfecha_emision_hasta().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=ventaslineas.getnombre_linea()+",";
		sDescripcion+=VentasLineasConstantesFunciones.NOMBREGRUPO+"=";
		sDescripcion+=ventaslineas.getnombre_grupo()+",";
		sDescripcion+=VentasLineasConstantesFunciones.NOMBRECATEGORIA+"=";
		sDescripcion+=ventaslineas.getnombre_categoria()+",";
		sDescripcion+=VentasLineasConstantesFunciones.NOMBREMARCA+"=";
		sDescripcion+=ventaslineas.getnombre_marca()+",";
		sDescripcion+=VentasLineasConstantesFunciones.MONTO+"=";
		sDescripcion+=ventaslineas.getmonto().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.NOTASCREDITO+"=";
		sDescripcion+=ventaslineas.getnotas_credito().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.VENTANETA+"=";
		sDescripcion+=ventaslineas.getventa_neta().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=ventaslineas.getporcentaje().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.ACUMULADO+"=";
		sDescripcion+=ventaslineas.getacumulado().toString()+",";
		sDescripcion+=VentasLineasConstantesFunciones.TIPO+"=";
		sDescripcion+=ventaslineas.gettipo()+",";
			
		return sDescripcion;
	}
	
	public static void setVentasLineasDescripcion(VentasLineas ventaslineas,String sValor) throws Exception {			
		if(ventaslineas !=null) {
			//ventaslineasventaslineas.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaVentasLineas")) {
			sNombreIndice="Tipo=  Por Empresa Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaVentasLineas(Long id_empresa,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVentasLineas(VentasLineas ventaslineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventaslineas.setnombre_linea(ventaslineas.getnombre_linea().trim());
		ventaslineas.setnombre_grupo(ventaslineas.getnombre_grupo().trim());
		ventaslineas.setnombre_categoria(ventaslineas.getnombre_categoria().trim());
		ventaslineas.setnombre_marca(ventaslineas.getnombre_marca().trim());
		ventaslineas.settipo(ventaslineas.gettipo().trim());
	}
	
	public static void quitarEspaciosVentasLineass(List<VentasLineas> ventaslineass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasLineas ventaslineas: ventaslineass) {
			ventaslineas.setnombre_linea(ventaslineas.getnombre_linea().trim());
			ventaslineas.setnombre_grupo(ventaslineas.getnombre_grupo().trim());
			ventaslineas.setnombre_categoria(ventaslineas.getnombre_categoria().trim());
			ventaslineas.setnombre_marca(ventaslineas.getnombre_marca().trim());
			ventaslineas.settipo(ventaslineas.gettipo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasLineas(VentasLineas ventaslineas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventaslineas.getConCambioAuxiliar()) {
			ventaslineas.setIsDeleted(ventaslineas.getIsDeletedAuxiliar());	
			ventaslineas.setIsNew(ventaslineas.getIsNewAuxiliar());	
			ventaslineas.setIsChanged(ventaslineas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventaslineas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventaslineas.setIsDeletedAuxiliar(false);	
			ventaslineas.setIsNewAuxiliar(false);	
			ventaslineas.setIsChangedAuxiliar(false);
			
			ventaslineas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasLineass(List<VentasLineas> ventaslineass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentasLineas ventaslineas : ventaslineass) {
			if(conAsignarBase && ventaslineas.getConCambioAuxiliar()) {
				ventaslineas.setIsDeleted(ventaslineas.getIsDeletedAuxiliar());	
				ventaslineas.setIsNew(ventaslineas.getIsNewAuxiliar());	
				ventaslineas.setIsChanged(ventaslineas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventaslineas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventaslineas.setIsDeletedAuxiliar(false);	
				ventaslineas.setIsNewAuxiliar(false);	
				ventaslineas.setIsChangedAuxiliar(false);
				
				ventaslineas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentasLineas(VentasLineas ventaslineas,Boolean conEnteros) throws Exception  {
		ventaslineas.setmonto(0.0);
		ventaslineas.setnotas_credito(0.0);
		ventaslineas.setventa_neta(0.0);
		ventaslineas.setporcentaje(0.0);
		ventaslineas.setacumulado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVentasLineass(List<VentasLineas> ventaslineass,Boolean conEnteros) throws Exception  {
		
		for(VentasLineas ventaslineas: ventaslineass) {
			ventaslineas.setmonto(0.0);
			ventaslineas.setnotas_credito(0.0);
			ventaslineas.setventa_neta(0.0);
			ventaslineas.setporcentaje(0.0);
			ventaslineas.setacumulado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentasLineas(List<VentasLineas> ventaslineass,VentasLineas ventaslineasAux) throws Exception  {
		VentasLineasConstantesFunciones.InicializarValoresVentasLineas(ventaslineasAux,true);
		
		for(VentasLineas ventaslineas: ventaslineass) {
			if(ventaslineas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventaslineasAux.setmonto(ventaslineasAux.getmonto()+ventaslineas.getmonto());			
			ventaslineasAux.setnotas_credito(ventaslineasAux.getnotas_credito()+ventaslineas.getnotas_credito());			
			ventaslineasAux.setventa_neta(ventaslineasAux.getventa_neta()+ventaslineas.getventa_neta());			
			ventaslineasAux.setporcentaje(ventaslineasAux.getporcentaje()+ventaslineas.getporcentaje());			
			ventaslineasAux.setacumulado(ventaslineasAux.getacumulado()+ventaslineas.getacumulado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasLineas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentasLineasConstantesFunciones.getArrayColumnasGlobalesVentasLineas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasLineas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasLineasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasLineasConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentasLineas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasLineas> ventaslineass,VentasLineas ventaslineas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasLineas ventaslineasAux: ventaslineass) {
			if(ventaslineasAux!=null && ventaslineas!=null) {
				if((ventaslineasAux.getId()==null && ventaslineas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventaslineasAux.getId()!=null && ventaslineas.getId()!=null){
					if(ventaslineasAux.getId().equals(ventaslineas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasLineas(List<VentasLineas> ventaslineass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double notas_creditoTotal=0.0;
		Double venta_netaTotal=0.0;
		Double porcentajeTotal=0.0;
		Double acumuladoTotal=0.0;
	
		for(VentasLineas ventaslineas: ventaslineass) {			
			if(ventaslineas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=ventaslineas.getmonto();
			notas_creditoTotal+=ventaslineas.getnotas_credito();
			venta_netaTotal+=ventaslineas.getventa_neta();
			porcentajeTotal+=ventaslineas.getporcentaje();
			acumuladoTotal+=ventaslineas.getacumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.NOTASCREDITO);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_NOTASCREDITO);
		datoGeneral.setdValorDouble(notas_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.VENTANETA);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_VENTANETA);
		datoGeneral.setdValorDouble(venta_netaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.ACUMULADO);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_ACUMULADO);
		datoGeneral.setdValorDouble(acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentasLineas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_ID, VentasLineasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_VERSIONROW, VentasLineasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_NOMBRELINEA, VentasLineasConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_NOMBREGRUPO, VentasLineasConstantesFunciones.NOMBREGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_NOMBRECATEGORIA, VentasLineasConstantesFunciones.NOMBRECATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_NOMBREMARCA, VentasLineasConstantesFunciones.NOMBREMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_MONTO, VentasLineasConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_NOTASCREDITO, VentasLineasConstantesFunciones.NOTASCREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_VENTANETA, VentasLineasConstantesFunciones.VENTANETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_PORCENTAJE, VentasLineasConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_ACUMULADO, VentasLineasConstantesFunciones.ACUMULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasLineasConstantesFunciones.LABEL_TIPO, VentasLineasConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentasLineas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.NOMBREGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.NOMBRECATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.NOMBREMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.NOTASCREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.VENTANETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.ACUMULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasLineasConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasLineas() throws Exception  {
		return VentasLineasConstantesFunciones.getTiposSeleccionarVentasLineas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasLineas(Boolean conFk) throws Exception  {
		return VentasLineasConstantesFunciones.getTiposSeleccionarVentasLineas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasLineas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_NOMBREGRUPO);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_NOMBREGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_NOMBRECATEGORIA);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_NOMBRECATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_NOMBREMARCA);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_NOMBREMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_NOTASCREDITO);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_NOTASCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_VENTANETA);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_VENTANETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_ACUMULADO);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_ACUMULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasLineasConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(VentasLineasConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentasLineas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentasLineas(VentasLineas ventaslineasAux) throws Exception {
		
			ventaslineasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventaslineasAux.getEmpresa()));
			ventaslineasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaslineasAux.getLinea()));
			ventaslineasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaslineasAux.getLineaGrupo()));
			ventaslineasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaslineasAux.getLineaCategoria()));
			ventaslineasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaslineasAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentasLineas(List<VentasLineas> ventaslineassTemp) throws Exception {
		for(VentasLineas ventaslineasAux:ventaslineassTemp) {
			
			ventaslineasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventaslineasAux.getEmpresa()));
			ventaslineasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaslineasAux.getLinea()));
			ventaslineasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaslineasAux.getLineaGrupo()));
			ventaslineasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaslineasAux.getLineaCategoria()));
			ventaslineasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaslineasAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentasLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentasLineas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasLineasConstantesFunciones.getClassesRelationshipsOfVentasLineas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasLineas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasLineasConstantesFunciones.getClassesRelationshipsFromStringsOfVentasLineas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasLineas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VentasLineas ventaslineas,List<VentasLineas> ventaslineass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentasLineas ventaslineas,List<VentasLineas> ventaslineass) throws Exception {
		try	{			
			for(VentasLineas ventaslineasLocal:ventaslineass) {
				if(ventaslineasLocal.getId().equals(ventaslineas.getId())) {
					ventaslineasLocal.setIsSelected(ventaslineas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentasLineas(List<VentasLineas> ventaslineassAux) throws Exception {
		//this.ventaslineassAux=ventaslineassAux;
		
		for(VentasLineas ventaslineasAux:ventaslineassAux) {
			if(ventaslineasAux.getIsChanged()) {
				ventaslineasAux.setIsChanged(false);
			}		
			
			if(ventaslineasAux.getIsNew()) {
				ventaslineasAux.setIsNew(false);
			}	
			
			if(ventaslineasAux.getIsDeleted()) {
				ventaslineasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentasLineas(VentasLineas ventaslineasAux) throws Exception {
		//this.ventaslineasAux=ventaslineasAux;
		
			if(ventaslineasAux.getIsChanged()) {
				ventaslineasAux.setIsChanged(false);
			}		
			
			if(ventaslineasAux.getIsNew()) {
				ventaslineasAux.setIsNew(false);
			}	
			
			if(ventaslineasAux.getIsDeleted()) {
				ventaslineasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentasLineas ventaslineasAsignar,VentasLineas ventaslineas) throws Exception {
		ventaslineasAsignar.setId(ventaslineas.getId());	
		ventaslineasAsignar.setVersionRow(ventaslineas.getVersionRow());	
		ventaslineasAsignar.setnombre_linea(ventaslineas.getnombre_linea());	
		ventaslineasAsignar.setnombre_grupo(ventaslineas.getnombre_grupo());	
		ventaslineasAsignar.setnombre_categoria(ventaslineas.getnombre_categoria());	
		ventaslineasAsignar.setnombre_marca(ventaslineas.getnombre_marca());	
		ventaslineasAsignar.setmonto(ventaslineas.getmonto());	
		ventaslineasAsignar.setnotas_credito(ventaslineas.getnotas_credito());	
		ventaslineasAsignar.setventa_neta(ventaslineas.getventa_neta());	
		ventaslineasAsignar.setporcentaje(ventaslineas.getporcentaje());	
		ventaslineasAsignar.setacumulado(ventaslineas.getacumulado());	
		ventaslineasAsignar.settipo(ventaslineas.gettipo());	
	}
	
	public static void inicializarVentasLineas(VentasLineas ventaslineas) throws Exception {
		try {
				ventaslineas.setId(0L);	
					
				ventaslineas.setnombre_linea("");	
				ventaslineas.setnombre_grupo("");	
				ventaslineas.setnombre_categoria("");	
				ventaslineas.setnombre_marca("");	
				ventaslineas.setmonto(0.0);	
				ventaslineas.setnotas_credito(0.0);	
				ventaslineas.setventa_neta(0.0);	
				ventaslineas.setporcentaje(0.0);	
				ventaslineas.setacumulado(0.0);	
				ventaslineas.settipo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentasLineas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_NOMBREGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_NOMBRECATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_NOMBREMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_NOTASCREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_VENTANETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_ACUMULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasLineasConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentasLineas(String sTipo,Row row,Workbook workbook,VentasLineas ventaslineas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getnombre_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getnombre_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getnombre_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getnotas_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getventa_neta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.getacumulado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaslineas.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentasLineas="";
	
	public String getsFinalQueryVentasLineas() {
		return this.sFinalQueryVentasLineas;
	}
	
	public void setsFinalQueryVentasLineas(String sFinalQueryVentasLineas) {
		this.sFinalQueryVentasLineas= sFinalQueryVentasLineas;
	}
	
	public Border resaltarSeleccionarVentasLineas=null;
	
	public Border setResaltarSeleccionarVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentasLineas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentasLineas() {
		return this.resaltarSeleccionarVentasLineas;
	}
	
	public void setResaltarSeleccionarVentasLineas(Border borderResaltarSeleccionarVentasLineas) {
		this.resaltarSeleccionarVentasLineas= borderResaltarSeleccionarVentasLineas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentasLineas=null;
	public Boolean mostraridVentasLineas=true;
	public Boolean activaridVentasLineas=true;

	public Border resaltarid_empresaVentasLineas=null;
	public Boolean mostrarid_empresaVentasLineas=true;
	public Boolean activarid_empresaVentasLineas=true;
	public Boolean cargarid_empresaVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_lineaVentasLineas=null;
	public Boolean mostrarid_lineaVentasLineas=true;
	public Boolean activarid_lineaVentasLineas=true;
	public Boolean cargarid_lineaVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoVentasLineas=null;
	public Boolean mostrarid_linea_grupoVentasLineas=true;
	public Boolean activarid_linea_grupoVentasLineas=true;
	public Boolean cargarid_linea_grupoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaVentasLineas=null;
	public Boolean mostrarid_linea_categoriaVentasLineas=true;
	public Boolean activarid_linea_categoriaVentasLineas=true;
	public Boolean cargarid_linea_categoriaVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaVentasLineas=null;
	public Boolean mostrarid_linea_marcaVentasLineas=true;
	public Boolean activarid_linea_marcaVentasLineas=true;
	public Boolean cargarid_linea_marcaVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaVentasLineas=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeVentasLineas=null;
	public Boolean mostrarfecha_emision_desdeVentasLineas=true;
	public Boolean activarfecha_emision_desdeVentasLineas=true;

	public Border resaltarfecha_emision_hastaVentasLineas=null;
	public Boolean mostrarfecha_emision_hastaVentasLineas=true;
	public Boolean activarfecha_emision_hastaVentasLineas=true;

	public Border resaltarnombre_lineaVentasLineas=null;
	public Boolean mostrarnombre_lineaVentasLineas=true;
	public Boolean activarnombre_lineaVentasLineas=true;

	public Border resaltarnombre_grupoVentasLineas=null;
	public Boolean mostrarnombre_grupoVentasLineas=true;
	public Boolean activarnombre_grupoVentasLineas=true;

	public Border resaltarnombre_categoriaVentasLineas=null;
	public Boolean mostrarnombre_categoriaVentasLineas=true;
	public Boolean activarnombre_categoriaVentasLineas=true;

	public Border resaltarnombre_marcaVentasLineas=null;
	public Boolean mostrarnombre_marcaVentasLineas=true;
	public Boolean activarnombre_marcaVentasLineas=true;

	public Border resaltarmontoVentasLineas=null;
	public Boolean mostrarmontoVentasLineas=true;
	public Boolean activarmontoVentasLineas=true;

	public Border resaltarnotas_creditoVentasLineas=null;
	public Boolean mostrarnotas_creditoVentasLineas=true;
	public Boolean activarnotas_creditoVentasLineas=true;

	public Border resaltarventa_netaVentasLineas=null;
	public Boolean mostrarventa_netaVentasLineas=true;
	public Boolean activarventa_netaVentasLineas=true;

	public Border resaltarporcentajeVentasLineas=null;
	public Boolean mostrarporcentajeVentasLineas=true;
	public Boolean activarporcentajeVentasLineas=true;

	public Border resaltaracumuladoVentasLineas=null;
	public Boolean mostraracumuladoVentasLineas=true;
	public Boolean activaracumuladoVentasLineas=true;

	public Border resaltartipoVentasLineas=null;
	public Boolean mostrartipoVentasLineas=true;
	public Boolean activartipoVentasLineas=true;

	
	

	public Border setResaltaridVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltaridVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentasLineas() {
		return this.resaltaridVentasLineas;
	}

	public void setResaltaridVentasLineas(Border borderResaltar) {
		this.resaltaridVentasLineas= borderResaltar;
	}

	public Boolean getMostraridVentasLineas() {
		return this.mostraridVentasLineas;
	}

	public void setMostraridVentasLineas(Boolean mostraridVentasLineas) {
		this.mostraridVentasLineas= mostraridVentasLineas;
	}

	public Boolean getActivaridVentasLineas() {
		return this.activaridVentasLineas;
	}

	public void setActivaridVentasLineas(Boolean activaridVentasLineas) {
		this.activaridVentasLineas= activaridVentasLineas;
	}

	public Border setResaltarid_empresaVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentasLineas() {
		return this.resaltarid_empresaVentasLineas;
	}

	public void setResaltarid_empresaVentasLineas(Border borderResaltar) {
		this.resaltarid_empresaVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentasLineas() {
		return this.mostrarid_empresaVentasLineas;
	}

	public void setMostrarid_empresaVentasLineas(Boolean mostrarid_empresaVentasLineas) {
		this.mostrarid_empresaVentasLineas= mostrarid_empresaVentasLineas;
	}

	public Boolean getActivarid_empresaVentasLineas() {
		return this.activarid_empresaVentasLineas;
	}

	public void setActivarid_empresaVentasLineas(Boolean activarid_empresaVentasLineas) {
		this.activarid_empresaVentasLineas= activarid_empresaVentasLineas;
	}

	public Boolean getCargarid_empresaVentasLineas() {
		return this.cargarid_empresaVentasLineas;
	}

	public void setCargarid_empresaVentasLineas(Boolean cargarid_empresaVentasLineas) {
		this.cargarid_empresaVentasLineas= cargarid_empresaVentasLineas;
	}

	public Border setResaltarid_lineaVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_lineaVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaVentasLineas() {
		return this.resaltarid_lineaVentasLineas;
	}

	public void setResaltarid_lineaVentasLineas(Border borderResaltar) {
		this.resaltarid_lineaVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_lineaVentasLineas() {
		return this.mostrarid_lineaVentasLineas;
	}

	public void setMostrarid_lineaVentasLineas(Boolean mostrarid_lineaVentasLineas) {
		this.mostrarid_lineaVentasLineas= mostrarid_lineaVentasLineas;
	}

	public Boolean getActivarid_lineaVentasLineas() {
		return this.activarid_lineaVentasLineas;
	}

	public void setActivarid_lineaVentasLineas(Boolean activarid_lineaVentasLineas) {
		this.activarid_lineaVentasLineas= activarid_lineaVentasLineas;
	}

	public Boolean getCargarid_lineaVentasLineas() {
		return this.cargarid_lineaVentasLineas;
	}

	public void setCargarid_lineaVentasLineas(Boolean cargarid_lineaVentasLineas) {
		this.cargarid_lineaVentasLineas= cargarid_lineaVentasLineas;
	}

	public Border setResaltarid_linea_grupoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoVentasLineas() {
		return this.resaltarid_linea_grupoVentasLineas;
	}

	public void setResaltarid_linea_grupoVentasLineas(Border borderResaltar) {
		this.resaltarid_linea_grupoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoVentasLineas() {
		return this.mostrarid_linea_grupoVentasLineas;
	}

	public void setMostrarid_linea_grupoVentasLineas(Boolean mostrarid_linea_grupoVentasLineas) {
		this.mostrarid_linea_grupoVentasLineas= mostrarid_linea_grupoVentasLineas;
	}

	public Boolean getActivarid_linea_grupoVentasLineas() {
		return this.activarid_linea_grupoVentasLineas;
	}

	public void setActivarid_linea_grupoVentasLineas(Boolean activarid_linea_grupoVentasLineas) {
		this.activarid_linea_grupoVentasLineas= activarid_linea_grupoVentasLineas;
	}

	public Boolean getCargarid_linea_grupoVentasLineas() {
		return this.cargarid_linea_grupoVentasLineas;
	}

	public void setCargarid_linea_grupoVentasLineas(Boolean cargarid_linea_grupoVentasLineas) {
		this.cargarid_linea_grupoVentasLineas= cargarid_linea_grupoVentasLineas;
	}

	public Border setResaltarid_linea_categoriaVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaVentasLineas() {
		return this.resaltarid_linea_categoriaVentasLineas;
	}

	public void setResaltarid_linea_categoriaVentasLineas(Border borderResaltar) {
		this.resaltarid_linea_categoriaVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaVentasLineas() {
		return this.mostrarid_linea_categoriaVentasLineas;
	}

	public void setMostrarid_linea_categoriaVentasLineas(Boolean mostrarid_linea_categoriaVentasLineas) {
		this.mostrarid_linea_categoriaVentasLineas= mostrarid_linea_categoriaVentasLineas;
	}

	public Boolean getActivarid_linea_categoriaVentasLineas() {
		return this.activarid_linea_categoriaVentasLineas;
	}

	public void setActivarid_linea_categoriaVentasLineas(Boolean activarid_linea_categoriaVentasLineas) {
		this.activarid_linea_categoriaVentasLineas= activarid_linea_categoriaVentasLineas;
	}

	public Boolean getCargarid_linea_categoriaVentasLineas() {
		return this.cargarid_linea_categoriaVentasLineas;
	}

	public void setCargarid_linea_categoriaVentasLineas(Boolean cargarid_linea_categoriaVentasLineas) {
		this.cargarid_linea_categoriaVentasLineas= cargarid_linea_categoriaVentasLineas;
	}

	public Border setResaltarid_linea_marcaVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaVentasLineas() {
		return this.resaltarid_linea_marcaVentasLineas;
	}

	public void setResaltarid_linea_marcaVentasLineas(Border borderResaltar) {
		this.resaltarid_linea_marcaVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaVentasLineas() {
		return this.mostrarid_linea_marcaVentasLineas;
	}

	public void setMostrarid_linea_marcaVentasLineas(Boolean mostrarid_linea_marcaVentasLineas) {
		this.mostrarid_linea_marcaVentasLineas= mostrarid_linea_marcaVentasLineas;
	}

	public Boolean getActivarid_linea_marcaVentasLineas() {
		return this.activarid_linea_marcaVentasLineas;
	}

	public void setActivarid_linea_marcaVentasLineas(Boolean activarid_linea_marcaVentasLineas) {
		this.activarid_linea_marcaVentasLineas= activarid_linea_marcaVentasLineas;
	}

	public Boolean getCargarid_linea_marcaVentasLineas() {
		return this.cargarid_linea_marcaVentasLineas;
	}

	public void setCargarid_linea_marcaVentasLineas(Boolean cargarid_linea_marcaVentasLineas) {
		this.cargarid_linea_marcaVentasLineas= cargarid_linea_marcaVentasLineas;
	}

	public Border setResaltarfecha_emision_desdeVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeVentasLineas() {
		return this.resaltarfecha_emision_desdeVentasLineas;
	}

	public void setResaltarfecha_emision_desdeVentasLineas(Border borderResaltar) {
		this.resaltarfecha_emision_desdeVentasLineas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeVentasLineas() {
		return this.mostrarfecha_emision_desdeVentasLineas;
	}

	public void setMostrarfecha_emision_desdeVentasLineas(Boolean mostrarfecha_emision_desdeVentasLineas) {
		this.mostrarfecha_emision_desdeVentasLineas= mostrarfecha_emision_desdeVentasLineas;
	}

	public Boolean getActivarfecha_emision_desdeVentasLineas() {
		return this.activarfecha_emision_desdeVentasLineas;
	}

	public void setActivarfecha_emision_desdeVentasLineas(Boolean activarfecha_emision_desdeVentasLineas) {
		this.activarfecha_emision_desdeVentasLineas= activarfecha_emision_desdeVentasLineas;
	}

	public Border setResaltarfecha_emision_hastaVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaVentasLineas() {
		return this.resaltarfecha_emision_hastaVentasLineas;
	}

	public void setResaltarfecha_emision_hastaVentasLineas(Border borderResaltar) {
		this.resaltarfecha_emision_hastaVentasLineas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaVentasLineas() {
		return this.mostrarfecha_emision_hastaVentasLineas;
	}

	public void setMostrarfecha_emision_hastaVentasLineas(Boolean mostrarfecha_emision_hastaVentasLineas) {
		this.mostrarfecha_emision_hastaVentasLineas= mostrarfecha_emision_hastaVentasLineas;
	}

	public Boolean getActivarfecha_emision_hastaVentasLineas() {
		return this.activarfecha_emision_hastaVentasLineas;
	}

	public void setActivarfecha_emision_hastaVentasLineas(Boolean activarfecha_emision_hastaVentasLineas) {
		this.activarfecha_emision_hastaVentasLineas= activarfecha_emision_hastaVentasLineas;
	}

	public Border setResaltarnombre_lineaVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaVentasLineas() {
		return this.resaltarnombre_lineaVentasLineas;
	}

	public void setResaltarnombre_lineaVentasLineas(Border borderResaltar) {
		this.resaltarnombre_lineaVentasLineas= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaVentasLineas() {
		return this.mostrarnombre_lineaVentasLineas;
	}

	public void setMostrarnombre_lineaVentasLineas(Boolean mostrarnombre_lineaVentasLineas) {
		this.mostrarnombre_lineaVentasLineas= mostrarnombre_lineaVentasLineas;
	}

	public Boolean getActivarnombre_lineaVentasLineas() {
		return this.activarnombre_lineaVentasLineas;
	}

	public void setActivarnombre_lineaVentasLineas(Boolean activarnombre_lineaVentasLineas) {
		this.activarnombre_lineaVentasLineas= activarnombre_lineaVentasLineas;
	}

	public Border setResaltarnombre_grupoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarnombre_grupoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupoVentasLineas() {
		return this.resaltarnombre_grupoVentasLineas;
	}

	public void setResaltarnombre_grupoVentasLineas(Border borderResaltar) {
		this.resaltarnombre_grupoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarnombre_grupoVentasLineas() {
		return this.mostrarnombre_grupoVentasLineas;
	}

	public void setMostrarnombre_grupoVentasLineas(Boolean mostrarnombre_grupoVentasLineas) {
		this.mostrarnombre_grupoVentasLineas= mostrarnombre_grupoVentasLineas;
	}

	public Boolean getActivarnombre_grupoVentasLineas() {
		return this.activarnombre_grupoVentasLineas;
	}

	public void setActivarnombre_grupoVentasLineas(Boolean activarnombre_grupoVentasLineas) {
		this.activarnombre_grupoVentasLineas= activarnombre_grupoVentasLineas;
	}

	public Border setResaltarnombre_categoriaVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarnombre_categoriaVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_categoriaVentasLineas() {
		return this.resaltarnombre_categoriaVentasLineas;
	}

	public void setResaltarnombre_categoriaVentasLineas(Border borderResaltar) {
		this.resaltarnombre_categoriaVentasLineas= borderResaltar;
	}

	public Boolean getMostrarnombre_categoriaVentasLineas() {
		return this.mostrarnombre_categoriaVentasLineas;
	}

	public void setMostrarnombre_categoriaVentasLineas(Boolean mostrarnombre_categoriaVentasLineas) {
		this.mostrarnombre_categoriaVentasLineas= mostrarnombre_categoriaVentasLineas;
	}

	public Boolean getActivarnombre_categoriaVentasLineas() {
		return this.activarnombre_categoriaVentasLineas;
	}

	public void setActivarnombre_categoriaVentasLineas(Boolean activarnombre_categoriaVentasLineas) {
		this.activarnombre_categoriaVentasLineas= activarnombre_categoriaVentasLineas;
	}

	public Border setResaltarnombre_marcaVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarnombre_marcaVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_marcaVentasLineas() {
		return this.resaltarnombre_marcaVentasLineas;
	}

	public void setResaltarnombre_marcaVentasLineas(Border borderResaltar) {
		this.resaltarnombre_marcaVentasLineas= borderResaltar;
	}

	public Boolean getMostrarnombre_marcaVentasLineas() {
		return this.mostrarnombre_marcaVentasLineas;
	}

	public void setMostrarnombre_marcaVentasLineas(Boolean mostrarnombre_marcaVentasLineas) {
		this.mostrarnombre_marcaVentasLineas= mostrarnombre_marcaVentasLineas;
	}

	public Boolean getActivarnombre_marcaVentasLineas() {
		return this.activarnombre_marcaVentasLineas;
	}

	public void setActivarnombre_marcaVentasLineas(Boolean activarnombre_marcaVentasLineas) {
		this.activarnombre_marcaVentasLineas= activarnombre_marcaVentasLineas;
	}

	public Border setResaltarmontoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarmontoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoVentasLineas() {
		return this.resaltarmontoVentasLineas;
	}

	public void setResaltarmontoVentasLineas(Border borderResaltar) {
		this.resaltarmontoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarmontoVentasLineas() {
		return this.mostrarmontoVentasLineas;
	}

	public void setMostrarmontoVentasLineas(Boolean mostrarmontoVentasLineas) {
		this.mostrarmontoVentasLineas= mostrarmontoVentasLineas;
	}

	public Boolean getActivarmontoVentasLineas() {
		return this.activarmontoVentasLineas;
	}

	public void setActivarmontoVentasLineas(Boolean activarmontoVentasLineas) {
		this.activarmontoVentasLineas= activarmontoVentasLineas;
	}

	public Border setResaltarnotas_creditoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarnotas_creditoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnotas_creditoVentasLineas() {
		return this.resaltarnotas_creditoVentasLineas;
	}

	public void setResaltarnotas_creditoVentasLineas(Border borderResaltar) {
		this.resaltarnotas_creditoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarnotas_creditoVentasLineas() {
		return this.mostrarnotas_creditoVentasLineas;
	}

	public void setMostrarnotas_creditoVentasLineas(Boolean mostrarnotas_creditoVentasLineas) {
		this.mostrarnotas_creditoVentasLineas= mostrarnotas_creditoVentasLineas;
	}

	public Boolean getActivarnotas_creditoVentasLineas() {
		return this.activarnotas_creditoVentasLineas;
	}

	public void setActivarnotas_creditoVentasLineas(Boolean activarnotas_creditoVentasLineas) {
		this.activarnotas_creditoVentasLineas= activarnotas_creditoVentasLineas;
	}

	public Border setResaltarventa_netaVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarventa_netaVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarventa_netaVentasLineas() {
		return this.resaltarventa_netaVentasLineas;
	}

	public void setResaltarventa_netaVentasLineas(Border borderResaltar) {
		this.resaltarventa_netaVentasLineas= borderResaltar;
	}

	public Boolean getMostrarventa_netaVentasLineas() {
		return this.mostrarventa_netaVentasLineas;
	}

	public void setMostrarventa_netaVentasLineas(Boolean mostrarventa_netaVentasLineas) {
		this.mostrarventa_netaVentasLineas= mostrarventa_netaVentasLineas;
	}

	public Boolean getActivarventa_netaVentasLineas() {
		return this.activarventa_netaVentasLineas;
	}

	public void setActivarventa_netaVentasLineas(Boolean activarventa_netaVentasLineas) {
		this.activarventa_netaVentasLineas= activarventa_netaVentasLineas;
	}

	public Border setResaltarporcentajeVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltarporcentajeVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeVentasLineas() {
		return this.resaltarporcentajeVentasLineas;
	}

	public void setResaltarporcentajeVentasLineas(Border borderResaltar) {
		this.resaltarporcentajeVentasLineas= borderResaltar;
	}

	public Boolean getMostrarporcentajeVentasLineas() {
		return this.mostrarporcentajeVentasLineas;
	}

	public void setMostrarporcentajeVentasLineas(Boolean mostrarporcentajeVentasLineas) {
		this.mostrarporcentajeVentasLineas= mostrarporcentajeVentasLineas;
	}

	public Boolean getActivarporcentajeVentasLineas() {
		return this.activarporcentajeVentasLineas;
	}

	public void setActivarporcentajeVentasLineas(Boolean activarporcentajeVentasLineas) {
		this.activarporcentajeVentasLineas= activarporcentajeVentasLineas;
	}

	public Border setResaltaracumuladoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltaracumuladoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaracumuladoVentasLineas() {
		return this.resaltaracumuladoVentasLineas;
	}

	public void setResaltaracumuladoVentasLineas(Border borderResaltar) {
		this.resaltaracumuladoVentasLineas= borderResaltar;
	}

	public Boolean getMostraracumuladoVentasLineas() {
		return this.mostraracumuladoVentasLineas;
	}

	public void setMostraracumuladoVentasLineas(Boolean mostraracumuladoVentasLineas) {
		this.mostraracumuladoVentasLineas= mostraracumuladoVentasLineas;
	}

	public Boolean getActivaracumuladoVentasLineas() {
		return this.activaracumuladoVentasLineas;
	}

	public void setActivaracumuladoVentasLineas(Boolean activaracumuladoVentasLineas) {
		this.activaracumuladoVentasLineas= activaracumuladoVentasLineas;
	}

	public Border setResaltartipoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaslineasBeanSwingJInternalFrame.jTtoolBarVentasLineas.setBorder(borderResaltar);
		
		this.resaltartipoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoVentasLineas() {
		return this.resaltartipoVentasLineas;
	}

	public void setResaltartipoVentasLineas(Border borderResaltar) {
		this.resaltartipoVentasLineas= borderResaltar;
	}

	public Boolean getMostrartipoVentasLineas() {
		return this.mostrartipoVentasLineas;
	}

	public void setMostrartipoVentasLineas(Boolean mostrartipoVentasLineas) {
		this.mostrartipoVentasLineas= mostrartipoVentasLineas;
	}

	public Boolean getActivartipoVentasLineas() {
		return this.activartipoVentasLineas;
	}

	public void setActivartipoVentasLineas(Boolean activartipoVentasLineas) {
		this.activartipoVentasLineas= activartipoVentasLineas;
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
		
		
		this.setMostraridVentasLineas(esInicial);
		this.setMostrarid_empresaVentasLineas(esInicial);
		this.setMostrarid_lineaVentasLineas(esInicial);
		this.setMostrarid_linea_grupoVentasLineas(esInicial);
		this.setMostrarid_linea_categoriaVentasLineas(esInicial);
		this.setMostrarid_linea_marcaVentasLineas(esInicial);
		this.setMostrarfecha_emision_desdeVentasLineas(esInicial);
		this.setMostrarfecha_emision_hastaVentasLineas(esInicial);
		this.setMostrarnombre_lineaVentasLineas(esInicial);
		this.setMostrarnombre_grupoVentasLineas(esInicial);
		this.setMostrarnombre_categoriaVentasLineas(esInicial);
		this.setMostrarnombre_marcaVentasLineas(esInicial);
		this.setMostrarmontoVentasLineas(esInicial);
		this.setMostrarnotas_creditoVentasLineas(esInicial);
		this.setMostrarventa_netaVentasLineas(esInicial);
		this.setMostrarporcentajeVentasLineas(esInicial);
		this.setMostraracumuladoVentasLineas(esInicial);
		this.setMostrartipoVentasLineas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasLineasConstantesFunciones.ID)) {
				this.setMostraridVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBREGRUPO)) {
				this.setMostrarnombre_grupoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBRECATEGORIA)) {
				this.setMostrarnombre_categoriaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBREMARCA)) {
				this.setMostrarnombre_marcaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.MONTO)) {
				this.setMostrarmontoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOTASCREDITO)) {
				this.setMostrarnotas_creditoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.VENTANETA)) {
				this.setMostrarventa_netaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.ACUMULADO)) {
				this.setMostraracumuladoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.TIPO)) {
				this.setMostrartipoVentasLineas(esAsigna);
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
		
		
		this.setActivaridVentasLineas(esInicial);
		this.setActivarid_empresaVentasLineas(esInicial);
		this.setActivarid_lineaVentasLineas(esInicial);
		this.setActivarid_linea_grupoVentasLineas(esInicial);
		this.setActivarid_linea_categoriaVentasLineas(esInicial);
		this.setActivarid_linea_marcaVentasLineas(esInicial);
		this.setActivarfecha_emision_desdeVentasLineas(esInicial);
		this.setActivarfecha_emision_hastaVentasLineas(esInicial);
		this.setActivarnombre_lineaVentasLineas(esInicial);
		this.setActivarnombre_grupoVentasLineas(esInicial);
		this.setActivarnombre_categoriaVentasLineas(esInicial);
		this.setActivarnombre_marcaVentasLineas(esInicial);
		this.setActivarmontoVentasLineas(esInicial);
		this.setActivarnotas_creditoVentasLineas(esInicial);
		this.setActivarventa_netaVentasLineas(esInicial);
		this.setActivarporcentajeVentasLineas(esInicial);
		this.setActivaracumuladoVentasLineas(esInicial);
		this.setActivartipoVentasLineas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasLineasConstantesFunciones.ID)) {
				this.setActivaridVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBREGRUPO)) {
				this.setActivarnombre_grupoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBRECATEGORIA)) {
				this.setActivarnombre_categoriaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBREMARCA)) {
				this.setActivarnombre_marcaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.MONTO)) {
				this.setActivarmontoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOTASCREDITO)) {
				this.setActivarnotas_creditoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.VENTANETA)) {
				this.setActivarventa_netaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.ACUMULADO)) {
				this.setActivaracumuladoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.TIPO)) {
				this.setActivartipoVentasLineas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentasLineas(esInicial);
		this.setResaltarid_empresaVentasLineas(esInicial);
		this.setResaltarid_lineaVentasLineas(esInicial);
		this.setResaltarid_linea_grupoVentasLineas(esInicial);
		this.setResaltarid_linea_categoriaVentasLineas(esInicial);
		this.setResaltarid_linea_marcaVentasLineas(esInicial);
		this.setResaltarfecha_emision_desdeVentasLineas(esInicial);
		this.setResaltarfecha_emision_hastaVentasLineas(esInicial);
		this.setResaltarnombre_lineaVentasLineas(esInicial);
		this.setResaltarnombre_grupoVentasLineas(esInicial);
		this.setResaltarnombre_categoriaVentasLineas(esInicial);
		this.setResaltarnombre_marcaVentasLineas(esInicial);
		this.setResaltarmontoVentasLineas(esInicial);
		this.setResaltarnotas_creditoVentasLineas(esInicial);
		this.setResaltarventa_netaVentasLineas(esInicial);
		this.setResaltarporcentajeVentasLineas(esInicial);
		this.setResaltaracumuladoVentasLineas(esInicial);
		this.setResaltartipoVentasLineas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasLineasConstantesFunciones.ID)) {
				this.setResaltaridVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBREGRUPO)) {
				this.setResaltarnombre_grupoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBRECATEGORIA)) {
				this.setResaltarnombre_categoriaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOMBREMARCA)) {
				this.setResaltarnombre_marcaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.MONTO)) {
				this.setResaltarmontoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.NOTASCREDITO)) {
				this.setResaltarnotas_creditoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.VENTANETA)) {
				this.setResaltarventa_netaVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.ACUMULADO)) {
				this.setResaltaracumuladoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasLineasConstantesFunciones.TIPO)) {
				this.setResaltartipoVentasLineas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaVentasLineasVentasLineas=true;

	public Boolean getMostrarBusquedaVentasLineasVentasLineas() {
		return this.mostrarBusquedaVentasLineasVentasLineas;
	}

	public void setMostrarBusquedaVentasLineasVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentasLineasVentasLineas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentasLineasVentasLineas=true;

	public Boolean getActivarBusquedaVentasLineasVentasLineas() {
		return this.activarBusquedaVentasLineasVentasLineas;
	}

	public void setActivarBusquedaVentasLineasVentasLineas(Boolean habilitarResaltar) {
		this.activarBusquedaVentasLineasVentasLineas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentasLineasVentasLineas=null;

	public Border getResaltarBusquedaVentasLineasVentasLineas() {
		return this.resaltarBusquedaVentasLineasVentasLineas;
	}

	public void setResaltarBusquedaVentasLineasVentasLineas(Border borderResaltar) {
		this.resaltarBusquedaVentasLineasVentasLineas= borderResaltar;
	}

	public void setResaltarBusquedaVentasLineasVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasLineasBeanSwingJInternalFrame ventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentasLineasVentasLineas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}