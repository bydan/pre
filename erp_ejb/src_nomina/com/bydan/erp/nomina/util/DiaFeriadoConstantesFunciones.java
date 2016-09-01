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


import com.bydan.erp.nomina.util.DiaFeriadoConstantesFunciones;
import com.bydan.erp.nomina.util.DiaFeriadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DiaFeriadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DiaFeriadoConstantesFunciones extends DiaFeriadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DiaFeriado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DiaFeriado"+DiaFeriadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DiaFeriadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DiaFeriadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DiaFeriadoConstantesFunciones.SCHEMA+"_"+DiaFeriadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DiaFeriadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DiaFeriadoConstantesFunciones.SCHEMA+"_"+DiaFeriadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DiaFeriadoConstantesFunciones.SCHEMA+"_"+DiaFeriadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DiaFeriadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DiaFeriadoConstantesFunciones.SCHEMA+"_"+DiaFeriadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiaFeriadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiaFeriadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiaFeriadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiaFeriadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiaFeriadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiaFeriadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DiaFeriadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DiaFeriadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DiaFeriadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DiaFeriadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Dia Feriados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Dia Feriado";
	public static final String SCLASSWEBTITULO_LOWER="Dia Feriado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DiaFeriado";
	public static final String OBJECTNAME="diaferiado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="dia_feriado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select diaferiado from "+DiaFeriadoConstantesFunciones.SPERSISTENCENAME+" diaferiado";
	public static String QUERYSELECTNATIVE="select "+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".id,"+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".version_row,"+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".id_empresa,"+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".nombre,"+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".fecha,"+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".dia,"+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".id_mes,"+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".id_anio,"+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".descripcion,"+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME+".esta_activo from "+DiaFeriadoConstantesFunciones.SCHEMA+"."+DiaFeriadoConstantesFunciones.TABLENAME;//+" as "+DiaFeriadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DiaFeriadoConstantesFuncionesAdditional diaferiadoConstantesFuncionesAdditional=null;
	
	public DiaFeriadoConstantesFuncionesAdditional getDiaFeriadoConstantesFuncionesAdditional() {
		return this.diaferiadoConstantesFuncionesAdditional;
	}
	
	public void setDiaFeriadoConstantesFuncionesAdditional(DiaFeriadoConstantesFuncionesAdditional diaferiadoConstantesFuncionesAdditional) {
		try {
			this.diaferiadoConstantesFuncionesAdditional=diaferiadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String FECHA= "fecha";
    public static final String DIA= "dia";
    public static final String IDMES= "id_mes";
    public static final String IDANIO= "id_anio";
    public static final String DESCRIPCION= "descripcion";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_DIA= "Dia";
		public static final String LABEL_DIA_LOWER= "Dia";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getDiaFeriadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DiaFeriadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DiaFeriadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DiaFeriadoConstantesFunciones.NOMBRE)) {sLabelColumna=DiaFeriadoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DiaFeriadoConstantesFunciones.FECHA)) {sLabelColumna=DiaFeriadoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DiaFeriadoConstantesFunciones.DIA)) {sLabelColumna=DiaFeriadoConstantesFunciones.LABEL_DIA;}
		if(sNombreColumna.equals(DiaFeriadoConstantesFunciones.IDMES)) {sLabelColumna=DiaFeriadoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DiaFeriadoConstantesFunciones.IDANIO)) {sLabelColumna=DiaFeriadoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DiaFeriadoConstantesFunciones.DESCRIPCION)) {sLabelColumna=DiaFeriadoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DiaFeriadoConstantesFunciones.ESTAACTIVO)) {sLabelColumna=DiaFeriadoConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(DiaFeriado diaferiado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!diaferiado.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(DiaFeriado diaferiado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(diaferiado.getId(),diaferiado.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getDiaFeriadoDescripcion(DiaFeriado diaferiado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(diaferiado !=null/* && diaferiado.getId()!=0*/) {
			sDescripcion=diaferiado.getnombre();//diaferiadodiaferiado.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDiaFeriadoDescripcionDetallado(DiaFeriado diaferiado) {
		String sDescripcion="";
			
		sDescripcion+=DiaFeriadoConstantesFunciones.ID+"=";
		sDescripcion+=diaferiado.getId().toString()+",";
		sDescripcion+=DiaFeriadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=diaferiado.getVersionRow().toString()+",";
		sDescripcion+=DiaFeriadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=diaferiado.getid_empresa().toString()+",";
		sDescripcion+=DiaFeriadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=diaferiado.getnombre()+",";
		sDescripcion+=DiaFeriadoConstantesFunciones.FECHA+"=";
		sDescripcion+=diaferiado.getfecha().toString()+",";
		sDescripcion+=DiaFeriadoConstantesFunciones.DIA+"=";
		sDescripcion+=diaferiado.getdia().toString()+",";
		sDescripcion+=DiaFeriadoConstantesFunciones.IDMES+"=";
		sDescripcion+=diaferiado.getid_mes().toString()+",";
		sDescripcion+=DiaFeriadoConstantesFunciones.IDANIO+"=";
		sDescripcion+=diaferiado.getid_anio().toString()+",";
		sDescripcion+=DiaFeriadoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=diaferiado.getdescripcion()+",";
		sDescripcion+=DiaFeriadoConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=diaferiado.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDiaFeriadoDescripcion(DiaFeriado diaferiado,String sValor) throws Exception {			
		if(diaferiado !=null) {
			diaferiado.setnombre(sValor);;//diaferiadodiaferiado.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDiaFeriado(DiaFeriado diaferiado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		diaferiado.setnombre(diaferiado.getnombre().trim());
		diaferiado.setdescripcion(diaferiado.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDiaFeriados(List<DiaFeriado> diaferiados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DiaFeriado diaferiado: diaferiados) {
			diaferiado.setnombre(diaferiado.getnombre().trim());
			diaferiado.setdescripcion(diaferiado.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDiaFeriado(DiaFeriado diaferiado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && diaferiado.getConCambioAuxiliar()) {
			diaferiado.setIsDeleted(diaferiado.getIsDeletedAuxiliar());	
			diaferiado.setIsNew(diaferiado.getIsNewAuxiliar());	
			diaferiado.setIsChanged(diaferiado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			diaferiado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			diaferiado.setIsDeletedAuxiliar(false);	
			diaferiado.setIsNewAuxiliar(false);	
			diaferiado.setIsChangedAuxiliar(false);
			
			diaferiado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDiaFeriados(List<DiaFeriado> diaferiados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DiaFeriado diaferiado : diaferiados) {
			if(conAsignarBase && diaferiado.getConCambioAuxiliar()) {
				diaferiado.setIsDeleted(diaferiado.getIsDeletedAuxiliar());	
				diaferiado.setIsNew(diaferiado.getIsNewAuxiliar());	
				diaferiado.setIsChanged(diaferiado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				diaferiado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				diaferiado.setIsDeletedAuxiliar(false);	
				diaferiado.setIsNewAuxiliar(false);	
				diaferiado.setIsChangedAuxiliar(false);
				
				diaferiado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDiaFeriado(DiaFeriado diaferiado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			diaferiado.setdia(0);
		}
	}		
	
	public static void InicializarValoresDiaFeriados(List<DiaFeriado> diaferiados,Boolean conEnteros) throws Exception  {
		
		for(DiaFeriado diaferiado: diaferiados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				diaferiado.setdia(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDiaFeriado(List<DiaFeriado> diaferiados,DiaFeriado diaferiadoAux) throws Exception  {
		DiaFeriadoConstantesFunciones.InicializarValoresDiaFeriado(diaferiadoAux,true);
		
		for(DiaFeriado diaferiado: diaferiados) {
			if(diaferiado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			diaferiadoAux.setdia(diaferiadoAux.getdia()+diaferiado.getdia());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDiaFeriado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DiaFeriadoConstantesFunciones.getArrayColumnasGlobalesDiaFeriado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDiaFeriado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiaFeriadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiaFeriadoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDiaFeriado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DiaFeriado> diaferiados,DiaFeriado diaferiado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DiaFeriado diaferiadoAux: diaferiados) {
			if(diaferiadoAux!=null && diaferiado!=null) {
				if((diaferiadoAux.getId()==null && diaferiado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(diaferiadoAux.getId()!=null && diaferiado.getId()!=null){
					if(diaferiadoAux.getId().equals(diaferiado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDiaFeriado(List<DiaFeriado> diaferiados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DiaFeriado diaferiado: diaferiados) {			
			if(diaferiado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDiaFeriado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_ID, DiaFeriadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_VERSIONROW, DiaFeriadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_IDEMPRESA, DiaFeriadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_NOMBRE, DiaFeriadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_FECHA, DiaFeriadoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_DIA, DiaFeriadoConstantesFunciones.DIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_IDMES, DiaFeriadoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_IDANIO, DiaFeriadoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_DESCRIPCION, DiaFeriadoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiaFeriadoConstantesFunciones.LABEL_ESTAACTIVO, DiaFeriadoConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDiaFeriado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.DIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiaFeriadoConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiaFeriado() throws Exception  {
		return DiaFeriadoConstantesFunciones.getTiposSeleccionarDiaFeriado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiaFeriado(Boolean conFk) throws Exception  {
		return DiaFeriadoConstantesFunciones.getTiposSeleccionarDiaFeriado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiaFeriado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiaFeriadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DiaFeriadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiaFeriadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DiaFeriadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiaFeriadoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DiaFeriadoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiaFeriadoConstantesFunciones.LABEL_DIA);
			reporte.setsDescripcion(DiaFeriadoConstantesFunciones.LABEL_DIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiaFeriadoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DiaFeriadoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiaFeriadoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DiaFeriadoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiaFeriadoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DiaFeriadoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiaFeriadoConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(DiaFeriadoConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDiaFeriado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDiaFeriado(DiaFeriado diaferiadoAux) throws Exception {
		
			diaferiadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(diaferiadoAux.getEmpresa()));
			diaferiadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(diaferiadoAux.getMes()));
			diaferiadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(diaferiadoAux.getAnio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDiaFeriado(List<DiaFeriado> diaferiadosTemp) throws Exception {
		for(DiaFeriado diaferiadoAux:diaferiadosTemp) {
			
			diaferiadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(diaferiadoAux.getEmpresa()));
			diaferiadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(diaferiadoAux.getMes()));
			diaferiadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(diaferiadoAux.getAnio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDiaFeriado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Anio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDiaFeriado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDiaFeriado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiaFeriadoConstantesFunciones.getClassesRelationshipsOfDiaFeriado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDiaFeriado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDiaFeriado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiaFeriadoConstantesFunciones.getClassesRelationshipsFromStringsOfDiaFeriado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDiaFeriado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DiaFeriado diaferiado,List<DiaFeriado> diaferiados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DiaFeriado diaferiadoEncontrado=null;
			
			for(DiaFeriado diaferiadoLocal:diaferiados) {
				if(diaferiadoLocal.getId().equals(diaferiado.getId())) {
					diaferiadoEncontrado=diaferiadoLocal;
					
					diaferiadoLocal.setIsChanged(diaferiado.getIsChanged());
					diaferiadoLocal.setIsNew(diaferiado.getIsNew());
					diaferiadoLocal.setIsDeleted(diaferiado.getIsDeleted());
					
					diaferiadoLocal.setGeneralEntityOriginal(diaferiado.getGeneralEntityOriginal());
					
					diaferiadoLocal.setId(diaferiado.getId());	
					diaferiadoLocal.setVersionRow(diaferiado.getVersionRow());	
					diaferiadoLocal.setid_empresa(diaferiado.getid_empresa());	
					diaferiadoLocal.setnombre(diaferiado.getnombre());	
					diaferiadoLocal.setfecha(diaferiado.getfecha());	
					diaferiadoLocal.setdia(diaferiado.getdia());	
					diaferiadoLocal.setid_mes(diaferiado.getid_mes());	
					diaferiadoLocal.setid_anio(diaferiado.getid_anio());	
					diaferiadoLocal.setdescripcion(diaferiado.getdescripcion());	
					diaferiadoLocal.setesta_activo(diaferiado.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!diaferiado.getIsDeleted()) {
				if(!existe) {
					diaferiados.add(diaferiado);
				}
			} else {
				if(diaferiadoEncontrado!=null && permiteQuitar)  {
					diaferiados.remove(diaferiadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DiaFeriado diaferiado,List<DiaFeriado> diaferiados) throws Exception {
		try	{			
			for(DiaFeriado diaferiadoLocal:diaferiados) {
				if(diaferiadoLocal.getId().equals(diaferiado.getId())) {
					diaferiadoLocal.setIsSelected(diaferiado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDiaFeriado(List<DiaFeriado> diaferiadosAux) throws Exception {
		//this.diaferiadosAux=diaferiadosAux;
		
		for(DiaFeriado diaferiadoAux:diaferiadosAux) {
			if(diaferiadoAux.getIsChanged()) {
				diaferiadoAux.setIsChanged(false);
			}		
			
			if(diaferiadoAux.getIsNew()) {
				diaferiadoAux.setIsNew(false);
			}	
			
			if(diaferiadoAux.getIsDeleted()) {
				diaferiadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDiaFeriado(DiaFeriado diaferiadoAux) throws Exception {
		//this.diaferiadoAux=diaferiadoAux;
		
			if(diaferiadoAux.getIsChanged()) {
				diaferiadoAux.setIsChanged(false);
			}		
			
			if(diaferiadoAux.getIsNew()) {
				diaferiadoAux.setIsNew(false);
			}	
			
			if(diaferiadoAux.getIsDeleted()) {
				diaferiadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DiaFeriado diaferiadoAsignar,DiaFeriado diaferiado) throws Exception {
		diaferiadoAsignar.setId(diaferiado.getId());	
		diaferiadoAsignar.setVersionRow(diaferiado.getVersionRow());	
		diaferiadoAsignar.setid_empresa(diaferiado.getid_empresa());
		diaferiadoAsignar.setempresa_descripcion(diaferiado.getempresa_descripcion());	
		diaferiadoAsignar.setnombre(diaferiado.getnombre());	
		diaferiadoAsignar.setfecha(diaferiado.getfecha());	
		diaferiadoAsignar.setdia(diaferiado.getdia());	
		diaferiadoAsignar.setid_mes(diaferiado.getid_mes());
		diaferiadoAsignar.setmes_descripcion(diaferiado.getmes_descripcion());	
		diaferiadoAsignar.setid_anio(diaferiado.getid_anio());
		diaferiadoAsignar.setanio_descripcion(diaferiado.getanio_descripcion());	
		diaferiadoAsignar.setdescripcion(diaferiado.getdescripcion());	
		diaferiadoAsignar.setesta_activo(diaferiado.getesta_activo());	
	}
	
	public static void inicializarDiaFeriado(DiaFeriado diaferiado) throws Exception {
		try {
				diaferiado.setId(0L);	
					
				diaferiado.setid_empresa(-1L);	
				diaferiado.setnombre("");	
				diaferiado.setfecha(new Date());	
				diaferiado.setdia(0);	
				diaferiado.setid_mes(null);	
				diaferiado.setid_anio(null);	
				diaferiado.setdescripcion("");	
				diaferiado.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDiaFeriado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DiaFeriadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiaFeriadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiaFeriadoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiaFeriadoConstantesFunciones.LABEL_DIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiaFeriadoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiaFeriadoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiaFeriadoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiaFeriadoConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDiaFeriado(String sTipo,Row row,Workbook workbook,DiaFeriado diaferiado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(diaferiado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diaferiado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diaferiado.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diaferiado.getdia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diaferiado.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diaferiado.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diaferiado.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(diaferiado.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDiaFeriado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDiaFeriado() {
		return this.sFinalQueryDiaFeriado;
	}
	
	public void setsFinalQueryDiaFeriado(String sFinalQueryDiaFeriado) {
		this.sFinalQueryDiaFeriado= sFinalQueryDiaFeriado;
	}
	
	public Border resaltarSeleccionarDiaFeriado=null;
	
	public Border setResaltarSeleccionarDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDiaFeriado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDiaFeriado() {
		return this.resaltarSeleccionarDiaFeriado;
	}
	
	public void setResaltarSeleccionarDiaFeriado(Border borderResaltarSeleccionarDiaFeriado) {
		this.resaltarSeleccionarDiaFeriado= borderResaltarSeleccionarDiaFeriado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDiaFeriado=null;
	public Boolean mostraridDiaFeriado=true;
	public Boolean activaridDiaFeriado=true;

	public Border resaltarid_empresaDiaFeriado=null;
	public Boolean mostrarid_empresaDiaFeriado=true;
	public Boolean activarid_empresaDiaFeriado=true;
	public Boolean cargarid_empresaDiaFeriado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDiaFeriado=false;//ConEventDepend=true

	public Border resaltarnombreDiaFeriado=null;
	public Boolean mostrarnombreDiaFeriado=true;
	public Boolean activarnombreDiaFeriado=true;

	public Border resaltarfechaDiaFeriado=null;
	public Boolean mostrarfechaDiaFeriado=true;
	public Boolean activarfechaDiaFeriado=true;

	public Border resaltardiaDiaFeriado=null;
	public Boolean mostrardiaDiaFeriado=true;
	public Boolean activardiaDiaFeriado=true;

	public Border resaltarid_mesDiaFeriado=null;
	public Boolean mostrarid_mesDiaFeriado=true;
	public Boolean activarid_mesDiaFeriado=true;
	public Boolean cargarid_mesDiaFeriado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDiaFeriado=false;//ConEventDepend=true

	public Border resaltarid_anioDiaFeriado=null;
	public Boolean mostrarid_anioDiaFeriado=true;
	public Boolean activarid_anioDiaFeriado=true;
	public Boolean cargarid_anioDiaFeriado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDiaFeriado=false;//ConEventDepend=true

	public Border resaltardescripcionDiaFeriado=null;
	public Boolean mostrardescripcionDiaFeriado=true;
	public Boolean activardescripcionDiaFeriado=true;

	public Border resaltaresta_activoDiaFeriado=null;
	public Boolean mostraresta_activoDiaFeriado=true;
	public Boolean activaresta_activoDiaFeriado=true;

	
	

	public Border setResaltaridDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltaridDiaFeriado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDiaFeriado() {
		return this.resaltaridDiaFeriado;
	}

	public void setResaltaridDiaFeriado(Border borderResaltar) {
		this.resaltaridDiaFeriado= borderResaltar;
	}

	public Boolean getMostraridDiaFeriado() {
		return this.mostraridDiaFeriado;
	}

	public void setMostraridDiaFeriado(Boolean mostraridDiaFeriado) {
		this.mostraridDiaFeriado= mostraridDiaFeriado;
	}

	public Boolean getActivaridDiaFeriado() {
		return this.activaridDiaFeriado;
	}

	public void setActivaridDiaFeriado(Boolean activaridDiaFeriado) {
		this.activaridDiaFeriado= activaridDiaFeriado;
	}

	public Border setResaltarid_empresaDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltarid_empresaDiaFeriado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDiaFeriado() {
		return this.resaltarid_empresaDiaFeriado;
	}

	public void setResaltarid_empresaDiaFeriado(Border borderResaltar) {
		this.resaltarid_empresaDiaFeriado= borderResaltar;
	}

	public Boolean getMostrarid_empresaDiaFeriado() {
		return this.mostrarid_empresaDiaFeriado;
	}

	public void setMostrarid_empresaDiaFeriado(Boolean mostrarid_empresaDiaFeriado) {
		this.mostrarid_empresaDiaFeriado= mostrarid_empresaDiaFeriado;
	}

	public Boolean getActivarid_empresaDiaFeriado() {
		return this.activarid_empresaDiaFeriado;
	}

	public void setActivarid_empresaDiaFeriado(Boolean activarid_empresaDiaFeriado) {
		this.activarid_empresaDiaFeriado= activarid_empresaDiaFeriado;
	}

	public Boolean getCargarid_empresaDiaFeriado() {
		return this.cargarid_empresaDiaFeriado;
	}

	public void setCargarid_empresaDiaFeriado(Boolean cargarid_empresaDiaFeriado) {
		this.cargarid_empresaDiaFeriado= cargarid_empresaDiaFeriado;
	}

	public Border setResaltarnombreDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltarnombreDiaFeriado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDiaFeriado() {
		return this.resaltarnombreDiaFeriado;
	}

	public void setResaltarnombreDiaFeriado(Border borderResaltar) {
		this.resaltarnombreDiaFeriado= borderResaltar;
	}

	public Boolean getMostrarnombreDiaFeriado() {
		return this.mostrarnombreDiaFeriado;
	}

	public void setMostrarnombreDiaFeriado(Boolean mostrarnombreDiaFeriado) {
		this.mostrarnombreDiaFeriado= mostrarnombreDiaFeriado;
	}

	public Boolean getActivarnombreDiaFeriado() {
		return this.activarnombreDiaFeriado;
	}

	public void setActivarnombreDiaFeriado(Boolean activarnombreDiaFeriado) {
		this.activarnombreDiaFeriado= activarnombreDiaFeriado;
	}

	public Border setResaltarfechaDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltarfechaDiaFeriado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDiaFeriado() {
		return this.resaltarfechaDiaFeriado;
	}

	public void setResaltarfechaDiaFeriado(Border borderResaltar) {
		this.resaltarfechaDiaFeriado= borderResaltar;
	}

	public Boolean getMostrarfechaDiaFeriado() {
		return this.mostrarfechaDiaFeriado;
	}

	public void setMostrarfechaDiaFeriado(Boolean mostrarfechaDiaFeriado) {
		this.mostrarfechaDiaFeriado= mostrarfechaDiaFeriado;
	}

	public Boolean getActivarfechaDiaFeriado() {
		return this.activarfechaDiaFeriado;
	}

	public void setActivarfechaDiaFeriado(Boolean activarfechaDiaFeriado) {
		this.activarfechaDiaFeriado= activarfechaDiaFeriado;
	}

	public Border setResaltardiaDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltardiaDiaFeriado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiaDiaFeriado() {
		return this.resaltardiaDiaFeriado;
	}

	public void setResaltardiaDiaFeriado(Border borderResaltar) {
		this.resaltardiaDiaFeriado= borderResaltar;
	}

	public Boolean getMostrardiaDiaFeriado() {
		return this.mostrardiaDiaFeriado;
	}

	public void setMostrardiaDiaFeriado(Boolean mostrardiaDiaFeriado) {
		this.mostrardiaDiaFeriado= mostrardiaDiaFeriado;
	}

	public Boolean getActivardiaDiaFeriado() {
		return this.activardiaDiaFeriado;
	}

	public void setActivardiaDiaFeriado(Boolean activardiaDiaFeriado) {
		this.activardiaDiaFeriado= activardiaDiaFeriado;
	}

	public Border setResaltarid_mesDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltarid_mesDiaFeriado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDiaFeriado() {
		return this.resaltarid_mesDiaFeriado;
	}

	public void setResaltarid_mesDiaFeriado(Border borderResaltar) {
		this.resaltarid_mesDiaFeriado= borderResaltar;
	}

	public Boolean getMostrarid_mesDiaFeriado() {
		return this.mostrarid_mesDiaFeriado;
	}

	public void setMostrarid_mesDiaFeriado(Boolean mostrarid_mesDiaFeriado) {
		this.mostrarid_mesDiaFeriado= mostrarid_mesDiaFeriado;
	}

	public Boolean getActivarid_mesDiaFeriado() {
		return this.activarid_mesDiaFeriado;
	}

	public void setActivarid_mesDiaFeriado(Boolean activarid_mesDiaFeriado) {
		this.activarid_mesDiaFeriado= activarid_mesDiaFeriado;
	}

	public Boolean getCargarid_mesDiaFeriado() {
		return this.cargarid_mesDiaFeriado;
	}

	public void setCargarid_mesDiaFeriado(Boolean cargarid_mesDiaFeriado) {
		this.cargarid_mesDiaFeriado= cargarid_mesDiaFeriado;
	}

	public Border setResaltarid_anioDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltarid_anioDiaFeriado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDiaFeriado() {
		return this.resaltarid_anioDiaFeriado;
	}

	public void setResaltarid_anioDiaFeriado(Border borderResaltar) {
		this.resaltarid_anioDiaFeriado= borderResaltar;
	}

	public Boolean getMostrarid_anioDiaFeriado() {
		return this.mostrarid_anioDiaFeriado;
	}

	public void setMostrarid_anioDiaFeriado(Boolean mostrarid_anioDiaFeriado) {
		this.mostrarid_anioDiaFeriado= mostrarid_anioDiaFeriado;
	}

	public Boolean getActivarid_anioDiaFeriado() {
		return this.activarid_anioDiaFeriado;
	}

	public void setActivarid_anioDiaFeriado(Boolean activarid_anioDiaFeriado) {
		this.activarid_anioDiaFeriado= activarid_anioDiaFeriado;
	}

	public Boolean getCargarid_anioDiaFeriado() {
		return this.cargarid_anioDiaFeriado;
	}

	public void setCargarid_anioDiaFeriado(Boolean cargarid_anioDiaFeriado) {
		this.cargarid_anioDiaFeriado= cargarid_anioDiaFeriado;
	}

	public Border setResaltardescripcionDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltardescripcionDiaFeriado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDiaFeriado() {
		return this.resaltardescripcionDiaFeriado;
	}

	public void setResaltardescripcionDiaFeriado(Border borderResaltar) {
		this.resaltardescripcionDiaFeriado= borderResaltar;
	}

	public Boolean getMostrardescripcionDiaFeriado() {
		return this.mostrardescripcionDiaFeriado;
	}

	public void setMostrardescripcionDiaFeriado(Boolean mostrardescripcionDiaFeriado) {
		this.mostrardescripcionDiaFeriado= mostrardescripcionDiaFeriado;
	}

	public Boolean getActivardescripcionDiaFeriado() {
		return this.activardescripcionDiaFeriado;
	}

	public void setActivardescripcionDiaFeriado(Boolean activardescripcionDiaFeriado) {
		this.activardescripcionDiaFeriado= activardescripcionDiaFeriado;
	}

	public Border setResaltaresta_activoDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diaferiadoBeanSwingJInternalFrame.jTtoolBarDiaFeriado.setBorder(borderResaltar);
		
		this.resaltaresta_activoDiaFeriado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoDiaFeriado() {
		return this.resaltaresta_activoDiaFeriado;
	}

	public void setResaltaresta_activoDiaFeriado(Border borderResaltar) {
		this.resaltaresta_activoDiaFeriado= borderResaltar;
	}

	public Boolean getMostraresta_activoDiaFeriado() {
		return this.mostraresta_activoDiaFeriado;
	}

	public void setMostraresta_activoDiaFeriado(Boolean mostraresta_activoDiaFeriado) {
		this.mostraresta_activoDiaFeriado= mostraresta_activoDiaFeriado;
	}

	public Boolean getActivaresta_activoDiaFeriado() {
		return this.activaresta_activoDiaFeriado;
	}

	public void setActivaresta_activoDiaFeriado(Boolean activaresta_activoDiaFeriado) {
		this.activaresta_activoDiaFeriado= activaresta_activoDiaFeriado;
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
		
		
		this.setMostraridDiaFeriado(esInicial);
		this.setMostrarid_empresaDiaFeriado(esInicial);
		this.setMostrarnombreDiaFeriado(esInicial);
		this.setMostrarfechaDiaFeriado(esInicial);
		this.setMostrardiaDiaFeriado(esInicial);
		this.setMostrarid_mesDiaFeriado(esInicial);
		this.setMostrarid_anioDiaFeriado(esInicial);
		this.setMostrardescripcionDiaFeriado(esInicial);
		this.setMostraresta_activoDiaFeriado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.ID)) {
				this.setMostraridDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.FECHA)) {
				this.setMostrarfechaDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.DIA)) {
				this.setMostrardiaDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoDiaFeriado(esAsigna);
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
		
		
		this.setActivaridDiaFeriado(esInicial);
		this.setActivarid_empresaDiaFeriado(esInicial);
		this.setActivarnombreDiaFeriado(esInicial);
		this.setActivarfechaDiaFeriado(esInicial);
		this.setActivardiaDiaFeriado(esInicial);
		this.setActivarid_mesDiaFeriado(esInicial);
		this.setActivarid_anioDiaFeriado(esInicial);
		this.setActivardescripcionDiaFeriado(esInicial);
		this.setActivaresta_activoDiaFeriado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.ID)) {
				this.setActivaridDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.FECHA)) {
				this.setActivarfechaDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.DIA)) {
				this.setActivardiaDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.IDMES)) {
				this.setActivarid_mesDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoDiaFeriado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDiaFeriado(esInicial);
		this.setResaltarid_empresaDiaFeriado(esInicial);
		this.setResaltarnombreDiaFeriado(esInicial);
		this.setResaltarfechaDiaFeriado(esInicial);
		this.setResaltardiaDiaFeriado(esInicial);
		this.setResaltarid_mesDiaFeriado(esInicial);
		this.setResaltarid_anioDiaFeriado(esInicial);
		this.setResaltardescripcionDiaFeriado(esInicial);
		this.setResaltaresta_activoDiaFeriado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.ID)) {
				this.setResaltaridDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.FECHA)) {
				this.setResaltarfechaDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.DIA)) {
				this.setResaltardiaDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDiaFeriado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiaFeriadoConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoDiaFeriado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioDiaFeriado=true;

	public Boolean getMostrarFK_IdAnioDiaFeriado() {
		return this.mostrarFK_IdAnioDiaFeriado;
	}

	public void setMostrarFK_IdAnioDiaFeriado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioDiaFeriado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDiaFeriado=true;

	public Boolean getMostrarFK_IdEmpresaDiaFeriado() {
		return this.mostrarFK_IdEmpresaDiaFeriado;
	}

	public void setMostrarFK_IdEmpresaDiaFeriado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDiaFeriado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesDiaFeriado=true;

	public Boolean getMostrarFK_IdMesDiaFeriado() {
		return this.mostrarFK_IdMesDiaFeriado;
	}

	public void setMostrarFK_IdMesDiaFeriado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesDiaFeriado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioDiaFeriado=true;

	public Boolean getActivarFK_IdAnioDiaFeriado() {
		return this.activarFK_IdAnioDiaFeriado;
	}

	public void setActivarFK_IdAnioDiaFeriado(Boolean habilitarResaltar) {
		this.activarFK_IdAnioDiaFeriado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDiaFeriado=true;

	public Boolean getActivarFK_IdEmpresaDiaFeriado() {
		return this.activarFK_IdEmpresaDiaFeriado;
	}

	public void setActivarFK_IdEmpresaDiaFeriado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDiaFeriado= habilitarResaltar;
	}

	public Boolean activarFK_IdMesDiaFeriado=true;

	public Boolean getActivarFK_IdMesDiaFeriado() {
		return this.activarFK_IdMesDiaFeriado;
	}

	public void setActivarFK_IdMesDiaFeriado(Boolean habilitarResaltar) {
		this.activarFK_IdMesDiaFeriado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioDiaFeriado=null;

	public Border getResaltarFK_IdAnioDiaFeriado() {
		return this.resaltarFK_IdAnioDiaFeriado;
	}

	public void setResaltarFK_IdAnioDiaFeriado(Border borderResaltar) {
		this.resaltarFK_IdAnioDiaFeriado= borderResaltar;
	}

	public void setResaltarFK_IdAnioDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioDiaFeriado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDiaFeriado=null;

	public Border getResaltarFK_IdEmpresaDiaFeriado() {
		return this.resaltarFK_IdEmpresaDiaFeriado;
	}

	public void setResaltarFK_IdEmpresaDiaFeriado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDiaFeriado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDiaFeriado= borderResaltar;
	}

	public Border resaltarFK_IdMesDiaFeriado=null;

	public Border getResaltarFK_IdMesDiaFeriado() {
		return this.resaltarFK_IdMesDiaFeriado;
	}

	public void setResaltarFK_IdMesDiaFeriado(Border borderResaltar) {
		this.resaltarFK_IdMesDiaFeriado= borderResaltar;
	}

	public void setResaltarFK_IdMesDiaFeriado(ParametroGeneralUsuario parametroGeneralUsuario/*DiaFeriadoBeanSwingJInternalFrame diaferiadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesDiaFeriado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}