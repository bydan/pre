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


import com.bydan.erp.nomina.util.FormatoNomiConstantesFunciones;
import com.bydan.erp.nomina.util.FormatoNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FormatoNomiParameterGeneral;

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
final public class FormatoNomiConstantesFunciones extends FormatoNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FormatoNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormatoNomi"+FormatoNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormatoNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormatoNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormatoNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormatoNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormatoNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormatoNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormatoNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormatoNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormatoNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormatoNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormatoNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormatoNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formato Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Formato Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Formato Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormatoNomi";
	public static final String OBJECTNAME="formatonomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="formato_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formatonomi from "+FormatoNomiConstantesFunciones.SPERSISTENCENAME+" formatonomi";
	public static String QUERYSELECTNATIVE="select "+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".id,"+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".version_row,"+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".id_empresa,"+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".id_sucursal,"+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".codigo,"+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".nombre,"+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".fecha,"+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".instrucciones,"+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".id_estructura,"+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME+".id_puntaje_nomi from "+FormatoNomiConstantesFunciones.SCHEMA+"."+FormatoNomiConstantesFunciones.TABLENAME;//+" as "+FormatoNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormatoNomiConstantesFuncionesAdditional formatonomiConstantesFuncionesAdditional=null;
	
	public FormatoNomiConstantesFuncionesAdditional getFormatoNomiConstantesFuncionesAdditional() {
		return this.formatonomiConstantesFuncionesAdditional;
	}
	
	public void setFormatoNomiConstantesFuncionesAdditional(FormatoNomiConstantesFuncionesAdditional formatonomiConstantesFuncionesAdditional) {
		try {
			this.formatonomiConstantesFuncionesAdditional=formatonomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String FECHA= "fecha";
    public static final String INSTRUCCIONES= "instrucciones";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDPUNTAJENOMI= "id_puntaje_nomi";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_INSTRUCCIONES= "Instrucciones";
		public static final String LABEL_INSTRUCCIONES_LOWER= "Instrucciones";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDPUNTAJENOMI= "Puntaje Nomi";
		public static final String LABEL_IDPUNTAJENOMI_LOWER= "Puntaje Nomi";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXINSTRUCCIONES=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXINSTRUCCIONES=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getFormatoNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormatoNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormatoNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormatoNomiConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FormatoNomiConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FormatoNomiConstantesFunciones.CODIGO)) {sLabelColumna=FormatoNomiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(FormatoNomiConstantesFunciones.NOMBRE)) {sLabelColumna=FormatoNomiConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(FormatoNomiConstantesFunciones.FECHA)) {sLabelColumna=FormatoNomiConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(FormatoNomiConstantesFunciones.INSTRUCCIONES)) {sLabelColumna=FormatoNomiConstantesFunciones.LABEL_INSTRUCCIONES;}
		if(sNombreColumna.equals(FormatoNomiConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=FormatoNomiConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(FormatoNomiConstantesFunciones.IDPUNTAJENOMI)) {sLabelColumna=FormatoNomiConstantesFunciones.LABEL_IDPUNTAJENOMI;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getFormatoNomiDescripcion(FormatoNomi formatonomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formatonomi !=null/* && formatonomi.getId()!=0*/) {
			sDescripcion=formatonomi.getcodigo();//formatonomiformatonomi.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFormatoNomiDescripcionDetallado(FormatoNomi formatonomi) {
		String sDescripcion="";
			
		sDescripcion+=FormatoNomiConstantesFunciones.ID+"=";
		sDescripcion+=formatonomi.getId().toString()+",";
		sDescripcion+=FormatoNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formatonomi.getVersionRow().toString()+",";
		sDescripcion+=FormatoNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formatonomi.getid_empresa().toString()+",";
		sDescripcion+=FormatoNomiConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=formatonomi.getid_sucursal().toString()+",";
		sDescripcion+=FormatoNomiConstantesFunciones.CODIGO+"=";
		sDescripcion+=formatonomi.getcodigo()+",";
		sDescripcion+=FormatoNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=formatonomi.getnombre()+",";
		sDescripcion+=FormatoNomiConstantesFunciones.FECHA+"=";
		sDescripcion+=formatonomi.getfecha().toString()+",";
		sDescripcion+=FormatoNomiConstantesFunciones.INSTRUCCIONES+"=";
		sDescripcion+=formatonomi.getinstrucciones()+",";
		sDescripcion+=FormatoNomiConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=formatonomi.getid_estructura().toString()+",";
		sDescripcion+=FormatoNomiConstantesFunciones.IDPUNTAJENOMI+"=";
		sDescripcion+=formatonomi.getid_puntaje_nomi().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormatoNomiDescripcion(FormatoNomi formatonomi,String sValor) throws Exception {			
		if(formatonomi !=null) {
			formatonomi.setcodigo(sValor);;//formatonomiformatonomi.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getPuntajeNomiDescripcion(PuntajeNomi puntajenomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(puntajenomi!=null/*&&puntajenomi.getId()>0*/) {
			sDescripcion=PuntajeNomiConstantesFunciones.getPuntajeNomiDescripcion(puntajenomi);
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
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdPuntajeNomi")) {
			sNombreIndice="Tipo=  Por Puntaje Nomi";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPuntajeNomi(Long id_puntaje_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_puntaje_nomi!=null) {sDetalleIndice+=" Codigo Unico De Puntaje Nomi="+id_puntaje_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormatoNomi(FormatoNomi formatonomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formatonomi.setcodigo(formatonomi.getcodigo().trim());
		formatonomi.setnombre(formatonomi.getnombre().trim());
		formatonomi.setinstrucciones(formatonomi.getinstrucciones().trim());
	}
	
	public static void quitarEspaciosFormatoNomis(List<FormatoNomi> formatonomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormatoNomi formatonomi: formatonomis) {
			formatonomi.setcodigo(formatonomi.getcodigo().trim());
			formatonomi.setnombre(formatonomi.getnombre().trim());
			formatonomi.setinstrucciones(formatonomi.getinstrucciones().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormatoNomi(FormatoNomi formatonomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formatonomi.getConCambioAuxiliar()) {
			formatonomi.setIsDeleted(formatonomi.getIsDeletedAuxiliar());	
			formatonomi.setIsNew(formatonomi.getIsNewAuxiliar());	
			formatonomi.setIsChanged(formatonomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formatonomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formatonomi.setIsDeletedAuxiliar(false);	
			formatonomi.setIsNewAuxiliar(false);	
			formatonomi.setIsChangedAuxiliar(false);
			
			formatonomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormatoNomis(List<FormatoNomi> formatonomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormatoNomi formatonomi : formatonomis) {
			if(conAsignarBase && formatonomi.getConCambioAuxiliar()) {
				formatonomi.setIsDeleted(formatonomi.getIsDeletedAuxiliar());	
				formatonomi.setIsNew(formatonomi.getIsNewAuxiliar());	
				formatonomi.setIsChanged(formatonomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formatonomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formatonomi.setIsDeletedAuxiliar(false);	
				formatonomi.setIsNewAuxiliar(false);	
				formatonomi.setIsChangedAuxiliar(false);
				
				formatonomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormatoNomi(FormatoNomi formatonomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormatoNomis(List<FormatoNomi> formatonomis,Boolean conEnteros) throws Exception  {
		
		for(FormatoNomi formatonomi: formatonomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormatoNomi(List<FormatoNomi> formatonomis,FormatoNomi formatonomiAux) throws Exception  {
		FormatoNomiConstantesFunciones.InicializarValoresFormatoNomi(formatonomiAux,true);
		
		for(FormatoNomi formatonomi: formatonomis) {
			if(formatonomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormatoNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormatoNomiConstantesFunciones.getArrayColumnasGlobalesFormatoNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormatoNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormatoNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormatoNomiConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormatoNomiConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormatoNomiConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormatoNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormatoNomi> formatonomis,FormatoNomi formatonomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormatoNomi formatonomiAux: formatonomis) {
			if(formatonomiAux!=null && formatonomi!=null) {
				if((formatonomiAux.getId()==null && formatonomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formatonomiAux.getId()!=null && formatonomi.getId()!=null){
					if(formatonomiAux.getId().equals(formatonomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormatoNomi(List<FormatoNomi> formatonomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(FormatoNomi formatonomi: formatonomis) {			
			if(formatonomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormatoNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_ID, FormatoNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_VERSIONROW, FormatoNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_IDEMPRESA, FormatoNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_IDSUCURSAL, FormatoNomiConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_CODIGO, FormatoNomiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_NOMBRE, FormatoNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_FECHA, FormatoNomiConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_INSTRUCCIONES, FormatoNomiConstantesFunciones.INSTRUCCIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_IDESTRUCTURA, FormatoNomiConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiConstantesFunciones.LABEL_IDPUNTAJENOMI, FormatoNomiConstantesFunciones.IDPUNTAJENOMI,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormatoNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.INSTRUCCIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiConstantesFunciones.IDPUNTAJENOMI;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoNomi() throws Exception  {
		return FormatoNomiConstantesFunciones.getTiposSeleccionarFormatoNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoNomi(Boolean conFk) throws Exception  {
		return FormatoNomiConstantesFunciones.getTiposSeleccionarFormatoNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormatoNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FormatoNomiConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(FormatoNomiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(FormatoNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(FormatoNomiConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiConstantesFunciones.LABEL_INSTRUCCIONES);
			reporte.setsDescripcion(FormatoNomiConstantesFunciones.LABEL_INSTRUCCIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(FormatoNomiConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiConstantesFunciones.LABEL_IDPUNTAJENOMI);
			reporte.setsDescripcion(FormatoNomiConstantesFunciones.LABEL_IDPUNTAJENOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormatoNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormatoNomi(FormatoNomi formatonomiAux) throws Exception {
		
			formatonomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatonomiAux.getEmpresa()));
			formatonomiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formatonomiAux.getSucursal()));
			formatonomiAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(formatonomiAux.getEstructura()));
			formatonomiAux.setpuntajenomi_descripcion(PuntajeNomiConstantesFunciones.getPuntajeNomiDescripcion(formatonomiAux.getPuntajeNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormatoNomi(List<FormatoNomi> formatonomisTemp) throws Exception {
		for(FormatoNomi formatonomiAux:formatonomisTemp) {
			
			formatonomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatonomiAux.getEmpresa()));
			formatonomiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formatonomiAux.getSucursal()));
			formatonomiAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(formatonomiAux.getEstructura()));
			formatonomiAux.setpuntajenomi_descripcion(PuntajeNomiConstantesFunciones.getPuntajeNomiDescripcion(formatonomiAux.getPuntajeNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormatoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(PuntajeNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PuntajeNomi.class)) {
						classes.add(new Classe(PuntajeNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormatoNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(PuntajeNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PuntajeNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(PuntajeNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PuntajeNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoNomiConstantesFunciones.getClassesRelationshipsOfFormatoNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormatoNomiPreguntaNomi.class));
				classes.add(new Classe(FormatoNomiFactorNomi.class));
				classes.add(new Classe(EvaluacionNomi.class));
				classes.add(new Classe(DetalleEvaluacionNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomiFactorNomi.class)) {
						classes.add(new Classe(FormatoNomiFactorNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EvaluacionNomi.class)) {
						classes.add(new Classe(EvaluacionNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleEvaluacionNomi.class)) {
						classes.add(new Classe(DetalleEvaluacionNomi.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormatoNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoNomiConstantesFunciones.getClassesRelationshipsFromStringsOfFormatoNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormatoNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
					}

					if(FormatoNomiFactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiFactorNomi.class)); continue;
					}

					if(EvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionNomi.class)); continue;
					}

					if(DetalleEvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
					}

					if(FormatoNomiFactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiFactorNomi.class)); continue;
					}

					if(EvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionNomi.class)); continue;
					}

					if(DetalleEvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionNomi.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(FormatoNomi formatonomi,List<FormatoNomi> formatonomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormatoNomi formatonomiEncontrado=null;
			
			for(FormatoNomi formatonomiLocal:formatonomis) {
				if(formatonomiLocal.getId().equals(formatonomi.getId())) {
					formatonomiEncontrado=formatonomiLocal;
					
					formatonomiLocal.setIsChanged(formatonomi.getIsChanged());
					formatonomiLocal.setIsNew(formatonomi.getIsNew());
					formatonomiLocal.setIsDeleted(formatonomi.getIsDeleted());
					
					formatonomiLocal.setGeneralEntityOriginal(formatonomi.getGeneralEntityOriginal());
					
					formatonomiLocal.setId(formatonomi.getId());	
					formatonomiLocal.setVersionRow(formatonomi.getVersionRow());	
					formatonomiLocal.setid_empresa(formatonomi.getid_empresa());	
					formatonomiLocal.setid_sucursal(formatonomi.getid_sucursal());	
					formatonomiLocal.setcodigo(formatonomi.getcodigo());	
					formatonomiLocal.setnombre(formatonomi.getnombre());	
					formatonomiLocal.setfecha(formatonomi.getfecha());	
					formatonomiLocal.setinstrucciones(formatonomi.getinstrucciones());	
					formatonomiLocal.setid_estructura(formatonomi.getid_estructura());	
					formatonomiLocal.setid_puntaje_nomi(formatonomi.getid_puntaje_nomi());	
					
					
					formatonomiLocal.setFormatoNomiPreguntaNomis(formatonomi.getFormatoNomiPreguntaNomis());
					formatonomiLocal.setFormatoNomiFactorNomis(formatonomi.getFormatoNomiFactorNomis());
					formatonomiLocal.setEvaluacionNomis(formatonomi.getEvaluacionNomis());
					formatonomiLocal.setDetalleEvaluacionNomis(formatonomi.getDetalleEvaluacionNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!formatonomi.getIsDeleted()) {
				if(!existe) {
					formatonomis.add(formatonomi);
				}
			} else {
				if(formatonomiEncontrado!=null && permiteQuitar)  {
					formatonomis.remove(formatonomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormatoNomi formatonomi,List<FormatoNomi> formatonomis) throws Exception {
		try	{			
			for(FormatoNomi formatonomiLocal:formatonomis) {
				if(formatonomiLocal.getId().equals(formatonomi.getId())) {
					formatonomiLocal.setIsSelected(formatonomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormatoNomi(List<FormatoNomi> formatonomisAux) throws Exception {
		//this.formatonomisAux=formatonomisAux;
		
		for(FormatoNomi formatonomiAux:formatonomisAux) {
			if(formatonomiAux.getIsChanged()) {
				formatonomiAux.setIsChanged(false);
			}		
			
			if(formatonomiAux.getIsNew()) {
				formatonomiAux.setIsNew(false);
			}	
			
			if(formatonomiAux.getIsDeleted()) {
				formatonomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormatoNomi(FormatoNomi formatonomiAux) throws Exception {
		//this.formatonomiAux=formatonomiAux;
		
			if(formatonomiAux.getIsChanged()) {
				formatonomiAux.setIsChanged(false);
			}		
			
			if(formatonomiAux.getIsNew()) {
				formatonomiAux.setIsNew(false);
			}	
			
			if(formatonomiAux.getIsDeleted()) {
				formatonomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormatoNomi formatonomiAsignar,FormatoNomi formatonomi) throws Exception {
		formatonomiAsignar.setId(formatonomi.getId());	
		formatonomiAsignar.setVersionRow(formatonomi.getVersionRow());	
		formatonomiAsignar.setid_empresa(formatonomi.getid_empresa());
		formatonomiAsignar.setempresa_descripcion(formatonomi.getempresa_descripcion());	
		formatonomiAsignar.setid_sucursal(formatonomi.getid_sucursal());
		formatonomiAsignar.setsucursal_descripcion(formatonomi.getsucursal_descripcion());	
		formatonomiAsignar.setcodigo(formatonomi.getcodigo());	
		formatonomiAsignar.setnombre(formatonomi.getnombre());	
		formatonomiAsignar.setfecha(formatonomi.getfecha());	
		formatonomiAsignar.setinstrucciones(formatonomi.getinstrucciones());	
		formatonomiAsignar.setid_estructura(formatonomi.getid_estructura());
		formatonomiAsignar.setestructura_descripcion(formatonomi.getestructura_descripcion());	
		formatonomiAsignar.setid_puntaje_nomi(formatonomi.getid_puntaje_nomi());
		formatonomiAsignar.setpuntajenomi_descripcion(formatonomi.getpuntajenomi_descripcion());	
	}
	
	public static void inicializarFormatoNomi(FormatoNomi formatonomi) throws Exception {
		try {
				formatonomi.setId(0L);	
					
				formatonomi.setid_empresa(-1L);	
				formatonomi.setid_sucursal(-1L);	
				formatonomi.setcodigo("");	
				formatonomi.setnombre("");	
				formatonomi.setfecha(new Date());	
				formatonomi.setinstrucciones("");	
				formatonomi.setid_estructura(-1L);	
				formatonomi.setid_puntaje_nomi(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormatoNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiConstantesFunciones.LABEL_INSTRUCCIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiConstantesFunciones.LABEL_IDPUNTAJENOMI);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormatoNomi(String sTipo,Row row,Workbook workbook,FormatoNomi formatonomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomi.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomi.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomi.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomi.getinstrucciones());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomi.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomi.getpuntajenomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormatoNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormatoNomi() {
		return this.sFinalQueryFormatoNomi;
	}
	
	public void setsFinalQueryFormatoNomi(String sFinalQueryFormatoNomi) {
		this.sFinalQueryFormatoNomi= sFinalQueryFormatoNomi;
	}
	
	public Border resaltarSeleccionarFormatoNomi=null;
	
	public Border setResaltarSeleccionarFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormatoNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormatoNomi() {
		return this.resaltarSeleccionarFormatoNomi;
	}
	
	public void setResaltarSeleccionarFormatoNomi(Border borderResaltarSeleccionarFormatoNomi) {
		this.resaltarSeleccionarFormatoNomi= borderResaltarSeleccionarFormatoNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormatoNomi=null;
	public Boolean mostraridFormatoNomi=true;
	public Boolean activaridFormatoNomi=true;

	public Border resaltarid_empresaFormatoNomi=null;
	public Boolean mostrarid_empresaFormatoNomi=true;
	public Boolean activarid_empresaFormatoNomi=true;
	public Boolean cargarid_empresaFormatoNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormatoNomi=false;//ConEventDepend=true

	public Border resaltarid_sucursalFormatoNomi=null;
	public Boolean mostrarid_sucursalFormatoNomi=true;
	public Boolean activarid_sucursalFormatoNomi=true;
	public Boolean cargarid_sucursalFormatoNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFormatoNomi=false;//ConEventDepend=true

	public Border resaltarcodigoFormatoNomi=null;
	public Boolean mostrarcodigoFormatoNomi=true;
	public Boolean activarcodigoFormatoNomi=true;

	public Border resaltarnombreFormatoNomi=null;
	public Boolean mostrarnombreFormatoNomi=true;
	public Boolean activarnombreFormatoNomi=true;

	public Border resaltarfechaFormatoNomi=null;
	public Boolean mostrarfechaFormatoNomi=true;
	public Boolean activarfechaFormatoNomi=false;

	public Border resaltarinstruccionesFormatoNomi=null;
	public Boolean mostrarinstruccionesFormatoNomi=true;
	public Boolean activarinstruccionesFormatoNomi=true;

	public Border resaltarid_estructuraFormatoNomi=null;
	public Boolean mostrarid_estructuraFormatoNomi=true;
	public Boolean activarid_estructuraFormatoNomi=true;
	public Boolean cargarid_estructuraFormatoNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraFormatoNomi=false;//ConEventDepend=true

	public Border resaltarid_puntaje_nomiFormatoNomi=null;
	public Boolean mostrarid_puntaje_nomiFormatoNomi=true;
	public Boolean activarid_puntaje_nomiFormatoNomi=true;
	public Boolean cargarid_puntaje_nomiFormatoNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_puntaje_nomiFormatoNomi=false;//ConEventDepend=true

	
	

	public Border setResaltaridFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltaridFormatoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormatoNomi() {
		return this.resaltaridFormatoNomi;
	}

	public void setResaltaridFormatoNomi(Border borderResaltar) {
		this.resaltaridFormatoNomi= borderResaltar;
	}

	public Boolean getMostraridFormatoNomi() {
		return this.mostraridFormatoNomi;
	}

	public void setMostraridFormatoNomi(Boolean mostraridFormatoNomi) {
		this.mostraridFormatoNomi= mostraridFormatoNomi;
	}

	public Boolean getActivaridFormatoNomi() {
		return this.activaridFormatoNomi;
	}

	public void setActivaridFormatoNomi(Boolean activaridFormatoNomi) {
		this.activaridFormatoNomi= activaridFormatoNomi;
	}

	public Border setResaltarid_empresaFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormatoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormatoNomi() {
		return this.resaltarid_empresaFormatoNomi;
	}

	public void setResaltarid_empresaFormatoNomi(Border borderResaltar) {
		this.resaltarid_empresaFormatoNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormatoNomi() {
		return this.mostrarid_empresaFormatoNomi;
	}

	public void setMostrarid_empresaFormatoNomi(Boolean mostrarid_empresaFormatoNomi) {
		this.mostrarid_empresaFormatoNomi= mostrarid_empresaFormatoNomi;
	}

	public Boolean getActivarid_empresaFormatoNomi() {
		return this.activarid_empresaFormatoNomi;
	}

	public void setActivarid_empresaFormatoNomi(Boolean activarid_empresaFormatoNomi) {
		this.activarid_empresaFormatoNomi= activarid_empresaFormatoNomi;
	}

	public Boolean getCargarid_empresaFormatoNomi() {
		return this.cargarid_empresaFormatoNomi;
	}

	public void setCargarid_empresaFormatoNomi(Boolean cargarid_empresaFormatoNomi) {
		this.cargarid_empresaFormatoNomi= cargarid_empresaFormatoNomi;
	}

	public Border setResaltarid_sucursalFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFormatoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFormatoNomi() {
		return this.resaltarid_sucursalFormatoNomi;
	}

	public void setResaltarid_sucursalFormatoNomi(Border borderResaltar) {
		this.resaltarid_sucursalFormatoNomi= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFormatoNomi() {
		return this.mostrarid_sucursalFormatoNomi;
	}

	public void setMostrarid_sucursalFormatoNomi(Boolean mostrarid_sucursalFormatoNomi) {
		this.mostrarid_sucursalFormatoNomi= mostrarid_sucursalFormatoNomi;
	}

	public Boolean getActivarid_sucursalFormatoNomi() {
		return this.activarid_sucursalFormatoNomi;
	}

	public void setActivarid_sucursalFormatoNomi(Boolean activarid_sucursalFormatoNomi) {
		this.activarid_sucursalFormatoNomi= activarid_sucursalFormatoNomi;
	}

	public Boolean getCargarid_sucursalFormatoNomi() {
		return this.cargarid_sucursalFormatoNomi;
	}

	public void setCargarid_sucursalFormatoNomi(Boolean cargarid_sucursalFormatoNomi) {
		this.cargarid_sucursalFormatoNomi= cargarid_sucursalFormatoNomi;
	}

	public Border setResaltarcodigoFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltarcodigoFormatoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoFormatoNomi() {
		return this.resaltarcodigoFormatoNomi;
	}

	public void setResaltarcodigoFormatoNomi(Border borderResaltar) {
		this.resaltarcodigoFormatoNomi= borderResaltar;
	}

	public Boolean getMostrarcodigoFormatoNomi() {
		return this.mostrarcodigoFormatoNomi;
	}

	public void setMostrarcodigoFormatoNomi(Boolean mostrarcodigoFormatoNomi) {
		this.mostrarcodigoFormatoNomi= mostrarcodigoFormatoNomi;
	}

	public Boolean getActivarcodigoFormatoNomi() {
		return this.activarcodigoFormatoNomi;
	}

	public void setActivarcodigoFormatoNomi(Boolean activarcodigoFormatoNomi) {
		this.activarcodigoFormatoNomi= activarcodigoFormatoNomi;
	}

	public Border setResaltarnombreFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltarnombreFormatoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreFormatoNomi() {
		return this.resaltarnombreFormatoNomi;
	}

	public void setResaltarnombreFormatoNomi(Border borderResaltar) {
		this.resaltarnombreFormatoNomi= borderResaltar;
	}

	public Boolean getMostrarnombreFormatoNomi() {
		return this.mostrarnombreFormatoNomi;
	}

	public void setMostrarnombreFormatoNomi(Boolean mostrarnombreFormatoNomi) {
		this.mostrarnombreFormatoNomi= mostrarnombreFormatoNomi;
	}

	public Boolean getActivarnombreFormatoNomi() {
		return this.activarnombreFormatoNomi;
	}

	public void setActivarnombreFormatoNomi(Boolean activarnombreFormatoNomi) {
		this.activarnombreFormatoNomi= activarnombreFormatoNomi;
	}

	public Border setResaltarfechaFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltarfechaFormatoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaFormatoNomi() {
		return this.resaltarfechaFormatoNomi;
	}

	public void setResaltarfechaFormatoNomi(Border borderResaltar) {
		this.resaltarfechaFormatoNomi= borderResaltar;
	}

	public Boolean getMostrarfechaFormatoNomi() {
		return this.mostrarfechaFormatoNomi;
	}

	public void setMostrarfechaFormatoNomi(Boolean mostrarfechaFormatoNomi) {
		this.mostrarfechaFormatoNomi= mostrarfechaFormatoNomi;
	}

	public Boolean getActivarfechaFormatoNomi() {
		return this.activarfechaFormatoNomi;
	}

	public void setActivarfechaFormatoNomi(Boolean activarfechaFormatoNomi) {
		this.activarfechaFormatoNomi= activarfechaFormatoNomi;
	}

	public Border setResaltarinstruccionesFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltarinstruccionesFormatoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinstruccionesFormatoNomi() {
		return this.resaltarinstruccionesFormatoNomi;
	}

	public void setResaltarinstruccionesFormatoNomi(Border borderResaltar) {
		this.resaltarinstruccionesFormatoNomi= borderResaltar;
	}

	public Boolean getMostrarinstruccionesFormatoNomi() {
		return this.mostrarinstruccionesFormatoNomi;
	}

	public void setMostrarinstruccionesFormatoNomi(Boolean mostrarinstruccionesFormatoNomi) {
		this.mostrarinstruccionesFormatoNomi= mostrarinstruccionesFormatoNomi;
	}

	public Boolean getActivarinstruccionesFormatoNomi() {
		return this.activarinstruccionesFormatoNomi;
	}

	public void setActivarinstruccionesFormatoNomi(Boolean activarinstruccionesFormatoNomi) {
		this.activarinstruccionesFormatoNomi= activarinstruccionesFormatoNomi;
	}

	public Border setResaltarid_estructuraFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltarid_estructuraFormatoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraFormatoNomi() {
		return this.resaltarid_estructuraFormatoNomi;
	}

	public void setResaltarid_estructuraFormatoNomi(Border borderResaltar) {
		this.resaltarid_estructuraFormatoNomi= borderResaltar;
	}

	public Boolean getMostrarid_estructuraFormatoNomi() {
		return this.mostrarid_estructuraFormatoNomi;
	}

	public void setMostrarid_estructuraFormatoNomi(Boolean mostrarid_estructuraFormatoNomi) {
		this.mostrarid_estructuraFormatoNomi= mostrarid_estructuraFormatoNomi;
	}

	public Boolean getActivarid_estructuraFormatoNomi() {
		return this.activarid_estructuraFormatoNomi;
	}

	public void setActivarid_estructuraFormatoNomi(Boolean activarid_estructuraFormatoNomi) {
		this.activarid_estructuraFormatoNomi= activarid_estructuraFormatoNomi;
	}

	public Boolean getCargarid_estructuraFormatoNomi() {
		return this.cargarid_estructuraFormatoNomi;
	}

	public void setCargarid_estructuraFormatoNomi(Boolean cargarid_estructuraFormatoNomi) {
		this.cargarid_estructuraFormatoNomi= cargarid_estructuraFormatoNomi;
	}

	public Border setResaltarid_puntaje_nomiFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltar);
		
		this.resaltarid_puntaje_nomiFormatoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_puntaje_nomiFormatoNomi() {
		return this.resaltarid_puntaje_nomiFormatoNomi;
	}

	public void setResaltarid_puntaje_nomiFormatoNomi(Border borderResaltar) {
		this.resaltarid_puntaje_nomiFormatoNomi= borderResaltar;
	}

	public Boolean getMostrarid_puntaje_nomiFormatoNomi() {
		return this.mostrarid_puntaje_nomiFormatoNomi;
	}

	public void setMostrarid_puntaje_nomiFormatoNomi(Boolean mostrarid_puntaje_nomiFormatoNomi) {
		this.mostrarid_puntaje_nomiFormatoNomi= mostrarid_puntaje_nomiFormatoNomi;
	}

	public Boolean getActivarid_puntaje_nomiFormatoNomi() {
		return this.activarid_puntaje_nomiFormatoNomi;
	}

	public void setActivarid_puntaje_nomiFormatoNomi(Boolean activarid_puntaje_nomiFormatoNomi) {
		this.activarid_puntaje_nomiFormatoNomi= activarid_puntaje_nomiFormatoNomi;
	}

	public Boolean getCargarid_puntaje_nomiFormatoNomi() {
		return this.cargarid_puntaje_nomiFormatoNomi;
	}

	public void setCargarid_puntaje_nomiFormatoNomi(Boolean cargarid_puntaje_nomiFormatoNomi) {
		this.cargarid_puntaje_nomiFormatoNomi= cargarid_puntaje_nomiFormatoNomi;
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
		
		
		this.setMostraridFormatoNomi(esInicial);
		this.setMostrarid_empresaFormatoNomi(esInicial);
		this.setMostrarid_sucursalFormatoNomi(esInicial);
		this.setMostrarcodigoFormatoNomi(esInicial);
		this.setMostrarnombreFormatoNomi(esInicial);
		this.setMostrarfechaFormatoNomi(esInicial);
		this.setMostrarinstruccionesFormatoNomi(esInicial);
		this.setMostrarid_estructuraFormatoNomi(esInicial);
		this.setMostrarid_puntaje_nomiFormatoNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoNomiConstantesFunciones.ID)) {
				this.setMostraridFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.FECHA)) {
				this.setMostrarfechaFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.INSTRUCCIONES)) {
				this.setMostrarinstruccionesFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDPUNTAJENOMI)) {
				this.setMostrarid_puntaje_nomiFormatoNomi(esAsigna);
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
		
		
		this.setActivaridFormatoNomi(esInicial);
		this.setActivarid_empresaFormatoNomi(esInicial);
		this.setActivarid_sucursalFormatoNomi(esInicial);
		this.setActivarcodigoFormatoNomi(esInicial);
		this.setActivarnombreFormatoNomi(esInicial);
		this.setActivarfechaFormatoNomi(esInicial);
		this.setActivarinstruccionesFormatoNomi(esInicial);
		this.setActivarid_estructuraFormatoNomi(esInicial);
		this.setActivarid_puntaje_nomiFormatoNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoNomiConstantesFunciones.ID)) {
				this.setActivaridFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.FECHA)) {
				this.setActivarfechaFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.INSTRUCCIONES)) {
				this.setActivarinstruccionesFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDPUNTAJENOMI)) {
				this.setActivarid_puntaje_nomiFormatoNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormatoNomi(esInicial);
		this.setResaltarid_empresaFormatoNomi(esInicial);
		this.setResaltarid_sucursalFormatoNomi(esInicial);
		this.setResaltarcodigoFormatoNomi(esInicial);
		this.setResaltarnombreFormatoNomi(esInicial);
		this.setResaltarfechaFormatoNomi(esInicial);
		this.setResaltarinstruccionesFormatoNomi(esInicial);
		this.setResaltarid_estructuraFormatoNomi(esInicial);
		this.setResaltarid_puntaje_nomiFormatoNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoNomiConstantesFunciones.ID)) {
				this.setResaltaridFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.FECHA)) {
				this.setResaltarfechaFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.INSTRUCCIONES)) {
				this.setResaltarinstruccionesFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraFormatoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiConstantesFunciones.IDPUNTAJENOMI)) {
				this.setResaltarid_puntaje_nomiFormatoNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormatoNomiPreguntaNomiFormatoNomi=null;

	public Border getResaltarFormatoNomiPreguntaNomiFormatoNomi() {
		return this.resaltarFormatoNomiPreguntaNomiFormatoNomi;
	}

	public void setResaltarFormatoNomiPreguntaNomiFormatoNomi(Border borderResaltarFormatoNomiPreguntaNomi) {
		if(borderResaltarFormatoNomiPreguntaNomi!=null) {
			this.resaltarFormatoNomiPreguntaNomiFormatoNomi= borderResaltarFormatoNomiPreguntaNomi;
		}
	}

	public Border setResaltarFormatoNomiPreguntaNomiFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltarFormatoNomiPreguntaNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltarFormatoNomiPreguntaNomi);
			
		this.resaltarFormatoNomiPreguntaNomiFormatoNomi= borderResaltarFormatoNomiPreguntaNomi;

		 return borderResaltarFormatoNomiPreguntaNomi;
	}



	public Boolean mostrarFormatoNomiPreguntaNomiFormatoNomi=true;

	public Boolean getMostrarFormatoNomiPreguntaNomiFormatoNomi() {
		return this.mostrarFormatoNomiPreguntaNomiFormatoNomi;
	}

	public void setMostrarFormatoNomiPreguntaNomiFormatoNomi(Boolean visibilidadResaltarFormatoNomiPreguntaNomi) {
		this.mostrarFormatoNomiPreguntaNomiFormatoNomi= visibilidadResaltarFormatoNomiPreguntaNomi;
	}



	public Boolean activarFormatoNomiPreguntaNomiFormatoNomi=true;

	public Boolean gethabilitarResaltarFormatoNomiPreguntaNomiFormatoNomi() {
		return this.activarFormatoNomiPreguntaNomiFormatoNomi;
	}

	public void setActivarFormatoNomiPreguntaNomiFormatoNomi(Boolean habilitarResaltarFormatoNomiPreguntaNomi) {
		this.activarFormatoNomiPreguntaNomiFormatoNomi= habilitarResaltarFormatoNomiPreguntaNomi;
	}


	public Border resaltarFormatoNomiFactorNomiFormatoNomi=null;

	public Border getResaltarFormatoNomiFactorNomiFormatoNomi() {
		return this.resaltarFormatoNomiFactorNomiFormatoNomi;
	}

	public void setResaltarFormatoNomiFactorNomiFormatoNomi(Border borderResaltarFormatoNomiFactorNomi) {
		if(borderResaltarFormatoNomiFactorNomi!=null) {
			this.resaltarFormatoNomiFactorNomiFormatoNomi= borderResaltarFormatoNomiFactorNomi;
		}
	}

	public Border setResaltarFormatoNomiFactorNomiFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltarFormatoNomiFactorNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltarFormatoNomiFactorNomi);
			
		this.resaltarFormatoNomiFactorNomiFormatoNomi= borderResaltarFormatoNomiFactorNomi;

		 return borderResaltarFormatoNomiFactorNomi;
	}



	public Boolean mostrarFormatoNomiFactorNomiFormatoNomi=true;

	public Boolean getMostrarFormatoNomiFactorNomiFormatoNomi() {
		return this.mostrarFormatoNomiFactorNomiFormatoNomi;
	}

	public void setMostrarFormatoNomiFactorNomiFormatoNomi(Boolean visibilidadResaltarFormatoNomiFactorNomi) {
		this.mostrarFormatoNomiFactorNomiFormatoNomi= visibilidadResaltarFormatoNomiFactorNomi;
	}



	public Boolean activarFormatoNomiFactorNomiFormatoNomi=true;

	public Boolean gethabilitarResaltarFormatoNomiFactorNomiFormatoNomi() {
		return this.activarFormatoNomiFactorNomiFormatoNomi;
	}

	public void setActivarFormatoNomiFactorNomiFormatoNomi(Boolean habilitarResaltarFormatoNomiFactorNomi) {
		this.activarFormatoNomiFactorNomiFormatoNomi= habilitarResaltarFormatoNomiFactorNomi;
	}


	public Border resaltarEvaluacionNomiFormatoNomi=null;

	public Border getResaltarEvaluacionNomiFormatoNomi() {
		return this.resaltarEvaluacionNomiFormatoNomi;
	}

	public void setResaltarEvaluacionNomiFormatoNomi(Border borderResaltarEvaluacionNomi) {
		if(borderResaltarEvaluacionNomi!=null) {
			this.resaltarEvaluacionNomiFormatoNomi= borderResaltarEvaluacionNomi;
		}
	}

	public Border setResaltarEvaluacionNomiFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltarEvaluacionNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltarEvaluacionNomi);
			
		this.resaltarEvaluacionNomiFormatoNomi= borderResaltarEvaluacionNomi;

		 return borderResaltarEvaluacionNomi;
	}



	public Boolean mostrarEvaluacionNomiFormatoNomi=true;

	public Boolean getMostrarEvaluacionNomiFormatoNomi() {
		return this.mostrarEvaluacionNomiFormatoNomi;
	}

	public void setMostrarEvaluacionNomiFormatoNomi(Boolean visibilidadResaltarEvaluacionNomi) {
		this.mostrarEvaluacionNomiFormatoNomi= visibilidadResaltarEvaluacionNomi;
	}



	public Boolean activarEvaluacionNomiFormatoNomi=true;

	public Boolean gethabilitarResaltarEvaluacionNomiFormatoNomi() {
		return this.activarEvaluacionNomiFormatoNomi;
	}

	public void setActivarEvaluacionNomiFormatoNomi(Boolean habilitarResaltarEvaluacionNomi) {
		this.activarEvaluacionNomiFormatoNomi= habilitarResaltarEvaluacionNomi;
	}


	public Border resaltarDetalleEvaluacionNomiFormatoNomi=null;

	public Border getResaltarDetalleEvaluacionNomiFormatoNomi() {
		return this.resaltarDetalleEvaluacionNomiFormatoNomi;
	}

	public void setResaltarDetalleEvaluacionNomiFormatoNomi(Border borderResaltarDetalleEvaluacionNomi) {
		if(borderResaltarDetalleEvaluacionNomi!=null) {
			this.resaltarDetalleEvaluacionNomiFormatoNomi= borderResaltarDetalleEvaluacionNomi;
		}
	}

	public Border setResaltarDetalleEvaluacionNomiFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleEvaluacionNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//formatonomiBeanSwingJInternalFrame.jTtoolBarFormatoNomi.setBorder(borderResaltarDetalleEvaluacionNomi);
			
		this.resaltarDetalleEvaluacionNomiFormatoNomi= borderResaltarDetalleEvaluacionNomi;

		 return borderResaltarDetalleEvaluacionNomi;
	}



	public Boolean mostrarDetalleEvaluacionNomiFormatoNomi=true;

	public Boolean getMostrarDetalleEvaluacionNomiFormatoNomi() {
		return this.mostrarDetalleEvaluacionNomiFormatoNomi;
	}

	public void setMostrarDetalleEvaluacionNomiFormatoNomi(Boolean visibilidadResaltarDetalleEvaluacionNomi) {
		this.mostrarDetalleEvaluacionNomiFormatoNomi= visibilidadResaltarDetalleEvaluacionNomi;
	}



	public Boolean activarDetalleEvaluacionNomiFormatoNomi=true;

	public Boolean gethabilitarResaltarDetalleEvaluacionNomiFormatoNomi() {
		return this.activarDetalleEvaluacionNomiFormatoNomi;
	}

	public void setActivarDetalleEvaluacionNomiFormatoNomi(Boolean habilitarResaltarDetalleEvaluacionNomi) {
		this.activarDetalleEvaluacionNomiFormatoNomi= habilitarResaltarDetalleEvaluacionNomi;
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

		this.setMostrarFormatoNomiPreguntaNomiFormatoNomi(esInicial);
		this.setMostrarFormatoNomiFactorNomiFormatoNomi(esInicial);
		this.setMostrarEvaluacionNomiFormatoNomi(esInicial);
		this.setMostrarDetalleEvaluacionNomiFormatoNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomiPreguntaNomi.class)) {
				this.setMostrarFormatoNomiPreguntaNomiFormatoNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormatoNomiFactorNomi.class)) {
				this.setMostrarFormatoNomiFactorNomiFormatoNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(EvaluacionNomi.class)) {
				this.setMostrarEvaluacionNomiFormatoNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleEvaluacionNomi.class)) {
				this.setMostrarDetalleEvaluacionNomiFormatoNomi(esAsigna);
				continue;
			}
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

		this.setActivarFormatoNomiPreguntaNomiFormatoNomi(esInicial);
		this.setActivarFormatoNomiFactorNomiFormatoNomi(esInicial);
		this.setActivarEvaluacionNomiFormatoNomi(esInicial);
		this.setActivarDetalleEvaluacionNomiFormatoNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomiPreguntaNomi.class)) {
				this.setActivarFormatoNomiPreguntaNomiFormatoNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormatoNomiFactorNomi.class)) {
				this.setActivarFormatoNomiFactorNomiFormatoNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(EvaluacionNomi.class)) {
				this.setActivarEvaluacionNomiFormatoNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleEvaluacionNomi.class)) {
				this.setActivarDetalleEvaluacionNomiFormatoNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormatoNomiPreguntaNomiFormatoNomi(esInicial);
		this.setResaltarFormatoNomiFactorNomiFormatoNomi(esInicial);
		this.setResaltarEvaluacionNomiFormatoNomi(esInicial);
		this.setResaltarDetalleEvaluacionNomiFormatoNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomiPreguntaNomi.class)) {
				this.setResaltarFormatoNomiPreguntaNomiFormatoNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormatoNomiFactorNomi.class)) {
				this.setResaltarFormatoNomiFactorNomiFormatoNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(EvaluacionNomi.class)) {
				this.setResaltarEvaluacionNomiFormatoNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleEvaluacionNomi.class)) {
				this.setResaltarDetalleEvaluacionNomiFormatoNomi(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaFormatoNomi=true;

	public Boolean getMostrarFK_IdEmpresaFormatoNomi() {
		return this.mostrarFK_IdEmpresaFormatoNomi;
	}

	public void setMostrarFK_IdEmpresaFormatoNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormatoNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraFormatoNomi=true;

	public Boolean getMostrarFK_IdEstructuraFormatoNomi() {
		return this.mostrarFK_IdEstructuraFormatoNomi;
	}

	public void setMostrarFK_IdEstructuraFormatoNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraFormatoNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPuntajeNomiFormatoNomi=true;

	public Boolean getMostrarFK_IdPuntajeNomiFormatoNomi() {
		return this.mostrarFK_IdPuntajeNomiFormatoNomi;
	}

	public void setMostrarFK_IdPuntajeNomiFormatoNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPuntajeNomiFormatoNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFormatoNomi=true;

	public Boolean getMostrarFK_IdSucursalFormatoNomi() {
		return this.mostrarFK_IdSucursalFormatoNomi;
	}

	public void setMostrarFK_IdSucursalFormatoNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFormatoNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaFormatoNomi=true;

	public Boolean getActivarFK_IdEmpresaFormatoNomi() {
		return this.activarFK_IdEmpresaFormatoNomi;
	}

	public void setActivarFK_IdEmpresaFormatoNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormatoNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraFormatoNomi=true;

	public Boolean getActivarFK_IdEstructuraFormatoNomi() {
		return this.activarFK_IdEstructuraFormatoNomi;
	}

	public void setActivarFK_IdEstructuraFormatoNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraFormatoNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdPuntajeNomiFormatoNomi=true;

	public Boolean getActivarFK_IdPuntajeNomiFormatoNomi() {
		return this.activarFK_IdPuntajeNomiFormatoNomi;
	}

	public void setActivarFK_IdPuntajeNomiFormatoNomi(Boolean habilitarResaltar) {
		this.activarFK_IdPuntajeNomiFormatoNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFormatoNomi=true;

	public Boolean getActivarFK_IdSucursalFormatoNomi() {
		return this.activarFK_IdSucursalFormatoNomi;
	}

	public void setActivarFK_IdSucursalFormatoNomi(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFormatoNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaFormatoNomi=null;

	public Border getResaltarFK_IdEmpresaFormatoNomi() {
		return this.resaltarFK_IdEmpresaFormatoNomi;
	}

	public void setResaltarFK_IdEmpresaFormatoNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormatoNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormatoNomi= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraFormatoNomi=null;

	public Border getResaltarFK_IdEstructuraFormatoNomi() {
		return this.resaltarFK_IdEstructuraFormatoNomi;
	}

	public void setResaltarFK_IdEstructuraFormatoNomi(Border borderResaltar) {
		this.resaltarFK_IdEstructuraFormatoNomi= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraFormatoNomi= borderResaltar;
	}

	public Border resaltarFK_IdPuntajeNomiFormatoNomi=null;

	public Border getResaltarFK_IdPuntajeNomiFormatoNomi() {
		return this.resaltarFK_IdPuntajeNomiFormatoNomi;
	}

	public void setResaltarFK_IdPuntajeNomiFormatoNomi(Border borderResaltar) {
		this.resaltarFK_IdPuntajeNomiFormatoNomi= borderResaltar;
	}

	public void setResaltarFK_IdPuntajeNomiFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPuntajeNomiFormatoNomi= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFormatoNomi=null;

	public Border getResaltarFK_IdSucursalFormatoNomi() {
		return this.resaltarFK_IdSucursalFormatoNomi;
	}

	public void setResaltarFK_IdSucursalFormatoNomi(Border borderResaltar) {
		this.resaltarFK_IdSucursalFormatoNomi= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFormatoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiBeanSwingJInternalFrame formatonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFormatoNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}