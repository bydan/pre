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


import com.bydan.erp.activosfijos.util.FormatoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.FormatoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.FormatoActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormatoActivoFijoConstantesFunciones extends FormatoActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FormatoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormatoActivoFijo"+FormatoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormatoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormatoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormatoActivoFijoConstantesFunciones.SCHEMA+"_"+FormatoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormatoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormatoActivoFijoConstantesFunciones.SCHEMA+"_"+FormatoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormatoActivoFijoConstantesFunciones.SCHEMA+"_"+FormatoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormatoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormatoActivoFijoConstantesFunciones.SCHEMA+"_"+FormatoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormatoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormatoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormatoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormatoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formatoss";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Formatos";
	public static final String SCLASSWEBTITULO_LOWER="Formato Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormatoActivoFijo";
	public static final String OBJECTNAME="formatoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="formato_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formatoactivofijo from "+FormatoActivoFijoConstantesFunciones.SPERSISTENCENAME+" formatoactivofijo";
	public static String QUERYSELECTNATIVE="select "+FormatoActivoFijoConstantesFunciones.SCHEMA+"."+FormatoActivoFijoConstantesFunciones.TABLENAME+".id,"+FormatoActivoFijoConstantesFunciones.SCHEMA+"."+FormatoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+FormatoActivoFijoConstantesFunciones.SCHEMA+"."+FormatoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+FormatoActivoFijoConstantesFunciones.SCHEMA+"."+FormatoActivoFijoConstantesFunciones.TABLENAME+".id_formato,"+FormatoActivoFijoConstantesFunciones.SCHEMA+"."+FormatoActivoFijoConstantesFunciones.TABLENAME+".id_formato2 from "+FormatoActivoFijoConstantesFunciones.SCHEMA+"."+FormatoActivoFijoConstantesFunciones.TABLENAME;//+" as "+FormatoActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormatoActivoFijoConstantesFuncionesAdditional formatoactivofijoConstantesFuncionesAdditional=null;
	
	public FormatoActivoFijoConstantesFuncionesAdditional getFormatoActivoFijoConstantesFuncionesAdditional() {
		return this.formatoactivofijoConstantesFuncionesAdditional;
	}
	
	public void setFormatoActivoFijoConstantesFuncionesAdditional(FormatoActivoFijoConstantesFuncionesAdditional formatoactivofijoConstantesFuncionesAdditional) {
		try {
			this.formatoactivofijoConstantesFuncionesAdditional=formatoactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDFORMATO= "id_formato";
    public static final String IDFORMATO2= "id_formato2";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDFORMATO2= "Formato2";
		public static final String LABEL_IDFORMATO2_LOWER= "Formato2";
	
		
		
		
		
		
	
	public static String getFormatoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormatoActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormatoActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormatoActivoFijoConstantesFunciones.IDFORMATO)) {sLabelColumna=FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(FormatoActivoFijoConstantesFunciones.IDFORMATO2)) {sLabelColumna=FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO2;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getFormatoActivoFijoDescripcion(FormatoActivoFijo formatoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formatoactivofijo !=null/* && formatoactivofijo.getId()!=0*/) {
			if(formatoactivofijo.getId()!=null) {
				sDescripcion=formatoactivofijo.getId().toString();
			}//formatoactivofijoformatoactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFormatoActivoFijoDescripcionDetallado(FormatoActivoFijo formatoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=FormatoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=formatoactivofijo.getId().toString()+",";
		sDescripcion+=FormatoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formatoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=FormatoActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formatoactivofijo.getid_empresa().toString()+",";
		sDescripcion+=FormatoActivoFijoConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=formatoactivofijo.getid_formato().toString()+",";
		sDescripcion+=FormatoActivoFijoConstantesFunciones.IDFORMATO2+"=";
		sDescripcion+=formatoactivofijo.getid_formato2().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormatoActivoFijoDescripcion(FormatoActivoFijo formatoactivofijo,String sValor) throws Exception {			
		if(formatoactivofijo !=null) {
			//formatoactivofijoformatoactivofijo.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormato2Descripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
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
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdFormato2")) {
			sNombreIndice="Tipo=  Por Formato2";
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

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato2(Long id_formato2) {
		String sDetalleIndice=" Parametros->";
		if(id_formato2!=null) {sDetalleIndice+=" Codigo Unico De Formato2="+id_formato2.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormatoActivoFijo(FormatoActivoFijo formatoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosFormatoActivoFijos(List<FormatoActivoFijo> formatoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormatoActivoFijo formatoactivofijo: formatoactivofijos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormatoActivoFijo(FormatoActivoFijo formatoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formatoactivofijo.getConCambioAuxiliar()) {
			formatoactivofijo.setIsDeleted(formatoactivofijo.getIsDeletedAuxiliar());	
			formatoactivofijo.setIsNew(formatoactivofijo.getIsNewAuxiliar());	
			formatoactivofijo.setIsChanged(formatoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formatoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formatoactivofijo.setIsDeletedAuxiliar(false);	
			formatoactivofijo.setIsNewAuxiliar(false);	
			formatoactivofijo.setIsChangedAuxiliar(false);
			
			formatoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormatoActivoFijos(List<FormatoActivoFijo> formatoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormatoActivoFijo formatoactivofijo : formatoactivofijos) {
			if(conAsignarBase && formatoactivofijo.getConCambioAuxiliar()) {
				formatoactivofijo.setIsDeleted(formatoactivofijo.getIsDeletedAuxiliar());	
				formatoactivofijo.setIsNew(formatoactivofijo.getIsNewAuxiliar());	
				formatoactivofijo.setIsChanged(formatoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formatoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formatoactivofijo.setIsDeletedAuxiliar(false);	
				formatoactivofijo.setIsNewAuxiliar(false);	
				formatoactivofijo.setIsChangedAuxiliar(false);
				
				formatoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormatoActivoFijo(FormatoActivoFijo formatoactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormatoActivoFijos(List<FormatoActivoFijo> formatoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(FormatoActivoFijo formatoactivofijo: formatoactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormatoActivoFijo(List<FormatoActivoFijo> formatoactivofijos,FormatoActivoFijo formatoactivofijoAux) throws Exception  {
		FormatoActivoFijoConstantesFunciones.InicializarValoresFormatoActivoFijo(formatoactivofijoAux,true);
		
		for(FormatoActivoFijo formatoactivofijo: formatoactivofijos) {
			if(formatoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormatoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormatoActivoFijoConstantesFunciones.getArrayColumnasGlobalesFormatoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormatoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormatoActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormatoActivoFijoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormatoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormatoActivoFijo> formatoactivofijos,FormatoActivoFijo formatoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormatoActivoFijo formatoactivofijoAux: formatoactivofijos) {
			if(formatoactivofijoAux!=null && formatoactivofijo!=null) {
				if((formatoactivofijoAux.getId()==null && formatoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formatoactivofijoAux.getId()!=null && formatoactivofijo.getId()!=null){
					if(formatoactivofijoAux.getId().equals(formatoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormatoActivoFijo(List<FormatoActivoFijo> formatoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(FormatoActivoFijo formatoactivofijo: formatoactivofijos) {			
			if(formatoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormatoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormatoActivoFijoConstantesFunciones.LABEL_ID, FormatoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoActivoFijoConstantesFunciones.LABEL_VERSIONROW, FormatoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoActivoFijoConstantesFunciones.LABEL_IDEMPRESA, FormatoActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO, FormatoActivoFijoConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO2, FormatoActivoFijoConstantesFunciones.IDFORMATO2,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormatoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormatoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoActivoFijoConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoActivoFijoConstantesFunciones.IDFORMATO2;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoActivoFijo() throws Exception  {
		return FormatoActivoFijoConstantesFunciones.getTiposSeleccionarFormatoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoActivoFijo(Boolean conFk) throws Exception  {
		return FormatoActivoFijoConstantesFunciones.getTiposSeleccionarFormatoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormatoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO2);
			reporte.setsDescripcion(FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormatoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormatoActivoFijo(FormatoActivoFijo formatoactivofijoAux) throws Exception {
		
			formatoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatoactivofijoAux.getEmpresa()));
			formatoactivofijoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(formatoactivofijoAux.getFormato()));
			formatoactivofijoAux.setformato2_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(formatoactivofijoAux.getFormato2()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormatoActivoFijo(List<FormatoActivoFijo> formatoactivofijosTemp) throws Exception {
		for(FormatoActivoFijo formatoactivofijoAux:formatoactivofijosTemp) {
			
			formatoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatoactivofijoAux.getEmpresa()));
			formatoactivofijoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(formatoactivofijoAux.getFormato()));
			formatoactivofijoAux.setformato2_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(formatoactivofijoAux.getFormato2()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormatoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormatoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoActivoFijoConstantesFunciones.getClassesRelationshipsOfFormatoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormatoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfFormatoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormatoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FormatoActivoFijo formatoactivofijo,List<FormatoActivoFijo> formatoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormatoActivoFijo formatoactivofijoEncontrado=null;
			
			for(FormatoActivoFijo formatoactivofijoLocal:formatoactivofijos) {
				if(formatoactivofijoLocal.getId().equals(formatoactivofijo.getId())) {
					formatoactivofijoEncontrado=formatoactivofijoLocal;
					
					formatoactivofijoLocal.setIsChanged(formatoactivofijo.getIsChanged());
					formatoactivofijoLocal.setIsNew(formatoactivofijo.getIsNew());
					formatoactivofijoLocal.setIsDeleted(formatoactivofijo.getIsDeleted());
					
					formatoactivofijoLocal.setGeneralEntityOriginal(formatoactivofijo.getGeneralEntityOriginal());
					
					formatoactivofijoLocal.setId(formatoactivofijo.getId());	
					formatoactivofijoLocal.setVersionRow(formatoactivofijo.getVersionRow());	
					formatoactivofijoLocal.setid_empresa(formatoactivofijo.getid_empresa());	
					formatoactivofijoLocal.setid_formato(formatoactivofijo.getid_formato());	
					formatoactivofijoLocal.setid_formato2(formatoactivofijo.getid_formato2());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!formatoactivofijo.getIsDeleted()) {
				if(!existe) {
					formatoactivofijos.add(formatoactivofijo);
				}
			} else {
				if(formatoactivofijoEncontrado!=null && permiteQuitar)  {
					formatoactivofijos.remove(formatoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormatoActivoFijo formatoactivofijo,List<FormatoActivoFijo> formatoactivofijos) throws Exception {
		try	{			
			for(FormatoActivoFijo formatoactivofijoLocal:formatoactivofijos) {
				if(formatoactivofijoLocal.getId().equals(formatoactivofijo.getId())) {
					formatoactivofijoLocal.setIsSelected(formatoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormatoActivoFijo(List<FormatoActivoFijo> formatoactivofijosAux) throws Exception {
		//this.formatoactivofijosAux=formatoactivofijosAux;
		
		for(FormatoActivoFijo formatoactivofijoAux:formatoactivofijosAux) {
			if(formatoactivofijoAux.getIsChanged()) {
				formatoactivofijoAux.setIsChanged(false);
			}		
			
			if(formatoactivofijoAux.getIsNew()) {
				formatoactivofijoAux.setIsNew(false);
			}	
			
			if(formatoactivofijoAux.getIsDeleted()) {
				formatoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormatoActivoFijo(FormatoActivoFijo formatoactivofijoAux) throws Exception {
		//this.formatoactivofijoAux=formatoactivofijoAux;
		
			if(formatoactivofijoAux.getIsChanged()) {
				formatoactivofijoAux.setIsChanged(false);
			}		
			
			if(formatoactivofijoAux.getIsNew()) {
				formatoactivofijoAux.setIsNew(false);
			}	
			
			if(formatoactivofijoAux.getIsDeleted()) {
				formatoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormatoActivoFijo formatoactivofijoAsignar,FormatoActivoFijo formatoactivofijo) throws Exception {
		formatoactivofijoAsignar.setId(formatoactivofijo.getId());	
		formatoactivofijoAsignar.setVersionRow(formatoactivofijo.getVersionRow());	
		formatoactivofijoAsignar.setid_empresa(formatoactivofijo.getid_empresa());
		formatoactivofijoAsignar.setempresa_descripcion(formatoactivofijo.getempresa_descripcion());	
		formatoactivofijoAsignar.setid_formato(formatoactivofijo.getid_formato());
		formatoactivofijoAsignar.setformato_descripcion(formatoactivofijo.getformato_descripcion());	
		formatoactivofijoAsignar.setid_formato2(formatoactivofijo.getid_formato2());
		formatoactivofijoAsignar.setformato2_descripcion(formatoactivofijo.getformato2_descripcion());	
	}
	
	public static void inicializarFormatoActivoFijo(FormatoActivoFijo formatoactivofijo) throws Exception {
		try {
				formatoactivofijo.setId(0L);	
					
				formatoactivofijo.setid_empresa(-1L);	
				formatoactivofijo.setid_formato(-1L);	
				formatoactivofijo.setid_formato2(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormatoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoActivoFijoConstantesFunciones.LABEL_IDFORMATO2);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormatoActivoFijo(String sTipo,Row row,Workbook workbook,FormatoActivoFijo formatoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formatoactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatoactivofijo.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatoactivofijo.getformato2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormatoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormatoActivoFijo() {
		return this.sFinalQueryFormatoActivoFijo;
	}
	
	public void setsFinalQueryFormatoActivoFijo(String sFinalQueryFormatoActivoFijo) {
		this.sFinalQueryFormatoActivoFijo= sFinalQueryFormatoActivoFijo;
	}
	
	public Border resaltarSeleccionarFormatoActivoFijo=null;
	
	public Border setResaltarSeleccionarFormatoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoActivoFijoBeanSwingJInternalFrame formatoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formatoactivofijoBeanSwingJInternalFrame.jTtoolBarFormatoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormatoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormatoActivoFijo() {
		return this.resaltarSeleccionarFormatoActivoFijo;
	}
	
	public void setResaltarSeleccionarFormatoActivoFijo(Border borderResaltarSeleccionarFormatoActivoFijo) {
		this.resaltarSeleccionarFormatoActivoFijo= borderResaltarSeleccionarFormatoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormatoActivoFijo=null;
	public Boolean mostraridFormatoActivoFijo=true;
	public Boolean activaridFormatoActivoFijo=true;

	public Border resaltarid_empresaFormatoActivoFijo=null;
	public Boolean mostrarid_empresaFormatoActivoFijo=true;
	public Boolean activarid_empresaFormatoActivoFijo=true;
	public Boolean cargarid_empresaFormatoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormatoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_formatoFormatoActivoFijo=null;
	public Boolean mostrarid_formatoFormatoActivoFijo=true;
	public Boolean activarid_formatoFormatoActivoFijo=true;
	public Boolean cargarid_formatoFormatoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoFormatoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_formato2FormatoActivoFijo=null;
	public Boolean mostrarid_formato2FormatoActivoFijo=true;
	public Boolean activarid_formato2FormatoActivoFijo=true;
	public Boolean cargarid_formato2FormatoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato2FormatoActivoFijo=false;//ConEventDepend=true

	
	

	public Border setResaltaridFormatoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoActivoFijoBeanSwingJInternalFrame formatoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoactivofijoBeanSwingJInternalFrame.jTtoolBarFormatoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridFormatoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormatoActivoFijo() {
		return this.resaltaridFormatoActivoFijo;
	}

	public void setResaltaridFormatoActivoFijo(Border borderResaltar) {
		this.resaltaridFormatoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridFormatoActivoFijo() {
		return this.mostraridFormatoActivoFijo;
	}

	public void setMostraridFormatoActivoFijo(Boolean mostraridFormatoActivoFijo) {
		this.mostraridFormatoActivoFijo= mostraridFormatoActivoFijo;
	}

	public Boolean getActivaridFormatoActivoFijo() {
		return this.activaridFormatoActivoFijo;
	}

	public void setActivaridFormatoActivoFijo(Boolean activaridFormatoActivoFijo) {
		this.activaridFormatoActivoFijo= activaridFormatoActivoFijo;
	}

	public Border setResaltarid_empresaFormatoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoActivoFijoBeanSwingJInternalFrame formatoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoactivofijoBeanSwingJInternalFrame.jTtoolBarFormatoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormatoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormatoActivoFijo() {
		return this.resaltarid_empresaFormatoActivoFijo;
	}

	public void setResaltarid_empresaFormatoActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaFormatoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormatoActivoFijo() {
		return this.mostrarid_empresaFormatoActivoFijo;
	}

	public void setMostrarid_empresaFormatoActivoFijo(Boolean mostrarid_empresaFormatoActivoFijo) {
		this.mostrarid_empresaFormatoActivoFijo= mostrarid_empresaFormatoActivoFijo;
	}

	public Boolean getActivarid_empresaFormatoActivoFijo() {
		return this.activarid_empresaFormatoActivoFijo;
	}

	public void setActivarid_empresaFormatoActivoFijo(Boolean activarid_empresaFormatoActivoFijo) {
		this.activarid_empresaFormatoActivoFijo= activarid_empresaFormatoActivoFijo;
	}

	public Boolean getCargarid_empresaFormatoActivoFijo() {
		return this.cargarid_empresaFormatoActivoFijo;
	}

	public void setCargarid_empresaFormatoActivoFijo(Boolean cargarid_empresaFormatoActivoFijo) {
		this.cargarid_empresaFormatoActivoFijo= cargarid_empresaFormatoActivoFijo;
	}

	public Border setResaltarid_formatoFormatoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoActivoFijoBeanSwingJInternalFrame formatoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoactivofijoBeanSwingJInternalFrame.jTtoolBarFormatoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_formatoFormatoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoFormatoActivoFijo() {
		return this.resaltarid_formatoFormatoActivoFijo;
	}

	public void setResaltarid_formatoFormatoActivoFijo(Border borderResaltar) {
		this.resaltarid_formatoFormatoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_formatoFormatoActivoFijo() {
		return this.mostrarid_formatoFormatoActivoFijo;
	}

	public void setMostrarid_formatoFormatoActivoFijo(Boolean mostrarid_formatoFormatoActivoFijo) {
		this.mostrarid_formatoFormatoActivoFijo= mostrarid_formatoFormatoActivoFijo;
	}

	public Boolean getActivarid_formatoFormatoActivoFijo() {
		return this.activarid_formatoFormatoActivoFijo;
	}

	public void setActivarid_formatoFormatoActivoFijo(Boolean activarid_formatoFormatoActivoFijo) {
		this.activarid_formatoFormatoActivoFijo= activarid_formatoFormatoActivoFijo;
	}

	public Boolean getCargarid_formatoFormatoActivoFijo() {
		return this.cargarid_formatoFormatoActivoFijo;
	}

	public void setCargarid_formatoFormatoActivoFijo(Boolean cargarid_formatoFormatoActivoFijo) {
		this.cargarid_formatoFormatoActivoFijo= cargarid_formatoFormatoActivoFijo;
	}

	public Border setResaltarid_formato2FormatoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoActivoFijoBeanSwingJInternalFrame formatoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoactivofijoBeanSwingJInternalFrame.jTtoolBarFormatoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_formato2FormatoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato2FormatoActivoFijo() {
		return this.resaltarid_formato2FormatoActivoFijo;
	}

	public void setResaltarid_formato2FormatoActivoFijo(Border borderResaltar) {
		this.resaltarid_formato2FormatoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_formato2FormatoActivoFijo() {
		return this.mostrarid_formato2FormatoActivoFijo;
	}

	public void setMostrarid_formato2FormatoActivoFijo(Boolean mostrarid_formato2FormatoActivoFijo) {
		this.mostrarid_formato2FormatoActivoFijo= mostrarid_formato2FormatoActivoFijo;
	}

	public Boolean getActivarid_formato2FormatoActivoFijo() {
		return this.activarid_formato2FormatoActivoFijo;
	}

	public void setActivarid_formato2FormatoActivoFijo(Boolean activarid_formato2FormatoActivoFijo) {
		this.activarid_formato2FormatoActivoFijo= activarid_formato2FormatoActivoFijo;
	}

	public Boolean getCargarid_formato2FormatoActivoFijo() {
		return this.cargarid_formato2FormatoActivoFijo;
	}

	public void setCargarid_formato2FormatoActivoFijo(Boolean cargarid_formato2FormatoActivoFijo) {
		this.cargarid_formato2FormatoActivoFijo= cargarid_formato2FormatoActivoFijo;
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
		
		
		this.setMostraridFormatoActivoFijo(esInicial);
		this.setMostrarid_empresaFormatoActivoFijo(esInicial);
		this.setMostrarid_formatoFormatoActivoFijo(esInicial);
		this.setMostrarid_formato2FormatoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridFormatoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormatoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoFormatoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.IDFORMATO2)) {
				this.setMostrarid_formato2FormatoActivoFijo(esAsigna);
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
		
		
		this.setActivaridFormatoActivoFijo(esInicial);
		this.setActivarid_empresaFormatoActivoFijo(esInicial);
		this.setActivarid_formatoFormatoActivoFijo(esInicial);
		this.setActivarid_formato2FormatoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridFormatoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormatoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoFormatoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.IDFORMATO2)) {
				this.setActivarid_formato2FormatoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoActivoFijoBeanSwingJInternalFrame formatoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormatoActivoFijo(esInicial);
		this.setResaltarid_empresaFormatoActivoFijo(esInicial);
		this.setResaltarid_formatoFormatoActivoFijo(esInicial);
		this.setResaltarid_formato2FormatoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridFormatoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormatoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoFormatoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoActivoFijoConstantesFunciones.IDFORMATO2)) {
				this.setResaltarid_formato2FormatoActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoActivoFijoBeanSwingJInternalFrame formatoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaFormatoActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaFormatoActivoFijo() {
		return this.mostrarFK_IdEmpresaFormatoActivoFijo;
	}

	public void setMostrarFK_IdEmpresaFormatoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormatoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaFormatoActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaFormatoActivoFijo() {
		return this.activarFK_IdEmpresaFormatoActivoFijo;
	}

	public void setActivarFK_IdEmpresaFormatoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormatoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaFormatoActivoFijo=null;

	public Border getResaltarFK_IdEmpresaFormatoActivoFijo() {
		return this.resaltarFK_IdEmpresaFormatoActivoFijo;
	}

	public void setResaltarFK_IdEmpresaFormatoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormatoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormatoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoActivoFijoBeanSwingJInternalFrame formatoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormatoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}