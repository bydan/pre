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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.ConversionInvenConstantesFunciones;
import com.bydan.erp.inventario.util.ConversionInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ConversionInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConversionInvenConstantesFunciones extends ConversionInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ConversionInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConversionInven"+ConversionInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConversionInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConversionInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConversionInvenConstantesFunciones.SCHEMA+"_"+ConversionInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConversionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConversionInvenConstantesFunciones.SCHEMA+"_"+ConversionInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConversionInvenConstantesFunciones.SCHEMA+"_"+ConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConversionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConversionInvenConstantesFunciones.SCHEMA+"_"+ConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConversionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConversionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConversionInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConversionInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConversionInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConversionInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Conversion Invenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Conversion Inven";
	public static final String SCLASSWEBTITULO_LOWER="Conversion Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConversionInven";
	public static final String OBJECTNAME="conversioninven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="conversion_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select conversioninven from "+ConversionInvenConstantesFunciones.SPERSISTENCENAME+" conversioninven";
	public static String QUERYSELECTNATIVE="select "+ConversionInvenConstantesFunciones.SCHEMA+"."+ConversionInvenConstantesFunciones.TABLENAME+".id,"+ConversionInvenConstantesFunciones.SCHEMA+"."+ConversionInvenConstantesFunciones.TABLENAME+".version_row,"+ConversionInvenConstantesFunciones.SCHEMA+"."+ConversionInvenConstantesFunciones.TABLENAME+".id_empresa,"+ConversionInvenConstantesFunciones.SCHEMA+"."+ConversionInvenConstantesFunciones.TABLENAME+".id_tipo_conversion_inven,"+ConversionInvenConstantesFunciones.SCHEMA+"."+ConversionInvenConstantesFunciones.TABLENAME+".id_unidad,"+ConversionInvenConstantesFunciones.SCHEMA+"."+ConversionInvenConstantesFunciones.TABLENAME+".id_unidad_conversion,"+ConversionInvenConstantesFunciones.SCHEMA+"."+ConversionInvenConstantesFunciones.TABLENAME+".valor,"+ConversionInvenConstantesFunciones.SCHEMA+"."+ConversionInvenConstantesFunciones.TABLENAME+".descripcion from "+ConversionInvenConstantesFunciones.SCHEMA+"."+ConversionInvenConstantesFunciones.TABLENAME;//+" as "+ConversionInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ConversionInvenConstantesFuncionesAdditional conversioninvenConstantesFuncionesAdditional=null;
	
	public ConversionInvenConstantesFuncionesAdditional getConversionInvenConstantesFuncionesAdditional() {
		return this.conversioninvenConstantesFuncionesAdditional;
	}
	
	public void setConversionInvenConstantesFuncionesAdditional(ConversionInvenConstantesFuncionesAdditional conversioninvenConstantesFuncionesAdditional) {
		try {
			this.conversioninvenConstantesFuncionesAdditional=conversioninvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOCONVERSIONINVEN= "id_tipo_conversion_inven";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDUNIDADCONVERSION= "id_unidad_conversion";
    public static final String VALOR= "valor";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOCONVERSIONINVEN= "Tipo Conversion";
		public static final String LABEL_IDTIPOCONVERSIONINVEN_LOWER= "Tipo Conversion Inven";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDUNIDADCONVERSION= "Unidad Conversion";
		public static final String LABEL_IDUNIDADCONVERSION_LOWER= "Unidad Conversion";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getConversionInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConversionInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConversionInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN)) {sLabelColumna=ConversionInvenConstantesFunciones.LABEL_IDTIPOCONVERSIONINVEN;}
		if(sNombreColumna.equals(ConversionInvenConstantesFunciones.IDUNIDAD)) {sLabelColumna=ConversionInvenConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ConversionInvenConstantesFunciones.IDUNIDADCONVERSION)) {sLabelColumna=ConversionInvenConstantesFunciones.LABEL_IDUNIDADCONVERSION;}
		if(sNombreColumna.equals(ConversionInvenConstantesFunciones.VALOR)) {sLabelColumna=ConversionInvenConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ConversionInvenConstantesFunciones.DESCRIPCION)) {sLabelColumna=ConversionInvenConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getConversionInvenDescripcion(ConversionInven conversioninven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(conversioninven !=null/* && conversioninven.getId()!=0*/) {
			if(conversioninven.getId()!=null) {
				sDescripcion=conversioninven.getId().toString();
			}//conversioninvenconversioninven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getConversionInvenDescripcionDetallado(ConversionInven conversioninven) {
		String sDescripcion="";
			
		sDescripcion+=ConversionInvenConstantesFunciones.ID+"=";
		sDescripcion+=conversioninven.getId().toString()+",";
		sDescripcion+=ConversionInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=conversioninven.getVersionRow().toString()+",";
		sDescripcion+=ConversionInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=conversioninven.getid_empresa().toString()+",";
		sDescripcion+=ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN+"=";
		sDescripcion+=conversioninven.getid_tipo_conversion_inven().toString()+",";
		sDescripcion+=ConversionInvenConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=conversioninven.getid_unidad().toString()+",";
		sDescripcion+=ConversionInvenConstantesFunciones.IDUNIDADCONVERSION+"=";
		sDescripcion+=conversioninven.getid_unidad_conversion().toString()+",";
		sDescripcion+=ConversionInvenConstantesFunciones.VALOR+"=";
		sDescripcion+=conversioninven.getvalor().toString()+",";
		sDescripcion+=ConversionInvenConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=conversioninven.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setConversionInvenDescripcion(ConversionInven conversioninven,String sValor) throws Exception {			
		if(conversioninven !=null) {
			//conversioninvenconversioninven.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoConversionInvenDescripcion(TipoConversionInven tipoconversioninven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoconversioninven!=null/*&&tipoconversioninven.getId()>0*/) {
			sDescripcion=TipoConversionInvenConstantesFunciones.getTipoConversionInvenDescripcion(tipoconversioninven);
		}

		return sDescripcion;
	}

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}

	public static String getUnidadConversionDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoConversionInven")) {
			sNombreIndice="Tipo=  Por Tipo Conversion";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unidad";
		} else if(sNombreIndice.equals("FK_IdUnidadConversion")) {
			sNombreIndice="Tipo=  Por Unidad Conversion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoConversionInven(Long id_tipo_conversion_inven) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_conversion_inven!=null) {sDetalleIndice+=" Codigo Unico De Tipo Conversion="+id_tipo_conversion_inven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidadConversion(Long id_unidad_conversion) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad_conversion!=null) {sDetalleIndice+=" Codigo Unico De Unidad Conversion="+id_unidad_conversion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConversionInven(ConversionInven conversioninven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		conversioninven.setdescripcion(conversioninven.getdescripcion().trim());
	}
	
	public static void quitarEspaciosConversionInvens(List<ConversionInven> conversioninvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConversionInven conversioninven: conversioninvens) {
			conversioninven.setdescripcion(conversioninven.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConversionInven(ConversionInven conversioninven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && conversioninven.getConCambioAuxiliar()) {
			conversioninven.setIsDeleted(conversioninven.getIsDeletedAuxiliar());	
			conversioninven.setIsNew(conversioninven.getIsNewAuxiliar());	
			conversioninven.setIsChanged(conversioninven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			conversioninven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			conversioninven.setIsDeletedAuxiliar(false);	
			conversioninven.setIsNewAuxiliar(false);	
			conversioninven.setIsChangedAuxiliar(false);
			
			conversioninven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConversionInvens(List<ConversionInven> conversioninvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConversionInven conversioninven : conversioninvens) {
			if(conAsignarBase && conversioninven.getConCambioAuxiliar()) {
				conversioninven.setIsDeleted(conversioninven.getIsDeletedAuxiliar());	
				conversioninven.setIsNew(conversioninven.getIsNewAuxiliar());	
				conversioninven.setIsChanged(conversioninven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				conversioninven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				conversioninven.setIsDeletedAuxiliar(false);	
				conversioninven.setIsNewAuxiliar(false);	
				conversioninven.setIsChangedAuxiliar(false);
				
				conversioninven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConversionInven(ConversionInven conversioninven,Boolean conEnteros) throws Exception  {
		conversioninven.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConversionInvens(List<ConversionInven> conversioninvens,Boolean conEnteros) throws Exception  {
		
		for(ConversionInven conversioninven: conversioninvens) {
			conversioninven.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConversionInven(List<ConversionInven> conversioninvens,ConversionInven conversioninvenAux) throws Exception  {
		ConversionInvenConstantesFunciones.InicializarValoresConversionInven(conversioninvenAux,true);
		
		for(ConversionInven conversioninven: conversioninvens) {
			if(conversioninven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			conversioninvenAux.setvalor(conversioninvenAux.getvalor()+conversioninven.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConversionInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConversionInvenConstantesFunciones.getArrayColumnasGlobalesConversionInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConversionInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConversionInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConversionInvenConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConversionInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConversionInven> conversioninvens,ConversionInven conversioninven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConversionInven conversioninvenAux: conversioninvens) {
			if(conversioninvenAux!=null && conversioninven!=null) {
				if((conversioninvenAux.getId()==null && conversioninven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(conversioninvenAux.getId()!=null && conversioninven.getId()!=null){
					if(conversioninvenAux.getId().equals(conversioninven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConversionInven(List<ConversionInven> conversioninvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(ConversionInven conversioninven: conversioninvens) {			
			if(conversioninven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=conversioninven.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConversionInvenConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ConversionInvenConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConversionInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConversionInvenConstantesFunciones.LABEL_ID, ConversionInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionInvenConstantesFunciones.LABEL_VERSIONROW, ConversionInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionInvenConstantesFunciones.LABEL_IDEMPRESA, ConversionInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionInvenConstantesFunciones.LABEL_IDTIPOCONVERSIONINVEN, ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionInvenConstantesFunciones.LABEL_IDUNIDAD, ConversionInvenConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionInvenConstantesFunciones.LABEL_IDUNIDADCONVERSION, ConversionInvenConstantesFunciones.IDUNIDADCONVERSION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionInvenConstantesFunciones.LABEL_VALOR, ConversionInvenConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionInvenConstantesFunciones.LABEL_DESCRIPCION, ConversionInvenConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConversionInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConversionInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionInvenConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionInvenConstantesFunciones.IDUNIDADCONVERSION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionInvenConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionInvenConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConversionInven() throws Exception  {
		return ConversionInvenConstantesFunciones.getTiposSeleccionarConversionInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConversionInven(Boolean conFk) throws Exception  {
		return ConversionInvenConstantesFunciones.getTiposSeleccionarConversionInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConversionInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConversionInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionInvenConstantesFunciones.LABEL_IDTIPOCONVERSIONINVEN);
			reporte.setsDescripcion(ConversionInvenConstantesFunciones.LABEL_IDTIPOCONVERSIONINVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionInvenConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ConversionInvenConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionInvenConstantesFunciones.LABEL_IDUNIDADCONVERSION);
			reporte.setsDescripcion(ConversionInvenConstantesFunciones.LABEL_IDUNIDADCONVERSION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionInvenConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ConversionInvenConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionInvenConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ConversionInvenConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConversionInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConversionInven(ConversionInven conversioninvenAux) throws Exception {
		
			conversioninvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(conversioninvenAux.getEmpresa()));
			conversioninvenAux.settipoconversioninven_descripcion(TipoConversionInvenConstantesFunciones.getTipoConversionInvenDescripcion(conversioninvenAux.getTipoConversionInven()));
			conversioninvenAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(conversioninvenAux.getUnidad()));
			conversioninvenAux.setunidadconversion_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(conversioninvenAux.getUnidadConversion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConversionInven(List<ConversionInven> conversioninvensTemp) throws Exception {
		for(ConversionInven conversioninvenAux:conversioninvensTemp) {
			
			conversioninvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(conversioninvenAux.getEmpresa()));
			conversioninvenAux.settipoconversioninven_descripcion(TipoConversionInvenConstantesFunciones.getTipoConversionInvenDescripcion(conversioninvenAux.getTipoConversionInven()));
			conversioninvenAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(conversioninvenAux.getUnidad()));
			conversioninvenAux.setunidadconversion_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(conversioninvenAux.getUnidadConversion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoConversionInven.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoConversionInven.class)) {
						classes.add(new Classe(TipoConversionInven.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConversionInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoConversionInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoConversionInven.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoConversionInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoConversionInven.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConversionInvenConstantesFunciones.getClassesRelationshipsOfConversionInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConversionInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConversionInvenConstantesFunciones.getClassesRelationshipsFromStringsOfConversionInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConversionInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ConversionInven conversioninven,List<ConversionInven> conversioninvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ConversionInven conversioninvenEncontrado=null;
			
			for(ConversionInven conversioninvenLocal:conversioninvens) {
				if(conversioninvenLocal.getId().equals(conversioninven.getId())) {
					conversioninvenEncontrado=conversioninvenLocal;
					
					conversioninvenLocal.setIsChanged(conversioninven.getIsChanged());
					conversioninvenLocal.setIsNew(conversioninven.getIsNew());
					conversioninvenLocal.setIsDeleted(conversioninven.getIsDeleted());
					
					conversioninvenLocal.setGeneralEntityOriginal(conversioninven.getGeneralEntityOriginal());
					
					conversioninvenLocal.setId(conversioninven.getId());	
					conversioninvenLocal.setVersionRow(conversioninven.getVersionRow());	
					conversioninvenLocal.setid_empresa(conversioninven.getid_empresa());	
					conversioninvenLocal.setid_tipo_conversion_inven(conversioninven.getid_tipo_conversion_inven());	
					conversioninvenLocal.setid_unidad(conversioninven.getid_unidad());	
					conversioninvenLocal.setid_unidad_conversion(conversioninven.getid_unidad_conversion());	
					conversioninvenLocal.setvalor(conversioninven.getvalor());	
					conversioninvenLocal.setdescripcion(conversioninven.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!conversioninven.getIsDeleted()) {
				if(!existe) {
					conversioninvens.add(conversioninven);
				}
			} else {
				if(conversioninvenEncontrado!=null && permiteQuitar)  {
					conversioninvens.remove(conversioninvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ConversionInven conversioninven,List<ConversionInven> conversioninvens) throws Exception {
		try	{			
			for(ConversionInven conversioninvenLocal:conversioninvens) {
				if(conversioninvenLocal.getId().equals(conversioninven.getId())) {
					conversioninvenLocal.setIsSelected(conversioninven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConversionInven(List<ConversionInven> conversioninvensAux) throws Exception {
		//this.conversioninvensAux=conversioninvensAux;
		
		for(ConversionInven conversioninvenAux:conversioninvensAux) {
			if(conversioninvenAux.getIsChanged()) {
				conversioninvenAux.setIsChanged(false);
			}		
			
			if(conversioninvenAux.getIsNew()) {
				conversioninvenAux.setIsNew(false);
			}	
			
			if(conversioninvenAux.getIsDeleted()) {
				conversioninvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConversionInven(ConversionInven conversioninvenAux) throws Exception {
		//this.conversioninvenAux=conversioninvenAux;
		
			if(conversioninvenAux.getIsChanged()) {
				conversioninvenAux.setIsChanged(false);
			}		
			
			if(conversioninvenAux.getIsNew()) {
				conversioninvenAux.setIsNew(false);
			}	
			
			if(conversioninvenAux.getIsDeleted()) {
				conversioninvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConversionInven conversioninvenAsignar,ConversionInven conversioninven) throws Exception {
		conversioninvenAsignar.setId(conversioninven.getId());	
		conversioninvenAsignar.setVersionRow(conversioninven.getVersionRow());	
		conversioninvenAsignar.setid_empresa(conversioninven.getid_empresa());
		conversioninvenAsignar.setempresa_descripcion(conversioninven.getempresa_descripcion());	
		conversioninvenAsignar.setid_tipo_conversion_inven(conversioninven.getid_tipo_conversion_inven());
		conversioninvenAsignar.settipoconversioninven_descripcion(conversioninven.gettipoconversioninven_descripcion());	
		conversioninvenAsignar.setid_unidad(conversioninven.getid_unidad());
		conversioninvenAsignar.setunidad_descripcion(conversioninven.getunidad_descripcion());	
		conversioninvenAsignar.setid_unidad_conversion(conversioninven.getid_unidad_conversion());
		conversioninvenAsignar.setunidadconversion_descripcion(conversioninven.getunidadconversion_descripcion());	
		conversioninvenAsignar.setvalor(conversioninven.getvalor());	
		conversioninvenAsignar.setdescripcion(conversioninven.getdescripcion());	
	}
	
	public static void inicializarConversionInven(ConversionInven conversioninven) throws Exception {
		try {
				conversioninven.setId(0L);	
					
				conversioninven.setid_empresa(-1L);	
				conversioninven.setid_tipo_conversion_inven(-1L);	
				conversioninven.setid_unidad(-1L);	
				conversioninven.setid_unidad_conversion(-1L);	
				conversioninven.setvalor(0.0);	
				conversioninven.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConversionInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionInvenConstantesFunciones.LABEL_IDTIPOCONVERSIONINVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionInvenConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionInvenConstantesFunciones.LABEL_IDUNIDADCONVERSION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionInvenConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionInvenConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConversionInven(String sTipo,Row row,Workbook workbook,ConversionInven conversioninven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(conversioninven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conversioninven.gettipoconversioninven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conversioninven.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conversioninven.getunidadconversion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conversioninven.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conversioninven.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConversionInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryConversionInven() {
		return this.sFinalQueryConversionInven;
	}
	
	public void setsFinalQueryConversionInven(String sFinalQueryConversionInven) {
		this.sFinalQueryConversionInven= sFinalQueryConversionInven;
	}
	
	public Border resaltarSeleccionarConversionInven=null;
	
	public Border setResaltarSeleccionarConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//conversioninvenBeanSwingJInternalFrame.jTtoolBarConversionInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConversionInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConversionInven() {
		return this.resaltarSeleccionarConversionInven;
	}
	
	public void setResaltarSeleccionarConversionInven(Border borderResaltarSeleccionarConversionInven) {
		this.resaltarSeleccionarConversionInven= borderResaltarSeleccionarConversionInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConversionInven=null;
	public Boolean mostraridConversionInven=true;
	public Boolean activaridConversionInven=true;

	public Border resaltarid_empresaConversionInven=null;
	public Boolean mostrarid_empresaConversionInven=true;
	public Boolean activarid_empresaConversionInven=true;
	public Boolean cargarid_empresaConversionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConversionInven=false;//ConEventDepend=true

	public Border resaltarid_tipo_conversion_invenConversionInven=null;
	public Boolean mostrarid_tipo_conversion_invenConversionInven=true;
	public Boolean activarid_tipo_conversion_invenConversionInven=true;
	public Boolean cargarid_tipo_conversion_invenConversionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_conversion_invenConversionInven=false;//ConEventDepend=true

	public Border resaltarid_unidadConversionInven=null;
	public Boolean mostrarid_unidadConversionInven=true;
	public Boolean activarid_unidadConversionInven=true;
	public Boolean cargarid_unidadConversionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadConversionInven=false;//ConEventDepend=true

	public Border resaltarid_unidad_conversionConversionInven=null;
	public Boolean mostrarid_unidad_conversionConversionInven=true;
	public Boolean activarid_unidad_conversionConversionInven=true;
	public Boolean cargarid_unidad_conversionConversionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidad_conversionConversionInven=false;//ConEventDepend=true

	public Border resaltarvalorConversionInven=null;
	public Boolean mostrarvalorConversionInven=true;
	public Boolean activarvalorConversionInven=true;

	public Border resaltardescripcionConversionInven=null;
	public Boolean mostrardescripcionConversionInven=true;
	public Boolean activardescripcionConversionInven=true;

	
	

	public Border setResaltaridConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversioninvenBeanSwingJInternalFrame.jTtoolBarConversionInven.setBorder(borderResaltar);
		
		this.resaltaridConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConversionInven() {
		return this.resaltaridConversionInven;
	}

	public void setResaltaridConversionInven(Border borderResaltar) {
		this.resaltaridConversionInven= borderResaltar;
	}

	public Boolean getMostraridConversionInven() {
		return this.mostraridConversionInven;
	}

	public void setMostraridConversionInven(Boolean mostraridConversionInven) {
		this.mostraridConversionInven= mostraridConversionInven;
	}

	public Boolean getActivaridConversionInven() {
		return this.activaridConversionInven;
	}

	public void setActivaridConversionInven(Boolean activaridConversionInven) {
		this.activaridConversionInven= activaridConversionInven;
	}

	public Border setResaltarid_empresaConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversioninvenBeanSwingJInternalFrame.jTtoolBarConversionInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConversionInven() {
		return this.resaltarid_empresaConversionInven;
	}

	public void setResaltarid_empresaConversionInven(Border borderResaltar) {
		this.resaltarid_empresaConversionInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaConversionInven() {
		return this.mostrarid_empresaConversionInven;
	}

	public void setMostrarid_empresaConversionInven(Boolean mostrarid_empresaConversionInven) {
		this.mostrarid_empresaConversionInven= mostrarid_empresaConversionInven;
	}

	public Boolean getActivarid_empresaConversionInven() {
		return this.activarid_empresaConversionInven;
	}

	public void setActivarid_empresaConversionInven(Boolean activarid_empresaConversionInven) {
		this.activarid_empresaConversionInven= activarid_empresaConversionInven;
	}

	public Boolean getCargarid_empresaConversionInven() {
		return this.cargarid_empresaConversionInven;
	}

	public void setCargarid_empresaConversionInven(Boolean cargarid_empresaConversionInven) {
		this.cargarid_empresaConversionInven= cargarid_empresaConversionInven;
	}

	public Border setResaltarid_tipo_conversion_invenConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversioninvenBeanSwingJInternalFrame.jTtoolBarConversionInven.setBorder(borderResaltar);
		
		this.resaltarid_tipo_conversion_invenConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_conversion_invenConversionInven() {
		return this.resaltarid_tipo_conversion_invenConversionInven;
	}

	public void setResaltarid_tipo_conversion_invenConversionInven(Border borderResaltar) {
		this.resaltarid_tipo_conversion_invenConversionInven= borderResaltar;
	}

	public Boolean getMostrarid_tipo_conversion_invenConversionInven() {
		return this.mostrarid_tipo_conversion_invenConversionInven;
	}

	public void setMostrarid_tipo_conversion_invenConversionInven(Boolean mostrarid_tipo_conversion_invenConversionInven) {
		this.mostrarid_tipo_conversion_invenConversionInven= mostrarid_tipo_conversion_invenConversionInven;
	}

	public Boolean getActivarid_tipo_conversion_invenConversionInven() {
		return this.activarid_tipo_conversion_invenConversionInven;
	}

	public void setActivarid_tipo_conversion_invenConversionInven(Boolean activarid_tipo_conversion_invenConversionInven) {
		this.activarid_tipo_conversion_invenConversionInven= activarid_tipo_conversion_invenConversionInven;
	}

	public Boolean getCargarid_tipo_conversion_invenConversionInven() {
		return this.cargarid_tipo_conversion_invenConversionInven;
	}

	public void setCargarid_tipo_conversion_invenConversionInven(Boolean cargarid_tipo_conversion_invenConversionInven) {
		this.cargarid_tipo_conversion_invenConversionInven= cargarid_tipo_conversion_invenConversionInven;
	}

	public Border setResaltarid_unidadConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversioninvenBeanSwingJInternalFrame.jTtoolBarConversionInven.setBorder(borderResaltar);
		
		this.resaltarid_unidadConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadConversionInven() {
		return this.resaltarid_unidadConversionInven;
	}

	public void setResaltarid_unidadConversionInven(Border borderResaltar) {
		this.resaltarid_unidadConversionInven= borderResaltar;
	}

	public Boolean getMostrarid_unidadConversionInven() {
		return this.mostrarid_unidadConversionInven;
	}

	public void setMostrarid_unidadConversionInven(Boolean mostrarid_unidadConversionInven) {
		this.mostrarid_unidadConversionInven= mostrarid_unidadConversionInven;
	}

	public Boolean getActivarid_unidadConversionInven() {
		return this.activarid_unidadConversionInven;
	}

	public void setActivarid_unidadConversionInven(Boolean activarid_unidadConversionInven) {
		this.activarid_unidadConversionInven= activarid_unidadConversionInven;
	}

	public Boolean getCargarid_unidadConversionInven() {
		return this.cargarid_unidadConversionInven;
	}

	public void setCargarid_unidadConversionInven(Boolean cargarid_unidadConversionInven) {
		this.cargarid_unidadConversionInven= cargarid_unidadConversionInven;
	}

	public Border setResaltarid_unidad_conversionConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversioninvenBeanSwingJInternalFrame.jTtoolBarConversionInven.setBorder(borderResaltar);
		
		this.resaltarid_unidad_conversionConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidad_conversionConversionInven() {
		return this.resaltarid_unidad_conversionConversionInven;
	}

	public void setResaltarid_unidad_conversionConversionInven(Border borderResaltar) {
		this.resaltarid_unidad_conversionConversionInven= borderResaltar;
	}

	public Boolean getMostrarid_unidad_conversionConversionInven() {
		return this.mostrarid_unidad_conversionConversionInven;
	}

	public void setMostrarid_unidad_conversionConversionInven(Boolean mostrarid_unidad_conversionConversionInven) {
		this.mostrarid_unidad_conversionConversionInven= mostrarid_unidad_conversionConversionInven;
	}

	public Boolean getActivarid_unidad_conversionConversionInven() {
		return this.activarid_unidad_conversionConversionInven;
	}

	public void setActivarid_unidad_conversionConversionInven(Boolean activarid_unidad_conversionConversionInven) {
		this.activarid_unidad_conversionConversionInven= activarid_unidad_conversionConversionInven;
	}

	public Boolean getCargarid_unidad_conversionConversionInven() {
		return this.cargarid_unidad_conversionConversionInven;
	}

	public void setCargarid_unidad_conversionConversionInven(Boolean cargarid_unidad_conversionConversionInven) {
		this.cargarid_unidad_conversionConversionInven= cargarid_unidad_conversionConversionInven;
	}

	public Border setResaltarvalorConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversioninvenBeanSwingJInternalFrame.jTtoolBarConversionInven.setBorder(borderResaltar);
		
		this.resaltarvalorConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorConversionInven() {
		return this.resaltarvalorConversionInven;
	}

	public void setResaltarvalorConversionInven(Border borderResaltar) {
		this.resaltarvalorConversionInven= borderResaltar;
	}

	public Boolean getMostrarvalorConversionInven() {
		return this.mostrarvalorConversionInven;
	}

	public void setMostrarvalorConversionInven(Boolean mostrarvalorConversionInven) {
		this.mostrarvalorConversionInven= mostrarvalorConversionInven;
	}

	public Boolean getActivarvalorConversionInven() {
		return this.activarvalorConversionInven;
	}

	public void setActivarvalorConversionInven(Boolean activarvalorConversionInven) {
		this.activarvalorConversionInven= activarvalorConversionInven;
	}

	public Border setResaltardescripcionConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversioninvenBeanSwingJInternalFrame.jTtoolBarConversionInven.setBorder(borderResaltar);
		
		this.resaltardescripcionConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionConversionInven() {
		return this.resaltardescripcionConversionInven;
	}

	public void setResaltardescripcionConversionInven(Border borderResaltar) {
		this.resaltardescripcionConversionInven= borderResaltar;
	}

	public Boolean getMostrardescripcionConversionInven() {
		return this.mostrardescripcionConversionInven;
	}

	public void setMostrardescripcionConversionInven(Boolean mostrardescripcionConversionInven) {
		this.mostrardescripcionConversionInven= mostrardescripcionConversionInven;
	}

	public Boolean getActivardescripcionConversionInven() {
		return this.activardescripcionConversionInven;
	}

	public void setActivardescripcionConversionInven(Boolean activardescripcionConversionInven) {
		this.activardescripcionConversionInven= activardescripcionConversionInven;
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
		
		
		this.setMostraridConversionInven(esInicial);
		this.setMostrarid_empresaConversionInven(esInicial);
		this.setMostrarid_tipo_conversion_invenConversionInven(esInicial);
		this.setMostrarid_unidadConversionInven(esInicial);
		this.setMostrarid_unidad_conversionConversionInven(esInicial);
		this.setMostrarvalorConversionInven(esInicial);
		this.setMostrardescripcionConversionInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConversionInvenConstantesFunciones.ID)) {
				this.setMostraridConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN)) {
				this.setMostrarid_tipo_conversion_invenConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDUNIDADCONVERSION)) {
				this.setMostrarid_unidad_conversionConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.VALOR)) {
				this.setMostrarvalorConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionConversionInven(esAsigna);
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
		
		
		this.setActivaridConversionInven(esInicial);
		this.setActivarid_empresaConversionInven(esInicial);
		this.setActivarid_tipo_conversion_invenConversionInven(esInicial);
		this.setActivarid_unidadConversionInven(esInicial);
		this.setActivarid_unidad_conversionConversionInven(esInicial);
		this.setActivarvalorConversionInven(esInicial);
		this.setActivardescripcionConversionInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConversionInvenConstantesFunciones.ID)) {
				this.setActivaridConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN)) {
				this.setActivarid_tipo_conversion_invenConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDUNIDADCONVERSION)) {
				this.setActivarid_unidad_conversionConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.VALOR)) {
				this.setActivarvalorConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionConversionInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConversionInven(esInicial);
		this.setResaltarid_empresaConversionInven(esInicial);
		this.setResaltarid_tipo_conversion_invenConversionInven(esInicial);
		this.setResaltarid_unidadConversionInven(esInicial);
		this.setResaltarid_unidad_conversionConversionInven(esInicial);
		this.setResaltarvalorConversionInven(esInicial);
		this.setResaltardescripcionConversionInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConversionInvenConstantesFunciones.ID)) {
				this.setResaltaridConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDTIPOCONVERSIONINVEN)) {
				this.setResaltarid_tipo_conversion_invenConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.IDUNIDADCONVERSION)) {
				this.setResaltarid_unidad_conversionConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.VALOR)) {
				this.setResaltarvalorConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionInvenConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionConversionInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaConversionInven=true;

	public Boolean getMostrarFK_IdEmpresaConversionInven() {
		return this.mostrarFK_IdEmpresaConversionInven;
	}

	public void setMostrarFK_IdEmpresaConversionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaConversionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoConversionInvenConversionInven=true;

	public Boolean getMostrarFK_IdTipoConversionInvenConversionInven() {
		return this.mostrarFK_IdTipoConversionInvenConversionInven;
	}

	public void setMostrarFK_IdTipoConversionInvenConversionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoConversionInvenConversionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadConversionInven=true;

	public Boolean getMostrarFK_IdUnidadConversionInven() {
		return this.mostrarFK_IdUnidadConversionInven;
	}

	public void setMostrarFK_IdUnidadConversionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadConversionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadConversionConversionInven=true;

	public Boolean getMostrarFK_IdUnidadConversionConversionInven() {
		return this.mostrarFK_IdUnidadConversionConversionInven;
	}

	public void setMostrarFK_IdUnidadConversionConversionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadConversionConversionInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaConversionInven=true;

	public Boolean getActivarFK_IdEmpresaConversionInven() {
		return this.activarFK_IdEmpresaConversionInven;
	}

	public void setActivarFK_IdEmpresaConversionInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaConversionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoConversionInvenConversionInven=true;

	public Boolean getActivarFK_IdTipoConversionInvenConversionInven() {
		return this.activarFK_IdTipoConversionInvenConversionInven;
	}

	public void setActivarFK_IdTipoConversionInvenConversionInven(Boolean habilitarResaltar) {
		this.activarFK_IdTipoConversionInvenConversionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadConversionInven=true;

	public Boolean getActivarFK_IdUnidadConversionInven() {
		return this.activarFK_IdUnidadConversionInven;
	}

	public void setActivarFK_IdUnidadConversionInven(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadConversionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadConversionConversionInven=true;

	public Boolean getActivarFK_IdUnidadConversionConversionInven() {
		return this.activarFK_IdUnidadConversionConversionInven;
	}

	public void setActivarFK_IdUnidadConversionConversionInven(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadConversionConversionInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaConversionInven=null;

	public Border getResaltarFK_IdEmpresaConversionInven() {
		return this.resaltarFK_IdEmpresaConversionInven;
	}

	public void setResaltarFK_IdEmpresaConversionInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaConversionInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaConversionInven= borderResaltar;
	}

	public Border resaltarFK_IdTipoConversionInvenConversionInven=null;

	public Border getResaltarFK_IdTipoConversionInvenConversionInven() {
		return this.resaltarFK_IdTipoConversionInvenConversionInven;
	}

	public void setResaltarFK_IdTipoConversionInvenConversionInven(Border borderResaltar) {
		this.resaltarFK_IdTipoConversionInvenConversionInven= borderResaltar;
	}

	public void setResaltarFK_IdTipoConversionInvenConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoConversionInvenConversionInven= borderResaltar;
	}

	public Border resaltarFK_IdUnidadConversionInven=null;

	public Border getResaltarFK_IdUnidadConversionInven() {
		return this.resaltarFK_IdUnidadConversionInven;
	}

	public void setResaltarFK_IdUnidadConversionInven(Border borderResaltar) {
		this.resaltarFK_IdUnidadConversionInven= borderResaltar;
	}

	public void setResaltarFK_IdUnidadConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadConversionInven= borderResaltar;
	}

	public Border resaltarFK_IdUnidadConversionConversionInven=null;

	public Border getResaltarFK_IdUnidadConversionConversionInven() {
		return this.resaltarFK_IdUnidadConversionConversionInven;
	}

	public void setResaltarFK_IdUnidadConversionConversionInven(Border borderResaltar) {
		this.resaltarFK_IdUnidadConversionConversionInven= borderResaltar;
	}

	public void setResaltarFK_IdUnidadConversionConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionInvenBeanSwingJInternalFrame conversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadConversionConversionInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}