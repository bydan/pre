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


import com.bydan.erp.nomina.util.report.IngresosPromediosConstantesFunciones;
import com.bydan.erp.nomina.util.report.IngresosPromediosParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.IngresosPromediosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class IngresosPromediosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="IngresosPromedios";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="IngresosPromedios"+IngresosPromediosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="IngresosPromediosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="IngresosPromediosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=IngresosPromediosConstantesFunciones.SCHEMA+"_"+IngresosPromediosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/IngresosPromediosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=IngresosPromediosConstantesFunciones.SCHEMA+"_"+IngresosPromediosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=IngresosPromediosConstantesFunciones.SCHEMA+"_"+IngresosPromediosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/IngresosPromediosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=IngresosPromediosConstantesFunciones.SCHEMA+"_"+IngresosPromediosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngresosPromediosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IngresosPromediosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngresosPromediosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngresosPromediosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IngresosPromediosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngresosPromediosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=IngresosPromediosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+IngresosPromediosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=IngresosPromediosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+IngresosPromediosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ingresos Promedioses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ingresos Promedios";
	public static final String SCLASSWEBTITULO_LOWER="Ingresos Promedios";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="IngresosPromedios";
	public static final String OBJECTNAME="ingresospromedios";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="ingresos_promedios";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ingresospromedios from "+IngresosPromediosConstantesFunciones.SPERSISTENCENAME+" ingresospromedios";
	public static String QUERYSELECTNATIVE="select "+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".id,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".version_row,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".id_estructura,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".codigo,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".id_empresa,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".id_anio,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".id_mes,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".codigo_cargo,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".codigo_dato,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".nombre,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".valor_pago,"+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME+".nombre_rubro_emplea from "+IngresosPromediosConstantesFunciones.SCHEMA+"."+IngresosPromediosConstantesFunciones.TABLENAME;//+" as "+IngresosPromediosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String CODIGO= "codigo";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String CODIGOCARGO= "codigo_cargo";
    public static final String CODIGODATO= "codigo_dato";
    public static final String NOMBRE= "nombre";
    public static final String VALORPAGO= "valor_pago";
    public static final String NOMBRERUBROEMPLEA= "nombre_rubro_emplea";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_CODIGOCARGO= "Codigo Cargo";
		public static final String LABEL_CODIGOCARGO_LOWER= "Codigo Cargo";
    	public static final String LABEL_CODIGODATO= "Codigo Dato";
		public static final String LABEL_CODIGODATO_LOWER= "Codigo Dato";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_VALORPAGO= "Valor Pago";
		public static final String LABEL_VALORPAGO_LOWER= "Valor Pago";
    	public static final String LABEL_NOMBRERUBROEMPLEA= "Nombre Rubro Emplea";
		public static final String LABEL_NOMBRERUBROEMPLEA_LOWER= "Nombre Rubro Emplea";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXCODIGO_CARGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CARGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_RUBRO_EMPLEA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_RUBRO_EMPLEA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getIngresosPromediosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.CODIGO)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.IDEMPRESA)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.IDANIO)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.IDMES)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.CODIGOCARGO)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_CODIGOCARGO;}
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.CODIGODATO)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_CODIGODATO;}
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.NOMBRE)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.VALORPAGO)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_VALORPAGO;}
		if(sNombreColumna.equals(IngresosPromediosConstantesFunciones.NOMBRERUBROEMPLEA)) {sLabelColumna=IngresosPromediosConstantesFunciones.LABEL_NOMBRERUBROEMPLEA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getIngresosPromediosDescripcion(IngresosPromedios ingresospromedios) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ingresospromedios !=null/* && ingresospromedios.getId()!=0*/) {
			sDescripcion=ingresospromedios.getcodigo();//ingresospromediosingresospromedios.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getIngresosPromediosDescripcionDetallado(IngresosPromedios ingresospromedios) {
		String sDescripcion="";
			
		sDescripcion+=IngresosPromediosConstantesFunciones.ID+"=";
		sDescripcion+=ingresospromedios.getId().toString()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ingresospromedios.getVersionRow().toString()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=ingresospromedios.getid_estructura().toString()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.CODIGO+"=";
		sDescripcion+=ingresospromedios.getcodigo()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ingresospromedios.getid_empresa().toString()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.IDANIO+"=";
		sDescripcion+=ingresospromedios.getid_anio().toString()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.IDMES+"=";
		sDescripcion+=ingresospromedios.getid_mes().toString()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.CODIGOCARGO+"=";
		sDescripcion+=ingresospromedios.getcodigo_cargo()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.CODIGODATO+"=";
		sDescripcion+=ingresospromedios.getcodigo_dato()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=ingresospromedios.getnombre()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.VALORPAGO+"=";
		sDescripcion+=ingresospromedios.getvalor_pago().toString()+",";
		sDescripcion+=IngresosPromediosConstantesFunciones.NOMBRERUBROEMPLEA+"=";
		sDescripcion+=ingresospromedios.getnombre_rubro_emplea()+",";
			
		return sDescripcion;
	}
	
	public static void setIngresosPromediosDescripcion(IngresosPromedios ingresospromedios,String sValor) throws Exception {			
		if(ingresospromedios !=null) {
			ingresospromedios.setcodigo(sValor);;//ingresospromediosingresospromedios.getcodigo().trim();
		}		
	}
	
		

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaIngresosPromedios")) {
			sNombreIndice="Tipo=  Por Estructura Por Codigo Por Anio Por Mes";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaIngresosPromedios(Long id_estructura,String codigo,Long id_anio,Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;}
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosIngresosPromedios(IngresosPromedios ingresospromedios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ingresospromedios.setcodigo_cargo(ingresospromedios.getcodigo_cargo().trim());
		ingresospromedios.setcodigo_dato(ingresospromedios.getcodigo_dato().trim());
		ingresospromedios.setnombre(ingresospromedios.getnombre().trim());
		ingresospromedios.setnombre_rubro_emplea(ingresospromedios.getnombre_rubro_emplea().trim());
	}
	
	public static void quitarEspaciosIngresosPromedioss(List<IngresosPromedios> ingresospromedioss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(IngresosPromedios ingresospromedios: ingresospromedioss) {
			ingresospromedios.setcodigo_cargo(ingresospromedios.getcodigo_cargo().trim());
			ingresospromedios.setcodigo_dato(ingresospromedios.getcodigo_dato().trim());
			ingresospromedios.setnombre(ingresospromedios.getnombre().trim());
			ingresospromedios.setnombre_rubro_emplea(ingresospromedios.getnombre_rubro_emplea().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIngresosPromedios(IngresosPromedios ingresospromedios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ingresospromedios.getConCambioAuxiliar()) {
			ingresospromedios.setIsDeleted(ingresospromedios.getIsDeletedAuxiliar());	
			ingresospromedios.setIsNew(ingresospromedios.getIsNewAuxiliar());	
			ingresospromedios.setIsChanged(ingresospromedios.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ingresospromedios.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ingresospromedios.setIsDeletedAuxiliar(false);	
			ingresospromedios.setIsNewAuxiliar(false);	
			ingresospromedios.setIsChangedAuxiliar(false);
			
			ingresospromedios.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIngresosPromedioss(List<IngresosPromedios> ingresospromedioss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(IngresosPromedios ingresospromedios : ingresospromedioss) {
			if(conAsignarBase && ingresospromedios.getConCambioAuxiliar()) {
				ingresospromedios.setIsDeleted(ingresospromedios.getIsDeletedAuxiliar());	
				ingresospromedios.setIsNew(ingresospromedios.getIsNewAuxiliar());	
				ingresospromedios.setIsChanged(ingresospromedios.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ingresospromedios.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ingresospromedios.setIsDeletedAuxiliar(false);	
				ingresospromedios.setIsNewAuxiliar(false);	
				ingresospromedios.setIsChangedAuxiliar(false);
				
				ingresospromedios.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresIngresosPromedios(IngresosPromedios ingresospromedios,Boolean conEnteros) throws Exception  {
		ingresospromedios.setvalor_pago(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresIngresosPromedioss(List<IngresosPromedios> ingresospromedioss,Boolean conEnteros) throws Exception  {
		
		for(IngresosPromedios ingresospromedios: ingresospromedioss) {
			ingresospromedios.setvalor_pago(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaIngresosPromedios(List<IngresosPromedios> ingresospromedioss,IngresosPromedios ingresospromediosAux) throws Exception  {
		IngresosPromediosConstantesFunciones.InicializarValoresIngresosPromedios(ingresospromediosAux,true);
		
		for(IngresosPromedios ingresospromedios: ingresospromedioss) {
			if(ingresospromedios.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ingresospromediosAux.setvalor_pago(ingresospromediosAux.getvalor_pago()+ingresospromedios.getvalor_pago());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesIngresosPromedios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=IngresosPromediosConstantesFunciones.getArrayColumnasGlobalesIngresosPromedios(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesIngresosPromedios(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(IngresosPromediosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(IngresosPromediosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoIngresosPromedios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<IngresosPromedios> ingresospromedioss,IngresosPromedios ingresospromedios,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(IngresosPromedios ingresospromediosAux: ingresospromedioss) {
			if(ingresospromediosAux!=null && ingresospromedios!=null) {
				if((ingresospromediosAux.getId()==null && ingresospromedios.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ingresospromediosAux.getId()!=null && ingresospromedios.getId()!=null){
					if(ingresospromediosAux.getId().equals(ingresospromedios.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaIngresosPromedios(List<IngresosPromedios> ingresospromedioss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_pagoTotal=0.0;
	
		for(IngresosPromedios ingresospromedios: ingresospromedioss) {			
			if(ingresospromedios.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_pagoTotal+=ingresospromedios.getvalor_pago();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(IngresosPromediosConstantesFunciones.VALORPAGO);
		datoGeneral.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_VALORPAGO);
		datoGeneral.setdValorDouble(valor_pagoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaIngresosPromedios() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,IngresosPromediosConstantesFunciones.LABEL_ID, IngresosPromediosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosPromediosConstantesFunciones.LABEL_VERSIONROW, IngresosPromediosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosPromediosConstantesFunciones.LABEL_CODIGOCARGO, IngresosPromediosConstantesFunciones.CODIGOCARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosPromediosConstantesFunciones.LABEL_CODIGODATO, IngresosPromediosConstantesFunciones.CODIGODATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosPromediosConstantesFunciones.LABEL_NOMBRE, IngresosPromediosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosPromediosConstantesFunciones.LABEL_VALORPAGO, IngresosPromediosConstantesFunciones.VALORPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosPromediosConstantesFunciones.LABEL_NOMBRERUBROEMPLEA, IngresosPromediosConstantesFunciones.NOMBRERUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasIngresosPromedios() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=IngresosPromediosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosPromediosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosPromediosConstantesFunciones.CODIGOCARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosPromediosConstantesFunciones.CODIGODATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosPromediosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosPromediosConstantesFunciones.VALORPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosPromediosConstantesFunciones.NOMBRERUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIngresosPromedios() throws Exception  {
		return IngresosPromediosConstantesFunciones.getTiposSeleccionarIngresosPromedios(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIngresosPromedios(Boolean conFk) throws Exception  {
		return IngresosPromediosConstantesFunciones.getTiposSeleccionarIngresosPromedios(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIngresosPromedios(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_CODIGOCARGO);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_CODIGOCARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_CODIGODATO);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_CODIGODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_VALORPAGO);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_VALORPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosPromediosConstantesFunciones.LABEL_NOMBRERUBROEMPLEA);
			reporte.setsDescripcion(IngresosPromediosConstantesFunciones.LABEL_NOMBRERUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesIngresosPromedios(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesIngresosPromedios(IngresosPromedios ingresospromediosAux) throws Exception {
		
			ingresospromediosAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(ingresospromediosAux.getEstructura()));
			ingresospromediosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ingresospromediosAux.getEmpresa()));
			ingresospromediosAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(ingresospromediosAux.getAnio()));
			ingresospromediosAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(ingresospromediosAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesIngresosPromedios(List<IngresosPromedios> ingresospromediossTemp) throws Exception {
		for(IngresosPromedios ingresospromediosAux:ingresospromediossTemp) {
			
			ingresospromediosAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(ingresospromediosAux.getEstructura()));
			ingresospromediosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ingresospromediosAux.getEmpresa()));
			ingresospromediosAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(ingresospromediosAux.getAnio()));
			ingresospromediosAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(ingresospromediosAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfIngresosPromedios(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfIngresosPromedios(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfIngresosPromedios(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return IngresosPromediosConstantesFunciones.getClassesRelationshipsOfIngresosPromedios(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfIngresosPromedios(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIngresosPromedios(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return IngresosPromediosConstantesFunciones.getClassesRelationshipsFromStringsOfIngresosPromedios(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIngresosPromedios(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(IngresosPromedios ingresospromedios,List<IngresosPromedios> ingresospromedioss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(IngresosPromedios ingresospromedios,List<IngresosPromedios> ingresospromedioss) throws Exception {
		try	{			
			for(IngresosPromedios ingresospromediosLocal:ingresospromedioss) {
				if(ingresospromediosLocal.getId().equals(ingresospromedios.getId())) {
					ingresospromediosLocal.setIsSelected(ingresospromedios.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesIngresosPromedios(List<IngresosPromedios> ingresospromediossAux) throws Exception {
		//this.ingresospromediossAux=ingresospromediossAux;
		
		for(IngresosPromedios ingresospromediosAux:ingresospromediossAux) {
			if(ingresospromediosAux.getIsChanged()) {
				ingresospromediosAux.setIsChanged(false);
			}		
			
			if(ingresospromediosAux.getIsNew()) {
				ingresospromediosAux.setIsNew(false);
			}	
			
			if(ingresospromediosAux.getIsDeleted()) {
				ingresospromediosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesIngresosPromedios(IngresosPromedios ingresospromediosAux) throws Exception {
		//this.ingresospromediosAux=ingresospromediosAux;
		
			if(ingresospromediosAux.getIsChanged()) {
				ingresospromediosAux.setIsChanged(false);
			}		
			
			if(ingresospromediosAux.getIsNew()) {
				ingresospromediosAux.setIsNew(false);
			}	
			
			if(ingresospromediosAux.getIsDeleted()) {
				ingresospromediosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(IngresosPromedios ingresospromediosAsignar,IngresosPromedios ingresospromedios) throws Exception {
		ingresospromediosAsignar.setId(ingresospromedios.getId());	
		ingresospromediosAsignar.setVersionRow(ingresospromedios.getVersionRow());	
		ingresospromediosAsignar.setcodigo_cargo(ingresospromedios.getcodigo_cargo());	
		ingresospromediosAsignar.setcodigo_dato(ingresospromedios.getcodigo_dato());	
		ingresospromediosAsignar.setnombre(ingresospromedios.getnombre());	
		ingresospromediosAsignar.setvalor_pago(ingresospromedios.getvalor_pago());	
		ingresospromediosAsignar.setnombre_rubro_emplea(ingresospromedios.getnombre_rubro_emplea());	
	}
	
	public static void inicializarIngresosPromedios(IngresosPromedios ingresospromedios) throws Exception {
		try {
				ingresospromedios.setId(0L);	
					
				ingresospromedios.setcodigo_cargo("");	
				ingresospromedios.setcodigo_dato("");	
				ingresospromedios.setnombre("");	
				ingresospromedios.setvalor_pago(0.0);	
				ingresospromedios.setnombre_rubro_emplea("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderIngresosPromedios(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_CODIGOCARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_CODIGODATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_VALORPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosPromediosConstantesFunciones.LABEL_NOMBRERUBROEMPLEA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataIngresosPromedios(String sTipo,Row row,Workbook workbook,IngresosPromedios ingresospromedios,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getcodigo_cargo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getcodigo_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getvalor_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresospromedios.getnombre_rubro_emplea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryIngresosPromedios="";
	
	public String getsFinalQueryIngresosPromedios() {
		return this.sFinalQueryIngresosPromedios;
	}
	
	public void setsFinalQueryIngresosPromedios(String sFinalQueryIngresosPromedios) {
		this.sFinalQueryIngresosPromedios= sFinalQueryIngresosPromedios;
	}
	
	public Border resaltarSeleccionarIngresosPromedios=null;
	
	public Border setResaltarSeleccionarIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarSeleccionarIngresosPromedios= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarIngresosPromedios() {
		return this.resaltarSeleccionarIngresosPromedios;
	}
	
	public void setResaltarSeleccionarIngresosPromedios(Border borderResaltarSeleccionarIngresosPromedios) {
		this.resaltarSeleccionarIngresosPromedios= borderResaltarSeleccionarIngresosPromedios;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridIngresosPromedios=null;
	public Boolean mostraridIngresosPromedios=true;
	public Boolean activaridIngresosPromedios=true;

	public Border resaltarid_estructuraIngresosPromedios=null;
	public Boolean mostrarid_estructuraIngresosPromedios=true;
	public Boolean activarid_estructuraIngresosPromedios=true;
	public Boolean cargarid_estructuraIngresosPromedios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraIngresosPromedios=false;//ConEventDepend=true

	public Border resaltarcodigoIngresosPromedios=null;
	public Boolean mostrarcodigoIngresosPromedios=true;
	public Boolean activarcodigoIngresosPromedios=true;

	public Border resaltarid_empresaIngresosPromedios=null;
	public Boolean mostrarid_empresaIngresosPromedios=true;
	public Boolean activarid_empresaIngresosPromedios=true;
	public Boolean cargarid_empresaIngresosPromedios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaIngresosPromedios=false;//ConEventDepend=true

	public Border resaltarid_anioIngresosPromedios=null;
	public Boolean mostrarid_anioIngresosPromedios=true;
	public Boolean activarid_anioIngresosPromedios=true;
	public Boolean cargarid_anioIngresosPromedios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioIngresosPromedios=false;//ConEventDepend=true

	public Border resaltarid_mesIngresosPromedios=null;
	public Boolean mostrarid_mesIngresosPromedios=true;
	public Boolean activarid_mesIngresosPromedios=true;
	public Boolean cargarid_mesIngresosPromedios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesIngresosPromedios=false;//ConEventDepend=true

	public Border resaltarcodigo_cargoIngresosPromedios=null;
	public Boolean mostrarcodigo_cargoIngresosPromedios=true;
	public Boolean activarcodigo_cargoIngresosPromedios=true;

	public Border resaltarcodigo_datoIngresosPromedios=null;
	public Boolean mostrarcodigo_datoIngresosPromedios=true;
	public Boolean activarcodigo_datoIngresosPromedios=true;

	public Border resaltarnombreIngresosPromedios=null;
	public Boolean mostrarnombreIngresosPromedios=true;
	public Boolean activarnombreIngresosPromedios=true;

	public Border resaltarvalor_pagoIngresosPromedios=null;
	public Boolean mostrarvalor_pagoIngresosPromedios=true;
	public Boolean activarvalor_pagoIngresosPromedios=true;

	public Border resaltarnombre_rubro_empleaIngresosPromedios=null;
	public Boolean mostrarnombre_rubro_empleaIngresosPromedios=true;
	public Boolean activarnombre_rubro_empleaIngresosPromedios=true;

	
	

	public Border setResaltaridIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltaridIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridIngresosPromedios() {
		return this.resaltaridIngresosPromedios;
	}

	public void setResaltaridIngresosPromedios(Border borderResaltar) {
		this.resaltaridIngresosPromedios= borderResaltar;
	}

	public Boolean getMostraridIngresosPromedios() {
		return this.mostraridIngresosPromedios;
	}

	public void setMostraridIngresosPromedios(Boolean mostraridIngresosPromedios) {
		this.mostraridIngresosPromedios= mostraridIngresosPromedios;
	}

	public Boolean getActivaridIngresosPromedios() {
		return this.activaridIngresosPromedios;
	}

	public void setActivaridIngresosPromedios(Boolean activaridIngresosPromedios) {
		this.activaridIngresosPromedios= activaridIngresosPromedios;
	}

	public Border setResaltarid_estructuraIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarid_estructuraIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraIngresosPromedios() {
		return this.resaltarid_estructuraIngresosPromedios;
	}

	public void setResaltarid_estructuraIngresosPromedios(Border borderResaltar) {
		this.resaltarid_estructuraIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarid_estructuraIngresosPromedios() {
		return this.mostrarid_estructuraIngresosPromedios;
	}

	public void setMostrarid_estructuraIngresosPromedios(Boolean mostrarid_estructuraIngresosPromedios) {
		this.mostrarid_estructuraIngresosPromedios= mostrarid_estructuraIngresosPromedios;
	}

	public Boolean getActivarid_estructuraIngresosPromedios() {
		return this.activarid_estructuraIngresosPromedios;
	}

	public void setActivarid_estructuraIngresosPromedios(Boolean activarid_estructuraIngresosPromedios) {
		this.activarid_estructuraIngresosPromedios= activarid_estructuraIngresosPromedios;
	}

	public Boolean getCargarid_estructuraIngresosPromedios() {
		return this.cargarid_estructuraIngresosPromedios;
	}

	public void setCargarid_estructuraIngresosPromedios(Boolean cargarid_estructuraIngresosPromedios) {
		this.cargarid_estructuraIngresosPromedios= cargarid_estructuraIngresosPromedios;
	}

	public Border setResaltarcodigoIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarcodigoIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoIngresosPromedios() {
		return this.resaltarcodigoIngresosPromedios;
	}

	public void setResaltarcodigoIngresosPromedios(Border borderResaltar) {
		this.resaltarcodigoIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarcodigoIngresosPromedios() {
		return this.mostrarcodigoIngresosPromedios;
	}

	public void setMostrarcodigoIngresosPromedios(Boolean mostrarcodigoIngresosPromedios) {
		this.mostrarcodigoIngresosPromedios= mostrarcodigoIngresosPromedios;
	}

	public Boolean getActivarcodigoIngresosPromedios() {
		return this.activarcodigoIngresosPromedios;
	}

	public void setActivarcodigoIngresosPromedios(Boolean activarcodigoIngresosPromedios) {
		this.activarcodigoIngresosPromedios= activarcodigoIngresosPromedios;
	}

	public Border setResaltarid_empresaIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarid_empresaIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaIngresosPromedios() {
		return this.resaltarid_empresaIngresosPromedios;
	}

	public void setResaltarid_empresaIngresosPromedios(Border borderResaltar) {
		this.resaltarid_empresaIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarid_empresaIngresosPromedios() {
		return this.mostrarid_empresaIngresosPromedios;
	}

	public void setMostrarid_empresaIngresosPromedios(Boolean mostrarid_empresaIngresosPromedios) {
		this.mostrarid_empresaIngresosPromedios= mostrarid_empresaIngresosPromedios;
	}

	public Boolean getActivarid_empresaIngresosPromedios() {
		return this.activarid_empresaIngresosPromedios;
	}

	public void setActivarid_empresaIngresosPromedios(Boolean activarid_empresaIngresosPromedios) {
		this.activarid_empresaIngresosPromedios= activarid_empresaIngresosPromedios;
	}

	public Boolean getCargarid_empresaIngresosPromedios() {
		return this.cargarid_empresaIngresosPromedios;
	}

	public void setCargarid_empresaIngresosPromedios(Boolean cargarid_empresaIngresosPromedios) {
		this.cargarid_empresaIngresosPromedios= cargarid_empresaIngresosPromedios;
	}

	public Border setResaltarid_anioIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarid_anioIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioIngresosPromedios() {
		return this.resaltarid_anioIngresosPromedios;
	}

	public void setResaltarid_anioIngresosPromedios(Border borderResaltar) {
		this.resaltarid_anioIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarid_anioIngresosPromedios() {
		return this.mostrarid_anioIngresosPromedios;
	}

	public void setMostrarid_anioIngresosPromedios(Boolean mostrarid_anioIngresosPromedios) {
		this.mostrarid_anioIngresosPromedios= mostrarid_anioIngresosPromedios;
	}

	public Boolean getActivarid_anioIngresosPromedios() {
		return this.activarid_anioIngresosPromedios;
	}

	public void setActivarid_anioIngresosPromedios(Boolean activarid_anioIngresosPromedios) {
		this.activarid_anioIngresosPromedios= activarid_anioIngresosPromedios;
	}

	public Boolean getCargarid_anioIngresosPromedios() {
		return this.cargarid_anioIngresosPromedios;
	}

	public void setCargarid_anioIngresosPromedios(Boolean cargarid_anioIngresosPromedios) {
		this.cargarid_anioIngresosPromedios= cargarid_anioIngresosPromedios;
	}

	public Border setResaltarid_mesIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarid_mesIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesIngresosPromedios() {
		return this.resaltarid_mesIngresosPromedios;
	}

	public void setResaltarid_mesIngresosPromedios(Border borderResaltar) {
		this.resaltarid_mesIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarid_mesIngresosPromedios() {
		return this.mostrarid_mesIngresosPromedios;
	}

	public void setMostrarid_mesIngresosPromedios(Boolean mostrarid_mesIngresosPromedios) {
		this.mostrarid_mesIngresosPromedios= mostrarid_mesIngresosPromedios;
	}

	public Boolean getActivarid_mesIngresosPromedios() {
		return this.activarid_mesIngresosPromedios;
	}

	public void setActivarid_mesIngresosPromedios(Boolean activarid_mesIngresosPromedios) {
		this.activarid_mesIngresosPromedios= activarid_mesIngresosPromedios;
	}

	public Boolean getCargarid_mesIngresosPromedios() {
		return this.cargarid_mesIngresosPromedios;
	}

	public void setCargarid_mesIngresosPromedios(Boolean cargarid_mesIngresosPromedios) {
		this.cargarid_mesIngresosPromedios= cargarid_mesIngresosPromedios;
	}

	public Border setResaltarcodigo_cargoIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarcodigo_cargoIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cargoIngresosPromedios() {
		return this.resaltarcodigo_cargoIngresosPromedios;
	}

	public void setResaltarcodigo_cargoIngresosPromedios(Border borderResaltar) {
		this.resaltarcodigo_cargoIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarcodigo_cargoIngresosPromedios() {
		return this.mostrarcodigo_cargoIngresosPromedios;
	}

	public void setMostrarcodigo_cargoIngresosPromedios(Boolean mostrarcodigo_cargoIngresosPromedios) {
		this.mostrarcodigo_cargoIngresosPromedios= mostrarcodigo_cargoIngresosPromedios;
	}

	public Boolean getActivarcodigo_cargoIngresosPromedios() {
		return this.activarcodigo_cargoIngresosPromedios;
	}

	public void setActivarcodigo_cargoIngresosPromedios(Boolean activarcodigo_cargoIngresosPromedios) {
		this.activarcodigo_cargoIngresosPromedios= activarcodigo_cargoIngresosPromedios;
	}

	public Border setResaltarcodigo_datoIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarcodigo_datoIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_datoIngresosPromedios() {
		return this.resaltarcodigo_datoIngresosPromedios;
	}

	public void setResaltarcodigo_datoIngresosPromedios(Border borderResaltar) {
		this.resaltarcodigo_datoIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarcodigo_datoIngresosPromedios() {
		return this.mostrarcodigo_datoIngresosPromedios;
	}

	public void setMostrarcodigo_datoIngresosPromedios(Boolean mostrarcodigo_datoIngresosPromedios) {
		this.mostrarcodigo_datoIngresosPromedios= mostrarcodigo_datoIngresosPromedios;
	}

	public Boolean getActivarcodigo_datoIngresosPromedios() {
		return this.activarcodigo_datoIngresosPromedios;
	}

	public void setActivarcodigo_datoIngresosPromedios(Boolean activarcodigo_datoIngresosPromedios) {
		this.activarcodigo_datoIngresosPromedios= activarcodigo_datoIngresosPromedios;
	}

	public Border setResaltarnombreIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarnombreIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreIngresosPromedios() {
		return this.resaltarnombreIngresosPromedios;
	}

	public void setResaltarnombreIngresosPromedios(Border borderResaltar) {
		this.resaltarnombreIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarnombreIngresosPromedios() {
		return this.mostrarnombreIngresosPromedios;
	}

	public void setMostrarnombreIngresosPromedios(Boolean mostrarnombreIngresosPromedios) {
		this.mostrarnombreIngresosPromedios= mostrarnombreIngresosPromedios;
	}

	public Boolean getActivarnombreIngresosPromedios() {
		return this.activarnombreIngresosPromedios;
	}

	public void setActivarnombreIngresosPromedios(Boolean activarnombreIngresosPromedios) {
		this.activarnombreIngresosPromedios= activarnombreIngresosPromedios;
	}

	public Border setResaltarvalor_pagoIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarvalor_pagoIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_pagoIngresosPromedios() {
		return this.resaltarvalor_pagoIngresosPromedios;
	}

	public void setResaltarvalor_pagoIngresosPromedios(Border borderResaltar) {
		this.resaltarvalor_pagoIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarvalor_pagoIngresosPromedios() {
		return this.mostrarvalor_pagoIngresosPromedios;
	}

	public void setMostrarvalor_pagoIngresosPromedios(Boolean mostrarvalor_pagoIngresosPromedios) {
		this.mostrarvalor_pagoIngresosPromedios= mostrarvalor_pagoIngresosPromedios;
	}

	public Boolean getActivarvalor_pagoIngresosPromedios() {
		return this.activarvalor_pagoIngresosPromedios;
	}

	public void setActivarvalor_pagoIngresosPromedios(Boolean activarvalor_pagoIngresosPromedios) {
		this.activarvalor_pagoIngresosPromedios= activarvalor_pagoIngresosPromedios;
	}

	public Border setResaltarnombre_rubro_empleaIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresospromediosBeanSwingJInternalFrame.jTtoolBarIngresosPromedios.setBorder(borderResaltar);
		
		this.resaltarnombre_rubro_empleaIngresosPromedios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_rubro_empleaIngresosPromedios() {
		return this.resaltarnombre_rubro_empleaIngresosPromedios;
	}

	public void setResaltarnombre_rubro_empleaIngresosPromedios(Border borderResaltar) {
		this.resaltarnombre_rubro_empleaIngresosPromedios= borderResaltar;
	}

	public Boolean getMostrarnombre_rubro_empleaIngresosPromedios() {
		return this.mostrarnombre_rubro_empleaIngresosPromedios;
	}

	public void setMostrarnombre_rubro_empleaIngresosPromedios(Boolean mostrarnombre_rubro_empleaIngresosPromedios) {
		this.mostrarnombre_rubro_empleaIngresosPromedios= mostrarnombre_rubro_empleaIngresosPromedios;
	}

	public Boolean getActivarnombre_rubro_empleaIngresosPromedios() {
		return this.activarnombre_rubro_empleaIngresosPromedios;
	}

	public void setActivarnombre_rubro_empleaIngresosPromedios(Boolean activarnombre_rubro_empleaIngresosPromedios) {
		this.activarnombre_rubro_empleaIngresosPromedios= activarnombre_rubro_empleaIngresosPromedios;
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
		
		
		this.setMostraridIngresosPromedios(esInicial);
		this.setMostrarid_estructuraIngresosPromedios(esInicial);
		this.setMostrarcodigoIngresosPromedios(esInicial);
		this.setMostrarid_empresaIngresosPromedios(esInicial);
		this.setMostrarid_anioIngresosPromedios(esInicial);
		this.setMostrarid_mesIngresosPromedios(esInicial);
		this.setMostrarcodigo_cargoIngresosPromedios(esInicial);
		this.setMostrarcodigo_datoIngresosPromedios(esInicial);
		this.setMostrarnombreIngresosPromedios(esInicial);
		this.setMostrarvalor_pagoIngresosPromedios(esInicial);
		this.setMostrarnombre_rubro_empleaIngresosPromedios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.ID)) {
				this.setMostraridIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDMES)) {
				this.setMostrarid_mesIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.CODIGOCARGO)) {
				this.setMostrarcodigo_cargoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.CODIGODATO)) {
				this.setMostrarcodigo_datoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.VALORPAGO)) {
				this.setMostrarvalor_pagoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.NOMBRERUBROEMPLEA)) {
				this.setMostrarnombre_rubro_empleaIngresosPromedios(esAsigna);
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
		
		
		this.setActivaridIngresosPromedios(esInicial);
		this.setActivarid_estructuraIngresosPromedios(esInicial);
		this.setActivarcodigoIngresosPromedios(esInicial);
		this.setActivarid_empresaIngresosPromedios(esInicial);
		this.setActivarid_anioIngresosPromedios(esInicial);
		this.setActivarid_mesIngresosPromedios(esInicial);
		this.setActivarcodigo_cargoIngresosPromedios(esInicial);
		this.setActivarcodigo_datoIngresosPromedios(esInicial);
		this.setActivarnombreIngresosPromedios(esInicial);
		this.setActivarvalor_pagoIngresosPromedios(esInicial);
		this.setActivarnombre_rubro_empleaIngresosPromedios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.ID)) {
				this.setActivaridIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDANIO)) {
				this.setActivarid_anioIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDMES)) {
				this.setActivarid_mesIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.CODIGOCARGO)) {
				this.setActivarcodigo_cargoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.CODIGODATO)) {
				this.setActivarcodigo_datoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.VALORPAGO)) {
				this.setActivarvalor_pagoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.NOMBRERUBROEMPLEA)) {
				this.setActivarnombre_rubro_empleaIngresosPromedios(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridIngresosPromedios(esInicial);
		this.setResaltarid_estructuraIngresosPromedios(esInicial);
		this.setResaltarcodigoIngresosPromedios(esInicial);
		this.setResaltarid_empresaIngresosPromedios(esInicial);
		this.setResaltarid_anioIngresosPromedios(esInicial);
		this.setResaltarid_mesIngresosPromedios(esInicial);
		this.setResaltarcodigo_cargoIngresosPromedios(esInicial);
		this.setResaltarcodigo_datoIngresosPromedios(esInicial);
		this.setResaltarnombreIngresosPromedios(esInicial);
		this.setResaltarvalor_pagoIngresosPromedios(esInicial);
		this.setResaltarnombre_rubro_empleaIngresosPromedios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.ID)) {
				this.setResaltaridIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.IDMES)) {
				this.setResaltarid_mesIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.CODIGOCARGO)) {
				this.setResaltarcodigo_cargoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.CODIGODATO)) {
				this.setResaltarcodigo_datoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.VALORPAGO)) {
				this.setResaltarvalor_pagoIngresosPromedios(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosPromediosConstantesFunciones.NOMBRERUBROEMPLEA)) {
				this.setResaltarnombre_rubro_empleaIngresosPromedios(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaIngresosPromediosIngresosPromedios=true;

	public Boolean getMostrarBusquedaIngresosPromediosIngresosPromedios() {
		return this.mostrarBusquedaIngresosPromediosIngresosPromedios;
	}

	public void setMostrarBusquedaIngresosPromediosIngresosPromedios(Boolean visibilidadResaltar) {
		this.mostrarBusquedaIngresosPromediosIngresosPromedios= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaIngresosPromediosIngresosPromedios=true;

	public Boolean getActivarBusquedaIngresosPromediosIngresosPromedios() {
		return this.activarBusquedaIngresosPromediosIngresosPromedios;
	}

	public void setActivarBusquedaIngresosPromediosIngresosPromedios(Boolean habilitarResaltar) {
		this.activarBusquedaIngresosPromediosIngresosPromedios= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaIngresosPromediosIngresosPromedios=null;

	public Border getResaltarBusquedaIngresosPromediosIngresosPromedios() {
		return this.resaltarBusquedaIngresosPromediosIngresosPromedios;
	}

	public void setResaltarBusquedaIngresosPromediosIngresosPromedios(Border borderResaltar) {
		this.resaltarBusquedaIngresosPromediosIngresosPromedios= borderResaltar;
	}

	public void setResaltarBusquedaIngresosPromediosIngresosPromedios(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosPromediosBeanSwingJInternalFrame ingresospromediosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaIngresosPromediosIngresosPromedios= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}