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


import com.bydan.erp.nomina.util.FormatoNomiPreguntaNomiConstantesFunciones;
import com.bydan.erp.nomina.util.FormatoNomiPreguntaNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FormatoNomiPreguntaNomiParameterGeneral;

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
final public class FormatoNomiPreguntaNomiConstantesFunciones extends FormatoNomiPreguntaNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FormatoNomiPreguntaNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormatoNomiPreguntaNomi"+FormatoNomiPreguntaNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormatoNomiPreguntaNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormatoNomiPreguntaNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiPreguntaNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormatoNomiPreguntaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiPreguntaNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiPreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormatoNomiPreguntaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"_"+FormatoNomiPreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiPreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoNomiPreguntaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiPreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiPreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoNomiPreguntaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoNomiPreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormatoNomiPreguntaNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormatoNomiPreguntaNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormatoNomiPreguntaNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormatoNomiPreguntaNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formato Nomi Pregunta Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Formato Nomi Pregunta Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Formato Nomi Pregunta Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormatoNomiPreguntaNomi";
	public static final String OBJECTNAME="formatonomipreguntanomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="formato_nomi_pregunta_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formatonomipreguntanomi from "+FormatoNomiPreguntaNomiConstantesFunciones.SPERSISTENCENAME+" formatonomipreguntanomi";
	public static String QUERYSELECTNATIVE="select "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".version_row,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_empresa,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_sucursal,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_formato_nomi,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_factor_nomi,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_pregunta_nomi,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".ponderacion from "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME;//+" as "+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormatoNomiPreguntaNomiConstantesFuncionesAdditional formatonomipreguntanomiConstantesFuncionesAdditional=null;
	
	public FormatoNomiPreguntaNomiConstantesFuncionesAdditional getFormatoNomiPreguntaNomiConstantesFuncionesAdditional() {
		return this.formatonomipreguntanomiConstantesFuncionesAdditional;
	}
	
	public void setFormatoNomiPreguntaNomiConstantesFuncionesAdditional(FormatoNomiPreguntaNomiConstantesFuncionesAdditional formatonomipreguntanomiConstantesFuncionesAdditional) {
		try {
			this.formatonomipreguntanomiConstantesFuncionesAdditional=formatonomipreguntanomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDFORMATONOMI= "id_formato_nomi";
    public static final String IDFACTORNOMI= "id_factor_nomi";
    public static final String IDPREGUNTANOMI= "id_pregunta_nomi";
    public static final String PONDERACION= "ponderacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDFORMATONOMI= "Formato Nomi";
		public static final String LABEL_IDFORMATONOMI_LOWER= "Formato Nomi";
    	public static final String LABEL_IDFACTORNOMI= "Factor Nomi";
		public static final String LABEL_IDFACTORNOMI_LOWER= "Factor Nomi";
    	public static final String LABEL_IDPREGUNTANOMI= "Pregunta Nomi";
		public static final String LABEL_IDPREGUNTANOMI_LOWER= "Pregunta Nomi";
    	public static final String LABEL_PONDERACION= "Ponderacion";
		public static final String LABEL_PONDERACION_LOWER= "Ponderacion";
	
		
		
		
		
		
		
		
		
	
	public static String getFormatoNomiPreguntaNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI)) {sLabelColumna=FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFORMATONOMI;}
		if(sNombreColumna.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI)) {sLabelColumna=FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI;}
		if(sNombreColumna.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI)) {sLabelColumna=FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDPREGUNTANOMI;}
		if(sNombreColumna.equals(FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION)) {sLabelColumna=FormatoNomiPreguntaNomiConstantesFunciones.LABEL_PONDERACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getFormatoNomiPreguntaNomiDescripcion(FormatoNomiPreguntaNomi formatonomipreguntanomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formatonomipreguntanomi !=null/* && formatonomipreguntanomi.getId()!=0*/) {
			if(formatonomipreguntanomi.getId()!=null) {
				sDescripcion=formatonomipreguntanomi.getId().toString();
			}//formatonomipreguntanomiformatonomipreguntanomi.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFormatoNomiPreguntaNomiDescripcionDetallado(FormatoNomiPreguntaNomi formatonomipreguntanomi) {
		String sDescripcion="";
			
		sDescripcion+=FormatoNomiPreguntaNomiConstantesFunciones.ID+"=";
		sDescripcion+=formatonomipreguntanomi.getId().toString()+",";
		sDescripcion+=FormatoNomiPreguntaNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formatonomipreguntanomi.getVersionRow().toString()+",";
		sDescripcion+=FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formatonomipreguntanomi.getid_empresa().toString()+",";
		sDescripcion+=FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=formatonomipreguntanomi.getid_sucursal().toString()+",";
		sDescripcion+=FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI+"=";
		sDescripcion+=formatonomipreguntanomi.getid_formato_nomi().toString()+",";
		sDescripcion+=FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI+"=";
		sDescripcion+=formatonomipreguntanomi.getid_factor_nomi().toString()+",";
		sDescripcion+=FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI+"=";
		sDescripcion+=formatonomipreguntanomi.getid_pregunta_nomi().toString()+",";
		sDescripcion+=FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION+"=";
		sDescripcion+=formatonomipreguntanomi.getponderacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormatoNomiPreguntaNomiDescripcion(FormatoNomiPreguntaNomi formatonomipreguntanomi,String sValor) throws Exception {			
		if(formatonomipreguntanomi !=null) {
			//formatonomipreguntanomiformatonomipreguntanomi.getId().toString();
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

	public static String getFormatoNomiDescripcion(FormatoNomi formatonomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formatonomi!=null/*&&formatonomi.getId()>0*/) {
			sDescripcion=FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(formatonomi);
		}

		return sDescripcion;
	}

	public static String getFactorNomiDescripcion(FactorNomi factornomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factornomi!=null/*&&factornomi.getId()>0*/) {
			sDescripcion=FactorNomiConstantesFunciones.getFactorNomiDescripcion(factornomi);
		}

		return sDescripcion;
	}

	public static String getPreguntaNomiDescripcion(PreguntaNomi preguntanomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(preguntanomi!=null/*&&preguntanomi.getId()>0*/) {
			sDescripcion=PreguntaNomiConstantesFunciones.getPreguntaNomiDescripcion(preguntanomi);
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
		} else if(sNombreIndice.equals("FK_IdFactorNomi")) {
			sNombreIndice="Tipo=  Por Factor Nomi";
		} else if(sNombreIndice.equals("FK_IdFormatoNomi")) {
			sNombreIndice="Tipo=  Por Formato Nomi";
		} else if(sNombreIndice.equals("FK_IdPreguntaNomi")) {
			sNombreIndice="Tipo=  Por Pregunta Nomi";
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

	public static String getDetalleIndiceFK_IdFactorNomi(Long id_factor_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_factor_nomi!=null) {sDetalleIndice+=" Codigo Unico De Factor Nomi="+id_factor_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoNomi(Long id_formato_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nomi!=null) {sDetalleIndice+=" Codigo Unico De Formato Nomi="+id_formato_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPreguntaNomi(Long id_pregunta_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_pregunta_nomi!=null) {sDetalleIndice+=" Codigo Unico De Pregunta Nomi="+id_pregunta_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi formatonomipreguntanomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosFormatoNomiPreguntaNomis(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi: formatonomipreguntanomis) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi formatonomipreguntanomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formatonomipreguntanomi.getConCambioAuxiliar()) {
			formatonomipreguntanomi.setIsDeleted(formatonomipreguntanomi.getIsDeletedAuxiliar());	
			formatonomipreguntanomi.setIsNew(formatonomipreguntanomi.getIsNewAuxiliar());	
			formatonomipreguntanomi.setIsChanged(formatonomipreguntanomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formatonomipreguntanomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formatonomipreguntanomi.setIsDeletedAuxiliar(false);	
			formatonomipreguntanomi.setIsNewAuxiliar(false);	
			formatonomipreguntanomi.setIsChangedAuxiliar(false);
			
			formatonomipreguntanomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormatoNomiPreguntaNomis(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi : formatonomipreguntanomis) {
			if(conAsignarBase && formatonomipreguntanomi.getConCambioAuxiliar()) {
				formatonomipreguntanomi.setIsDeleted(formatonomipreguntanomi.getIsDeletedAuxiliar());	
				formatonomipreguntanomi.setIsNew(formatonomipreguntanomi.getIsNewAuxiliar());	
				formatonomipreguntanomi.setIsChanged(formatonomipreguntanomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formatonomipreguntanomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formatonomipreguntanomi.setIsDeletedAuxiliar(false);	
				formatonomipreguntanomi.setIsNewAuxiliar(false);	
				formatonomipreguntanomi.setIsChangedAuxiliar(false);
				
				formatonomipreguntanomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi formatonomipreguntanomi,Boolean conEnteros) throws Exception  {
		formatonomipreguntanomi.setponderacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormatoNomiPreguntaNomis(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,Boolean conEnteros) throws Exception  {
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi: formatonomipreguntanomis) {
			formatonomipreguntanomi.setponderacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormatoNomiPreguntaNomi(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,FormatoNomiPreguntaNomi formatonomipreguntanomiAux) throws Exception  {
		FormatoNomiPreguntaNomiConstantesFunciones.InicializarValoresFormatoNomiPreguntaNomi(formatonomipreguntanomiAux,true);
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi: formatonomipreguntanomis) {
			if(formatonomipreguntanomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			formatonomipreguntanomiAux.setponderacion(formatonomipreguntanomiAux.getponderacion()+formatonomipreguntanomi.getponderacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormatoNomiPreguntaNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormatoNomiPreguntaNomiConstantesFunciones.getArrayColumnasGlobalesFormatoNomiPreguntaNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormatoNomiPreguntaNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormatoNomiPreguntaNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,FormatoNomiPreguntaNomi formatonomipreguntanomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomiAux: formatonomipreguntanomis) {
			if(formatonomipreguntanomiAux!=null && formatonomipreguntanomi!=null) {
				if((formatonomipreguntanomiAux.getId()==null && formatonomipreguntanomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formatonomipreguntanomiAux.getId()!=null && formatonomipreguntanomi.getId()!=null){
					if(formatonomipreguntanomiAux.getId().equals(formatonomipreguntanomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormatoNomiPreguntaNomi(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ponderacionTotal=0.0;
	
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi: formatonomipreguntanomis) {			
			if(formatonomipreguntanomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ponderacionTotal+=formatonomipreguntanomi.getponderacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION);
		datoGeneral.setsDescripcion(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_PONDERACION);
		datoGeneral.setdValorDouble(ponderacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormatoNomiPreguntaNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormatoNomiPreguntaNomiConstantesFunciones.LABEL_ID, FormatoNomiPreguntaNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiPreguntaNomiConstantesFunciones.LABEL_VERSIONROW, FormatoNomiPreguntaNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDEMPRESA, FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDSUCURSAL, FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFORMATONOMI, FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI, FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDPREGUNTANOMI, FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoNomiPreguntaNomiConstantesFunciones.LABEL_PONDERACION, FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormatoNomiPreguntaNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiPreguntaNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiPreguntaNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoNomiPreguntaNomi() throws Exception  {
		return FormatoNomiPreguntaNomiConstantesFunciones.getTiposSeleccionarFormatoNomiPreguntaNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoNomiPreguntaNomi(Boolean conFk) throws Exception  {
		return FormatoNomiPreguntaNomiConstantesFunciones.getTiposSeleccionarFormatoNomiPreguntaNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormatoNomiPreguntaNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFORMATONOMI);
			reporte.setsDescripcion(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFORMATONOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI);
			reporte.setsDescripcion(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDPREGUNTANOMI);
			reporte.setsDescripcion(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDPREGUNTANOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_PONDERACION);
			reporte.setsDescripcion(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_PONDERACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormatoNomiPreguntaNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi formatonomipreguntanomiAux) throws Exception {
		
			formatonomipreguntanomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatonomipreguntanomiAux.getEmpresa()));
			formatonomipreguntanomiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formatonomipreguntanomiAux.getSucursal()));
			formatonomipreguntanomiAux.setformatonomi_descripcion(FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(formatonomipreguntanomiAux.getFormatoNomi()));
			formatonomipreguntanomiAux.setfactornomi_descripcion(FactorNomiConstantesFunciones.getFactorNomiDescripcion(formatonomipreguntanomiAux.getFactorNomi()));
			formatonomipreguntanomiAux.setpreguntanomi_descripcion(PreguntaNomiConstantesFunciones.getPreguntaNomiDescripcion(formatonomipreguntanomiAux.getPreguntaNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(List<FormatoNomiPreguntaNomi> formatonomipreguntanomisTemp) throws Exception {
		for(FormatoNomiPreguntaNomi formatonomipreguntanomiAux:formatonomipreguntanomisTemp) {
			
			formatonomipreguntanomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatonomipreguntanomiAux.getEmpresa()));
			formatonomipreguntanomiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formatonomipreguntanomiAux.getSucursal()));
			formatonomipreguntanomiAux.setformatonomi_descripcion(FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(formatonomipreguntanomiAux.getFormatoNomi()));
			formatonomipreguntanomiAux.setfactornomi_descripcion(FactorNomiConstantesFunciones.getFactorNomiDescripcion(formatonomipreguntanomiAux.getFactorNomi()));
			formatonomipreguntanomiAux.setpreguntanomi_descripcion(PreguntaNomiConstantesFunciones.getPreguntaNomiDescripcion(formatonomipreguntanomiAux.getPreguntaNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormatoNomiPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(FormatoNomi.class));
				classes.add(new Classe(FactorNomi.class));
				classes.add(new Classe(PreguntaNomi.class));
				
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
					if(clas.clas.equals(FormatoNomi.class)) {
						classes.add(new Classe(FormatoNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FactorNomi.class)) {
						classes.add(new Classe(FactorNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PreguntaNomi.class)) {
						classes.add(new Classe(PreguntaNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormatoNomiPreguntaNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(FactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FactorNomi.class)); continue;
					}

					if(PreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaNomi.class)); continue;
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

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(FactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FactorNomi.class)); continue;
					}

					if(PreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoNomiPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoNomiPreguntaNomiConstantesFunciones.getClassesRelationshipsOfFormatoNomiPreguntaNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoNomiPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CalificacionEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CalificacionEmpleado.class)) {
						classes.add(new Classe(CalificacionEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormatoNomiPreguntaNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoNomiPreguntaNomiConstantesFunciones.getClassesRelationshipsFromStringsOfFormatoNomiPreguntaNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormatoNomiPreguntaNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalificacionEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalificacionEmpleado.class)); continue;
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
	public static void actualizarLista(FormatoNomiPreguntaNomi formatonomipreguntanomi,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormatoNomiPreguntaNomi formatonomipreguntanomiEncontrado=null;
			
			for(FormatoNomiPreguntaNomi formatonomipreguntanomiLocal:formatonomipreguntanomis) {
				if(formatonomipreguntanomiLocal.getId().equals(formatonomipreguntanomi.getId())) {
					formatonomipreguntanomiEncontrado=formatonomipreguntanomiLocal;
					
					formatonomipreguntanomiLocal.setIsChanged(formatonomipreguntanomi.getIsChanged());
					formatonomipreguntanomiLocal.setIsNew(formatonomipreguntanomi.getIsNew());
					formatonomipreguntanomiLocal.setIsDeleted(formatonomipreguntanomi.getIsDeleted());
					
					formatonomipreguntanomiLocal.setGeneralEntityOriginal(formatonomipreguntanomi.getGeneralEntityOriginal());
					
					formatonomipreguntanomiLocal.setId(formatonomipreguntanomi.getId());	
					formatonomipreguntanomiLocal.setVersionRow(formatonomipreguntanomi.getVersionRow());	
					formatonomipreguntanomiLocal.setid_empresa(formatonomipreguntanomi.getid_empresa());	
					formatonomipreguntanomiLocal.setid_sucursal(formatonomipreguntanomi.getid_sucursal());	
					formatonomipreguntanomiLocal.setid_formato_nomi(formatonomipreguntanomi.getid_formato_nomi());	
					formatonomipreguntanomiLocal.setid_factor_nomi(formatonomipreguntanomi.getid_factor_nomi());	
					formatonomipreguntanomiLocal.setid_pregunta_nomi(formatonomipreguntanomi.getid_pregunta_nomi());	
					formatonomipreguntanomiLocal.setponderacion(formatonomipreguntanomi.getponderacion());	
					
					
					formatonomipreguntanomiLocal.setCalificacionEmpleados(formatonomipreguntanomi.getCalificacionEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!formatonomipreguntanomi.getIsDeleted()) {
				if(!existe) {
					formatonomipreguntanomis.add(formatonomipreguntanomi);
				}
			} else {
				if(formatonomipreguntanomiEncontrado!=null && permiteQuitar)  {
					formatonomipreguntanomis.remove(formatonomipreguntanomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormatoNomiPreguntaNomi formatonomipreguntanomi,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis) throws Exception {
		try	{			
			for(FormatoNomiPreguntaNomi formatonomipreguntanomiLocal:formatonomipreguntanomis) {
				if(formatonomipreguntanomiLocal.getId().equals(formatonomipreguntanomi.getId())) {
					formatonomipreguntanomiLocal.setIsSelected(formatonomipreguntanomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormatoNomiPreguntaNomi(List<FormatoNomiPreguntaNomi> formatonomipreguntanomisAux) throws Exception {
		//this.formatonomipreguntanomisAux=formatonomipreguntanomisAux;
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomiAux:formatonomipreguntanomisAux) {
			if(formatonomipreguntanomiAux.getIsChanged()) {
				formatonomipreguntanomiAux.setIsChanged(false);
			}		
			
			if(formatonomipreguntanomiAux.getIsNew()) {
				formatonomipreguntanomiAux.setIsNew(false);
			}	
			
			if(formatonomipreguntanomiAux.getIsDeleted()) {
				formatonomipreguntanomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi formatonomipreguntanomiAux) throws Exception {
		//this.formatonomipreguntanomiAux=formatonomipreguntanomiAux;
		
			if(formatonomipreguntanomiAux.getIsChanged()) {
				formatonomipreguntanomiAux.setIsChanged(false);
			}		
			
			if(formatonomipreguntanomiAux.getIsNew()) {
				formatonomipreguntanomiAux.setIsNew(false);
			}	
			
			if(formatonomipreguntanomiAux.getIsDeleted()) {
				formatonomipreguntanomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormatoNomiPreguntaNomi formatonomipreguntanomiAsignar,FormatoNomiPreguntaNomi formatonomipreguntanomi) throws Exception {
		formatonomipreguntanomiAsignar.setId(formatonomipreguntanomi.getId());	
		formatonomipreguntanomiAsignar.setVersionRow(formatonomipreguntanomi.getVersionRow());	
		formatonomipreguntanomiAsignar.setid_empresa(formatonomipreguntanomi.getid_empresa());
		formatonomipreguntanomiAsignar.setempresa_descripcion(formatonomipreguntanomi.getempresa_descripcion());	
		formatonomipreguntanomiAsignar.setid_sucursal(formatonomipreguntanomi.getid_sucursal());
		formatonomipreguntanomiAsignar.setsucursal_descripcion(formatonomipreguntanomi.getsucursal_descripcion());	
		formatonomipreguntanomiAsignar.setid_formato_nomi(formatonomipreguntanomi.getid_formato_nomi());
		formatonomipreguntanomiAsignar.setformatonomi_descripcion(formatonomipreguntanomi.getformatonomi_descripcion());	
		formatonomipreguntanomiAsignar.setid_factor_nomi(formatonomipreguntanomi.getid_factor_nomi());
		formatonomipreguntanomiAsignar.setfactornomi_descripcion(formatonomipreguntanomi.getfactornomi_descripcion());	
		formatonomipreguntanomiAsignar.setid_pregunta_nomi(formatonomipreguntanomi.getid_pregunta_nomi());
		formatonomipreguntanomiAsignar.setpreguntanomi_descripcion(formatonomipreguntanomi.getpreguntanomi_descripcion());	
		formatonomipreguntanomiAsignar.setponderacion(formatonomipreguntanomi.getponderacion());	
	}
	
	public static void inicializarFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi formatonomipreguntanomi) throws Exception {
		try {
				formatonomipreguntanomi.setId(0L);	
					
				formatonomipreguntanomi.setid_empresa(-1L);	
				formatonomipreguntanomi.setid_sucursal(-1L);	
				formatonomipreguntanomi.setid_formato_nomi(-1L);	
				formatonomipreguntanomi.setid_factor_nomi(-1L);	
				formatonomipreguntanomi.setid_pregunta_nomi(-1L);	
				formatonomipreguntanomi.setponderacion(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormatoNomiPreguntaNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFORMATONOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_IDPREGUNTANOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoNomiPreguntaNomiConstantesFunciones.LABEL_PONDERACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormatoNomiPreguntaNomi(String sTipo,Row row,Workbook workbook,FormatoNomiPreguntaNomi formatonomipreguntanomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomipreguntanomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomipreguntanomi.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomipreguntanomi.getformatonomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomipreguntanomi.getfactornomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomipreguntanomi.getpreguntanomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formatonomipreguntanomi.getponderacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormatoNomiPreguntaNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormatoNomiPreguntaNomi() {
		return this.sFinalQueryFormatoNomiPreguntaNomi;
	}
	
	public void setsFinalQueryFormatoNomiPreguntaNomi(String sFinalQueryFormatoNomiPreguntaNomi) {
		this.sFinalQueryFormatoNomiPreguntaNomi= sFinalQueryFormatoNomiPreguntaNomi;
	}
	
	public Border resaltarSeleccionarFormatoNomiPreguntaNomi=null;
	
	public Border setResaltarSeleccionarFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formatonomipreguntanomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormatoNomiPreguntaNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormatoNomiPreguntaNomi() {
		return this.resaltarSeleccionarFormatoNomiPreguntaNomi;
	}
	
	public void setResaltarSeleccionarFormatoNomiPreguntaNomi(Border borderResaltarSeleccionarFormatoNomiPreguntaNomi) {
		this.resaltarSeleccionarFormatoNomiPreguntaNomi= borderResaltarSeleccionarFormatoNomiPreguntaNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormatoNomiPreguntaNomi=null;
	public Boolean mostraridFormatoNomiPreguntaNomi=true;
	public Boolean activaridFormatoNomiPreguntaNomi=true;

	public Border resaltarid_empresaFormatoNomiPreguntaNomi=null;
	public Boolean mostrarid_empresaFormatoNomiPreguntaNomi=true;
	public Boolean activarid_empresaFormatoNomiPreguntaNomi=true;
	public Boolean cargarid_empresaFormatoNomiPreguntaNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormatoNomiPreguntaNomi=false;//ConEventDepend=true

	public Border resaltarid_sucursalFormatoNomiPreguntaNomi=null;
	public Boolean mostrarid_sucursalFormatoNomiPreguntaNomi=true;
	public Boolean activarid_sucursalFormatoNomiPreguntaNomi=true;
	public Boolean cargarid_sucursalFormatoNomiPreguntaNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFormatoNomiPreguntaNomi=false;//ConEventDepend=true

	public Border resaltarid_formato_nomiFormatoNomiPreguntaNomi=null;
	public Boolean mostrarid_formato_nomiFormatoNomiPreguntaNomi=true;
	public Boolean activarid_formato_nomiFormatoNomiPreguntaNomi=true;
	public Boolean cargarid_formato_nomiFormatoNomiPreguntaNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nomiFormatoNomiPreguntaNomi=false;//ConEventDepend=true

	public Border resaltarid_factor_nomiFormatoNomiPreguntaNomi=null;
	public Boolean mostrarid_factor_nomiFormatoNomiPreguntaNomi=true;
	public Boolean activarid_factor_nomiFormatoNomiPreguntaNomi=true;
	public Boolean cargarid_factor_nomiFormatoNomiPreguntaNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_factor_nomiFormatoNomiPreguntaNomi=false;//ConEventDepend=true

	public Border resaltarid_pregunta_nomiFormatoNomiPreguntaNomi=null;
	public Boolean mostrarid_pregunta_nomiFormatoNomiPreguntaNomi=true;
	public Boolean activarid_pregunta_nomiFormatoNomiPreguntaNomi=true;
	public Boolean cargarid_pregunta_nomiFormatoNomiPreguntaNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pregunta_nomiFormatoNomiPreguntaNomi=false;//ConEventDepend=true

	public Border resaltarponderacionFormatoNomiPreguntaNomi=null;
	public Boolean mostrarponderacionFormatoNomiPreguntaNomi=true;
	public Boolean activarponderacionFormatoNomiPreguntaNomi=true;

	
	

	public Border setResaltaridFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomipreguntanomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltaridFormatoNomiPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormatoNomiPreguntaNomi() {
		return this.resaltaridFormatoNomiPreguntaNomi;
	}

	public void setResaltaridFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltaridFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Boolean getMostraridFormatoNomiPreguntaNomi() {
		return this.mostraridFormatoNomiPreguntaNomi;
	}

	public void setMostraridFormatoNomiPreguntaNomi(Boolean mostraridFormatoNomiPreguntaNomi) {
		this.mostraridFormatoNomiPreguntaNomi= mostraridFormatoNomiPreguntaNomi;
	}

	public Boolean getActivaridFormatoNomiPreguntaNomi() {
		return this.activaridFormatoNomiPreguntaNomi;
	}

	public void setActivaridFormatoNomiPreguntaNomi(Boolean activaridFormatoNomiPreguntaNomi) {
		this.activaridFormatoNomiPreguntaNomi= activaridFormatoNomiPreguntaNomi;
	}

	public Border setResaltarid_empresaFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomipreguntanomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormatoNomiPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormatoNomiPreguntaNomi() {
		return this.resaltarid_empresaFormatoNomiPreguntaNomi;
	}

	public void setResaltarid_empresaFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarid_empresaFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormatoNomiPreguntaNomi() {
		return this.mostrarid_empresaFormatoNomiPreguntaNomi;
	}

	public void setMostrarid_empresaFormatoNomiPreguntaNomi(Boolean mostrarid_empresaFormatoNomiPreguntaNomi) {
		this.mostrarid_empresaFormatoNomiPreguntaNomi= mostrarid_empresaFormatoNomiPreguntaNomi;
	}

	public Boolean getActivarid_empresaFormatoNomiPreguntaNomi() {
		return this.activarid_empresaFormatoNomiPreguntaNomi;
	}

	public void setActivarid_empresaFormatoNomiPreguntaNomi(Boolean activarid_empresaFormatoNomiPreguntaNomi) {
		this.activarid_empresaFormatoNomiPreguntaNomi= activarid_empresaFormatoNomiPreguntaNomi;
	}

	public Boolean getCargarid_empresaFormatoNomiPreguntaNomi() {
		return this.cargarid_empresaFormatoNomiPreguntaNomi;
	}

	public void setCargarid_empresaFormatoNomiPreguntaNomi(Boolean cargarid_empresaFormatoNomiPreguntaNomi) {
		this.cargarid_empresaFormatoNomiPreguntaNomi= cargarid_empresaFormatoNomiPreguntaNomi;
	}

	public Border setResaltarid_sucursalFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomipreguntanomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFormatoNomiPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFormatoNomiPreguntaNomi() {
		return this.resaltarid_sucursalFormatoNomiPreguntaNomi;
	}

	public void setResaltarid_sucursalFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarid_sucursalFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFormatoNomiPreguntaNomi() {
		return this.mostrarid_sucursalFormatoNomiPreguntaNomi;
	}

	public void setMostrarid_sucursalFormatoNomiPreguntaNomi(Boolean mostrarid_sucursalFormatoNomiPreguntaNomi) {
		this.mostrarid_sucursalFormatoNomiPreguntaNomi= mostrarid_sucursalFormatoNomiPreguntaNomi;
	}

	public Boolean getActivarid_sucursalFormatoNomiPreguntaNomi() {
		return this.activarid_sucursalFormatoNomiPreguntaNomi;
	}

	public void setActivarid_sucursalFormatoNomiPreguntaNomi(Boolean activarid_sucursalFormatoNomiPreguntaNomi) {
		this.activarid_sucursalFormatoNomiPreguntaNomi= activarid_sucursalFormatoNomiPreguntaNomi;
	}

	public Boolean getCargarid_sucursalFormatoNomiPreguntaNomi() {
		return this.cargarid_sucursalFormatoNomiPreguntaNomi;
	}

	public void setCargarid_sucursalFormatoNomiPreguntaNomi(Boolean cargarid_sucursalFormatoNomiPreguntaNomi) {
		this.cargarid_sucursalFormatoNomiPreguntaNomi= cargarid_sucursalFormatoNomiPreguntaNomi;
	}

	public Border setResaltarid_formato_nomiFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomipreguntanomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarid_formato_nomiFormatoNomiPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nomiFormatoNomiPreguntaNomi() {
		return this.resaltarid_formato_nomiFormatoNomiPreguntaNomi;
	}

	public void setResaltarid_formato_nomiFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarid_formato_nomiFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarid_formato_nomiFormatoNomiPreguntaNomi() {
		return this.mostrarid_formato_nomiFormatoNomiPreguntaNomi;
	}

	public void setMostrarid_formato_nomiFormatoNomiPreguntaNomi(Boolean mostrarid_formato_nomiFormatoNomiPreguntaNomi) {
		this.mostrarid_formato_nomiFormatoNomiPreguntaNomi= mostrarid_formato_nomiFormatoNomiPreguntaNomi;
	}

	public Boolean getActivarid_formato_nomiFormatoNomiPreguntaNomi() {
		return this.activarid_formato_nomiFormatoNomiPreguntaNomi;
	}

	public void setActivarid_formato_nomiFormatoNomiPreguntaNomi(Boolean activarid_formato_nomiFormatoNomiPreguntaNomi) {
		this.activarid_formato_nomiFormatoNomiPreguntaNomi= activarid_formato_nomiFormatoNomiPreguntaNomi;
	}

	public Boolean getCargarid_formato_nomiFormatoNomiPreguntaNomi() {
		return this.cargarid_formato_nomiFormatoNomiPreguntaNomi;
	}

	public void setCargarid_formato_nomiFormatoNomiPreguntaNomi(Boolean cargarid_formato_nomiFormatoNomiPreguntaNomi) {
		this.cargarid_formato_nomiFormatoNomiPreguntaNomi= cargarid_formato_nomiFormatoNomiPreguntaNomi;
	}

	public Border setResaltarid_factor_nomiFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomipreguntanomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarid_factor_nomiFormatoNomiPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_factor_nomiFormatoNomiPreguntaNomi() {
		return this.resaltarid_factor_nomiFormatoNomiPreguntaNomi;
	}

	public void setResaltarid_factor_nomiFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarid_factor_nomiFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarid_factor_nomiFormatoNomiPreguntaNomi() {
		return this.mostrarid_factor_nomiFormatoNomiPreguntaNomi;
	}

	public void setMostrarid_factor_nomiFormatoNomiPreguntaNomi(Boolean mostrarid_factor_nomiFormatoNomiPreguntaNomi) {
		this.mostrarid_factor_nomiFormatoNomiPreguntaNomi= mostrarid_factor_nomiFormatoNomiPreguntaNomi;
	}

	public Boolean getActivarid_factor_nomiFormatoNomiPreguntaNomi() {
		return this.activarid_factor_nomiFormatoNomiPreguntaNomi;
	}

	public void setActivarid_factor_nomiFormatoNomiPreguntaNomi(Boolean activarid_factor_nomiFormatoNomiPreguntaNomi) {
		this.activarid_factor_nomiFormatoNomiPreguntaNomi= activarid_factor_nomiFormatoNomiPreguntaNomi;
	}

	public Boolean getCargarid_factor_nomiFormatoNomiPreguntaNomi() {
		return this.cargarid_factor_nomiFormatoNomiPreguntaNomi;
	}

	public void setCargarid_factor_nomiFormatoNomiPreguntaNomi(Boolean cargarid_factor_nomiFormatoNomiPreguntaNomi) {
		this.cargarid_factor_nomiFormatoNomiPreguntaNomi= cargarid_factor_nomiFormatoNomiPreguntaNomi;
	}

	public Border setResaltarid_pregunta_nomiFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomipreguntanomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarid_pregunta_nomiFormatoNomiPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pregunta_nomiFormatoNomiPreguntaNomi() {
		return this.resaltarid_pregunta_nomiFormatoNomiPreguntaNomi;
	}

	public void setResaltarid_pregunta_nomiFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarid_pregunta_nomiFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarid_pregunta_nomiFormatoNomiPreguntaNomi() {
		return this.mostrarid_pregunta_nomiFormatoNomiPreguntaNomi;
	}

	public void setMostrarid_pregunta_nomiFormatoNomiPreguntaNomi(Boolean mostrarid_pregunta_nomiFormatoNomiPreguntaNomi) {
		this.mostrarid_pregunta_nomiFormatoNomiPreguntaNomi= mostrarid_pregunta_nomiFormatoNomiPreguntaNomi;
	}

	public Boolean getActivarid_pregunta_nomiFormatoNomiPreguntaNomi() {
		return this.activarid_pregunta_nomiFormatoNomiPreguntaNomi;
	}

	public void setActivarid_pregunta_nomiFormatoNomiPreguntaNomi(Boolean activarid_pregunta_nomiFormatoNomiPreguntaNomi) {
		this.activarid_pregunta_nomiFormatoNomiPreguntaNomi= activarid_pregunta_nomiFormatoNomiPreguntaNomi;
	}

	public Boolean getCargarid_pregunta_nomiFormatoNomiPreguntaNomi() {
		return this.cargarid_pregunta_nomiFormatoNomiPreguntaNomi;
	}

	public void setCargarid_pregunta_nomiFormatoNomiPreguntaNomi(Boolean cargarid_pregunta_nomiFormatoNomiPreguntaNomi) {
		this.cargarid_pregunta_nomiFormatoNomiPreguntaNomi= cargarid_pregunta_nomiFormatoNomiPreguntaNomi;
	}

	public Border setResaltarponderacionFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatonomipreguntanomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarponderacionFormatoNomiPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarponderacionFormatoNomiPreguntaNomi() {
		return this.resaltarponderacionFormatoNomiPreguntaNomi;
	}

	public void setResaltarponderacionFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarponderacionFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarponderacionFormatoNomiPreguntaNomi() {
		return this.mostrarponderacionFormatoNomiPreguntaNomi;
	}

	public void setMostrarponderacionFormatoNomiPreguntaNomi(Boolean mostrarponderacionFormatoNomiPreguntaNomi) {
		this.mostrarponderacionFormatoNomiPreguntaNomi= mostrarponderacionFormatoNomiPreguntaNomi;
	}

	public Boolean getActivarponderacionFormatoNomiPreguntaNomi() {
		return this.activarponderacionFormatoNomiPreguntaNomi;
	}

	public void setActivarponderacionFormatoNomiPreguntaNomi(Boolean activarponderacionFormatoNomiPreguntaNomi) {
		this.activarponderacionFormatoNomiPreguntaNomi= activarponderacionFormatoNomiPreguntaNomi;
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
		
		
		this.setMostraridFormatoNomiPreguntaNomi(esInicial);
		this.setMostrarid_empresaFormatoNomiPreguntaNomi(esInicial);
		this.setMostrarid_sucursalFormatoNomiPreguntaNomi(esInicial);
		this.setMostrarid_formato_nomiFormatoNomiPreguntaNomi(esInicial);
		this.setMostrarid_factor_nomiFormatoNomiPreguntaNomi(esInicial);
		this.setMostrarid_pregunta_nomiFormatoNomiPreguntaNomi(esInicial);
		this.setMostrarponderacionFormatoNomiPreguntaNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.ID)) {
				this.setMostraridFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setMostrarid_formato_nomiFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI)) {
				this.setMostrarid_factor_nomiFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI)) {
				this.setMostrarid_pregunta_nomiFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION)) {
				this.setMostrarponderacionFormatoNomiPreguntaNomi(esAsigna);
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
		
		
		this.setActivaridFormatoNomiPreguntaNomi(esInicial);
		this.setActivarid_empresaFormatoNomiPreguntaNomi(esInicial);
		this.setActivarid_sucursalFormatoNomiPreguntaNomi(esInicial);
		this.setActivarid_formato_nomiFormatoNomiPreguntaNomi(esInicial);
		this.setActivarid_factor_nomiFormatoNomiPreguntaNomi(esInicial);
		this.setActivarid_pregunta_nomiFormatoNomiPreguntaNomi(esInicial);
		this.setActivarponderacionFormatoNomiPreguntaNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.ID)) {
				this.setActivaridFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setActivarid_formato_nomiFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI)) {
				this.setActivarid_factor_nomiFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI)) {
				this.setActivarid_pregunta_nomiFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION)) {
				this.setActivarponderacionFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormatoNomiPreguntaNomi(esInicial);
		this.setResaltarid_empresaFormatoNomiPreguntaNomi(esInicial);
		this.setResaltarid_sucursalFormatoNomiPreguntaNomi(esInicial);
		this.setResaltarid_formato_nomiFormatoNomiPreguntaNomi(esInicial);
		this.setResaltarid_factor_nomiFormatoNomiPreguntaNomi(esInicial);
		this.setResaltarid_pregunta_nomiFormatoNomiPreguntaNomi(esInicial);
		this.setResaltarponderacionFormatoNomiPreguntaNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.ID)) {
				this.setResaltaridFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setResaltarid_formato_nomiFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI)) {
				this.setResaltarid_factor_nomiFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI)) {
				this.setResaltarid_pregunta_nomiFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION)) {
				this.setResaltarponderacionFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCalificacionEmpleadoFormatoNomiPreguntaNomi=null;

	public Border getResaltarCalificacionEmpleadoFormatoNomiPreguntaNomi() {
		return this.resaltarCalificacionEmpleadoFormatoNomiPreguntaNomi;
	}

	public void setResaltarCalificacionEmpleadoFormatoNomiPreguntaNomi(Border borderResaltarCalificacionEmpleado) {
		if(borderResaltarCalificacionEmpleado!=null) {
			this.resaltarCalificacionEmpleadoFormatoNomiPreguntaNomi= borderResaltarCalificacionEmpleado;
		}
	}

	public Border setResaltarCalificacionEmpleadoFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltarCalificacionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//formatonomipreguntanomiBeanSwingJInternalFrame.jTtoolBarFormatoNomiPreguntaNomi.setBorder(borderResaltarCalificacionEmpleado);
			
		this.resaltarCalificacionEmpleadoFormatoNomiPreguntaNomi= borderResaltarCalificacionEmpleado;

		 return borderResaltarCalificacionEmpleado;
	}



	public Boolean mostrarCalificacionEmpleadoFormatoNomiPreguntaNomi=true;

	public Boolean getMostrarCalificacionEmpleadoFormatoNomiPreguntaNomi() {
		return this.mostrarCalificacionEmpleadoFormatoNomiPreguntaNomi;
	}

	public void setMostrarCalificacionEmpleadoFormatoNomiPreguntaNomi(Boolean visibilidadResaltarCalificacionEmpleado) {
		this.mostrarCalificacionEmpleadoFormatoNomiPreguntaNomi= visibilidadResaltarCalificacionEmpleado;
	}



	public Boolean activarCalificacionEmpleadoFormatoNomiPreguntaNomi=true;

	public Boolean gethabilitarResaltarCalificacionEmpleadoFormatoNomiPreguntaNomi() {
		return this.activarCalificacionEmpleadoFormatoNomiPreguntaNomi;
	}

	public void setActivarCalificacionEmpleadoFormatoNomiPreguntaNomi(Boolean habilitarResaltarCalificacionEmpleado) {
		this.activarCalificacionEmpleadoFormatoNomiPreguntaNomi= habilitarResaltarCalificacionEmpleado;
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

		this.setMostrarCalificacionEmpleadoFormatoNomiPreguntaNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setMostrarCalificacionEmpleadoFormatoNomiPreguntaNomi(esAsigna);
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

		this.setActivarCalificacionEmpleadoFormatoNomiPreguntaNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setActivarCalificacionEmpleadoFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCalificacionEmpleadoFormatoNomiPreguntaNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setResaltarCalificacionEmpleadoFormatoNomiPreguntaNomi(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaFormatoNomiPreguntaNomi=true;

	public Boolean getMostrarFK_IdEmpresaFormatoNomiPreguntaNomi() {
		return this.mostrarFK_IdEmpresaFormatoNomiPreguntaNomi;
	}

	public void setMostrarFK_IdEmpresaFormatoNomiPreguntaNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormatoNomiPreguntaNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFactorNomiFormatoNomiPreguntaNomi=true;

	public Boolean getMostrarFK_IdFactorNomiFormatoNomiPreguntaNomi() {
		return this.mostrarFK_IdFactorNomiFormatoNomiPreguntaNomi;
	}

	public void setMostrarFK_IdFactorNomiFormatoNomiPreguntaNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFactorNomiFormatoNomiPreguntaNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNomiFormatoNomiPreguntaNomi=true;

	public Boolean getMostrarFK_IdFormatoNomiFormatoNomiPreguntaNomi() {
		return this.mostrarFK_IdFormatoNomiFormatoNomiPreguntaNomi;
	}

	public void setMostrarFK_IdFormatoNomiFormatoNomiPreguntaNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNomiFormatoNomiPreguntaNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPreguntaNomiFormatoNomiPreguntaNomi=true;

	public Boolean getMostrarFK_IdPreguntaNomiFormatoNomiPreguntaNomi() {
		return this.mostrarFK_IdPreguntaNomiFormatoNomiPreguntaNomi;
	}

	public void setMostrarFK_IdPreguntaNomiFormatoNomiPreguntaNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPreguntaNomiFormatoNomiPreguntaNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFormatoNomiPreguntaNomi=true;

	public Boolean getMostrarFK_IdSucursalFormatoNomiPreguntaNomi() {
		return this.mostrarFK_IdSucursalFormatoNomiPreguntaNomi;
	}

	public void setMostrarFK_IdSucursalFormatoNomiPreguntaNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFormatoNomiPreguntaNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaFormatoNomiPreguntaNomi=true;

	public Boolean getActivarFK_IdEmpresaFormatoNomiPreguntaNomi() {
		return this.activarFK_IdEmpresaFormatoNomiPreguntaNomi;
	}

	public void setActivarFK_IdEmpresaFormatoNomiPreguntaNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormatoNomiPreguntaNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdFactorNomiFormatoNomiPreguntaNomi=true;

	public Boolean getActivarFK_IdFactorNomiFormatoNomiPreguntaNomi() {
		return this.activarFK_IdFactorNomiFormatoNomiPreguntaNomi;
	}

	public void setActivarFK_IdFactorNomiFormatoNomiPreguntaNomi(Boolean habilitarResaltar) {
		this.activarFK_IdFactorNomiFormatoNomiPreguntaNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNomiFormatoNomiPreguntaNomi=true;

	public Boolean getActivarFK_IdFormatoNomiFormatoNomiPreguntaNomi() {
		return this.activarFK_IdFormatoNomiFormatoNomiPreguntaNomi;
	}

	public void setActivarFK_IdFormatoNomiFormatoNomiPreguntaNomi(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNomiFormatoNomiPreguntaNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdPreguntaNomiFormatoNomiPreguntaNomi=true;

	public Boolean getActivarFK_IdPreguntaNomiFormatoNomiPreguntaNomi() {
		return this.activarFK_IdPreguntaNomiFormatoNomiPreguntaNomi;
	}

	public void setActivarFK_IdPreguntaNomiFormatoNomiPreguntaNomi(Boolean habilitarResaltar) {
		this.activarFK_IdPreguntaNomiFormatoNomiPreguntaNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFormatoNomiPreguntaNomi=true;

	public Boolean getActivarFK_IdSucursalFormatoNomiPreguntaNomi() {
		return this.activarFK_IdSucursalFormatoNomiPreguntaNomi;
	}

	public void setActivarFK_IdSucursalFormatoNomiPreguntaNomi(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFormatoNomiPreguntaNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaFormatoNomiPreguntaNomi=null;

	public Border getResaltarFK_IdEmpresaFormatoNomiPreguntaNomi() {
		return this.resaltarFK_IdEmpresaFormatoNomiPreguntaNomi;
	}

	public void setResaltarFK_IdEmpresaFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormatoNomiPreguntaNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Border resaltarFK_IdFactorNomiFormatoNomiPreguntaNomi=null;

	public Border getResaltarFK_IdFactorNomiFormatoNomiPreguntaNomi() {
		return this.resaltarFK_IdFactorNomiFormatoNomiPreguntaNomi;
	}

	public void setResaltarFK_IdFactorNomiFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarFK_IdFactorNomiFormatoNomiPreguntaNomi= borderResaltar;
	}

	public void setResaltarFK_IdFactorNomiFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFactorNomiFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNomiFormatoNomiPreguntaNomi=null;

	public Border getResaltarFK_IdFormatoNomiFormatoNomiPreguntaNomi() {
		return this.resaltarFK_IdFormatoNomiFormatoNomiPreguntaNomi;
	}

	public void setResaltarFK_IdFormatoNomiFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarFK_IdFormatoNomiFormatoNomiPreguntaNomi= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNomiFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNomiFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Border resaltarFK_IdPreguntaNomiFormatoNomiPreguntaNomi=null;

	public Border getResaltarFK_IdPreguntaNomiFormatoNomiPreguntaNomi() {
		return this.resaltarFK_IdPreguntaNomiFormatoNomiPreguntaNomi;
	}

	public void setResaltarFK_IdPreguntaNomiFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarFK_IdPreguntaNomiFormatoNomiPreguntaNomi= borderResaltar;
	}

	public void setResaltarFK_IdPreguntaNomiFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPreguntaNomiFormatoNomiPreguntaNomi= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFormatoNomiPreguntaNomi=null;

	public Border getResaltarFK_IdSucursalFormatoNomiPreguntaNomi() {
		return this.resaltarFK_IdSucursalFormatoNomiPreguntaNomi;
	}

	public void setResaltarFK_IdSucursalFormatoNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarFK_IdSucursalFormatoNomiPreguntaNomi= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFormatoNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoNomiPreguntaNomiBeanSwingJInternalFrame formatonomipreguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFormatoNomiPreguntaNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}