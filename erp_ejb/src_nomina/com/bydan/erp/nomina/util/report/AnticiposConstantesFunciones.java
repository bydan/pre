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
package com.bydan.erp.nomina.util.report;

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


import com.bydan.erp.nomina.util.report.AnticiposConstantesFunciones;
import com.bydan.erp.nomina.util.report.AnticiposParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.AnticiposParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AnticiposConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Anticipos";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Anticipos"+AnticiposConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AnticiposHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AnticiposHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AnticiposConstantesFunciones.SCHEMA+"_"+AnticiposConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AnticiposHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AnticiposConstantesFunciones.SCHEMA+"_"+AnticiposConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AnticiposConstantesFunciones.SCHEMA+"_"+AnticiposConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AnticiposHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AnticiposConstantesFunciones.SCHEMA+"_"+AnticiposConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnticiposConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AnticiposHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnticiposConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnticiposConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AnticiposHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnticiposConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AnticiposConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AnticiposConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AnticiposConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AnticiposConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Anticiposes";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Anticipos";
	public static final String SCLASSWEBTITULO_LOWER="Anticipos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Anticipos";
	public static final String OBJECTNAME="anticipos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="anticipos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select anticipos from "+AnticiposConstantesFunciones.SPERSISTENCENAME+" anticipos";
	public static String QUERYSELECTNATIVE="select "+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".id,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".version_row,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".id_empresa,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".id_tipo_contrato,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".codigo,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".fecha_desde,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".fecha_hasta,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".codigo_cargo,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".nombre_estructura,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".codigo_dato,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".nombre_completo,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".sueldo,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".fecha,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".valor,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".valor_adicional,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".valor_prestamo,"+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME+".total from "+AnticiposConstantesFunciones.SCHEMA+"."+AnticiposConstantesFunciones.TABLENAME;//+" as "+AnticiposConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOCONTRATO= "id_tipo_contrato";
    public static final String CODIGO= "codigo";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String CODIGOCARGO= "codigo_cargo";
    public static final String NOMBREESTRUCTURA= "nombre_estructura";
    public static final String CODIGODATO= "codigo_dato";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String SUELDO= "sueldo";
    public static final String FECHA= "fecha";
    public static final String VALOR= "valor";
    public static final String VALORADICIONAL= "valor_adicional";
    public static final String VALORPRESTAMO= "valor_prestamo";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOCONTRATO= "Tipo Contrato";
		public static final String LABEL_IDTIPOCONTRATO_LOWER= "Tipo Contrato";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_CODIGOCARGO= "Codigo Cargo";
		public static final String LABEL_CODIGOCARGO_LOWER= "Codigo Cargo";
    	public static final String LABEL_NOMBREESTRUCTURA= "Nombre Estructura";
		public static final String LABEL_NOMBREESTRUCTURA_LOWER= "Nombre Estructura";
    	public static final String LABEL_CODIGODATO= "Codigo Dato";
		public static final String LABEL_CODIGODATO_LOWER= "Codigo Dato";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_SUELDO= "Sueldo";
		public static final String LABEL_SUELDO_LOWER= "Sueldo";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_VALORADICIONAL= "Valor Adicional";
		public static final String LABEL_VALORADICIONAL_LOWER= "Valor Adicional";
    	public static final String LABEL_VALORPRESTAMO= "Valor Prestamo";
		public static final String LABEL_VALORPRESTAMO_LOWER= "Valor Prestamo";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_CARGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CARGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ESTRUCTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ESTRUCTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	
	public static String getAnticiposLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AnticiposConstantesFunciones.IDEMPRESA)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.IDTIPOCONTRATO)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_IDTIPOCONTRATO;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.CODIGO)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.FECHADESDE)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.FECHAHASTA)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.CODIGOCARGO)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_CODIGOCARGO;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.NOMBREESTRUCTURA)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_NOMBREESTRUCTURA;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.CODIGODATO)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_CODIGODATO;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.SUELDO)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_SUELDO;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.FECHA)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.VALOR)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.VALORADICIONAL)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_VALORADICIONAL;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.VALORPRESTAMO)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_VALORPRESTAMO;}
		if(sNombreColumna.equals(AnticiposConstantesFunciones.TOTAL)) {sLabelColumna=AnticiposConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAnticiposDescripcion(Anticipos anticipos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(anticipos !=null/* && anticipos.getId()!=0*/) {
			sDescripcion=anticipos.getcodigo();//anticiposanticipos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAnticiposDescripcionDetallado(Anticipos anticipos) {
		String sDescripcion="";
			
		sDescripcion+=AnticiposConstantesFunciones.ID+"=";
		sDescripcion+=anticipos.getId().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=anticipos.getVersionRow().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=anticipos.getid_empresa().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.IDTIPOCONTRATO+"=";
		sDescripcion+=anticipos.getid_tipo_contrato().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.CODIGO+"=";
		sDescripcion+=anticipos.getcodigo()+",";
		sDescripcion+=AnticiposConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=anticipos.getfecha_desde().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=anticipos.getfecha_hasta().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.CODIGOCARGO+"=";
		sDescripcion+=anticipos.getcodigo_cargo()+",";
		sDescripcion+=AnticiposConstantesFunciones.NOMBREESTRUCTURA+"=";
		sDescripcion+=anticipos.getnombre_estructura()+",";
		sDescripcion+=AnticiposConstantesFunciones.CODIGODATO+"=";
		sDescripcion+=anticipos.getcodigo_dato()+",";
		sDescripcion+=AnticiposConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=anticipos.getnombre_completo()+",";
		sDescripcion+=AnticiposConstantesFunciones.SUELDO+"=";
		sDescripcion+=anticipos.getsueldo().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.FECHA+"=";
		sDescripcion+=anticipos.getfecha().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.VALOR+"=";
		sDescripcion+=anticipos.getvalor().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.VALORADICIONAL+"=";
		sDescripcion+=anticipos.getvalor_adicional().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.VALORPRESTAMO+"=";
		sDescripcion+=anticipos.getvalor_prestamo().toString()+",";
		sDescripcion+=AnticiposConstantesFunciones.TOTAL+"=";
		sDescripcion+=anticipos.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAnticiposDescripcion(Anticipos anticipos,String sValor) throws Exception {			
		if(anticipos !=null) {
			anticipos.setcodigo(sValor);;//anticiposanticipos.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoContratoDescripcion(TipoContrato tipocontrato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocontrato!=null/*&&tipocontrato.getId()>0*/) {
			sDescripcion=TipoContratoConstantesFunciones.getTipoContratoDescripcion(tipocontrato);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaAnticipos")) {
			sNombreIndice="Tipo=  Por Tipo Contrato Por Codigo Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoContrato")) {
			sNombreIndice="Tipo=  Por Tipo Contrato";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaAnticipos(Long id_tipo_contrato,String codigo,Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_contrato!=null) {sDetalleIndice+=" Codigo Unico De Tipo Contrato="+id_tipo_contrato.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoContrato(Long id_tipo_contrato) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_contrato!=null) {sDetalleIndice+=" Codigo Unico De Tipo Contrato="+id_tipo_contrato.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAnticipos(Anticipos anticipos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		anticipos.setcodigo_cargo(anticipos.getcodigo_cargo().trim());
		anticipos.setnombre_estructura(anticipos.getnombre_estructura().trim());
		anticipos.setcodigo_dato(anticipos.getcodigo_dato().trim());
		anticipos.setnombre_completo(anticipos.getnombre_completo().trim());
	}
	
	public static void quitarEspaciosAnticiposs(List<Anticipos> anticiposs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Anticipos anticipos: anticiposs) {
			anticipos.setcodigo_cargo(anticipos.getcodigo_cargo().trim());
			anticipos.setnombre_estructura(anticipos.getnombre_estructura().trim());
			anticipos.setcodigo_dato(anticipos.getcodigo_dato().trim());
			anticipos.setnombre_completo(anticipos.getnombre_completo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAnticipos(Anticipos anticipos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && anticipos.getConCambioAuxiliar()) {
			anticipos.setIsDeleted(anticipos.getIsDeletedAuxiliar());	
			anticipos.setIsNew(anticipos.getIsNewAuxiliar());	
			anticipos.setIsChanged(anticipos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			anticipos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			anticipos.setIsDeletedAuxiliar(false);	
			anticipos.setIsNewAuxiliar(false);	
			anticipos.setIsChangedAuxiliar(false);
			
			anticipos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAnticiposs(List<Anticipos> anticiposs,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Anticipos anticipos : anticiposs) {
			if(conAsignarBase && anticipos.getConCambioAuxiliar()) {
				anticipos.setIsDeleted(anticipos.getIsDeletedAuxiliar());	
				anticipos.setIsNew(anticipos.getIsNewAuxiliar());	
				anticipos.setIsChanged(anticipos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				anticipos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				anticipos.setIsDeletedAuxiliar(false);	
				anticipos.setIsNewAuxiliar(false);	
				anticipos.setIsChangedAuxiliar(false);
				
				anticipos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAnticipos(Anticipos anticipos,Boolean conEnteros) throws Exception  {
		anticipos.setsueldo(0.0);
		anticipos.setvalor(0.0);
		anticipos.setvalor_adicional(0.0);
		anticipos.setvalor_prestamo(0.0);
		anticipos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAnticiposs(List<Anticipos> anticiposs,Boolean conEnteros) throws Exception  {
		
		for(Anticipos anticipos: anticiposs) {
			anticipos.setsueldo(0.0);
			anticipos.setvalor(0.0);
			anticipos.setvalor_adicional(0.0);
			anticipos.setvalor_prestamo(0.0);
			anticipos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAnticipos(List<Anticipos> anticiposs,Anticipos anticiposAux) throws Exception  {
		AnticiposConstantesFunciones.InicializarValoresAnticipos(anticiposAux,true);
		
		for(Anticipos anticipos: anticiposs) {
			if(anticipos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			anticiposAux.setsueldo(anticiposAux.getsueldo()+anticipos.getsueldo());			
			anticiposAux.setvalor(anticiposAux.getvalor()+anticipos.getvalor());			
			anticiposAux.setvalor_adicional(anticiposAux.getvalor_adicional()+anticipos.getvalor_adicional());			
			anticiposAux.setvalor_prestamo(anticiposAux.getvalor_prestamo()+anticipos.getvalor_prestamo());			
			anticiposAux.settotal(anticiposAux.gettotal()+anticipos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAnticipos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AnticiposConstantesFunciones.getArrayColumnasGlobalesAnticipos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAnticipos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AnticiposConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AnticiposConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAnticipos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Anticipos> anticiposs,Anticipos anticipos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Anticipos anticiposAux: anticiposs) {
			if(anticiposAux!=null && anticipos!=null) {
				if((anticiposAux.getId()==null && anticipos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(anticiposAux.getId()!=null && anticipos.getId()!=null){
					if(anticiposAux.getId().equals(anticipos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAnticipos(List<Anticipos> anticiposs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double sueldoTotal=0.0;
		Double valorTotal=0.0;
		Double valor_adicionalTotal=0.0;
		Double valor_prestamoTotal=0.0;
		Double totalTotal=0.0;
	
		for(Anticipos anticipos: anticiposs) {			
			if(anticipos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			sueldoTotal+=anticipos.getsueldo();
			valorTotal+=anticipos.getvalor();
			valor_adicionalTotal+=anticipos.getvalor_adicional();
			valor_prestamoTotal+=anticipos.getvalor_prestamo();
			totalTotal+=anticipos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticiposConstantesFunciones.SUELDO);
		datoGeneral.setsDescripcion(AnticiposConstantesFunciones.LABEL_SUELDO);
		datoGeneral.setdValorDouble(sueldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticiposConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(AnticiposConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticiposConstantesFunciones.VALORADICIONAL);
		datoGeneral.setsDescripcion(AnticiposConstantesFunciones.LABEL_VALORADICIONAL);
		datoGeneral.setdValorDouble(valor_adicionalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticiposConstantesFunciones.VALORPRESTAMO);
		datoGeneral.setsDescripcion(AnticiposConstantesFunciones.LABEL_VALORPRESTAMO);
		datoGeneral.setdValorDouble(valor_prestamoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticiposConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(AnticiposConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAnticipos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_ID, AnticiposConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_VERSIONROW, AnticiposConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_CODIGOCARGO, AnticiposConstantesFunciones.CODIGOCARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_NOMBREESTRUCTURA, AnticiposConstantesFunciones.NOMBREESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_CODIGODATO, AnticiposConstantesFunciones.CODIGODATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_NOMBRECOMPLETO, AnticiposConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_SUELDO, AnticiposConstantesFunciones.SUELDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_FECHA, AnticiposConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_VALOR, AnticiposConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_VALORADICIONAL, AnticiposConstantesFunciones.VALORADICIONAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_VALORPRESTAMO, AnticiposConstantesFunciones.VALORPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticiposConstantesFunciones.LABEL_TOTAL, AnticiposConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAnticipos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.CODIGOCARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.NOMBREESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.CODIGODATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.SUELDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.VALORADICIONAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.VALORPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticiposConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnticipos() throws Exception  {
		return AnticiposConstantesFunciones.getTiposSeleccionarAnticipos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnticipos(Boolean conFk) throws Exception  {
		return AnticiposConstantesFunciones.getTiposSeleccionarAnticipos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnticipos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_IDTIPOCONTRATO);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_IDTIPOCONTRATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_CODIGOCARGO);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_CODIGOCARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_NOMBREESTRUCTURA);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_NOMBREESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_CODIGODATO);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_CODIGODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_SUELDO);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_SUELDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_VALORADICIONAL);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_VALORADICIONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_VALORPRESTAMO);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_VALORPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticiposConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(AnticiposConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAnticipos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAnticipos(Anticipos anticiposAux) throws Exception {
		
			anticiposAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(anticiposAux.getEmpresa()));
			anticiposAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(anticiposAux.getTipoContrato()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAnticipos(List<Anticipos> anticipossTemp) throws Exception {
		for(Anticipos anticiposAux:anticipossTemp) {
			
			anticiposAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(anticiposAux.getEmpresa()));
			anticiposAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(anticiposAux.getTipoContrato()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAnticipos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoContrato.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoContrato.class)) {
						classes.add(new Classe(TipoContrato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAnticipos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnticipos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AnticiposConstantesFunciones.getClassesRelationshipsOfAnticipos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnticipos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAnticipos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AnticiposConstantesFunciones.getClassesRelationshipsFromStringsOfAnticipos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAnticipos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Anticipos anticipos,List<Anticipos> anticiposs,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(Anticipos anticipos,List<Anticipos> anticiposs) throws Exception {
		try	{			
			for(Anticipos anticiposLocal:anticiposs) {
				if(anticiposLocal.getId().equals(anticipos.getId())) {
					anticiposLocal.setIsSelected(anticipos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAnticipos(List<Anticipos> anticipossAux) throws Exception {
		//this.anticipossAux=anticipossAux;
		
		for(Anticipos anticiposAux:anticipossAux) {
			if(anticiposAux.getIsChanged()) {
				anticiposAux.setIsChanged(false);
			}		
			
			if(anticiposAux.getIsNew()) {
				anticiposAux.setIsNew(false);
			}	
			
			if(anticiposAux.getIsDeleted()) {
				anticiposAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAnticipos(Anticipos anticiposAux) throws Exception {
		//this.anticiposAux=anticiposAux;
		
			if(anticiposAux.getIsChanged()) {
				anticiposAux.setIsChanged(false);
			}		
			
			if(anticiposAux.getIsNew()) {
				anticiposAux.setIsNew(false);
			}	
			
			if(anticiposAux.getIsDeleted()) {
				anticiposAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Anticipos anticiposAsignar,Anticipos anticipos) throws Exception {
		anticiposAsignar.setId(anticipos.getId());	
		anticiposAsignar.setVersionRow(anticipos.getVersionRow());	
		anticiposAsignar.setcodigo_cargo(anticipos.getcodigo_cargo());	
		anticiposAsignar.setnombre_estructura(anticipos.getnombre_estructura());	
		anticiposAsignar.setcodigo_dato(anticipos.getcodigo_dato());	
		anticiposAsignar.setnombre_completo(anticipos.getnombre_completo());	
		anticiposAsignar.setsueldo(anticipos.getsueldo());	
		anticiposAsignar.setfecha(anticipos.getfecha());	
		anticiposAsignar.setvalor(anticipos.getvalor());	
		anticiposAsignar.setvalor_adicional(anticipos.getvalor_adicional());	
		anticiposAsignar.setvalor_prestamo(anticipos.getvalor_prestamo());	
		anticiposAsignar.settotal(anticipos.gettotal());	
	}
	
	public static void inicializarAnticipos(Anticipos anticipos) throws Exception {
		try {
				anticipos.setId(0L);	
					
				anticipos.setcodigo_cargo("");	
				anticipos.setnombre_estructura("");	
				anticipos.setcodigo_dato("");	
				anticipos.setnombre_completo("");	
				anticipos.setsueldo(0.0);	
				anticipos.setfecha(new Date());	
				anticipos.setvalor(0.0);	
				anticipos.setvalor_adicional(0.0);	
				anticipos.setvalor_prestamo(0.0);	
				anticipos.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAnticipos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_IDTIPOCONTRATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_CODIGOCARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_NOMBREESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_CODIGODATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_SUELDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_VALORADICIONAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_VALORPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticiposConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAnticipos(String sTipo,Row row,Workbook workbook,Anticipos anticipos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.gettipocontrato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getcodigo_cargo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getnombre_estructura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getcodigo_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getsueldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getvalor_adicional());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.getvalor_prestamo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAnticipos="";
	
	public String getsFinalQueryAnticipos() {
		return this.sFinalQueryAnticipos;
	}
	
	public void setsFinalQueryAnticipos(String sFinalQueryAnticipos) {
		this.sFinalQueryAnticipos= sFinalQueryAnticipos;
	}
	
	public Border resaltarSeleccionarAnticipos=null;
	
	public Border setResaltarSeleccionarAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAnticipos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAnticipos() {
		return this.resaltarSeleccionarAnticipos;
	}
	
	public void setResaltarSeleccionarAnticipos(Border borderResaltarSeleccionarAnticipos) {
		this.resaltarSeleccionarAnticipos= borderResaltarSeleccionarAnticipos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAnticipos=null;
	public Boolean mostraridAnticipos=true;
	public Boolean activaridAnticipos=true;

	public Border resaltarid_empresaAnticipos=null;
	public Boolean mostrarid_empresaAnticipos=true;
	public Boolean activarid_empresaAnticipos=true;
	public Boolean cargarid_empresaAnticipos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAnticipos=false;//ConEventDepend=true

	public Border resaltarid_tipo_contratoAnticipos=null;
	public Boolean mostrarid_tipo_contratoAnticipos=true;
	public Boolean activarid_tipo_contratoAnticipos=true;
	public Boolean cargarid_tipo_contratoAnticipos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_contratoAnticipos=false;//ConEventDepend=true

	public Border resaltarcodigoAnticipos=null;
	public Boolean mostrarcodigoAnticipos=true;
	public Boolean activarcodigoAnticipos=true;

	public Border resaltarfecha_desdeAnticipos=null;
	public Boolean mostrarfecha_desdeAnticipos=true;
	public Boolean activarfecha_desdeAnticipos=true;

	public Border resaltarfecha_hastaAnticipos=null;
	public Boolean mostrarfecha_hastaAnticipos=true;
	public Boolean activarfecha_hastaAnticipos=true;

	public Border resaltarcodigo_cargoAnticipos=null;
	public Boolean mostrarcodigo_cargoAnticipos=true;
	public Boolean activarcodigo_cargoAnticipos=true;

	public Border resaltarnombre_estructuraAnticipos=null;
	public Boolean mostrarnombre_estructuraAnticipos=true;
	public Boolean activarnombre_estructuraAnticipos=true;

	public Border resaltarcodigo_datoAnticipos=null;
	public Boolean mostrarcodigo_datoAnticipos=true;
	public Boolean activarcodigo_datoAnticipos=true;

	public Border resaltarnombre_completoAnticipos=null;
	public Boolean mostrarnombre_completoAnticipos=true;
	public Boolean activarnombre_completoAnticipos=true;

	public Border resaltarsueldoAnticipos=null;
	public Boolean mostrarsueldoAnticipos=true;
	public Boolean activarsueldoAnticipos=true;

	public Border resaltarfechaAnticipos=null;
	public Boolean mostrarfechaAnticipos=true;
	public Boolean activarfechaAnticipos=true;

	public Border resaltarvalorAnticipos=null;
	public Boolean mostrarvalorAnticipos=true;
	public Boolean activarvalorAnticipos=true;

	public Border resaltarvalor_adicionalAnticipos=null;
	public Boolean mostrarvalor_adicionalAnticipos=true;
	public Boolean activarvalor_adicionalAnticipos=true;

	public Border resaltarvalor_prestamoAnticipos=null;
	public Boolean mostrarvalor_prestamoAnticipos=true;
	public Boolean activarvalor_prestamoAnticipos=true;

	public Border resaltartotalAnticipos=null;
	public Boolean mostrartotalAnticipos=true;
	public Boolean activartotalAnticipos=true;

	
	

	public Border setResaltaridAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltaridAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAnticipos() {
		return this.resaltaridAnticipos;
	}

	public void setResaltaridAnticipos(Border borderResaltar) {
		this.resaltaridAnticipos= borderResaltar;
	}

	public Boolean getMostraridAnticipos() {
		return this.mostraridAnticipos;
	}

	public void setMostraridAnticipos(Boolean mostraridAnticipos) {
		this.mostraridAnticipos= mostraridAnticipos;
	}

	public Boolean getActivaridAnticipos() {
		return this.activaridAnticipos;
	}

	public void setActivaridAnticipos(Boolean activaridAnticipos) {
		this.activaridAnticipos= activaridAnticipos;
	}

	public Border setResaltarid_empresaAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarid_empresaAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAnticipos() {
		return this.resaltarid_empresaAnticipos;
	}

	public void setResaltarid_empresaAnticipos(Border borderResaltar) {
		this.resaltarid_empresaAnticipos= borderResaltar;
	}

	public Boolean getMostrarid_empresaAnticipos() {
		return this.mostrarid_empresaAnticipos;
	}

	public void setMostrarid_empresaAnticipos(Boolean mostrarid_empresaAnticipos) {
		this.mostrarid_empresaAnticipos= mostrarid_empresaAnticipos;
	}

	public Boolean getActivarid_empresaAnticipos() {
		return this.activarid_empresaAnticipos;
	}

	public void setActivarid_empresaAnticipos(Boolean activarid_empresaAnticipos) {
		this.activarid_empresaAnticipos= activarid_empresaAnticipos;
	}

	public Boolean getCargarid_empresaAnticipos() {
		return this.cargarid_empresaAnticipos;
	}

	public void setCargarid_empresaAnticipos(Boolean cargarid_empresaAnticipos) {
		this.cargarid_empresaAnticipos= cargarid_empresaAnticipos;
	}

	public Border setResaltarid_tipo_contratoAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarid_tipo_contratoAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_contratoAnticipos() {
		return this.resaltarid_tipo_contratoAnticipos;
	}

	public void setResaltarid_tipo_contratoAnticipos(Border borderResaltar) {
		this.resaltarid_tipo_contratoAnticipos= borderResaltar;
	}

	public Boolean getMostrarid_tipo_contratoAnticipos() {
		return this.mostrarid_tipo_contratoAnticipos;
	}

	public void setMostrarid_tipo_contratoAnticipos(Boolean mostrarid_tipo_contratoAnticipos) {
		this.mostrarid_tipo_contratoAnticipos= mostrarid_tipo_contratoAnticipos;
	}

	public Boolean getActivarid_tipo_contratoAnticipos() {
		return this.activarid_tipo_contratoAnticipos;
	}

	public void setActivarid_tipo_contratoAnticipos(Boolean activarid_tipo_contratoAnticipos) {
		this.activarid_tipo_contratoAnticipos= activarid_tipo_contratoAnticipos;
	}

	public Boolean getCargarid_tipo_contratoAnticipos() {
		return this.cargarid_tipo_contratoAnticipos;
	}

	public void setCargarid_tipo_contratoAnticipos(Boolean cargarid_tipo_contratoAnticipos) {
		this.cargarid_tipo_contratoAnticipos= cargarid_tipo_contratoAnticipos;
	}

	public Border setResaltarcodigoAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarcodigoAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoAnticipos() {
		return this.resaltarcodigoAnticipos;
	}

	public void setResaltarcodigoAnticipos(Border borderResaltar) {
		this.resaltarcodigoAnticipos= borderResaltar;
	}

	public Boolean getMostrarcodigoAnticipos() {
		return this.mostrarcodigoAnticipos;
	}

	public void setMostrarcodigoAnticipos(Boolean mostrarcodigoAnticipos) {
		this.mostrarcodigoAnticipos= mostrarcodigoAnticipos;
	}

	public Boolean getActivarcodigoAnticipos() {
		return this.activarcodigoAnticipos;
	}

	public void setActivarcodigoAnticipos(Boolean activarcodigoAnticipos) {
		this.activarcodigoAnticipos= activarcodigoAnticipos;
	}

	public Border setResaltarfecha_desdeAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeAnticipos() {
		return this.resaltarfecha_desdeAnticipos;
	}

	public void setResaltarfecha_desdeAnticipos(Border borderResaltar) {
		this.resaltarfecha_desdeAnticipos= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeAnticipos() {
		return this.mostrarfecha_desdeAnticipos;
	}

	public void setMostrarfecha_desdeAnticipos(Boolean mostrarfecha_desdeAnticipos) {
		this.mostrarfecha_desdeAnticipos= mostrarfecha_desdeAnticipos;
	}

	public Boolean getActivarfecha_desdeAnticipos() {
		return this.activarfecha_desdeAnticipos;
	}

	public void setActivarfecha_desdeAnticipos(Boolean activarfecha_desdeAnticipos) {
		this.activarfecha_desdeAnticipos= activarfecha_desdeAnticipos;
	}

	public Border setResaltarfecha_hastaAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaAnticipos() {
		return this.resaltarfecha_hastaAnticipos;
	}

	public void setResaltarfecha_hastaAnticipos(Border borderResaltar) {
		this.resaltarfecha_hastaAnticipos= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaAnticipos() {
		return this.mostrarfecha_hastaAnticipos;
	}

	public void setMostrarfecha_hastaAnticipos(Boolean mostrarfecha_hastaAnticipos) {
		this.mostrarfecha_hastaAnticipos= mostrarfecha_hastaAnticipos;
	}

	public Boolean getActivarfecha_hastaAnticipos() {
		return this.activarfecha_hastaAnticipos;
	}

	public void setActivarfecha_hastaAnticipos(Boolean activarfecha_hastaAnticipos) {
		this.activarfecha_hastaAnticipos= activarfecha_hastaAnticipos;
	}

	public Border setResaltarcodigo_cargoAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarcodigo_cargoAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cargoAnticipos() {
		return this.resaltarcodigo_cargoAnticipos;
	}

	public void setResaltarcodigo_cargoAnticipos(Border borderResaltar) {
		this.resaltarcodigo_cargoAnticipos= borderResaltar;
	}

	public Boolean getMostrarcodigo_cargoAnticipos() {
		return this.mostrarcodigo_cargoAnticipos;
	}

	public void setMostrarcodigo_cargoAnticipos(Boolean mostrarcodigo_cargoAnticipos) {
		this.mostrarcodigo_cargoAnticipos= mostrarcodigo_cargoAnticipos;
	}

	public Boolean getActivarcodigo_cargoAnticipos() {
		return this.activarcodigo_cargoAnticipos;
	}

	public void setActivarcodigo_cargoAnticipos(Boolean activarcodigo_cargoAnticipos) {
		this.activarcodigo_cargoAnticipos= activarcodigo_cargoAnticipos;
	}

	public Border setResaltarnombre_estructuraAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarnombre_estructuraAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_estructuraAnticipos() {
		return this.resaltarnombre_estructuraAnticipos;
	}

	public void setResaltarnombre_estructuraAnticipos(Border borderResaltar) {
		this.resaltarnombre_estructuraAnticipos= borderResaltar;
	}

	public Boolean getMostrarnombre_estructuraAnticipos() {
		return this.mostrarnombre_estructuraAnticipos;
	}

	public void setMostrarnombre_estructuraAnticipos(Boolean mostrarnombre_estructuraAnticipos) {
		this.mostrarnombre_estructuraAnticipos= mostrarnombre_estructuraAnticipos;
	}

	public Boolean getActivarnombre_estructuraAnticipos() {
		return this.activarnombre_estructuraAnticipos;
	}

	public void setActivarnombre_estructuraAnticipos(Boolean activarnombre_estructuraAnticipos) {
		this.activarnombre_estructuraAnticipos= activarnombre_estructuraAnticipos;
	}

	public Border setResaltarcodigo_datoAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarcodigo_datoAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_datoAnticipos() {
		return this.resaltarcodigo_datoAnticipos;
	}

	public void setResaltarcodigo_datoAnticipos(Border borderResaltar) {
		this.resaltarcodigo_datoAnticipos= borderResaltar;
	}

	public Boolean getMostrarcodigo_datoAnticipos() {
		return this.mostrarcodigo_datoAnticipos;
	}

	public void setMostrarcodigo_datoAnticipos(Boolean mostrarcodigo_datoAnticipos) {
		this.mostrarcodigo_datoAnticipos= mostrarcodigo_datoAnticipos;
	}

	public Boolean getActivarcodigo_datoAnticipos() {
		return this.activarcodigo_datoAnticipos;
	}

	public void setActivarcodigo_datoAnticipos(Boolean activarcodigo_datoAnticipos) {
		this.activarcodigo_datoAnticipos= activarcodigo_datoAnticipos;
	}

	public Border setResaltarnombre_completoAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoAnticipos() {
		return this.resaltarnombre_completoAnticipos;
	}

	public void setResaltarnombre_completoAnticipos(Border borderResaltar) {
		this.resaltarnombre_completoAnticipos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoAnticipos() {
		return this.mostrarnombre_completoAnticipos;
	}

	public void setMostrarnombre_completoAnticipos(Boolean mostrarnombre_completoAnticipos) {
		this.mostrarnombre_completoAnticipos= mostrarnombre_completoAnticipos;
	}

	public Boolean getActivarnombre_completoAnticipos() {
		return this.activarnombre_completoAnticipos;
	}

	public void setActivarnombre_completoAnticipos(Boolean activarnombre_completoAnticipos) {
		this.activarnombre_completoAnticipos= activarnombre_completoAnticipos;
	}

	public Border setResaltarsueldoAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarsueldoAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsueldoAnticipos() {
		return this.resaltarsueldoAnticipos;
	}

	public void setResaltarsueldoAnticipos(Border borderResaltar) {
		this.resaltarsueldoAnticipos= borderResaltar;
	}

	public Boolean getMostrarsueldoAnticipos() {
		return this.mostrarsueldoAnticipos;
	}

	public void setMostrarsueldoAnticipos(Boolean mostrarsueldoAnticipos) {
		this.mostrarsueldoAnticipos= mostrarsueldoAnticipos;
	}

	public Boolean getActivarsueldoAnticipos() {
		return this.activarsueldoAnticipos;
	}

	public void setActivarsueldoAnticipos(Boolean activarsueldoAnticipos) {
		this.activarsueldoAnticipos= activarsueldoAnticipos;
	}

	public Border setResaltarfechaAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarfechaAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAnticipos() {
		return this.resaltarfechaAnticipos;
	}

	public void setResaltarfechaAnticipos(Border borderResaltar) {
		this.resaltarfechaAnticipos= borderResaltar;
	}

	public Boolean getMostrarfechaAnticipos() {
		return this.mostrarfechaAnticipos;
	}

	public void setMostrarfechaAnticipos(Boolean mostrarfechaAnticipos) {
		this.mostrarfechaAnticipos= mostrarfechaAnticipos;
	}

	public Boolean getActivarfechaAnticipos() {
		return this.activarfechaAnticipos;
	}

	public void setActivarfechaAnticipos(Boolean activarfechaAnticipos) {
		this.activarfechaAnticipos= activarfechaAnticipos;
	}

	public Border setResaltarvalorAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarvalorAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorAnticipos() {
		return this.resaltarvalorAnticipos;
	}

	public void setResaltarvalorAnticipos(Border borderResaltar) {
		this.resaltarvalorAnticipos= borderResaltar;
	}

	public Boolean getMostrarvalorAnticipos() {
		return this.mostrarvalorAnticipos;
	}

	public void setMostrarvalorAnticipos(Boolean mostrarvalorAnticipos) {
		this.mostrarvalorAnticipos= mostrarvalorAnticipos;
	}

	public Boolean getActivarvalorAnticipos() {
		return this.activarvalorAnticipos;
	}

	public void setActivarvalorAnticipos(Boolean activarvalorAnticipos) {
		this.activarvalorAnticipos= activarvalorAnticipos;
	}

	public Border setResaltarvalor_adicionalAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarvalor_adicionalAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_adicionalAnticipos() {
		return this.resaltarvalor_adicionalAnticipos;
	}

	public void setResaltarvalor_adicionalAnticipos(Border borderResaltar) {
		this.resaltarvalor_adicionalAnticipos= borderResaltar;
	}

	public Boolean getMostrarvalor_adicionalAnticipos() {
		return this.mostrarvalor_adicionalAnticipos;
	}

	public void setMostrarvalor_adicionalAnticipos(Boolean mostrarvalor_adicionalAnticipos) {
		this.mostrarvalor_adicionalAnticipos= mostrarvalor_adicionalAnticipos;
	}

	public Boolean getActivarvalor_adicionalAnticipos() {
		return this.activarvalor_adicionalAnticipos;
	}

	public void setActivarvalor_adicionalAnticipos(Boolean activarvalor_adicionalAnticipos) {
		this.activarvalor_adicionalAnticipos= activarvalor_adicionalAnticipos;
	}

	public Border setResaltarvalor_prestamoAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltarvalor_prestamoAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_prestamoAnticipos() {
		return this.resaltarvalor_prestamoAnticipos;
	}

	public void setResaltarvalor_prestamoAnticipos(Border borderResaltar) {
		this.resaltarvalor_prestamoAnticipos= borderResaltar;
	}

	public Boolean getMostrarvalor_prestamoAnticipos() {
		return this.mostrarvalor_prestamoAnticipos;
	}

	public void setMostrarvalor_prestamoAnticipos(Boolean mostrarvalor_prestamoAnticipos) {
		this.mostrarvalor_prestamoAnticipos= mostrarvalor_prestamoAnticipos;
	}

	public Boolean getActivarvalor_prestamoAnticipos() {
		return this.activarvalor_prestamoAnticipos;
	}

	public void setActivarvalor_prestamoAnticipos(Boolean activarvalor_prestamoAnticipos) {
		this.activarvalor_prestamoAnticipos= activarvalor_prestamoAnticipos;
	}

	public Border setResaltartotalAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticiposBeanSwingJInternalFrame.jTtoolBarAnticipos.setBorder(borderResaltar);
		
		this.resaltartotalAnticipos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalAnticipos() {
		return this.resaltartotalAnticipos;
	}

	public void setResaltartotalAnticipos(Border borderResaltar) {
		this.resaltartotalAnticipos= borderResaltar;
	}

	public Boolean getMostrartotalAnticipos() {
		return this.mostrartotalAnticipos;
	}

	public void setMostrartotalAnticipos(Boolean mostrartotalAnticipos) {
		this.mostrartotalAnticipos= mostrartotalAnticipos;
	}

	public Boolean getActivartotalAnticipos() {
		return this.activartotalAnticipos;
	}

	public void setActivartotalAnticipos(Boolean activartotalAnticipos) {
		this.activartotalAnticipos= activartotalAnticipos;
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
		
		
		this.setMostraridAnticipos(esInicial);
		this.setMostrarid_empresaAnticipos(esInicial);
		this.setMostrarid_tipo_contratoAnticipos(esInicial);
		this.setMostrarcodigoAnticipos(esInicial);
		this.setMostrarfecha_desdeAnticipos(esInicial);
		this.setMostrarfecha_hastaAnticipos(esInicial);
		this.setMostrarcodigo_cargoAnticipos(esInicial);
		this.setMostrarnombre_estructuraAnticipos(esInicial);
		this.setMostrarcodigo_datoAnticipos(esInicial);
		this.setMostrarnombre_completoAnticipos(esInicial);
		this.setMostrarsueldoAnticipos(esInicial);
		this.setMostrarfechaAnticipos(esInicial);
		this.setMostrarvalorAnticipos(esInicial);
		this.setMostrarvalor_adicionalAnticipos(esInicial);
		this.setMostrarvalor_prestamoAnticipos(esInicial);
		this.setMostrartotalAnticipos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnticiposConstantesFunciones.ID)) {
				this.setMostraridAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.IDTIPOCONTRATO)) {
				this.setMostrarid_tipo_contratoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.CODIGOCARGO)) {
				this.setMostrarcodigo_cargoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.NOMBREESTRUCTURA)) {
				this.setMostrarnombre_estructuraAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.CODIGODATO)) {
				this.setMostrarcodigo_datoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.SUELDO)) {
				this.setMostrarsueldoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.FECHA)) {
				this.setMostrarfechaAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.VALOR)) {
				this.setMostrarvalorAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.VALORADICIONAL)) {
				this.setMostrarvalor_adicionalAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.VALORPRESTAMO)) {
				this.setMostrarvalor_prestamoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.TOTAL)) {
				this.setMostrartotalAnticipos(esAsigna);
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
		
		
		this.setActivaridAnticipos(esInicial);
		this.setActivarid_empresaAnticipos(esInicial);
		this.setActivarid_tipo_contratoAnticipos(esInicial);
		this.setActivarcodigoAnticipos(esInicial);
		this.setActivarfecha_desdeAnticipos(esInicial);
		this.setActivarfecha_hastaAnticipos(esInicial);
		this.setActivarcodigo_cargoAnticipos(esInicial);
		this.setActivarnombre_estructuraAnticipos(esInicial);
		this.setActivarcodigo_datoAnticipos(esInicial);
		this.setActivarnombre_completoAnticipos(esInicial);
		this.setActivarsueldoAnticipos(esInicial);
		this.setActivarfechaAnticipos(esInicial);
		this.setActivarvalorAnticipos(esInicial);
		this.setActivarvalor_adicionalAnticipos(esInicial);
		this.setActivarvalor_prestamoAnticipos(esInicial);
		this.setActivartotalAnticipos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnticiposConstantesFunciones.ID)) {
				this.setActivaridAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.IDTIPOCONTRATO)) {
				this.setActivarid_tipo_contratoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.CODIGO)) {
				this.setActivarcodigoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.CODIGOCARGO)) {
				this.setActivarcodigo_cargoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.NOMBREESTRUCTURA)) {
				this.setActivarnombre_estructuraAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.CODIGODATO)) {
				this.setActivarcodigo_datoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.SUELDO)) {
				this.setActivarsueldoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.FECHA)) {
				this.setActivarfechaAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.VALOR)) {
				this.setActivarvalorAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.VALORADICIONAL)) {
				this.setActivarvalor_adicionalAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.VALORPRESTAMO)) {
				this.setActivarvalor_prestamoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.TOTAL)) {
				this.setActivartotalAnticipos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAnticipos(esInicial);
		this.setResaltarid_empresaAnticipos(esInicial);
		this.setResaltarid_tipo_contratoAnticipos(esInicial);
		this.setResaltarcodigoAnticipos(esInicial);
		this.setResaltarfecha_desdeAnticipos(esInicial);
		this.setResaltarfecha_hastaAnticipos(esInicial);
		this.setResaltarcodigo_cargoAnticipos(esInicial);
		this.setResaltarnombre_estructuraAnticipos(esInicial);
		this.setResaltarcodigo_datoAnticipos(esInicial);
		this.setResaltarnombre_completoAnticipos(esInicial);
		this.setResaltarsueldoAnticipos(esInicial);
		this.setResaltarfechaAnticipos(esInicial);
		this.setResaltarvalorAnticipos(esInicial);
		this.setResaltarvalor_adicionalAnticipos(esInicial);
		this.setResaltarvalor_prestamoAnticipos(esInicial);
		this.setResaltartotalAnticipos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnticiposConstantesFunciones.ID)) {
				this.setResaltaridAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.IDTIPOCONTRATO)) {
				this.setResaltarid_tipo_contratoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.CODIGOCARGO)) {
				this.setResaltarcodigo_cargoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.NOMBREESTRUCTURA)) {
				this.setResaltarnombre_estructuraAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.CODIGODATO)) {
				this.setResaltarcodigo_datoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.SUELDO)) {
				this.setResaltarsueldoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.FECHA)) {
				this.setResaltarfechaAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.VALOR)) {
				this.setResaltarvalorAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.VALORADICIONAL)) {
				this.setResaltarvalor_adicionalAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.VALORPRESTAMO)) {
				this.setResaltarvalor_prestamoAnticipos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticiposConstantesFunciones.TOTAL)) {
				this.setResaltartotalAnticipos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaAnticiposAnticipos=true;

	public Boolean getMostrarBusquedaAnticiposAnticipos() {
		return this.mostrarBusquedaAnticiposAnticipos;
	}

	public void setMostrarBusquedaAnticiposAnticipos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaAnticiposAnticipos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaAnticiposAnticipos=true;

	public Boolean getActivarBusquedaAnticiposAnticipos() {
		return this.activarBusquedaAnticiposAnticipos;
	}

	public void setActivarBusquedaAnticiposAnticipos(Boolean habilitarResaltar) {
		this.activarBusquedaAnticiposAnticipos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaAnticiposAnticipos=null;

	public Border getResaltarBusquedaAnticiposAnticipos() {
		return this.resaltarBusquedaAnticiposAnticipos;
	}

	public void setResaltarBusquedaAnticiposAnticipos(Border borderResaltar) {
		this.resaltarBusquedaAnticiposAnticipos= borderResaltar;
	}

	public void setResaltarBusquedaAnticiposAnticipos(ParametroGeneralUsuario parametroGeneralUsuario/*AnticiposBeanSwingJInternalFrame anticiposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaAnticiposAnticipos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}