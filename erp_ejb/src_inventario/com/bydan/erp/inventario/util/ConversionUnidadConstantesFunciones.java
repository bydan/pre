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


import com.bydan.erp.inventario.util.ConversionUnidadConstantesFunciones;
import com.bydan.erp.inventario.util.ConversionUnidadParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ConversionUnidadParameterGeneral;

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
final public class ConversionUnidadConstantesFunciones extends ConversionUnidadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ConversionUnidad";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConversionUnidad"+ConversionUnidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConversionUnidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConversionUnidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConversionUnidadConstantesFunciones.SCHEMA+"_"+ConversionUnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConversionUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConversionUnidadConstantesFunciones.SCHEMA+"_"+ConversionUnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConversionUnidadConstantesFunciones.SCHEMA+"_"+ConversionUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConversionUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConversionUnidadConstantesFunciones.SCHEMA+"_"+ConversionUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConversionUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConversionUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConversionUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConversionUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConversionUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConversionUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConversionUnidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConversionUnidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConversionUnidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConversionUnidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Conversion Unidades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Conversion Unidad";
	public static final String SCLASSWEBTITULO_LOWER="Conversion Unidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConversionUnidad";
	public static final String OBJECTNAME="conversionunidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="conversion_unidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select conversionunidad from "+ConversionUnidadConstantesFunciones.SPERSISTENCENAME+" conversionunidad";
	public static String QUERYSELECTNATIVE="select "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".id,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".version_row,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".id_empresa,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".id_unidad_desde,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".id_unidad_hasta,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".valor,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".relacion from "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME;//+" as "+ConversionUnidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ConversionUnidadConstantesFuncionesAdditional conversionunidadConstantesFuncionesAdditional=null;
	
	public ConversionUnidadConstantesFuncionesAdditional getConversionUnidadConstantesFuncionesAdditional() {
		return this.conversionunidadConstantesFuncionesAdditional;
	}
	
	public void setConversionUnidadConstantesFuncionesAdditional(ConversionUnidadConstantesFuncionesAdditional conversionunidadConstantesFuncionesAdditional) {
		try {
			this.conversionunidadConstantesFuncionesAdditional=conversionunidadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDUNIDADDESDE= "id_unidad_desde";
    public static final String IDUNIDADHASTA= "id_unidad_hasta";
    public static final String VALOR= "valor";
    public static final String RELACION= "relacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDUNIDADDESDE= "Unidad Desde";
		public static final String LABEL_IDUNIDADDESDE_LOWER= "Unidad Desde";
    	public static final String LABEL_IDUNIDADHASTA= "Unidad Hasta";
		public static final String LABEL_IDUNIDADHASTA_LOWER= "Unidad Hasta";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_RELACION= "Relacion";
		public static final String LABEL_RELACION_LOWER= "Relacion";
	
		
		
		
		
		
		
		
	
	public static String getConversionUnidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConversionUnidadConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConversionUnidadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConversionUnidadConstantesFunciones.IDUNIDADDESDE)) {sLabelColumna=ConversionUnidadConstantesFunciones.LABEL_IDUNIDADDESDE;}
		if(sNombreColumna.equals(ConversionUnidadConstantesFunciones.IDUNIDADHASTA)) {sLabelColumna=ConversionUnidadConstantesFunciones.LABEL_IDUNIDADHASTA;}
		if(sNombreColumna.equals(ConversionUnidadConstantesFunciones.VALOR)) {sLabelColumna=ConversionUnidadConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ConversionUnidadConstantesFunciones.RELACION)) {sLabelColumna=ConversionUnidadConstantesFunciones.LABEL_RELACION;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getConversionUnidadDescripcion(ConversionUnidad conversionunidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(conversionunidad !=null/* && conversionunidad.getId()!=0*/) {
			if(conversionunidad.getId()!=null) {
				sDescripcion=conversionunidad.getId().toString();
			}//conversionunidadconversionunidad.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getConversionUnidadDescripcionDetallado(ConversionUnidad conversionunidad) {
		String sDescripcion="";
			
		sDescripcion+=ConversionUnidadConstantesFunciones.ID+"=";
		sDescripcion+=conversionunidad.getId().toString()+",";
		sDescripcion+=ConversionUnidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=conversionunidad.getVersionRow().toString()+",";
		sDescripcion+=ConversionUnidadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=conversionunidad.getid_empresa().toString()+",";
		sDescripcion+=ConversionUnidadConstantesFunciones.IDUNIDADDESDE+"=";
		sDescripcion+=conversionunidad.getid_unidad_desde().toString()+",";
		sDescripcion+=ConversionUnidadConstantesFunciones.IDUNIDADHASTA+"=";
		sDescripcion+=conversionunidad.getid_unidad_hasta().toString()+",";
		sDescripcion+=ConversionUnidadConstantesFunciones.VALOR+"=";
		sDescripcion+=conversionunidad.getvalor().toString()+",";
		sDescripcion+=ConversionUnidadConstantesFunciones.RELACION+"=";
		sDescripcion+=conversionunidad.getrelacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setConversionUnidadDescripcion(ConversionUnidad conversionunidad,String sValor) throws Exception {			
		if(conversionunidad !=null) {
			//conversionunidadconversionunidad.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getUnidadDesdeDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}

	public static String getUnidadHastaDescripcion(Unidad unidad) {
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
		} else if(sNombreIndice.equals("FK_IdUnidadDesde")) {
			sNombreIndice="Tipo=  Por Unidad Desde";
		} else if(sNombreIndice.equals("FK_IdUnidadHasta")) {
			sNombreIndice="Tipo=  Por Unidad Hasta";
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

	public static String getDetalleIndiceFK_IdUnidadDesde(Long id_unidad_desde) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad_desde!=null) {sDetalleIndice+=" Codigo Unico De Unidad Desde="+id_unidad_desde.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidadHasta(Long id_unidad_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad_hasta!=null) {sDetalleIndice+=" Codigo Unico De Unidad Hasta="+id_unidad_hasta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConversionUnidad(ConversionUnidad conversionunidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosConversionUnidads(List<ConversionUnidad> conversionunidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConversionUnidad conversionunidad: conversionunidads) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConversionUnidad(ConversionUnidad conversionunidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && conversionunidad.getConCambioAuxiliar()) {
			conversionunidad.setIsDeleted(conversionunidad.getIsDeletedAuxiliar());	
			conversionunidad.setIsNew(conversionunidad.getIsNewAuxiliar());	
			conversionunidad.setIsChanged(conversionunidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			conversionunidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			conversionunidad.setIsDeletedAuxiliar(false);	
			conversionunidad.setIsNewAuxiliar(false);	
			conversionunidad.setIsChangedAuxiliar(false);
			
			conversionunidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConversionUnidads(List<ConversionUnidad> conversionunidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConversionUnidad conversionunidad : conversionunidads) {
			if(conAsignarBase && conversionunidad.getConCambioAuxiliar()) {
				conversionunidad.setIsDeleted(conversionunidad.getIsDeletedAuxiliar());	
				conversionunidad.setIsNew(conversionunidad.getIsNewAuxiliar());	
				conversionunidad.setIsChanged(conversionunidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				conversionunidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				conversionunidad.setIsDeletedAuxiliar(false);	
				conversionunidad.setIsNewAuxiliar(false);	
				conversionunidad.setIsChangedAuxiliar(false);
				
				conversionunidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConversionUnidad(ConversionUnidad conversionunidad,Boolean conEnteros) throws Exception  {
		conversionunidad.setvalor(0.0);
		conversionunidad.setrelacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConversionUnidads(List<ConversionUnidad> conversionunidads,Boolean conEnteros) throws Exception  {
		
		for(ConversionUnidad conversionunidad: conversionunidads) {
			conversionunidad.setvalor(0.0);
			conversionunidad.setrelacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConversionUnidad(List<ConversionUnidad> conversionunidads,ConversionUnidad conversionunidadAux) throws Exception  {
		ConversionUnidadConstantesFunciones.InicializarValoresConversionUnidad(conversionunidadAux,true);
		
		for(ConversionUnidad conversionunidad: conversionunidads) {
			if(conversionunidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			conversionunidadAux.setvalor(conversionunidadAux.getvalor()+conversionunidad.getvalor());			
			conversionunidadAux.setrelacion(conversionunidadAux.getrelacion()+conversionunidad.getrelacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConversionUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConversionUnidadConstantesFunciones.getArrayColumnasGlobalesConversionUnidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConversionUnidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConversionUnidadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConversionUnidadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConversionUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConversionUnidad> conversionunidads,ConversionUnidad conversionunidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConversionUnidad conversionunidadAux: conversionunidads) {
			if(conversionunidadAux!=null && conversionunidad!=null) {
				if((conversionunidadAux.getId()==null && conversionunidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(conversionunidadAux.getId()!=null && conversionunidad.getId()!=null){
					if(conversionunidadAux.getId().equals(conversionunidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConversionUnidad(List<ConversionUnidad> conversionunidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double relacionTotal=0.0;
	
		for(ConversionUnidad conversionunidad: conversionunidads) {			
			if(conversionunidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=conversionunidad.getvalor();
			relacionTotal+=conversionunidad.getrelacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConversionUnidadConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ConversionUnidadConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConversionUnidadConstantesFunciones.RELACION);
		datoGeneral.setsDescripcion(ConversionUnidadConstantesFunciones.LABEL_RELACION);
		datoGeneral.setdValorDouble(relacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConversionUnidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConversionUnidadConstantesFunciones.LABEL_ID, ConversionUnidadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionUnidadConstantesFunciones.LABEL_VERSIONROW, ConversionUnidadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionUnidadConstantesFunciones.LABEL_IDEMPRESA, ConversionUnidadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionUnidadConstantesFunciones.LABEL_IDUNIDADDESDE, ConversionUnidadConstantesFunciones.IDUNIDADDESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionUnidadConstantesFunciones.LABEL_IDUNIDADHASTA, ConversionUnidadConstantesFunciones.IDUNIDADHASTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionUnidadConstantesFunciones.LABEL_VALOR, ConversionUnidadConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConversionUnidadConstantesFunciones.LABEL_RELACION, ConversionUnidadConstantesFunciones.RELACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConversionUnidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConversionUnidadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionUnidadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionUnidadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionUnidadConstantesFunciones.IDUNIDADDESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionUnidadConstantesFunciones.IDUNIDADHASTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionUnidadConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConversionUnidadConstantesFunciones.RELACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConversionUnidad() throws Exception  {
		return ConversionUnidadConstantesFunciones.getTiposSeleccionarConversionUnidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConversionUnidad(Boolean conFk) throws Exception  {
		return ConversionUnidadConstantesFunciones.getTiposSeleccionarConversionUnidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConversionUnidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionUnidadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConversionUnidadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionUnidadConstantesFunciones.LABEL_IDUNIDADDESDE);
			reporte.setsDescripcion(ConversionUnidadConstantesFunciones.LABEL_IDUNIDADDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionUnidadConstantesFunciones.LABEL_IDUNIDADHASTA);
			reporte.setsDescripcion(ConversionUnidadConstantesFunciones.LABEL_IDUNIDADHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionUnidadConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ConversionUnidadConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConversionUnidadConstantesFunciones.LABEL_RELACION);
			reporte.setsDescripcion(ConversionUnidadConstantesFunciones.LABEL_RELACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConversionUnidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConversionUnidad(ConversionUnidad conversionunidadAux) throws Exception {
		
			conversionunidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(conversionunidadAux.getEmpresa()));
			conversionunidadAux.setunidaddesde_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(conversionunidadAux.getUnidadDesde()));
			conversionunidadAux.setunidadhasta_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(conversionunidadAux.getUnidadHasta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConversionUnidad(List<ConversionUnidad> conversionunidadsTemp) throws Exception {
		for(ConversionUnidad conversionunidadAux:conversionunidadsTemp) {
			
			conversionunidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(conversionunidadAux.getEmpresa()));
			conversionunidadAux.setunidaddesde_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(conversionunidadAux.getUnidadDesde()));
			conversionunidadAux.setunidadhasta_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(conversionunidadAux.getUnidadHasta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConversionUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConversionUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConversionUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConversionUnidadConstantesFunciones.getClassesRelationshipsOfConversionUnidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConversionUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConversionUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConversionUnidadConstantesFunciones.getClassesRelationshipsFromStringsOfConversionUnidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConversionUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ConversionUnidad conversionunidad,List<ConversionUnidad> conversionunidads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ConversionUnidad conversionunidadEncontrado=null;
			
			for(ConversionUnidad conversionunidadLocal:conversionunidads) {
				if(conversionunidadLocal.getId().equals(conversionunidad.getId())) {
					conversionunidadEncontrado=conversionunidadLocal;
					
					conversionunidadLocal.setIsChanged(conversionunidad.getIsChanged());
					conversionunidadLocal.setIsNew(conversionunidad.getIsNew());
					conversionunidadLocal.setIsDeleted(conversionunidad.getIsDeleted());
					
					conversionunidadLocal.setGeneralEntityOriginal(conversionunidad.getGeneralEntityOriginal());
					
					conversionunidadLocal.setId(conversionunidad.getId());	
					conversionunidadLocal.setVersionRow(conversionunidad.getVersionRow());	
					conversionunidadLocal.setid_empresa(conversionunidad.getid_empresa());	
					conversionunidadLocal.setid_unidad_desde(conversionunidad.getid_unidad_desde());	
					conversionunidadLocal.setid_unidad_hasta(conversionunidad.getid_unidad_hasta());	
					conversionunidadLocal.setvalor(conversionunidad.getvalor());	
					conversionunidadLocal.setrelacion(conversionunidad.getrelacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!conversionunidad.getIsDeleted()) {
				if(!existe) {
					conversionunidads.add(conversionunidad);
				}
			} else {
				if(conversionunidadEncontrado!=null && permiteQuitar)  {
					conversionunidads.remove(conversionunidadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ConversionUnidad conversionunidad,List<ConversionUnidad> conversionunidads) throws Exception {
		try	{			
			for(ConversionUnidad conversionunidadLocal:conversionunidads) {
				if(conversionunidadLocal.getId().equals(conversionunidad.getId())) {
					conversionunidadLocal.setIsSelected(conversionunidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConversionUnidad(List<ConversionUnidad> conversionunidadsAux) throws Exception {
		//this.conversionunidadsAux=conversionunidadsAux;
		
		for(ConversionUnidad conversionunidadAux:conversionunidadsAux) {
			if(conversionunidadAux.getIsChanged()) {
				conversionunidadAux.setIsChanged(false);
			}		
			
			if(conversionunidadAux.getIsNew()) {
				conversionunidadAux.setIsNew(false);
			}	
			
			if(conversionunidadAux.getIsDeleted()) {
				conversionunidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConversionUnidad(ConversionUnidad conversionunidadAux) throws Exception {
		//this.conversionunidadAux=conversionunidadAux;
		
			if(conversionunidadAux.getIsChanged()) {
				conversionunidadAux.setIsChanged(false);
			}		
			
			if(conversionunidadAux.getIsNew()) {
				conversionunidadAux.setIsNew(false);
			}	
			
			if(conversionunidadAux.getIsDeleted()) {
				conversionunidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConversionUnidad conversionunidadAsignar,ConversionUnidad conversionunidad) throws Exception {
		conversionunidadAsignar.setId(conversionunidad.getId());	
		conversionunidadAsignar.setVersionRow(conversionunidad.getVersionRow());	
		conversionunidadAsignar.setid_empresa(conversionunidad.getid_empresa());
		conversionunidadAsignar.setempresa_descripcion(conversionunidad.getempresa_descripcion());	
		conversionunidadAsignar.setid_unidad_desde(conversionunidad.getid_unidad_desde());
		conversionunidadAsignar.setunidaddesde_descripcion(conversionunidad.getunidaddesde_descripcion());	
		conversionunidadAsignar.setid_unidad_hasta(conversionunidad.getid_unidad_hasta());
		conversionunidadAsignar.setunidadhasta_descripcion(conversionunidad.getunidadhasta_descripcion());	
		conversionunidadAsignar.setvalor(conversionunidad.getvalor());	
		conversionunidadAsignar.setrelacion(conversionunidad.getrelacion());	
	}
	
	public static void inicializarConversionUnidad(ConversionUnidad conversionunidad) throws Exception {
		try {
				conversionunidad.setId(0L);	
					
				conversionunidad.setid_empresa(-1L);	
				conversionunidad.setid_unidad_desde(-1L);	
				conversionunidad.setid_unidad_hasta(-1L);	
				conversionunidad.setvalor(0.0);	
				conversionunidad.setrelacion(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConversionUnidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionUnidadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionUnidadConstantesFunciones.LABEL_IDUNIDADDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionUnidadConstantesFunciones.LABEL_IDUNIDADHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionUnidadConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConversionUnidadConstantesFunciones.LABEL_RELACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConversionUnidad(String sTipo,Row row,Workbook workbook,ConversionUnidad conversionunidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(conversionunidad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conversionunidad.getunidaddesde_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conversionunidad.getunidadhasta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conversionunidad.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conversionunidad.getrelacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConversionUnidad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryConversionUnidad() {
		return this.sFinalQueryConversionUnidad;
	}
	
	public void setsFinalQueryConversionUnidad(String sFinalQueryConversionUnidad) {
		this.sFinalQueryConversionUnidad= sFinalQueryConversionUnidad;
	}
	
	public Border resaltarSeleccionarConversionUnidad=null;
	
	public Border setResaltarSeleccionarConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//conversionunidadBeanSwingJInternalFrame.jTtoolBarConversionUnidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConversionUnidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConversionUnidad() {
		return this.resaltarSeleccionarConversionUnidad;
	}
	
	public void setResaltarSeleccionarConversionUnidad(Border borderResaltarSeleccionarConversionUnidad) {
		this.resaltarSeleccionarConversionUnidad= borderResaltarSeleccionarConversionUnidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConversionUnidad=null;
	public Boolean mostraridConversionUnidad=true;
	public Boolean activaridConversionUnidad=true;

	public Border resaltarid_empresaConversionUnidad=null;
	public Boolean mostrarid_empresaConversionUnidad=true;
	public Boolean activarid_empresaConversionUnidad=true;
	public Boolean cargarid_empresaConversionUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConversionUnidad=false;//ConEventDepend=true

	public Border resaltarid_unidad_desdeConversionUnidad=null;
	public Boolean mostrarid_unidad_desdeConversionUnidad=true;
	public Boolean activarid_unidad_desdeConversionUnidad=true;
	public Boolean cargarid_unidad_desdeConversionUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidad_desdeConversionUnidad=false;//ConEventDepend=true

	public Border resaltarid_unidad_hastaConversionUnidad=null;
	public Boolean mostrarid_unidad_hastaConversionUnidad=true;
	public Boolean activarid_unidad_hastaConversionUnidad=true;
	public Boolean cargarid_unidad_hastaConversionUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidad_hastaConversionUnidad=false;//ConEventDepend=true

	public Border resaltarvalorConversionUnidad=null;
	public Boolean mostrarvalorConversionUnidad=true;
	public Boolean activarvalorConversionUnidad=true;

	public Border resaltarrelacionConversionUnidad=null;
	public Boolean mostrarrelacionConversionUnidad=true;
	public Boolean activarrelacionConversionUnidad=true;

	
	

	public Border setResaltaridConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversionunidadBeanSwingJInternalFrame.jTtoolBarConversionUnidad.setBorder(borderResaltar);
		
		this.resaltaridConversionUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConversionUnidad() {
		return this.resaltaridConversionUnidad;
	}

	public void setResaltaridConversionUnidad(Border borderResaltar) {
		this.resaltaridConversionUnidad= borderResaltar;
	}

	public Boolean getMostraridConversionUnidad() {
		return this.mostraridConversionUnidad;
	}

	public void setMostraridConversionUnidad(Boolean mostraridConversionUnidad) {
		this.mostraridConversionUnidad= mostraridConversionUnidad;
	}

	public Boolean getActivaridConversionUnidad() {
		return this.activaridConversionUnidad;
	}

	public void setActivaridConversionUnidad(Boolean activaridConversionUnidad) {
		this.activaridConversionUnidad= activaridConversionUnidad;
	}

	public Border setResaltarid_empresaConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversionunidadBeanSwingJInternalFrame.jTtoolBarConversionUnidad.setBorder(borderResaltar);
		
		this.resaltarid_empresaConversionUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConversionUnidad() {
		return this.resaltarid_empresaConversionUnidad;
	}

	public void setResaltarid_empresaConversionUnidad(Border borderResaltar) {
		this.resaltarid_empresaConversionUnidad= borderResaltar;
	}

	public Boolean getMostrarid_empresaConversionUnidad() {
		return this.mostrarid_empresaConversionUnidad;
	}

	public void setMostrarid_empresaConversionUnidad(Boolean mostrarid_empresaConversionUnidad) {
		this.mostrarid_empresaConversionUnidad= mostrarid_empresaConversionUnidad;
	}

	public Boolean getActivarid_empresaConversionUnidad() {
		return this.activarid_empresaConversionUnidad;
	}

	public void setActivarid_empresaConversionUnidad(Boolean activarid_empresaConversionUnidad) {
		this.activarid_empresaConversionUnidad= activarid_empresaConversionUnidad;
	}

	public Boolean getCargarid_empresaConversionUnidad() {
		return this.cargarid_empresaConversionUnidad;
	}

	public void setCargarid_empresaConversionUnidad(Boolean cargarid_empresaConversionUnidad) {
		this.cargarid_empresaConversionUnidad= cargarid_empresaConversionUnidad;
	}

	public Border setResaltarid_unidad_desdeConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversionunidadBeanSwingJInternalFrame.jTtoolBarConversionUnidad.setBorder(borderResaltar);
		
		this.resaltarid_unidad_desdeConversionUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidad_desdeConversionUnidad() {
		return this.resaltarid_unidad_desdeConversionUnidad;
	}

	public void setResaltarid_unidad_desdeConversionUnidad(Border borderResaltar) {
		this.resaltarid_unidad_desdeConversionUnidad= borderResaltar;
	}

	public Boolean getMostrarid_unidad_desdeConversionUnidad() {
		return this.mostrarid_unidad_desdeConversionUnidad;
	}

	public void setMostrarid_unidad_desdeConversionUnidad(Boolean mostrarid_unidad_desdeConversionUnidad) {
		this.mostrarid_unidad_desdeConversionUnidad= mostrarid_unidad_desdeConversionUnidad;
	}

	public Boolean getActivarid_unidad_desdeConversionUnidad() {
		return this.activarid_unidad_desdeConversionUnidad;
	}

	public void setActivarid_unidad_desdeConversionUnidad(Boolean activarid_unidad_desdeConversionUnidad) {
		this.activarid_unidad_desdeConversionUnidad= activarid_unidad_desdeConversionUnidad;
	}

	public Boolean getCargarid_unidad_desdeConversionUnidad() {
		return this.cargarid_unidad_desdeConversionUnidad;
	}

	public void setCargarid_unidad_desdeConversionUnidad(Boolean cargarid_unidad_desdeConversionUnidad) {
		this.cargarid_unidad_desdeConversionUnidad= cargarid_unidad_desdeConversionUnidad;
	}

	public Border setResaltarid_unidad_hastaConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversionunidadBeanSwingJInternalFrame.jTtoolBarConversionUnidad.setBorder(borderResaltar);
		
		this.resaltarid_unidad_hastaConversionUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidad_hastaConversionUnidad() {
		return this.resaltarid_unidad_hastaConversionUnidad;
	}

	public void setResaltarid_unidad_hastaConversionUnidad(Border borderResaltar) {
		this.resaltarid_unidad_hastaConversionUnidad= borderResaltar;
	}

	public Boolean getMostrarid_unidad_hastaConversionUnidad() {
		return this.mostrarid_unidad_hastaConversionUnidad;
	}

	public void setMostrarid_unidad_hastaConversionUnidad(Boolean mostrarid_unidad_hastaConversionUnidad) {
		this.mostrarid_unidad_hastaConversionUnidad= mostrarid_unidad_hastaConversionUnidad;
	}

	public Boolean getActivarid_unidad_hastaConversionUnidad() {
		return this.activarid_unidad_hastaConversionUnidad;
	}

	public void setActivarid_unidad_hastaConversionUnidad(Boolean activarid_unidad_hastaConversionUnidad) {
		this.activarid_unidad_hastaConversionUnidad= activarid_unidad_hastaConversionUnidad;
	}

	public Boolean getCargarid_unidad_hastaConversionUnidad() {
		return this.cargarid_unidad_hastaConversionUnidad;
	}

	public void setCargarid_unidad_hastaConversionUnidad(Boolean cargarid_unidad_hastaConversionUnidad) {
		this.cargarid_unidad_hastaConversionUnidad= cargarid_unidad_hastaConversionUnidad;
	}

	public Border setResaltarvalorConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversionunidadBeanSwingJInternalFrame.jTtoolBarConversionUnidad.setBorder(borderResaltar);
		
		this.resaltarvalorConversionUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorConversionUnidad() {
		return this.resaltarvalorConversionUnidad;
	}

	public void setResaltarvalorConversionUnidad(Border borderResaltar) {
		this.resaltarvalorConversionUnidad= borderResaltar;
	}

	public Boolean getMostrarvalorConversionUnidad() {
		return this.mostrarvalorConversionUnidad;
	}

	public void setMostrarvalorConversionUnidad(Boolean mostrarvalorConversionUnidad) {
		this.mostrarvalorConversionUnidad= mostrarvalorConversionUnidad;
	}

	public Boolean getActivarvalorConversionUnidad() {
		return this.activarvalorConversionUnidad;
	}

	public void setActivarvalorConversionUnidad(Boolean activarvalorConversionUnidad) {
		this.activarvalorConversionUnidad= activarvalorConversionUnidad;
	}

	public Border setResaltarrelacionConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conversionunidadBeanSwingJInternalFrame.jTtoolBarConversionUnidad.setBorder(borderResaltar);
		
		this.resaltarrelacionConversionUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrelacionConversionUnidad() {
		return this.resaltarrelacionConversionUnidad;
	}

	public void setResaltarrelacionConversionUnidad(Border borderResaltar) {
		this.resaltarrelacionConversionUnidad= borderResaltar;
	}

	public Boolean getMostrarrelacionConversionUnidad() {
		return this.mostrarrelacionConversionUnidad;
	}

	public void setMostrarrelacionConversionUnidad(Boolean mostrarrelacionConversionUnidad) {
		this.mostrarrelacionConversionUnidad= mostrarrelacionConversionUnidad;
	}

	public Boolean getActivarrelacionConversionUnidad() {
		return this.activarrelacionConversionUnidad;
	}

	public void setActivarrelacionConversionUnidad(Boolean activarrelacionConversionUnidad) {
		this.activarrelacionConversionUnidad= activarrelacionConversionUnidad;
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
		
		
		this.setMostraridConversionUnidad(esInicial);
		this.setMostrarid_empresaConversionUnidad(esInicial);
		this.setMostrarid_unidad_desdeConversionUnidad(esInicial);
		this.setMostrarid_unidad_hastaConversionUnidad(esInicial);
		this.setMostrarvalorConversionUnidad(esInicial);
		this.setMostrarrelacionConversionUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.ID)) {
				this.setMostraridConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.IDUNIDADDESDE)) {
				this.setMostrarid_unidad_desdeConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.IDUNIDADHASTA)) {
				this.setMostrarid_unidad_hastaConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.VALOR)) {
				this.setMostrarvalorConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.RELACION)) {
				this.setMostrarrelacionConversionUnidad(esAsigna);
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
		
		
		this.setActivaridConversionUnidad(esInicial);
		this.setActivarid_empresaConversionUnidad(esInicial);
		this.setActivarid_unidad_desdeConversionUnidad(esInicial);
		this.setActivarid_unidad_hastaConversionUnidad(esInicial);
		this.setActivarvalorConversionUnidad(esInicial);
		this.setActivarrelacionConversionUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.ID)) {
				this.setActivaridConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.IDUNIDADDESDE)) {
				this.setActivarid_unidad_desdeConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.IDUNIDADHASTA)) {
				this.setActivarid_unidad_hastaConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.VALOR)) {
				this.setActivarvalorConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.RELACION)) {
				this.setActivarrelacionConversionUnidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConversionUnidad(esInicial);
		this.setResaltarid_empresaConversionUnidad(esInicial);
		this.setResaltarid_unidad_desdeConversionUnidad(esInicial);
		this.setResaltarid_unidad_hastaConversionUnidad(esInicial);
		this.setResaltarvalorConversionUnidad(esInicial);
		this.setResaltarrelacionConversionUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.ID)) {
				this.setResaltaridConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.IDUNIDADDESDE)) {
				this.setResaltarid_unidad_desdeConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.IDUNIDADHASTA)) {
				this.setResaltarid_unidad_hastaConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.VALOR)) {
				this.setResaltarvalorConversionUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConversionUnidadConstantesFunciones.RELACION)) {
				this.setResaltarrelacionConversionUnidad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaConversionUnidad=true;

	public Boolean getMostrarFK_IdEmpresaConversionUnidad() {
		return this.mostrarFK_IdEmpresaConversionUnidad;
	}

	public void setMostrarFK_IdEmpresaConversionUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaConversionUnidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDesdeConversionUnidad=true;

	public Boolean getMostrarFK_IdUnidadDesdeConversionUnidad() {
		return this.mostrarFK_IdUnidadDesdeConversionUnidad;
	}

	public void setMostrarFK_IdUnidadDesdeConversionUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDesdeConversionUnidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadHastaConversionUnidad=true;

	public Boolean getMostrarFK_IdUnidadHastaConversionUnidad() {
		return this.mostrarFK_IdUnidadHastaConversionUnidad;
	}

	public void setMostrarFK_IdUnidadHastaConversionUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadHastaConversionUnidad= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaConversionUnidad=true;

	public Boolean getActivarFK_IdEmpresaConversionUnidad() {
		return this.activarFK_IdEmpresaConversionUnidad;
	}

	public void setActivarFK_IdEmpresaConversionUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaConversionUnidad= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDesdeConversionUnidad=true;

	public Boolean getActivarFK_IdUnidadDesdeConversionUnidad() {
		return this.activarFK_IdUnidadDesdeConversionUnidad;
	}

	public void setActivarFK_IdUnidadDesdeConversionUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDesdeConversionUnidad= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadHastaConversionUnidad=true;

	public Boolean getActivarFK_IdUnidadHastaConversionUnidad() {
		return this.activarFK_IdUnidadHastaConversionUnidad;
	}

	public void setActivarFK_IdUnidadHastaConversionUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadHastaConversionUnidad= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaConversionUnidad=null;

	public Border getResaltarFK_IdEmpresaConversionUnidad() {
		return this.resaltarFK_IdEmpresaConversionUnidad;
	}

	public void setResaltarFK_IdEmpresaConversionUnidad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaConversionUnidad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaConversionUnidad= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDesdeConversionUnidad=null;

	public Border getResaltarFK_IdUnidadDesdeConversionUnidad() {
		return this.resaltarFK_IdUnidadDesdeConversionUnidad;
	}

	public void setResaltarFK_IdUnidadDesdeConversionUnidad(Border borderResaltar) {
		this.resaltarFK_IdUnidadDesdeConversionUnidad= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDesdeConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDesdeConversionUnidad= borderResaltar;
	}

	public Border resaltarFK_IdUnidadHastaConversionUnidad=null;

	public Border getResaltarFK_IdUnidadHastaConversionUnidad() {
		return this.resaltarFK_IdUnidadHastaConversionUnidad;
	}

	public void setResaltarFK_IdUnidadHastaConversionUnidad(Border borderResaltar) {
		this.resaltarFK_IdUnidadHastaConversionUnidad= borderResaltar;
	}

	public void setResaltarFK_IdUnidadHastaConversionUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ConversionUnidadBeanSwingJInternalFrame conversionunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadHastaConversionUnidad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}